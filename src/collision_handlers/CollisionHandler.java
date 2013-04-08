package collision_handlers;

import design_patterns.Visitor;
import test_sprites.Coin;
import test_sprites.Koopa;
import test_sprites.Mario;
import test_sprites.Platform;
import test_sprites.Turtle;
import util.Sprite;

public class CollisionHandler {

    public void visit (Sprite sprite) {
        System.err.println("Going into visit method of CollisionHandler. Should never happen.");
        
    }


}
