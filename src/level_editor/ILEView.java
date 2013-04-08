package level_editor;


import util.Location;
import viewUtil.Renderable;

/**
 * Interface between LevelEditor and LEView. LevelEditor can only pass a Renderable
 * object to the view which will then paint the object.
 * 
 * @author Danny Goodman
 * 
 * This Interface specifies Domain-specific tools -TODO
 *
 */
public interface ILEView {

    /**
     * Render the Renderable Object based on State.
     * 
     * @param r
     */
    public void render(Renderable r);
    
//    public void createSprite(int SpriteID, Location l);
//    
//    public void removeSprite(Location l);
    
}
