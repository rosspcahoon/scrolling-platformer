package level_editor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import util.IModel;
import util.WorkspaceModel;
import viewUtil.Renderable;
import viewUtil.Window;
import viewUtil.WorkspaceView;

/**
 * The controller is responsible for interfacing between an IView and an IModel.
 * Among other things, it is responsible for handling events from the IView, and
 * ensuring that the model components are kept in sync.
 * Moreover, it is responsible for keeping track of the mapping between models of the
 * workspace and their view.
 * @author SLogo team 3
 *
 */

public class LEController {

    private static final int DEFAULT_SIZE = 10;
    private Window myView;
    private IModel myModel;
    private Map<WorkspaceModel, WorkspaceView> myWorkspace2Tab;
    private Map<WorkspaceView, WorkspaceModel> myTab2Workspace;

    /**
     * Constructor
     */
    public LEController() {
        String language = getLanguage();
        myModel = new LevelEditor(language);
        myView = new LEView("Level Editor", language, this);
        myWorkspace2Tab = new HashMap<WorkspaceModel, WorkspaceView>();
        myTab2Workspace = new HashMap<WorkspaceView, WorkspaceModel>();
    }

    private String getLanguage () {
        String[] languages = {"English", "French"};
        int n = JOptionPane.showOptionDialog(null,
                            "Choose a language", "Language Selection",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, languages, languages[0]);
        String language = languages[n];
        return language;
    }
    
    /**
     * Initialize the GUI.
     */

    public void start() {
        //Welcome message
//        myView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myView.pack();
//        myView.setVisible(true);
    }
   

    /**
     * Load a file in a specific tab - TODO
     * @param f - File to be loaded.
     * @param t - Tab where file is to be loaded.
     */
    public void loadFile (WorkspaceView t, File f) {

    }

    /**
     * return the Room Object corresponding to the input TabView
     * @param t
     * @return
     */
    private WorkspaceModel getModelForWorkspace (WorkspaceView v) {
        return myTab2Workspace.get(v);
    }

    private WorkspaceView getViewForWorkspace (WorkspaceModel m) {
        return myWorkspace2Tab.get(m);
    }


    /**
     * calls model to process the input string command
     * @param t - 
     * @param cmd - command to process
     * @return ret - return int from command process
     */
    public int processCommand (WorkspaceView t, String cmd) {
        WorkspaceModel m = getModelForWorkspace(t);
        int ret = myModel.processCommand(m, cmd);
        t.setRenderable((Renderable) m);
        return ret;
    }

    
    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public void initializeWorkspace() {
        int id = myWorkspace2Tab.size();
        initializeWorkspace(id);
    }

    /**
     * Initialize a room with the ID provided
     * also initialize a corresponding Tab in the view.
     * @param id
     */
    private void initializeWorkspace (int id) {
        WorkspaceModel m = new SpriteGrid(DEFAULT_SIZE,DEFAULT_SIZE);
        WorkspaceView associatedTab = new LETab(id, myView);
        myWorkspace2Tab.put(m, associatedTab);
        myTab2Workspace.put(associatedTab, m);
        myView.addWorkspace(associatedTab, (Renderable) m);
        
    }

}
