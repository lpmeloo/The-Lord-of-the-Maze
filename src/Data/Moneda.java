/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import businessLogic.Animacion;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import businessLogic.Administrador;
import UI.Game;

/**
 *
 * @author user
 */
public class Moneda extends ObjetoDelJuego {
    Textura tex = Game.getInstancia();
    private Animacion animacion;
    private Administrador administrador;
    private float altura=32;
    private float ancho=32;
    
    public Moneda(float posX, float posY, Identificacion id,Administrador administrador){
        super(posX, posY,id);
        this.administrador=administrador;
        animacion = new Animacion(3,tex.moneda[0],tex.moneda[1],tex.moneda[2],tex.moneda[3],
                                    tex.moneda[4],tex.moneda[5],tex.moneda[6],
                                    tex.moneda[7],tex.moneda[8]);
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
        colision(administrador.objetos);
        animacion.correrAnimacion();
    }

    private void colision(LinkedList<ObjetoDelJuego> objetos){
       for(int i = 0; i<administrador.objetos.size();i++){
           ObjetoDelJuego objetoTemporal=administrador.objetos.get(i);
           if(objetoTemporal.getId()==Identificacion.Bloque){
               
               if(getLimitesArriba().intersects(objetoTemporal.getLimites())){
                   posY=objetoTemporal.getPosY()+altura/2;
                   velY=0;     
               }
               
               if(getLimites().intersects(objetoTemporal.getLimites())){
                   posY=objetoTemporal.getPosY()-altura;
                   velY=0;
                          
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   posX=objetoTemporal.getPosX()-ancho;      
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   posX=objetoTemporal.getPosX()+ancho;                  
               }
           }
           if(objetoTemporal.getId()==Identificacion.Personaje){
               
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
        animacion.drawAnimation(g, (int)posX, (int)posY);
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
