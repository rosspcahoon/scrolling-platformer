package level_editor;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import util.Sprite;

public class Level implements Renderable{

    private List<Sprite> mySprites;
    private Status myStatus;
    
    public Level(){
        mySprites = new ArrayList<Sprite>();
    }   
    
    public void addSprite(Sprite s){
        mySprites.add(s);
    }
    
    @Override
    public Status getState () {
        return myStatus;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub
        
    }

}
