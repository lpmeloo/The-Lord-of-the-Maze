package Data;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class ObjetoDelJuego {
    
    protected float posX;
    protected float posY;
    protected float velX=0;
    protected float velY=0;
    protected Identificacion id;
    protected boolean cayendo = true;
    protected boolean saltando= false;
    protected int mirandoHacia=1;
    
    public boolean isCayendo() {
        return cayendo;
    }

    public void setCayendo(boolean cayendo) {
        this.cayendo = cayendo;
    }

    public boolean isSaltando() {
        return saltando;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;
    }
    
    public ObjetoDelJuego(float posX,float posY, Identificacion id){
        this.posX=posX;
        this.posY=posY;
        this.id= id;
    }
    
    public abstract void tick(LinkedList<ObjetoDelJuego> objeto);
    public abstract void render(Graphics g);
    public abstract Rectangle getLimites();

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    public Identificacion getId(){
        return id;
    }
    
    public int getMirandoHacia(){
        return mirandoHacia;
    }
    
}
