package test_sprites;

import java.awt.Dimension;
import collision_handlers.Coin_CH;
import collision_handlers.CollisionHandler;
import util.Location;
import util.Pixmap;
import abstract_sprites.AbstractStaticEntity;

public class Coin extends AbstractStaticEntity {

    
    private Coin_CH collisionHandler = new Coin_CH();
    
    public Coin_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Coin_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Coin (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }

    
    public void print() {
        System.out.println("Coin");
    }
    
    @Override
    public Type getType() {
        return Type.COIN;
    }



}
