package model;

import java.util.ArrayList;
import java.util.List;
import level_editor.Level;
import scrollingmanager.ScrollingManager;
import util.PlatformerConstants;
import view.View;
/**
 * Instantiates all of the levels for gameplay.
 * 
 * @author Scott Valentine
 *
 */
public class LevelFactory {

    /**
     * Generates levels to be displayed by the view and played by the model.
     * 
     * @param view is the view used for level information.
     * @return a List of all levels that will be played in the game.
     */
    public List<Level> generateLevels (ScrollingManager myScrollingManager, View view) {
        Level myCurrLevel = new Level(1, myScrollingManager, view);
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);
        List<Level> l = new ArrayList<Level>();
        l.add(myCurrLevel);
        return l;
    }

}
