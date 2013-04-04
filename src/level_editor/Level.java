package level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import util.PlatformerConstants;
import util.Sprite;
//import util.Sprite;
import util.WorkspaceModel;
import viewUtil.Renderable;

public class Level extends WorkspaceModel{
   
   private Dimension myFrameOfAction = new Dimension(PlatformerConstants.ACTION_FRAME_SIZE);
   private Dimension myFrameOfReference = new Dimension(PlatformerConstants.REFERENCE_FRAME_SIZE);
   private Sprite myPlayer;
   private List<Sprite> mySprites;
   private List<Sprite> myFrameOfActionSprites;
   private List<Sprite> myFrameOfReferenceSprites;
    
    public Level(int id){
//        mySprites = new ArrayList<Sprite>();
    }   
    
//    public void addSprite(Sprite s){
//        mySprites.add(s);
//    }
//    
    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub
        
    }

}
