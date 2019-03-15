/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import Data.Identificacion;
import Data.ObjetoDelJuego;
import Data.Proyectil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author user
 */
public class Entrada extends KeyAdapter{
    
    Administrador administrador;

    public Entrada(Administrador administrador){
        this.administrador=administrador;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        
        for(int i =0; i<administrador.objetos.size();i++){
            ObjetoDelJuego objetoTemporal=administrador.objetos.get(i);
            if(objetoTemporal.getId()==Identificacion.Personaje){
                if(key==KeyEvent.VK_D||key==KeyEvent.VK_RIGHT){
                    objetoTemporal.setVelX(5);
                }
                if(key==KeyEvent.VK_A||key==KeyEvent.VK_LEFT){
                    objetoTemporal.setVelX(-5);
                }
                if((key==KeyEvent.VK_W||key==KeyEvent.VK_UP)&&!objetoTemporal.isSaltando()){
                    objetoTemporal.setSaltando(true);
                    objetoTemporal.setVelY(-10);
                }
                if(key==KeyEvent.VK_SPACE){
                    
                    administrador.anadirObjeto(new Proyectil(objetoTemporal.getPosX(),objetoTemporal.getPosY(),Identificacion.Proyectil,objetoTemporal.getMirandoHacia()*5,administrador));
                }
            }
        }
        
        if(key==KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i =0; i<administrador.objetos.size();i++){
            ObjetoDelJuego objetoTemporal=administrador.objetos.get(i);
            if(objetoTemporal.getId()==Identificacion.Personaje){
                if(key==KeyEvent.VK_D||key==KeyEvent.VK_RIGHT){
                    objetoTemporal.setVelX(0);
                }
                if(key==KeyEvent.VK_A||key==KeyEvent.VK_LEFT){
                    objetoTemporal.setVelX(0);
                }
            }
        }
    }
}
