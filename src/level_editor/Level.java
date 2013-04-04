package level_editor;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import util.Location;
import util.Sprite;

public class Level implements Renderable, Editable{

    private List<Sprite> mySprites;
    private Status myStatus;
=======
//import util.Sprite;
import util.WorkspaceModel;
import viewUtil.Renderable;

public class Level extends WorkspaceModel{

//    private List<Sprite> mySprites;
>>>>>>> cc6e9d36831ed8df8cdcd9a25f622626d3d29928
    
    public Level(int id){
//        mySprites = new ArrayList<Sprite>();
    }   
    
<<<<<<< HEAD
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
    
=======
//    public void addSprite(Sprite s){
//        mySprites.add(s);
//    }
//    
>>>>>>> cc6e9d36831ed8df8cdcd9a25f622626d3d29928
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
