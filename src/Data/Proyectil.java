/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import businessLogic.Animacion;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import businessLogic.Administrador;
import businessLogic.CargadorImagenes;
import UI.Game;

/**
 *
 * @author user
 */
public class Proyectil extends ObjetoDelJuego{
    
    int tipo=Game.getTipoPersonaje();
    private float ancho=16;
    private float altura=16;
    private Administrador administrador;
    Textura tex = Game.getInstancia();
    private Animacion der;
    private Animacion izq;
    
    
    
    
    public Proyectil(float x, float y, Identificacion id, int velX,Administrador administrador){
        super(x, y, id);
        this.administrador=administrador;
        this.velX=velX;
        if(tipo==1){
           izq=new Animacion(3,tex.proyectiles[0],tex.proyectiles[1],tex.proyectiles[2],tex.proyectiles[3]);
        der=new Animacion(3,tex.proyectiles[4],tex.proyectiles[5],tex.proyectiles[6]); 
        }
        else if(tipo==2){
            izq=new Animacion(3,tex.proyectiles[8],tex.proyectiles[9],tex.proyectiles[10],tex.proyectiles[11]);
            der=new Animacion(3,tex.proyectiles[12],tex.proyectiles[13],tex.proyectiles[14]);
        }else{
            izq=new Animacion(3,tex.proyectiles[16],tex.proyectiles[17],tex.proyectiles[18],tex.proyectiles[19]);
            der=new Animacion(3,tex.proyectiles[20],tex.proyectiles[21],tex.proyectiles[22]);
        }
        
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
        posX+=velX;
        colision(administrador.objetos);
        der.correrAnimacion();
        izq.correrAnimacion();
    }
    
    private void colision(LinkedList<ObjetoDelJuego> objetos){
       for(int i = 0; i<administrador.objetos.size();i++){
           ObjetoDelJuego objetoTemporal=administrador.objetos.get(i);
           if(objetoTemporal.getId()==Identificacion.Bloque||objetoTemporal.getId()==Identificacion.Enemigo){
               
               if(getLimitesArriba().intersects(objetoTemporal.getLimites())){
                   administrador.quitarObjeto(this);
               }
               
               if(getLimites().intersects(objetoTemporal.getLimites())){
                   administrador.quitarObjeto(this);
                           
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   administrador.quitarObjeto(this);      
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   administrador.quitarObjeto(this);                
               }
           }
       }
   }

    @Override
    public void render(Graphics g) {
        if(velX>0){
            der.drawAnimation(g,(int)posX,(int)posY);
        }
        else if(velX<0){
            izq.drawAnimation(g, (int)posX,(int)posY);
        }else{
            der.drawAnimation(g, (int)posX, (int)posY);
        }
        
    }

    @Override
    public Rectangle getLimites() {
        return new Rectangle((int)(posX+(int)((ancho/2)-(ancho/2)/2)), (int)(posY+(int)(altura/2)), (int)ancho/2, (int)altura/2);
    }
    
    public Rectangle getLimitesArriba() {
        return new Rectangle((int)(posX+(ancho/2-(ancho/2)/2)), (int)posY, (int)ancho/2, (int)altura/2);
    }
    
    public Rectangle getLimitesDerecha() {
        return new Rectangle((int)(posX+32), (int)posY+5, (int)5, (int)altura-10);
    }
    public Rectangle getLimitesIzquierda() {
        return new Rectangle((int)posX, (int)posY+5, (int)5, (int)altura-10);
    }
    
}
