package level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;
import util.Sprite;
import viewUtil.Renderable;


public class SpriteGrid implements Renderable {

    private static final int DEFAULT_SPRITE_SIZE = 25;
    private int mySpriteSize;
    private SpriteBox[][] myGrid;
    private Dimension mySize;
    private Set<SpriteBox> myPaintableBoxes;

    public SpriteGrid (int x, int y) {
        mySpriteSize = DEFAULT_SPRITE_SIZE;
        mySize = new Dimension(x, y);
        myGrid = new SpriteBox[x][y];
        initializeGrid();
        myPaintableBoxes = new HashSet<SpriteBox>();
    }

    public void addSprite (Sprite spr, int x, int y) {
        SpriteBox currentBox = nearestBox(x, y);
        if (checkAvailable(currentBox, spr.getWidth(), spr.getHeight())) {
            currentBox.addSprite(spr);
            myPaintableBoxes.add(currentBox);
            combineBoxes(currentBox, currentBox, spr.getWidth(), spr.getHeight());
        }
        ;
    }

    private boolean checkAvailable (SpriteBox current, double width, double height) {
        if(!current.isAvailable()){
            return false;
        }
        boolean bool1 = true;
        boolean bool2 = true;
        if (width > mySpriteSize) {
            SpriteBox next = nearestBox(current.getX() + mySpriteSize, current.getY());
            bool1 = checkAvailable(next, width - mySpriteSize, height);
        }
        if (height > mySpriteSize) {
            SpriteBox nextBox = nearestBox(current.getX(), current.getY() + mySpriteSize);
            bool2 = checkAvailable(nextBox, width, height - mySpriteSize);
        }
        return bool1 && bool2;
    }

    private void combineBoxes (SpriteBox initial, SpriteBox current, double width, double height) {
        if (width > mySpriteSize) {
            SpriteBox next = nearestBox(current.getX() + mySpriteSize, current.getY());
            initial.combineWith(next);
            combineBoxes(initial, next, width - mySpriteSize, height);
        }
        if (height > mySpriteSize) {
            SpriteBox nextBox = nearestBox(current.getX(), current.getY() + mySpriteSize);
            initial.combineWith(nextBox);
            combineBoxes(initial, nextBox, width, height - mySpriteSize);
        }
    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub

    }

    public int getSpriteSize () {
        return mySpriteSize;
    }

    private void initializeGrid () {
        for (int x = 0; x < mySize.getWidth(); x++) {
            for (int y = 0; y < mySize.getHeight(); y++) {
                myGrid[x][y] = new SpriteBox(this, x, y);
            }
        }
    }

    private SpriteBox nearestBox (double x, double y) {
        int xCoord = (int) Math.round(x / mySpriteSize);
        int yCoord = (int) Math.round(x / mySpriteSize);
        return myGrid[xCoord][yCoord];
    }

}
