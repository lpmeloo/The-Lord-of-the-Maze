/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import businessLogic.CargadorImagenes;
import businessLogic.HojaGraficos;
import java.awt.image.BufferedImage;

/**
 *
 * @author user
 */
public class Textura {
    
    HojaGraficos hojaBloq;
    HojaGraficos hojaPers;
    HojaGraficos hojaProy;
    HojaGraficos hojaEnem;
    HojaGraficos hojaMone;
    
    public BufferedImage[]bloques= new BufferedImage[2];
    public BufferedImage[]personajes= new BufferedImage[21];
    public BufferedImage[]proyectiles= new BufferedImage[32];
    public BufferedImage[]enemigos= new BufferedImage[11];
    public BufferedImage[]moneda=new BufferedImage[9];

    private BufferedImage hojaBloque=null;
    private BufferedImage hojaPersonaje=null;
    private BufferedImage hojaProyectiles=null;
    private BufferedImage hojaEnemigos=null;
    private BufferedImage hojaMoneda=null;
    
    public Textura(){
        
        CargadorImagenes cargador = new CargadorImagenes();
        try{
            hojaBloque=cargador.cargarImagen("/spriteSheet.png");
            hojaPersonaje=cargador.cargarImagen("/elfo2.png");
            hojaProyectiles=cargador.cargarImagen("/proyectiles.png");
            hojaEnemigos=cargador.cargarImagen("/enemigos.png");
            hojaMoneda=cargador.cargarImagen("/moneda.png");
            
        }catch(Exception e){
            e.printStackTrace();
        }
               
        hojaBloq=new HojaGraficos(hojaBloque);
        hojaPers=new HojaGraficos(hojaPersonaje);
        hojaProy=new HojaGraficos(hojaProyectiles);
        hojaEnem=new HojaGraficos(hojaEnemigos);
        hojaMone=new HojaGraficos(hojaMoneda);
        
        getTexturas();        
    }
    
    private void getTexturas(){
        bloques[0]=hojaBloq.tomarImagen(7,1,34,34);//bloque de tierra con pasto
        bloques[1]=hojaBloq.tomarImagen(2,3,34,34);
        
        //Elfo 1
        
        personajes[0]=hojaPers.tomarImagen(1,1,32,64);
        personajes[1]=hojaPers.tomarImagen(2, 1, 32, 64);//caminando der
        personajes[2]=hojaPers.tomarImagen(3, 1, 32, 64);//caminando derecha
        personajes[3]=hojaPers.tomarImagen(4, 1, 32, 64);//caminando derecha
        personajes[4]=hojaPers.tomarImagen(5, 1, 32, 64);//caminando izquierda
        personajes[5]=hojaPers.tomarImagen(6, 1, 32, 64);//caminando izquierda
        personajes[6]=hojaPers.tomarImagen(7, 1, 32, 64);//caminando izquierda
        
        //Elfo 2
        
        personajes[7]=hojaPers.tomarImagen(1,2,32,64);
        personajes[8]=hojaPers.tomarImagen(2, 2, 32, 64);//caminando der
        personajes[9]=hojaPers.tomarImagen(3, 2, 32, 64);//caminando derecha
        personajes[10]=hojaPers.tomarImagen(4, 2, 32, 64);//caminando derecha
        personajes[11]=hojaPers.tomarImagen(5, 2, 32, 64);//caminando izquierda
        personajes[12]=hojaPers.tomarImagen(6, 2, 32, 64);//caminando izquierda
        personajes[13]=hojaPers.tomarImagen(7, 2, 32, 64);//caminando izquierda
        
        //Elfo 3
        
        personajes[14]=hojaPers.tomarImagen(1,3,32,64);
        personajes[15]=hojaPers.tomarImagen(2, 3, 32, 64);//caminando der
        personajes[16]=hojaPers.tomarImagen(3, 3, 32, 64);//caminando derecha
        personajes[17]=hojaPers.tomarImagen(4, 3, 32, 64);//caminando derecha
        personajes[18]=hojaPers.tomarImagen(5, 3, 32, 64);//caminando izquierda
        personajes[19]=hojaPers.tomarImagen(6, 3, 32, 64);//caminando izquierda
        personajes[20]=hojaPers.tomarImagen(7, 3, 32, 64);//caminando izquierda
        
        //Enemigo 1
        
        enemigos[0]=hojaEnem.tomarImagen(1, 1, 32, 64);//Mirando al frente
        enemigos[1]=hojaEnem.tomarImagen(2, 1, 32, 64);//caminando derecha
        enemigos[2]=hojaEnem.tomarImagen(3, 1, 32, 64);//caminando derecha
        
        enemigos[3]=hojaEnem.tomarImagen(4, 1, 32, 64);//caminando izquierda
        enemigos[4]=hojaEnem.tomarImagen(5, 1, 32, 64);//caminando izquierda
        
        //Enemigo 2
        
        enemigos[5]=hojaEnem.tomarImagen(1, 2, 32, 64);//Mirando al frente
        enemigos[6]=hojaEnem.tomarImagen(2, 2, 32, 64);//caminando derecha
        enemigos[7]=hojaEnem.tomarImagen(3, 2, 32, 64);//caminando izquierda
        
        //Enemigo 3
        
        enemigos[8]=hojaEnem.tomarImagen(1, 3, 32, 64);//Mirando al frente
        enemigos[9]=hojaEnem.tomarImagen(2, 3, 32, 64);//caminando derecha
        enemigos[10]=hojaEnem.tomarImagen(3, 3, 32, 64);//caminando izquierda
        
        //Proyectiles
        
        proyectiles[0]=hojaProy.tomarImagen(1, 1, 64, 64);//Fuego hacia la izquierda
        proyectiles[1]=hojaProy.tomarImagen(2, 1, 64, 64);//Fuego hacia la izquierda
        proyectiles[2]=hojaProy.tomarImagen(3, 1, 64, 64);//Fuego hacia la izquierda
        proyectiles[3]=hojaProy.tomarImagen(4, 1, 64, 64);//Fuego hacia la izquierda
        
        proyectiles[4]=hojaProy.tomarImagen(6, 1, 64, 64);//Fuego hacia la derecha
        proyectiles[5]=hojaProy.tomarImagen(7, 1, 64, 64);//Fuego hacia la derecha
        proyectiles[6]=hojaProy.tomarImagen(8, 1, 64, 64);//Fuego hacia la derecha
        //proyectiles[7]=hojaProy.tomarImagen(8, 1, 64, 64);//Fuego hacia la derecha
              
        proyectiles[8]=hojaProy.tomarImagen(1, 2, 64, 64);//Agua hacia la izquierda
        proyectiles[9]=hojaProy.tomarImagen(2, 2, 64, 64);//Agua hacia la izquierda
        proyectiles[10]=hojaProy.tomarImagen(3, 2, 64, 64);//Agua hacia la izquierda
        proyectiles[11]=hojaProy.tomarImagen(4, 2, 64, 64);//Agua hacia la izquierda
        
        proyectiles[12]=hojaProy.tomarImagen(6, 2, 64, 64);//Agua hacia la derecha
        proyectiles[13]=hojaProy.tomarImagen(7, 2, 64, 64);//Agua hacia la derecha
        proyectiles[14]=hojaProy.tomarImagen(8, 2, 64, 64);//Agua hacia la derecha
        //proyectiles[15]=hojaProy.tomarImagen(8, 2, 64, 64);//Agua hacia la derecha
        
        proyectiles[16]=hojaProy.tomarImagen(1, 3, 64, 64);//Tierra hacia la izquierda
        proyectiles[17]=hojaProy.tomarImagen(2, 3, 64, 64);//Tierra hacia la izquierda
        proyectiles[18]=hojaProy.tomarImagen(3, 3, 64, 64);//Tierra hacia la izquierda
        proyectiles[19]=hojaProy.tomarImagen(4, 3, 64, 64);//Tierra hacia la izquierda
        
        proyectiles[20]=hojaProy.tomarImagen(6, 3, 64, 64);//Tierra hacia la derecha
        proyectiles[21]=hojaProy.tomarImagen(7, 3, 64, 64);//Tierra hacia la derecha
        proyectiles[22]=hojaProy.tomarImagen(8, 3, 64, 64);//Tierra hacia la derecha
        //proyectiles[23]=hojaProy.tomarImagen(8, 3, 64, 64);//Tierra hacia la derecha
        
        //Animacion moneda
        
        moneda[0]=hojaMone.tomarImagen(1,1,29,30);
        moneda[1]=hojaMone.tomarImagen(2,1,29,30);
        moneda[2]=hojaMone.tomarImagen(3,1,29,30);
        moneda[3]=hojaMone.tomarImagen(4,1,29,30);
        moneda[4]=hojaMone.tomarImagen(5,1,29,30);
        moneda[5]=hojaMone.tomarImagen(6,1,29,30);
        moneda[6]=hojaMone.tomarImagen(7,1,29,30);
        moneda[7]=hojaMone.tomarImagen(8,1,29,30);
        moneda[8]=hojaMone.tomarImagen(9,1,29,30);
        
        
        
    }   
    
    
    
    
    
    
    
}
