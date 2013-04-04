package sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import collision_handlers.PlayerCollisionHandler;
import design_patterns.State;
import util.Location;
import util.Pixmap;


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
public class Player extends AbstractCharacter {

    Graphics2D pen;
    PlayerCollisionHandler myCollisionHandler;
    List<State> myStates;
    State currentState; 
    
    public Player (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }
    
    
    public void update() {
        currentState.update();
    }
    
    public void paint() {
        currentState.draw(pen);
    }
    
    public void changeState(State newState) {
        currentState = newState;
    }


}
