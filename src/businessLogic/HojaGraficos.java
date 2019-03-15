/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.awt.image.BufferedImage;

/**
 *
 * @author user
 */
public class HojaGraficos {
    private BufferedImage imagen;
    
    public HojaGraficos(BufferedImage imagen){
        this.imagen = imagen;
    }
    
    public BufferedImage tomarImagen(int columna, int fila, int ancho, int altura){
        BufferedImage img = imagen.getSubimage((columna-1)*ancho,(fila-1)*altura,ancho, altura);     
        return img;
    }
}
