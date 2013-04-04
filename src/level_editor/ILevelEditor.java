package level_editor;

<<<<<<< HEAD:src/level_editor/iLevelEditor.java
/**
 * Interface between LevelEditor and LEView. LEView can only pass a command to the 
 * LevelEditor.
 * 
 * @author Danny Goodman
 *
 */
public interface iLevelEditor {
=======
public interface ILevelEditor {
>>>>>>> cc6e9d36831ed8df8cdcd9a25f622626d3d29928:src/level_editor/ILevelEditor.java

    /**
     * Process a String representing a command.
     * 
     * @param command - unprocessed String.
     */
    public void processCommand(String command);

    
}
