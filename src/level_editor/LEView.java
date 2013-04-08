package level_editor;

import javax.swing.JFrame;
import viewUtil.Renderable;
import viewUtil.Window;
import viewUtil.WorkspaceView;


public class LEView extends Window {
    

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Level Editor";
    
    public LEView (String language, LEController lEController) {
        super(TITLE, language, lEController);
        // TODO Auto-generated constructor stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public WorkspaceView initializeWorkspaceView (int id) {
        return new LETab(id, this);
    }

    /**
     * TODO: refactor the part below as they are specific to SLogo and not to the window
     * maybe it would make sense to have them being required by setting the window to
     * implement an interface, and ensuring that the implementation is delegated to 
     * some component of the window.
     */
    
    /**
     * Set the turtle shape
     */
//    public void setTurtleShape () {
//        int response = myChooser.showOpenDialog(null);
//        if (response == JFileChooser.APPROVE_OPTION) {
//            String imgURL = myChooser.getSelectedFile().getAbsolutePath();
//            WorkspaceView temp = (WorkspaceView) myTabbedPane.getSelectedComponent();
//            if (temp != null) {
//                return;
//            }
//            int last = registerTurtleShape(imgURL);
//            setTurtleShape(last);
//        }
//    }
//
//    private void setTurtleShape (int i) {
//        WorkspaceView temp = (WorkspaceView) myTabbedPane.getSelectedComponent();
//        processCommand(temp, "setshape " + i);
//    }
//
//    private int registerTurtleShape (String imgURL) {
//        return processCommand(
//                     getLiteral("COMMAND_NAME_REGISTER_SHAPE") + " " + imgURL);
//    }
//    
//    /**
//     * Change the color of the pen
//     */
//    public void changePenColor() {
//        Color result = JColorChooser.showDialog(this, getLiteral("ChangePenColor"), 
//                                                getCurrentPenColor());
//        int pos = processCommand(getLiteral("COMMAND_NAME_LAST_PEN_COLOR_INDEX"));
//        processCommand(getLiteral("COMMAND_NAME_SET_PALETTE") +
//                                 " " + pos + " " 
//                                 + result.getRed() + " "
//                                 + result.getGreen() + " "
//                                 + result.getBlue());
//        processCommand(getLiteral("COMMAND_NAME_SET_PEN_COLOR") + " " + pos);
//    }

    @Override
    protected void setMenu () {
        super.setMenu(new LEMenuBar(this));
    }

    @Override
    public void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable r) {
        // TODO Auto-generated method stub
        super.addTab(associatedWorkspaceView, r);
    }

}
