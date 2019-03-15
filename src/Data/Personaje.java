package Data;

import businessLogic.Animacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import businessLogic.Administrador;
import businessLogic.CargadorImagenes;
import UI.Game;

public class Personaje extends ObjetoDelJuego{
    
    private float ancho=34;
    private float altura=64;
    private float gravedad =0.3f;
    
    
    private final float velocidadMax=10;
    private Administrador administrador;
    private CargadorImagenes cargador=new CargadorImagenes();
    private BufferedImage corazon = cargador.cargarImagen("/corazon.png");
    Textura tex = Game.getInstancia();
    private Animacion caminar;
    private Animacion caminarIzq;
    private int salud=5;
    private int puntos=0;
    int tipo;
   
    public Personaje(float posX, float posY, Identificacion id, Administrador administrador,int tipo) {
        super(posX, posY, id);
        this.administrador=administrador;
        if(tipo ==1){
            caminar=new Animacion(3,tex.personajes[1],tex.personajes[2],tex.personajes[3]);
            caminarIzq=new Animacion(3,tex.personajes[4],tex.personajes[5],tex.personajes[6]);
        }else if (tipo==2){
            caminar=new Animacion(3,tex.personajes[8],tex.personajes[9],tex.personajes[10]);
            caminarIzq=new Animacion(3,tex.personajes[11],tex.personajes[12],tex.personajes[13]);
        }else{
            caminar=new Animacion(3,tex.personajes[15],tex.personajes[16],tex.personajes[17]);
            caminarIzq=new Animacion(3,tex.personajes[18],tex.personajes[19],tex.personajes[20]);
        }
        
        this.tipo=tipo;
    }

    @Override
    public void tick(LinkedList<ObjetoDelJuego> objeto) {
        posX+=velX;
        posY+=velY;
        
        if(salud==0){
            administrador.quitarObjeto(this);
            System.exit(1);
        }
       
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
                   cayendo=false;
                   saltando=false;         
               }else{
                   cayendo=true;
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   posX=objetoTemporal.getPosX()-ancho;      
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   posX=objetoTemporal.getPosX()+ancho;                  
               }
           }
           
           if(objetoTemporal.getId()==Identificacion.Enemigo){
               
               if(getLimitesArriba().intersects(objetoTemporal.getLimites())){     
                   salud=salud--;
               }
               
               if(getLimites().intersects(objetoTemporal.getLimites())){
                   salud--;               
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   salud--;              
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   salud--;
               }
           }
           if(objetoTemporal.getId()==Identificacion.Moneda){
               if(getLimitesArriba().intersects(objetoTemporal.getLimites())){     
                   puntos++;
               }
               
               if(getLimites().intersects(objetoTemporal.getLimites())){
                   puntos++;              
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   puntos++;              
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   puntos++;
               }
           }
           if(objetoTemporal.getId()==Identificacion.Portal){
               
               if(getLimitesArriba().intersects(objetoTemporal.getLimites())){
                   System.exit(1);
               }
               
               if(getLimites().intersects(objetoTemporal.getLimites())){
                   System.exit(1);        
               }
               
               if(getLimitesDerecha().intersects(objetoTemporal.getLimites())){
                   System.exit(1);     
               }
               if(getLimitesIzquierda().intersects(objetoTemporal.getLimites())){
                   System.exit(1);                  
               }
           }
       }
   }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("PUNTAJE: "+puntos, (int) (posX+40), 90);
        for(int i =0; i<salud;i++){
            g.drawImage(corazon,(int)((32*i)+32)+(int)posX-40,32, null);
            
        }
        if(velX>0){
            caminar.drawAnimation(g,(int)posX,(int)posY);
        }
        else if(velX<0){
            caminarIzq.drawAnimation(g, (int)posX,(int)posY);
        }else{
            if(tipo==1){
                g.drawImage(tex.personajes[0],(int)posX,(int)posY,32,64,null);
            }else if (tipo==2){
                g.drawImage(tex.personajes[7],(int)posX,(int)posY,32,64,null);
            }else{
                g.drawImage(tex.personajes[14],(int)posX,(int)posY,32,64,null);
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
        return new Rectangle((int)(posX+ancho), (int)posY+5, (int)5, (int)altura-10);
    }
    public Rectangle getLimitesIzquierda() {
        return new Rectangle((int)posX, (int)posY, (int)5, (int)altura-10);
    }
    
}
