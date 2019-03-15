package Data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import UI.Game;

public class Bloque extends ObjetoDelJuego {
    
    Textura tex = Game.getInstancia();
    private int tipo;
    public Bloque(float posX, float posY, Identificacion id, int tipo){
        super(posX, posY,id);
        this.tipo = tipo;
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
        
    }

    @Override
    public void render(Graphics g) {
        if(tipo==0){
        g.drawImage(tex.bloques[0], (int)posX, (int)posY, null);
        }
        if(tipo==1){
            g.drawImage(tex.bloques[1], (int)posX, (int)posY, null);
        }
    }

    @Override
    public Rectangle getLimites() {
        return new Rectangle((int)posX,(int)posY,32 , 32);
    }
    
    
}
