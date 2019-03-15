package UI;

import Data.ObjetoDelJuego;

public class Camara {
    private float x,y;

    public Camara(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void tick(ObjetoDelJuego personaje){
        x=-personaje.getPosX()+Game.WIDTH/2;
       
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
}
