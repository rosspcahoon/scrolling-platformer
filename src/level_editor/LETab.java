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
public class LETab extends WorkspaceView implements ILEView {
    private LevelView myLevelView;
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
        myLevelView = new LevelView(this);
        myEditorView = new EditorView(this);
    }

    @Override
    protected void addComponents () {
        // TODO Auto-generated method stub
        EasyGridFactory.layoutVertical(this, myLevelView, myEditorView);
//        System.out.println("here");
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub
        myLevelView.render(r);
    }

}
