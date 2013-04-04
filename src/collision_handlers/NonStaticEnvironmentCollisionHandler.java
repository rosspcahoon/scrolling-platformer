package collision_handlers;

import design_patterns.Visitor;
import sprites.NonPlayableCharacter;
import sprites.NonStaticEnviroPlaceHolder;
import sprites.Player;
import sprites.StaticEnviroPlaceHolder;

/**
 * Same idea as the PlayerCollisionHandler... 
 * 
 * @author Jay Wang
 *
 */
public class NonStaticEnvironmentCollisionHandler implements Visitor {

    @Override
    public void visit (Player player) {
        // TODO Auto-generated method stub
        
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
