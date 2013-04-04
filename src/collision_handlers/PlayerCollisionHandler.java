package collision_handlers;
import sprites.NonPlayableCharacter;
import sprites.NonStaticEnviroPlaceHolder;
import sprites.Player;
import sprites.StaticEnviroPlaceHolder;
import sprites.Visitor;

/**
 * Here is a sample for how we want to handle collisions. Each sprite will 
 * have its own collision handler. Every collision handler will handle the 
 * Visitor interface, which will require it to implement a multitude of 
 * visit methods. Each visit method details how this sprite is going to 
 * interact with the Sprite it has just collided with. 
 *   
 * @author Jay Wang
 */

public class PlayerCollisionHandler implements Visitor {

    @Override
    public void visit (Player player) {
        
    }

    @Override
    public void visit (NonPlayableCharacter npc) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit (StaticEnviroPlaceHolder se) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit (NonStaticEnviroPlaceHolder nse) {
        // TODO Auto-generated method stub
        
    }

}