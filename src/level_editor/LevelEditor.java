package level_editor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import level_editor.commands.Command;
import level_editor.commands.CommandLibrary;


public class LevelEditor implements iLevelEditor {

    private static final String SPACE = " ";
    private static final String NO_METHOD_COMMAND_ERROR = "Command does not exist";
    private static final String PARAM_COMMAND_ERROR = "Incorrect Parameters";
    private static final String DEFAULT_COMMAND_ERROR = "Incorrect Command";
    private Level myLevel;

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
            myLevel.getState().setErrorMessage(NO_METHOD_COMMAND_ERROR);
        }
        catch (IllegalAccessException e) {
            myLevel.getState().setErrorMessage(DEFAULT_COMMAND_ERROR);
        }
        catch (IllegalArgumentException e) {
            myLevel.getState().setErrorMessage(PARAM_COMMAND_ERROR);
        }
        catch (InvocationTargetException e) {
            myLevel.getState().setErrorMessage(DEFAULT_COMMAND_ERROR);
        }
    }

    @Command
    public void createSprite (int id, int x, int y) {
        System.out.println("create sprite " + id + " at (" + x + "," + y + ")");
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
        l.processCommand("createSprite 1 400 500");
    }
}
