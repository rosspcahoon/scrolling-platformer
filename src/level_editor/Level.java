package level_editor;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import util.Sprite;
import util.WorkspaceModel;
import viewUtil.Renderable;

public class Level extends WorkspaceModel{

    private List<Sprite> mySprites;
    
    public Level(int id){
        mySprites = new ArrayList<Sprite>();
    }   
    
    public void addSprite(Sprite s){
        mySprites.add(s);
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

}
