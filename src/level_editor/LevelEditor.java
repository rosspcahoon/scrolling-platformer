package level_editor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import util.Location;
import util.Sprite;
import level_editor.commands.Command;
import level_editor.commands.CommandLibrary;


public class LevelEditor implements iLevelEditor {

    private static final String SPACE = " ";
    private static final String NO_METHOD_COMMAND_ERROR = "Command does not exist";
    private static final String PARAM_COMMAND_ERROR = "Incorrect Parameters";
    private static final String DEFAULT_COMMAND_ERROR = "Incorrect Command";
    private Editable myLevel;

    public LevelEditor () {
        myLevel = new Level();
    }

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
    
    @Command
    public void changeBackground (int id) {
        
    }

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
