package level_editor;

import java.awt.Container;
import util.IWindow;
import viewUtil.EasyGridFactory;
import viewUtil.Renderable;
import viewUtil.WorkspaceView;

/**
 * This class is a specialized Workspace for a Level Editor.
 * @author Dagbedji Fagnisse
 *
 */
public class LETab extends WorkspaceView implements ILEView, ILevelEditor{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Renderable myRenderable;
    private LevelGridView myLevelView;
    private EditorView myEditorView;

    public LETab (Container host) {
        super(host);
        // TODO Auto-generated constructor stub
    }

    public LETab (int id, Container host) {
        // TODO Auto-generated constructor stub
        super(id, host);
    }



    @Override
    public int getID () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected void initializeVariables () {
        // TODO Auto-generated method stub
        myLevelView = new LevelGridView(this);
        myEditorView = new EditorView(this);
    }

    @Override
    protected void addComponents () {
        // TODO Auto-generated method stub
        EasyGridFactory.layoutVertical(this, myLevelView);
        System.out.println("here");
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub !!!
        myLevelView.render(r);
    }

    @Override
    public void setRenderable (Renderable r) {
        // TODO Auto-generated method stub
        myRenderable = r;
//        myRenderableHistory.add(renderableRoom);
        render(myRenderable);
    }

    @Override
    public void processCommand (String command) {
        // TODO - Need to refactor
        super.processConsoleInput(command);
    }

}
