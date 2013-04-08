package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import scrollingmanager.ScrollingManager;
import sprites.Player;
import util.Location;
import util.Pixmap;
import view.View;

public class Model {

    private View myView;
    private Player myPlayer;
    
    // This is weird how it works. I think you just need to instantiate it(see constructor)
    private ModelInputs myInputs;
    private LevelManager myLevelManager;
    
    public Model (View view, ScrollingManager myScrollingManager) {
         myPlayer = new Player(new Pixmap("brick9.gif"), new Location(100,100), new Dimension(10,10), view);
        
        myInputs = new ModelInputs(myPlayer, view);
        myView = view;        
        myLevelManager = new LevelManager(myScrollingManager, view);
        myLevelManager.currentLevel().addPlayer(myPlayer);
    }

    private void intersectingSprites (){
        
    }
    
    /**
     * Draw all elements of the game.
     */
     public void paint(Graphics2D pen) {
         myLevelManager.currentLevel().paint(pen);
     }
    
     public void update(double elapsedTime) {
         myLevelManager.currentLevel().update(elapsedTime, myView.getSize(), myView);
     }
     
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
