/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import Data.Bloque;
import Data.Identificacion;
import Data.ObjetoDelJuego;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Administrador {
    public LinkedList<ObjetoDelJuego> objetos=new LinkedList<>();
    private ObjetoDelJuego objetoTemporal;
    
    public void tick(){
        for(int i = 0; i<objetos.size();i++){
            objetoTemporal = objetos.get(i);
            objetoTemporal.tick(objetos);
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i<objetos.size();i++){
            objetoTemporal = objetos.get(i);
            objetoTemporal.render(g);
        }
    }
    
    public void anadirObjeto(ObjetoDelJuego objeto){
        this.objetos.add(objeto);
    }
    
    public void quitarObjeto(ObjetoDelJuego objeto){
        this.objetos.remove(objeto);
    }
    
}
