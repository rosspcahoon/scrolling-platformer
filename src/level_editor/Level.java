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
public class Level extends WorkspaceModel{

    private Dimension mySize;
    private Sprite myPlayer;
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
            myPlayer = s;
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

    public void update(double elapsedTime, Dimension bounds) {
        if(myPlayer != null) {
            updateFrames();
            myPlayer.update(elapsedTime, bounds);
            for(Sprite s: myFrameOfActionSprites) {
                s.update(elapsedTime, bounds);
            }
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        if(myPlayer != null) {
            for(Sprite s: myFrameOfActionSprites) {
                s.paint(pen);
            }
            myPlayer.paint(pen);
        }
    }

    private void updateFrames() {
        myFrameOfActionSprites.clear();
        myFrameOfReferenceSprites.clear();
        if(mySprites.size() > 0) {
            for(Sprite s: mySprites) {
                if(checkRange(s, PlatformerConstants.REFERENCE_FRAME_SIZE)) {
                    myFrameOfReferenceSprites.add(s);
                    myFrameOfActionSprites.add(s);
                }
                if(!myFrameOfActionSprites.contains(s) & checkRange(s, PlatformerConstants.ACTION_FRAME_SIZE)) {
                    myFrameOfActionSprites.add(s);
                }
            }
        }

    }

    private boolean checkRange(Sprite sprite, Dimension frame) {
        //This is pretty hacky, I am trying to think of a more elegant way
        //        System.out.println(myPlayer == null);
        //        double x = myPlayer.getX();
        if(myPlayer == null ||
                myPlayer.getX() - frame.getWidth()/2 > sprite.getX()
                | myPlayer.getX() + frame.getWidth()/2 < sprite.getX()
                | myPlayer.getY() - frame.getHeight()/2 > sprite.getY()
                | myPlayer.getY() + frame.getHeight()/2 < sprite.getY()) {
            return false;
        }
        return true;
    }
}
