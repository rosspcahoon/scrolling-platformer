package level_editor;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import util.Location;
import level_editor.commands.Command;
import level_editor.commands.CommandLibrary;
import level_editor.ILevelEditor;


/**
 * Level Editor creates and edits an Editable Level based on input from the
 * iLEView myView.
 * 
 * @author Danny Goodman
 *
 */
import util.IModel;
import util.WorkspaceModel;

public class LevelEditor implements ILevelEditor, IModel {

    public LevelEditor (String language) {
        // TODO Auto-generated constructor stub
    }

    private static final String SPACE = " ";
    private static final String NO_METHOD_COMMAND_ERROR = "Command does not exist";
    private static final String PARAM_COMMAND_ERROR = "Incorrect Parameters";
    private static final String DEFAULT_COMMAND_ERROR = "Incorrect Command";
    private Editable myLevel;
    private ILEView myView;

    public LevelEditor () {
        myLevel = new Level(0); // TODO Why the id????
    }

    /**
     * Takes in the command name and parameters all as one String to be processed.
     * Splits the string by White Space and obtains name and parameters from String.
     * Calls @Command method through reflection.
     * 
     * @param command - the input from the LEView. 
     */
    @Override
    public void processCommand (String command) {
        String[] splitCommand = command.split(SPACE);
        String name = splitCommand[0];
        Object[] params = getParams(splitCommand);
        try {
            Method m = CommandLibrary.get(name);
            m.invoke(this, params);
        }
        catch (NullPointerException e) {
            myLevel.setErrorMessage(NO_METHOD_COMMAND_ERROR);
        }
        catch (IllegalAccessException e) {
            myLevel.setErrorMessage(DEFAULT_COMMAND_ERROR);
        }
        catch (IllegalArgumentException e) {
            myLevel.setErrorMessage(PARAM_COMMAND_ERROR);
        }
        catch (InvocationTargetException e) {
            myLevel.setErrorMessage(DEFAULT_COMMAND_ERROR);
        }
    }

    @Command
    public void createSprite (int id, int x, int y) {
        //TODO create Sprite based on id.
    }
    
    @Command
    public void deleteSprite (int x, int y) {
        myLevel.deleteSprite(new Location(x,y));
    }

    @Override
    public int processCommand (WorkspaceModel m, String cmd) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Command
    public void changeBackground (int id) {
        //TODO change Background based on id
    }

    /**
     * Takes in the command as a Sting[] and returns the parameters as an Integer[].
     * The output is used by the processCommand method to invoke the command method.
     * @param splitCommand - command as a String[] with name followed by params.
     * @return Integer[] of parameters
     */
    private Integer[] getParams (String[] splitCommand) {
        Integer[] params = new Integer[splitCommand.length - 1];
        for (int i = 0; i < params.length; i++) {
            params[i] = Integer.parseInt(splitCommand[i + 1]);
        }
        return params;
    }

    //For Preliminary Testing only. Will be deleted.
    public static void main (String args[]) {
        LevelEditor l = new LevelEditor();
        l.processCommand("deleteSprite 400 500");
    }
}
