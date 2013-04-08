package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
import sprites.Player;
import model.Model;
import model.Model2;


/**
 *
 * @author Ross Cahoon
 */
public class View extends JComponent {
    // default serialization ID
    private static final long serialVersionUID = 1L;
    // animate 25 times per second if possible
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    // input state
    public static final int NO_KEY_PRESSED = -1;

    // drives the animation
    private Timer myTimer;
    // game to be animated
    private Model2 myGame;
    // input state
    private int myLastKeyPressed;
    private Point myLastMousePosition;
    // MULTIPLE KEY SUPPORT
    private Set<Integer> myKeys;
    // Player
    private Player myPlayer;


    /**
     * Create a panel so that it knows its size
     */
    public View (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // prepare to receive input
        setFocusable(true);
        requestFocus();
        setInputListeners();
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        scrollManager(pen);
        
        // first time needs to be special cased :(
        if (myGame != null) {
            myGame.paint((Graphics2D) pen);
        }
    }
    
    /**
     * Scroll Manager
     */
    private void scrollManager(Graphics pen) {
        Image img = new ImageIcon(getClass().getResource("/images/forestbackground.jpg")).getImage();
        

        int horizontal = ((int) myGame.getRightBoundary() + this.getWidth()*1000) % this.getWidth();
        int vertical = ((int) myGame.getLowerBoundary() + this.getHeight()*1000) % this.getHeight();

            pen.drawImage(img, 0 - horizontal, 0 - vertical, 800, 300, null);
            pen.drawImage(img, this.getWidth() - horizontal,  0 - vertical, 800, 300, null);
            pen.drawImage(img, 0 - horizontal,this.getHeight() - vertical, 800, 300, null);
            pen.drawImage(img, this.getWidth() - horizontal, this.getHeight() - vertical, 800, 300, null);

        // first time needs to be special cased :(
        if (myGame != null) {
            myGame.paint((Graphics2D) pen);
        }
    }

    /**
     * Returns last key pressed by the user or -1 if nothing is pressed.
     */
    public int getLastKeyPressed () {
        return myLastKeyPressed;
    }

    /**
     * Returns all keys currently pressed by the user.
     */
    // MULTIPLE KEY SUPPORT
    public Collection<Integer> getKeysPressed () {
        return Collections.unmodifiableSet(myKeys);
    }

    /**
     * Returns last position of the mouse in the canvas.
     */
    public Point getLastMousePosition () {
        return myLastMousePosition;
    }

    /**
     * Start the animation.
     */
    public void start () {
        final int stepTime = DEFAULT_DELAY;
        // create a timer to animate the canvas
        Timer timer = new Timer(stepTime, 
                                new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                myGame.update((double) stepTime / ONE_SECOND);
                repaint();
            }
        });
        // start animation
        myGame = new Model2(this);
        timer.start();
    }

    /**
     * Stop the animation.
     */
    public void stop () {
        myTimer.stop();
    }

    /**
     * Create listeners that will update state based on user input.
     */
    private void setInputListeners () {
        // initialize input state
        myLastKeyPressed = NO_KEY_PRESSED;
        // MULTIPLE KEY SUPPORT
        myKeys = new TreeSet<Integer>();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                myLastKeyPressed = e.getKeyCode();
                // MULTIPLE KEY SUPPORT
                myKeys.add(e.getKeyCode());
            }
            @Override
            public void keyReleased (KeyEvent e) {
                myLastKeyPressed = NO_KEY_PRESSED;
                // MULTIPLE KEY SUPPORT
                myKeys.remove((Integer)e.getKeyCode());
            }
        });
        myLastMousePosition = new Point();
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved (MouseEvent e) {
                myLastMousePosition = e.getPoint();
            }
        });
    }
}
