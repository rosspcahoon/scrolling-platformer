package collision_handlers;

import test_sprites.Coin;
import test_sprites.Koopa;
import test_sprites.Mario;
import test_sprites.Platform;
import test_sprites.Turtle;
import util.Sprite;
import design_patterns.Visitor;

public class Koopa_CH extends CollisionHandler implements Visitor {

    @Override
    public void visit (Mario mario) {
        System.out.println("Koopa has just collided with Mario!");
        
    }

    @Override
    public void visit (Coin coin) {
        System.out.println("Koopa has just collided with Coin!");
        
    }

    @Override
    public void visit (Koopa koopa) {
        System.out.println("Koopa has just collided with Koopa!");
        
    }

    @Override
    public void visit (Platform platform) {
        System.out.println("Koopa has just collided with Platform!");
        
    }

    @Override
    public void visit (Turtle turtle) {
        System.out.println("Koopa has just collided with Turtle!");
        
    }

    public void handleKoopaCollision (Sprite obj2) {
        System.out.println(obj2.getType());
        
        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                this.visit(object1);
                break;
                
            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                this.visit(object2);
                break;
                
            case MARIO:
                Mario object3 = (Mario) obj2;
                this.visit(object3);
                break;
                
            case PLATFORM:
                Platform object4  = (Platform) obj2;
                this.visit(object4);
                break;
                
            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                this.visit(object5);
                break;
        }
    }
}
