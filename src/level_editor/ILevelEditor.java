package level_editor;

/**
 * Interface between LevelEditor and LEView. LEView can only pass a command to the 
 * LevelEditor.
 * 
 * @author Danny Goodman
 *
 */
public interface ILevelEditor {

    /**
     * Process a String representing a command.
     * 
     * @param command - unprocessed String.
     */
    public void processCommand(String command);

    
}
