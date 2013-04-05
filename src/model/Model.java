package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
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
    }

    /**
     * Update game for this moment, given the time since the last moment.
     */
    public void update(double elapsedTime) {
        Dimension bounds = myView.getSize();
//            updateSprites(elapsedTime, bounds, myView);

    }

    /**
     * Draw all elements of the game.
     */
    public void paint(Graphics2D pen) {
        myCurrLevel.paint(pen);
    }

}
