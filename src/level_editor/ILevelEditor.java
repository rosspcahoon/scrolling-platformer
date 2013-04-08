package level_editor;

/**
 * Interface between a LevelEditor model and a Level Editor view.
 * This interface defines the behavior that any external component should
 * expect from a Level Editor entity (domain-specific).
 * 
 *  
 * Initial implementation: View can only pass a command to the LevelEditor.
 * 
 * @author Danny Goodman, Dagbedji Fagnisse
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
