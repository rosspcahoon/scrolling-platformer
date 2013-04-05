package level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
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
        mySize = PlatformerConstants.DEFAULT_LEVEL_SIZE;
        mySprites = new ArrayList<Sprite>();
    }   

    public void addSprite(Sprite s){
        if(s.getClass().getName().equals("Player")) {
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

    public void update() {
        updateFrames();
        //        myPlayer.update(elapsedTime, bounds);
        for(Sprite s: myFrameOfActionSprites) {
            //            s.update(elapsedTime, bounds);
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        for(Sprite s: myFrameOfActionSprites) {
            s.paint(pen);
        }
    }

    private void updateFrames() {
        myFrameOfActionSprites.clear();
        myFrameOfReferenceSprites.clear();
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

    private boolean checkRange(Sprite sprite, Dimension frame) {
        //This is pretty hacky, I am trying to think of a more elegant way
        if(myPlayer.getX() - frame.getWidth()/2 > sprite.getX()
                | myPlayer.getX() + frame.getWidth()/2 < sprite.getX()
                | myPlayer.getY() - frame.getHeight()/2 > sprite.getY()
                | myPlayer.getY() + frame.getHeight()/2 < sprite.getY()) {
            return false;
        }
        return true;
    }
}
