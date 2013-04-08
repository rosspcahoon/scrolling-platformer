package level_editor;

/**
 * Interface between LevelEditor and LEView. LEView can only pass a command to the 
 * LevelEditor.
 * This interface defines the behavior that any view/controller component should
 * expect from the Level Editor model.
 * 
 * @author Danny Goodman
 *
 */
public interface ILEModel {

    /**
     * Process a String representing a command.
     * 
     * @param command - unprocessed String.
     */
    public void processCommand(String command);

    
}
