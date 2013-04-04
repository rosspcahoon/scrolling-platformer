package level_editor.commands;

import java.util.HashMap;
import java.util.Map;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import level_editor.LevelEditor;

public class CommandLibrary {

    private static Map<String,Method> myCommandMap;
    
    static{
        myCommandMap = new HashMap<String,Method>();
        fillMap();
    }

    private static void fillMap () {
        Method[] allMethods = LevelEditor.class.getMethods();
        for (int i = 0; i < allMethods.length; i++){
            Method currentMethod = allMethods[i];
            Annotation[] a = currentMethod.getAnnotations();
            for (int j = 0; j < a.length; j++){
                System.out.println(a[j]);
            }
            if(currentMethod.isAnnotationPresent(Command.class)){
                myCommandMap.put(currentMethod.getName(),currentMethod);
            }
        }
    }
    
    public static Method get(String key){
        return myCommandMap.get(key);
    }
}
