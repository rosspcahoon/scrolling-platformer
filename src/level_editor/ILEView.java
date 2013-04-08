package level_editor;


import viewUtil.Renderable;

/**
 * Interface between LevelEditor and LEView. LevelEditor can only pass a Renderable
 * object to the view which will then paint the object.
 * 
 * @author Danny Goodman
 *
 */
public interface ILEView {

    /**
     * Render the Renderable Object based on State.
     * 
     * @param r
     */
    public void render(Renderable r);
    
}
