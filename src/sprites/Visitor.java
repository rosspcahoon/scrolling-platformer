package sprites;

/** 
 * This is how we are going to handle collisions - through the Visitor 
 * design pattern. This interface is merely an extremely overloaded 
 * visit method. For every new sprite you have, you need a new visit 
 * method. Essentially, the visit method details how you will interact 
 * with the Type parameter.   
 *   
 *   
 * @author Jay Wang
 *
 */
public interface Visitor {
    
    public void visit (Player player); 
    public void visit (NonPlayableCharacter npc);
    public void visit (StaticEnviroPlaceHolder se);
    public void visit (NonStaticEnviroPlaceHolder nse);
    

}
