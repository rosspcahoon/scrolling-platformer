package test_sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.List;
import collision_handlers.CollisionHandler;
import collision_handlers.Mario_CH;
import design_patterns.State;
import sprites.Player;
import util.Location;
import util.Pixmap;
import util.Vector;
import view.View;
import abstract_sprites.AbstractPlayer;

public class Mario extends Player {

    private Mario_CH collisionHandler = new Mario_CH();
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
    private static final Vector LEFT_VELOCITY = new Vector(LEFT_DIRECTION, MOVE_SPEED);
    private static final Vector RIGHT_VELOCITY = new Vector(RIGHT_DIRECTION, MOVE_SPEED);
    private static final Vector UP_VELOCITY = new Vector(UP_DIRECTION, MOVE_SPEED);
    private static final Vector DOWN_VELOCITY = new Vector(DOWN_DIRECTION, MOVE_SPEED);
    
    public Mario_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Mario_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Mario (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size, view);
        myView = view;
        myOriginalCenter = center;
        mySize = size;
        myImage = image;
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Mario");
    }
    
    @Override
    public Type getType() {
        return Type.MARIO;
    }
    

   
    
    
    public void update(double elapsedTime, Dimension bounds) {
//        Commented out for scrolling testing
//        currentState.update();
        // move based on input
//      ONLY FOR TESTING
        int key = myView.getLastKeyPressed();
        if (key == MOVE_LEFT)
        {
            translate(LEFT_VELOCITY);
        }
        if (key == MOVE_RIGHT)
        {
            translate(RIGHT_VELOCITY);
        }
        if (key == MOVE_UP)
        {
            translate(UP_VELOCITY);
        }
        if (key == MOVE_DOWN)
        {
            translate(DOWN_VELOCITY);
        }
//        ONLY FOR TESTING
    }
   
    public void changeState(State newState) {
        currentState = newState;
    }
}



