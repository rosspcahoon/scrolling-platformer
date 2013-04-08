package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import scrollingmanager.ScrollingManager;
import sprites.Player;
import util.Location;
import util.Pixmap;
import view.View;

/**
 * Represents a scrolling platformer.
 *  * 
 * @author Ross Cahoon
 * @author Jay Wang
 * @author Scott Valentine
 */

public class Model {

    private View myView;
    private Player myPlayer;
    
    // This is weird how it works. I think you just need to instantiate it(see constructor)
    private ModelInputs myInputs;
    private LevelManager myLevelManager;
    
    /**
     * Constructs a new Model based on the view and the scrolling manager used by the game.
     * 
     * @param view which is used to display/control game.
     * @param myScrollingManager used to control in-game scrolling.
     */
    public Model (View view, ScrollingManager myScrollingManager) {
        // TODO: player instantiation changes from game to game.
         myPlayer = new Player(new Pixmap("brick9.gif"), new Location(100,100), new Dimension(10,10), view);
        
        myInputs = new ModelInputs(myPlayer, view);
        myView = view;        
        myLevelManager = new LevelManager(myScrollingManager, view);
        myLevelManager.currentLevel().addPlayer(myPlayer);
    }

    // TODO: find way to handle intersections (maybe within level)
    private void intersectingSprites (){
        
    }
    
    /**
     * Draw all elements of the game.
     */
     public void paint(Graphics2D pen) {
         myLevelManager.currentLevel().paint(pen);
     }
    
     /**
      * Updates all the game elements since the last update.
      * 
      * @param elapsedTime is the elapsed time since the last update.
      */
     public void update(double elapsedTime) {
         myLevelManager.currentLevel().update(elapsedTime, myView.getSize(), myView);
     }
     
     /**
      * Gives the right boundary
      * 
      * @return
      */
     public double getRightBoundary() {
         return myLevelManager.currentLevel().getRightBoundary();
     }

     public double getLeftBoundary() {
         return myLevelManager.currentLevel().getLeftBoundary();
     }

     public double getUpperBoundary() {
         return myLevelManager.currentLevel().getUpperBoundary();
     }

     public double getLowerBoundary() {
         return myLevelManager.currentLevel().getLowerBoundary();
     }
     
     public Dimension getLevelBounds() {
         return myLevelManager.currentLevel().getLevelBounds();
     }
}
