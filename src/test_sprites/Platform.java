package test_sprites;

import java.awt.Dimension;
import collision_handlers.CollisionHandler;
import collision_handlers.Platform_CH;
import util.Location;
import util.Pixmap;
import abstract_sprites.AbstractStaticEntity;

public class Platform extends AbstractStaticEntity{

    private Platform_CH collisionHandler = new Platform_CH();
    
    
    public Platform_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Platform_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Platform (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Platform");
    }
    
    @Override
    public Type getType() {
        return Type.PLATFORM;
    }
}
