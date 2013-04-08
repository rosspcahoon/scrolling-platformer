package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import sprites.Player;
import sprites.StaticEnviroPlaceHolder;
import util.Location;
import util.Pixmap;
import util.PlatformerConstants;
import view.View;
import level_editor.Level;


/**
 * Represents a scrolling platformer.
 *  * 
 * @author Ross Cahoon
 */
public class Model {
//    private List<Level> myLevels;
    private Level myCurrLevel;
    private View myView;


    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model(View view) {
        myView = view;
        //ONLY USED FOR TESTING
        myCurrLevel = new Level(1, view);
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);
        myCurrLevel.addSprite(new Player(new Pixmap("brick9.gif"), 
                                     new Location(myView.getWidth() / 2, myView.getHeight() / 2),
                                     new Dimension(25, 25),
                                     myView));
        myCurrLevel.addSprite(new StaticEnviroPlaceHolder(new Pixmap("brick10.gif"), 
                                         new Location(myView.getWidth() + 200, myView.getHeight() / 2),
                                         new Dimension(25, 25)));        
        
        //ONLY USED FOR TESTING
    }

    /**
     * Update game for this moment, given the time since the last moment.
     */
    public void update(double elapsedTime) {
        Dimension bounds = myView.getSize();
        myCurrLevel.update(elapsedTime, bounds, myView);
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
    
    public double getLeftBoundary() {
        return myCurrLevel.getLeftBoundary();
    }
    
    public double getUpperBoundary() {
        return myCurrLevel.getUpperBoundary();
    }
    
    public double getLowerBoundary() {
        return myCurrLevel.getLowerBoundary();
    }
    
    public Dimension getLevelBounds() {
        return myCurrLevel.getLevelBounds();
    }
}
