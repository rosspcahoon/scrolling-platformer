package level_editor;


import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import sprites.Player;
import util.Location;
import level_editor.commands.Command;
import level_editor.commands.CommandLibrary;


/**
 * Level Editor creates and edits an Editable Level based on input from the
 * iLEView myView.
 * 
 * @author Danny Goodman
 *
 */
import util.Editable;
import util.IModel;
import util.Pixmap;

public class LevelEditor implements IModel {

    private static final String SPACE = " ";
    private static final String NO_METHOD_COMMAND_ERROR = "Command does not exist";
    private static final String PARAM_COMMAND_ERROR = "Incorrect Parameters";
    private static final String DEFAULT_COMMAND_ERROR = "Incorrect Command";
    private Editable myLevel;

    public LevelEditor () {
        myLevel = new Level(1); 
    }

    public LevelEditor (String language) {
        this();
    }

    @Override
    public int processCommand (Editable m, String cmd) {
        // TODO Auto-generated method stub
        myLevel = (Level) m;
        processCommand(cmd);
        return 0;
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
        //TODO change Background based on id
    }

    /**
     * Takes in the command name and parameters all as one String to be processed.
     * Splits the string by White Space and obtains name and parameters from String.
     * Calls @Command method through reflection.
     * 
     * @param command - the input from the LEView. 
     */
    
    private void processCommand (String command) {
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
        l.processCommand("addSprite 1 400 500");
        SpriteGrid sg = new SpriteGrid(4,4);
        sg.addSprite(new Player(new Pixmap("ball.gif"), new Location(), new Dimension(100,100)), 10, 10);
        for(int i = 0; i < 4;i++){
            for(int j = 0; j < 4;j++){
                sg.addSprite(new Player(new Pixmap("ball.gif"), new Location(), new Dimension(25,25)), i*25, j*25);
            }
        }
        sg.deleteSprite(50, 45);
        for(int i = 0; i < 4;i++){
            for(int j = 0; j < 4;j++){
                sg.addSprite(new Player(new Pixmap("ball.gif"), new Location(), new Dimension(25,25)), i*25, j*25);
            }
        }
    }
}
