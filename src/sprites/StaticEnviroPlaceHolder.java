package sprites;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;


/**
 * This Class is meant to be a place holder for a real static environment  
 * object such as a Platform, Tunnels, swirling ball and chain.    
 *    
 *      
 * @author Jay Wang
 */
public class StaticEnviroPlaceHolder extends AbstractStaticEnvironment {

    public StaticEnviroPlaceHolder (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

}
