package sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.List;
import abstract_sprites.AbstractPlayer;
import collision_handlers.Mario_CH;
import design_patterns.State;
import test_sprites.Type;
import util.Location;
import util.Pixmap;
import util.Vector;
import view.View;


/**
 * Two Design Patterns being used here: Visitor and State. 
 * 
 * Visitor pattern is used to handle collisions. Essentially, whenever
 * a collision is detected, we will call the visit method of myCollisionHandler
 * and pass in the object Player has just collided with. 
 * 
 * State pattern is used to handle the state the Player is in. currenState
 * starts out at a default state. All updating and painting is done on 
 * a state level. This is evinced through the Player's update and paint 
 * methods. 
 * 
 * 
 * @author Jay Wang
 *
 */
public class Player extends AbstractPlayer {

//    Graphics2D pen;
    Mario_CH myCollisionHandler;
    List<State> myStates;
    State currentState; 
    View myView;
    private Location myOriginalCenter;
    private Dimension mySize;
    private Pixmap myImage;
    
    // Used for testing purposes only
    private static final int MOVE_LEFT = KeyEvent.VK_A;
    private static final int MOVE_RIGHT = KeyEvent.VK_D;
    private static final int MOVE_UP = KeyEvent.VK_W;
    private static final int MOVE_DOWN = KeyEvent.VK_S;
    private static final int MOVE_SPEED = 10;
    public static final Vector LEFT_VELOCITY = new Vector(LEFT_DIRECTION, MOVE_SPEED);
    public static final Vector RIGHT_VELOCITY = new Vector(RIGHT_DIRECTION, MOVE_SPEED);
    public static final Vector UP_VELOCITY = new Vector(UP_DIRECTION, MOVE_SPEED);
    public static final Vector DOWN_VELOCITY = new Vector(DOWN_DIRECTION, MOVE_SPEED);
    
    public Player (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size);
        myView = view;
        myOriginalCenter = center;
        mySize = size;
        myImage = image;
    }
    
    
    public void update(double elapsedTime, Dimension bounds) {
//        Commented out for scrolling testing
//        currentState.update();
        // move based on input
//      ONLY FOR TESTING
//        int key = myView.getLastKeyPressed();
//        if (key == MOVE_LEFT)
//        {
//            translate(LEFT_VELOCITY);
//        }
//        if (key == MOVE_RIGHT)
//        {
//            translate(RIGHT_VELOCITY);
//        }
//        if (key == MOVE_UP)
//        {
//            translate(UP_VELOCITY);
//        }
//        if (key == MOVE_DOWN)
//        {
//            translate(DOWN_VELOCITY);
//        }
//        ONLY FOR TESTING
    }
   
    @Override
    public void paint (Graphics2D pen) {
        myImage.paint(pen, myOriginalCenter, mySize);
    }
    
    public void changeState(State newState) {
        currentState = newState;
    }
    
    public Location getOriginalCenter() {
        return myOriginalCenter;
    }
    
    public double getRightBoundary(Dimension frame) {
        return (this.getX() + frame.getWidth() / 2);
    }
    
    public double getLeftBoundary(Dimension frame) {
        return (this.getX() - frame.getWidth() / 2);
    }
    
    public double getUpperBoundary(Dimension frame) {
        return (this.getY() - frame.getHeight() / 2);
    }
    
    public double getLowerBoundary(Dimension frame) { 
        return (this.getY() + frame.getHeight() / 2);
    }
    
    public Type getType() {
        return Type.NONE;
    }
}
