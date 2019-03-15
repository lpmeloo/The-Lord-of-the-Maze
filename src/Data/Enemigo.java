/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import businessLogic.Animacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import businessLogic.Administrador;
import UI.Game;

/**
 *
 * @author user
 */
public class Enemigo extends ObjetoDelJuego {

    
    private float ancho=32;
    private float altura=64;
    private float gravedad =0.3f;
    
    
    private final float velocidadMax=10;
    private Administrador administrador;
    
    Textura tex = Game.getInstancia();
    private Animacion caminar;
    private Animacion caminarIzq;
    private int tipo;
  
    
    public Enemigo(float posX, float posY, Identificacion id, Administrador administrador, int tipo) { 
        super(posX, posY, id);
        this.tipo=tipo;
        setVelX(5);
        this.administrador=administrador;
        
        if(tipo==1){
            caminar=new Animacion(3,tex.enemigos[1],tex.enemigos[2]);
            caminarIzq=new Animacion(3,tex.enemigos[3],tex.enemigos[4]);
        }else if (tipo==2){
            caminar=new Animacion(3,tex.enemigos[6]);
            caminarIzq=new Animacion(3,tex.enemigos[7]);
        }else{
            caminar=new Animacion(3,tex.enemigos[9]);
            caminarIzq=new Animacion(3,tex.enemigos[10]);
        }
           
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
        posX+=velX;
        posY+=velY;
       
        
        
        if(velX<0){
            mirandoHacia=-1;
        }else if(velX>0){
            mirandoHacia=1;
        }
        
        if(saltando || cayendo){
            velY+=gravedad;
            if(velY>velocidadMax){
                velY=velocidadMax;
            }
        }     
        colision(administrador.objetos);
        caminar.correrAnimacion();
        caminarIzq.correrAnimacion();
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
                   velX=-velX;
                   
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   posX=objetoTemporal.getPosX()+ancho;    
                   velX=-velX;
                   
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
           if(objetoTemporal.getId()==Identificacion.Proyectil){
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
        g.setColor(Color.blue);
        if(velX>0){
            caminar.drawAnimation(g,(int)posX,(int)posY);
        }
        else if(velX<0){
            caminarIzq.drawAnimation(g, (int)posX,(int)posY);
        }else{
            if(tipo==1){
                g.drawImage(tex.enemigos[0],(int)posX,(int)posY,32,64,null);  
            }else if(tipo==2){
                g.drawImage(tex.enemigos[5],(int)posX,(int)posY,32,64,null);  
            }else if (tipo==3){
                g.drawImage(tex.enemigos[8],(int)posX,(int)posY,32,64,null);
            }
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
        return new Rectangle((int)(posX+ancho-5), (int)posY+5, (int)5, (int)altura-10);
    }
    public Rectangle getLimitesIzquierda() {
        return new Rectangle((int)posX, (int)posY+5, (int)5, (int)altura-10);
    }
}
