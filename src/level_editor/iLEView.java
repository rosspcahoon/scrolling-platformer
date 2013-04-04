package level_editor;

/**
 * Interface between LevelEditor and LEView. LevelEditor can only pass a Renderable
 * object to the view which will then paint the object.
 * 
 * @author Danny Goodman
 *
 */
public interface iLEView {

    /**
     * Render the Renderable Object based on State.
     * 
     * @param r
     */
    public void render(Renderable r);
    
}
