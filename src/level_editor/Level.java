package level_editor;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import util.Editable;
import util.Location;
import util.Sprite;
import viewUtil.Renderable;

public class Level implements Editable, Renderable {


    private List<Sprite> mySprites;
    private Status myStatus;
    
    public Level(int id){
        mySprites = new ArrayList<Sprite>();
        myStatus = new Status();
    }   
    
    public void addSprite(Sprite s){
        mySprites.add(s);
    } 
    
//Methods from Renderable Interface. To be called by View components.  
    
    @Override
    public Status getState () {
        return myStatus;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub
        
    }

    
//Methods from Editable Interface. Methods called by LevelEditor.
    
    @Override
    public void changeBackground () { //params need to be added
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
        myStatus.setErrorMessage(errorMessage);
        
    }

}
