package viewUtil;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.Stack;
import viewUtil.Renderable;
import util.IWindow;
import viewUtil.ViewConstants;
import viewUtil.Window;


public abstract class WorkspaceView extends WindowView{

    /**
     * 
     */
    private static final long serialVersionUID = 2039042992476659779L;
    
    private int myID;
    private Window myWindow;
    @SuppressWarnings("unused")
    private GridBagConstraints myConstraints;
    private Renderable myRenderable;
    private Dimension mySize = ViewConstants.DEFAULT_TAB_SIZE;

    public WorkspaceView (Container hostWindow) {
        super(hostWindow);
        setWindow();
        setPreferredSize(mySize);
        //TODO : for undo/redo stuff
//        myRenderableHistory = new Stack<Renderable>();
//        myRenderableBrowsingHelper = new Stack<Renderable>();
    }

    public WorkspaceView (int id, Container hostWindow) {
        // TODO Auto-generated constructor stub
        this(hostWindow);
        myID = id; 
    }

    public void setRenderable (Renderable r) {
        myRenderable = r;
    }
    
    /**
     * Get the ID for this component
     * @return the id of the component
     */
    public int getID () {
        return myID;
    }
    
    /**
     * TODO - for use in history browsing
     */
    private void setWindow() {
        myWindow = (Window) getParent();
    }
    
    
//TODO : Maybe not (maybe remove this one)
    public void setBackground (Image img) {
        // TODO Auto-generated method stub
        
    }

    //TODO: think about this one too
    public void toggleGrid () {
        // TODO Auto-generated method stub
        
    }

    public void undo () {
        // TODO Auto-generated method stub
        
    }

    public void redo () {
        // TODO Auto-generated method stub
        
    }

}