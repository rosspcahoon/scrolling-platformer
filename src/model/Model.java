package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import sprites.Player;
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
   // private List<Level> myLevels;
    private Level myCurrLevel;
    private View myView;


    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model(View view) {
        myView = view;
        //ONLY USED FOR TESTING
        myCurrLevel = new Level(1);
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);
        myCurrLevel.addSprite(new Player(new Pixmap("brick9.gif"), 
                                     new Location(myView.getWidth() / 2, myView.getHeight()-25),
                                     new Dimension(25, 25),
                                     myView));
        
        //ONLY USED FOR TESTING
    }

    /**
     * Update game for this moment, given the time since the last moment.
     */
    public void update(double elapsedTime) {
        Dimension bounds = myView.getSize();
        myCurrLevel.update(elapsedTime, bounds);
    }

    /**
     * Draw all elements of the game.
     */
    public void paint(Graphics2D pen) {
        myCurrLevel.paint(pen);
    }

}
