package level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Set;
import scrollingmanager.ScrollingManager;
import util.Editable;
import util.Location;
import util.Sprite;
import viewUtil.Renderable;


public class SpriteGrid implements Editable, Renderable{

    private static final int DEFAULT_SPRITE_SIZE = 25;
    private int mySpriteSize;
    private SpriteBox[][] myGrid;
    private Dimension mySize;
    private Set<SpriteBox> myPaintableBoxes;
    private ScrollingManager myScrollingManager;

    public SpriteGrid (int x, int y) {
        mySpriteSize = DEFAULT_SPRITE_SIZE;
        mySize = new Dimension(x, y);
        myGrid = new SpriteBox[x][y];
        initializeGrid();
        myPaintableBoxes = new HashSet<SpriteBox>();
    }

    public int getSpriteSize () {
        return mySpriteSize;
    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        for (SpriteBox box : myPaintableBoxes) {
            box.paint(pen);
        }
    }

    public void addSprite (Sprite spr, int x, int y) {
        SpriteBox currentBox = nearestBox(x, y);
        if (checkAvailable(currentBox, spr.getWidth(), spr.getHeight())) {
            currentBox.addSprite(spr);
            myPaintableBoxes.add(currentBox);
            combineBoxes(currentBox, currentBox, spr.getWidth(), spr.getHeight());}
        else{
            // TODO send Unavailable feedback
        }
    }

    public void deleteSprite (int x, int y) {
        SpriteBox currentBox = nearestBox(x, y);
        currentBox.deleteSprite();
        myPaintableBoxes.remove(currentBox);
    }
    
    public Editable createLevel(int id){
        Editable lev = new Level(id, myScrollingManager);
        for(SpriteBox box:myPaintableBoxes){
            lev.addNewSprite(box.getSprite());
        }
        return lev;
    }

    private boolean checkAvailable (SpriteBox current, double width, double height) {
        if (!current.isAvailable()) { return false; }
        boolean bool1 = true;
        boolean bool2 = true;
        if (width > mySpriteSize) {
            SpriteBox next = nearestBox(current.getX() + mySpriteSize, current.getY());
            bool1 = checkAvailable(next, width - mySpriteSize, height);
        }
        if (height > mySpriteSize && bool1) {
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
            SpriteBox next = nearestBox(current.getX(), current.getY() + mySpriteSize);
            initial.combineWith(next);
            combineBoxes(initial, next, width, height - mySpriteSize);
        }
    }

    private SpriteBox nearestBox (double x, double y) {
        int xCoord = (int) Math.round(x / mySpriteSize);
        int yCoord = (int) Math.round(y / mySpriteSize);
        return myGrid[xCoord][yCoord];
    }

    private void initializeGrid () {
        for (int x = 0; x < mySize.getWidth(); x++) {
            for (int y = 0; y < mySize.getHeight(); y++) {
                myGrid[x][y] = new SpriteBox(this, x, y);
            }
        }
    }

    @Override
    public void changeBackground () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addNewSprite (Sprite s) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteSprite (Location deleteAtLocation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setErrorMessage (String errorMessage) {
        // TODO Auto-generated method stub
        
    }

}
