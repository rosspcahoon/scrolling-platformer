package level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import sprites.Player;
import util.PlatformerConstants;
import util.Sprite;
//import util.Sprite;
import util.WorkspaceModel;
import view.View;
public class Level extends WorkspaceModel{

    private Dimension mySize;
    private Dimension frameOfReferenceSize;
    private Dimension frameOfActionSize;
    private Player myPlayer;
    private List<Sprite> mySprites;
    private List<Sprite> myFrameOfActionSprites;
    private List<Sprite> myFrameOfReferenceSprites;
    

    public Level(int id){
        //MIGHT WANT TO INITIALIZE THIS WITH A PLAYER AS WELL
        mySize = PlatformerConstants.DEFAULT_LEVEL_SIZE;
        initFrames();
    }

    private void initFrames() {
        myFrameOfActionSprites = new ArrayList<Sprite>();
        myFrameOfReferenceSprites = new ArrayList<Sprite>();
        mySprites = new ArrayList<Sprite>();       
    }

    public void setSize(Dimension size) {
        mySize = size;
    }
    /**
     * Adds a sprite to the level. If the Sprite is a player,
     *  it will set it to the current player.
     * @param s the Sprite to be added
     */

    public void addSprite(Sprite s){

        if(s.getClass().getName().equals("sprites.Player")) {
            myPlayer = (Player) s;
        }
        else {
            mySprites.add(s);
        }
    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    public void update(double elapsedTime, Dimension bounds, View view) {
        if(myPlayer != null) {
//            System.out.println("Player Location: " + myPlayer.getCenter());
            updateFrames(view);
            myPlayer.update(elapsedTime, bounds);
            for(Sprite s: myFrameOfActionSprites) {
                s.update(elapsedTime, bounds);
            }
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        if(myPlayer != null) {
            for(Sprite s: myFrameOfReferenceSprites) {
                s.paint(pen,myPlayer.getCenter(), myPlayer.getOriginalCenter());
            }
            myPlayer.paint(pen);
        }
    }

    private void updateFrames(View view) {
        myFrameOfActionSprites.clear();
        myFrameOfReferenceSprites.clear();
       frameOfReferenceSize = view.getSize();
       frameOfActionSize = calcActionFrameSize(view.getSize());
        if(mySprites.size() > 0) {
            for(Sprite s: mySprites) {
//                System.out.println("Sprite Location: " + s.getCenter());
                if(checkRange(s, frameOfReferenceSize)) {
                    myFrameOfReferenceSprites.add(s);
                    myFrameOfActionSprites.add(s);
                }
                if(!myFrameOfActionSprites.contains(s) & checkRange(s, frameOfActionSize)) {
                    myFrameOfActionSprites.add(s);
                }
            }
        }

    }

    private boolean checkRange(Sprite sprite, Dimension frame) {
        //This is pretty hacky, I am trying to think of a more elegant way
        if(myPlayer == null ||
                myPlayer.getLeftBoundary(frame) > sprite.getX()
                || myPlayer.getRightBoundary(frame) < sprite.getX()
                || myPlayer.getLowerBoundary(frame) < sprite.getY()
                || myPlayer.getUpperBoundary(frame) > sprite.getY()) {
            return false;
        }
        return true;
    }
    
    private Dimension calcActionFrameSize(Dimension size) {
        Dimension temp = new Dimension((int) size.getWidth() + 100, (int) size.getHeight() + 100);
        return temp;
    }
    
    public int getRightBoundary() {
        return myPlayer.getRightBoundary(frameOfReferenceSize);
    }
    
    public int getLowerBoundary() {
        return myPlayer.getLowerBoundary(frameOfReferenceSize);
    }
}
