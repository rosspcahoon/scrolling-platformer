package level_editor;

import util.Location;
import util.Sprite;

public interface Editable {

    public void changeBackground();
    
    public void addNewSprite(Sprite s);
    
    public void deleteSprite(Location deleteAtLocation);
    
    public void setErrorMessage(String errorMessage);
}
