package sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
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
    private Pixmap myImage;

    public StaticEnviroPlaceHolder (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        myImage = image;
        mySize = size;
    }

}
