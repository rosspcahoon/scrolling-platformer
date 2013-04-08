package test_sprites;

import java.awt.Dimension;
import collision_handlers.CollisionHandler;
import collision_handlers.Turtle_CH;
import util.Location;
import util.Pixmap;
import abstract_sprites.AbstractNonStaticEntity;

public class Turtle extends AbstractNonStaticEntity {

    
    private Turtle_CH collisionHandler = new Turtle_CH();
    
    
    public Turtle_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Turtle_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Turtle (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Turtle");
    }
    
    @Override
    public Type getType() {
        return Type.TURTLE;
    }
}
