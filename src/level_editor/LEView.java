package level_editor;

import javax.swing.JFrame;
import util.Controller;
import util.IWindow;
import viewUtil.Renderable;
import viewUtil.Window;

public class LEView extends Window implements iLEView {
    
    public LEView (String string, String language, Controller controller) {
        super(string, language, controller);
        // TODO Auto-generated constructor stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main (String[] args) {
        
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub
        
    }
    
    

}
