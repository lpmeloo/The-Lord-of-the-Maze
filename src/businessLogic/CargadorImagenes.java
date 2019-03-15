package businessLogic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CargadorImagenes {
    
    private BufferedImage imagen;

    public BufferedImage cargarImagen(String path) {
        try{
            imagen=ImageIO.read(getClass().getResource(path));
        } catch(IOException e){
            e.printStackTrace();
        }
        return imagen;
    }
}
