/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import businessLogic.CargadorImagenes;

/**
 *
 * @author user
 */
public class Portal extends ObjetoDelJuego {

    CargadorImagenes cargador;
    BufferedImage portalito;
    
    public Portal(float posX, float posY, Identificacion id) {
        super(posX, posY, id);
        cargador = new CargadorImagenes();
        portalito=cargador.cargarImagen("/portal.png");
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(portalito, (int)posX,(int)posY,null);
    }

    @Override
    public Rectangle getLimites() {
        return new Rectangle((int)posX,(int)posY, 30,30);
    }
    
}
