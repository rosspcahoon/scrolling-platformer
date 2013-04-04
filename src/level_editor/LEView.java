package level_editor;

import java.util.ResourceBundle;
import javax.swing.JFrame;
import viewUtil.Renderable;
import viewUtil.Window;


public class LEView extends Window implements ILEView {
    

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Level Editor";
    private static final String DEFAULT_RESOURCE_PACKAGE = "";
    private ResourceBundle myResources;
    
    public LEView (String string, String language, LEController lEController) {
        super(string, language, lEController);
        // TODO Auto-generated constructor stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


//    public LEView () {
//        setTitle(TITLE);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        // myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
//        addComponents();
//        pack();
//        setVisible(true);
//    }

    private void addComponents () {
        // TODO Auto-generated method stub

    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub

    }

}
