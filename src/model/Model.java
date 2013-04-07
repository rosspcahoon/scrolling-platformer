package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import collision_handlers.Coin_CH;
import collision_handlers.Koopa_CH;
import collision_handlers.Mario_CH;
import collision_handlers.Platform_CH;
import collision_handlers.Turtle_CH;
import sprites.Player;
import sprites.Test_S_One;
import test_sprites.Coin;
import test_sprites.Koopa;
import test_sprites.Mario;
import test_sprites.Platform;
import test_sprites.Turtle;
import test_sprites.Type;
import util.Location;
import util.Pixmap;
import util.PlatformerConstants;
import util.Sprite;
import view.View;
import level_editor.Level;


/**
 * Represents a scrolling platformer.
 *  * 
 * @author Ross Cahoon
 * @author Jay Wang
 */
public class Model {
   // private List<Level> myLevels;
    private Level myCurrLevel;
    private View myView;
    private List<Sprite> spriteList; 


    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model(View view) {
        setSpriteList(new ArrayList<Sprite>());
        myView = view;
        //ONLY USED FOR TESTING
        myCurrLevel = new Level(1, view);
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);
        
        spriteList.add(new Player(new Pixmap("brick9.gif"), 
                                     new Location(myView.getWidth() / 2, myView.getHeight() / 2),
                                     new Dimension(25, 25),
                                     myView));
        
        spriteList.add(new Test_S_One(new Pixmap("brick10.gif"), 
                                             new Location(myView.getWidth() - 100, myView.getHeight() - 100),
                                             new Dimension(25, 25))); 
        
        spriteList.add(new Mario(new Pixmap("mario.gif"), 
                                      new Location(myView.getWidth() - 200, myView.getHeight() - 200),
                                      new Dimension(30, 60),
                                      myView));     
        
        spriteList.add(new Coin(new Pixmap("coin.gif"), 
                                 new Location(myView.getWidth() - 400, myView.getHeight() - 250),
                                 new Dimension(30, 30)));   
        
        spriteList.add(new Koopa(new Pixmap("koopa.gif"), 
                                 new Location(myView.getWidth() - 300, myView.getHeight() - 275),
                                 new Dimension(30, 60)));   
        
        spriteList.add(new Platform(new Pixmap("platform.gif"), 
                                 new Location(myView.getWidth() - 80, myView.getHeight() - 150),
                                 new Dimension(30, 60)));   
        
        spriteList.add(new Turtle(new Pixmap("turtle.gif"), 
                                 new Location(myView.getWidth() - 500, myView.getHeight() - 75),
                                 new Dimension(30, 60)));   
        
        
        for (Sprite sprite : spriteList) {
            myCurrLevel.addSprite(sprite);
            System.out.println(sprite.toString());
        }
               

        //ONLY USED FOR TESTING
    }

    /**
     * Update game for this moment, given the time since the last moment.
     */
    public void update(double elapsedTime) {
        Dimension bounds = myView.getSize();
        intersectingSprites();
        myCurrLevel.update(elapsedTime, bounds, myView);
    }
    
    private void intersectingSprites () {        
        for (int i = 0; i < spriteList.size(); i++) {
            for (int j = i+1; j < spriteList.size(); j++) {     
                handleCollision(spriteList.get(i), spriteList.get(j));
                handleCollision(spriteList.get(j), spriteList.get(i));
            }
        }
    }
    
    private void handleCollision (Sprite obj1, Sprite obj2) {
        
        if (!obj1.intersects(obj2)) return;
        
        switch (obj1.getType()) {
            case COIN:
                Coin object1 = (Coin) obj1;
                object1.getCollisionHandler().handleCoinCollision(obj2);
                break;
                
            case KOOPA:
                Koopa object2 = (Koopa) obj1;
                object2.getCollisionHandler().handleKoopaCollision(obj2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj1;
                object3.getCollisionHandler().handleMarioCollision(obj2);
                break;
                
            case PLATFORM:
                Platform object4 = (Platform) obj1;
                object4.getCollisionHandler().handlePlatformCollision(obj2);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj1;
                object5.getCollisionHandler().handleTurtleCollision(obj2);
                break;

            default:
                break;
                
        }       
    }
    
    /**
     * Draw all elements of the game.
     */
    public void paint(Graphics2D pen) {
        myCurrLevel.paint(pen);
    }
    
    public double getRightBoundary() {
        return myCurrLevel.getRightBoundary();
    }
    
    public double getLowerBoundary() {
        return myCurrLevel.getLowerBoundary();
    }

    public List<Sprite> getSpriteList () {
        return spriteList;
    }

    public void setSpriteList (List<Sprite> spriteList) {
        this.spriteList = spriteList;
    }
}
