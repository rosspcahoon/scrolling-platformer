package viewUtil;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.Timer;


/**
 * This class is responsible for setting up the menu bar for a specific window.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {
    private static final int DEFAULT_DELAY = 100;
    private Window myWindow;
    private WindowActionLibrary myActionLibrary;
    private JMenu myFileMenu;
    private JMenu myPreferencesMenu;
    private JMenu myHelpMenu;
    private JMenu myEditMenu;
    private Timer myTimer;
    
    /**
     * Constructor for MenuBarView
     * @param window the parent view that component is inside of
     */
    
    public MenuBarView(Window window) {
        myWindow = window;
        myActionLibrary = new WindowActionLibrary(myWindow);
        addComponents();
        ActionListener prefListener =  new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                if (myWindow.getTabCount() > 0) {
                    enableTabDependentsMenus();
                }
            }
        };
        myTimer = new Timer(DEFAULT_DELAY, prefListener);
        myTimer.start();
    }

    private void addComponents () {
        this.add(makeFileMenu());
        this.add(makePreferencesMenu());
        this.add(makeEditMenu());
        this.add(makeHelpMenu());
    }

    private JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.getResources().getString("FileMenu"));
        result.setMnemonic(KeyEvent.VK_F);
        result.add(myActionLibrary.new NewTabAction());
        result.add(myActionLibrary.new OpenFileAction());
        result.add(myActionLibrary.new SaveFileAction());
        result.add(new JSeparator());
        result.add(myActionLibrary.new QuitAction());
        myFileMenu = result;
        return myFileMenu;
    }
    
    private JMenu makeEditMenu() {
        JMenu result = new JMenu(Window.getResources().getString("EditMenu"));
        result.setMnemonic(KeyEvent.VK_E);
        result.add(myActionLibrary.new UndoAction());
        result.add(myActionLibrary.new RedoAction());
        result.setEnabled(false);
        myEditMenu = result;
        return myEditMenu;
    }
    
    private JMenu makePreferencesMenu() {
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.add(myActionLibrary.new ChangeBackgroundAction());
        result.add(myActionLibrary.new ToggleGridAction());
        result.add(myActionLibrary.new ChangeTurtleAction());
        result.add(new JSeparator());
        result.add(myActionLibrary.new ChangePenColorAction());
        result.add(myActionLibrary.new ChangePenPropertiesAction());
        result.setEnabled(false);
        myPreferencesMenu = result;
        return myPreferencesMenu;
    }
    
    private JMenu makeHelpMenu() {
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        result.add(myActionLibrary.new WebInfoAction());
        myHelpMenu = result;
        return myHelpMenu;
    }
    
    /**
     * Make the preferences menu active
     */
    private void enableTabDependentsMenus() {
        myPreferencesMenu.setEnabled(true);
        myEditMenu.setEnabled(true);
    }
    
}
