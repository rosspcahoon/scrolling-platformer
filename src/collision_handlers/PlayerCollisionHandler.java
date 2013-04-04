package collision_handlers;
import design_patterns.Visitor;
import sprites.NonPlayableCharacter;
import sprites.NonStaticEnviroPlaceHolder;
import sprites.Player;
import sprites.StaticEnviroPlaceHolder;

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
    /**
     * Here you would write how the player would respond when it collides 
     * with a NonPlayableCharacter npc. Keep in mind that this is very abstract
     * right now. In reality, it would interact with something like 
     * Koopa koopa. 
     */
    public void visit (NonPlayableCharacter npc) {
        
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
