package model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import view.View;


/**
 * Creates window that can be moved, resized, and closed by the user.
 *
 * @author Robert C. Duvall
 */
public class Main
{
    // constants
    public static final Dimension SIZE = new Dimension(1200, 800);
    public static final String TITLE = "Scrolling Test";


    /**
     * main --- where the program starts
     * @param args
     */
    public static void main (String args[])
    {
        // view of user's content
        View display = new View(SIZE);
        // container that will work with user's OS
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(display, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        // start animation
        display.start();
        // TODO: handle iconify (reason for start/stop)
        // TODO: full screen?
    }
}
