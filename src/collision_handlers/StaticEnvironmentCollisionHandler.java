package collision_handlers;

import sprites.NonPlayableCharacter;
import sprites.NonStaticEnviroPlaceHolder;
import sprites.Player;
import sprites.StaticEnviroPlaceHolder;
import sprites.Visitor;

/**
 * Same idea as the PlayerCollisionHandler... 
 * 
 * @author Jay Wang
 *
 */
public class StaticEnvironmentCollisionHandler implements Visitor {

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
