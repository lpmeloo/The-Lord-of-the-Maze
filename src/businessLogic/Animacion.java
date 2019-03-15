package businessLogic;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animacion {
    
    private int velocidad;
    private int fotogramas;
    private int indice;
    private int contador; //posicion fotograma actual
    
    private BufferedImage[] imagenes;
    private BufferedImage imagenActual;

    public Animacion(int velocidad, BufferedImage...args) {
        this.velocidad = velocidad;
        imagenes=new BufferedImage[args.length];
        for(int i=0; i<args.length;i++){
            imagenes[i]=args[i];
        }
        fotogramas=args.length;
    }
    
    public void correrAnimacion(){
        indice++;
        if(indice>velocidad){
            indice=0;
            nextFrame();
        }
    }
    
    private void nextFrame(){
        for(int i =0; i<fotogramas;i++){
            if(contador==i){
                imagenActual=imagenes[i];
            }
        }
        contador++;       
        if(contador>fotogramas){
            contador=0;
        }
    }
    
    public void drawAnimation(Graphics g, int x, int y){
        g.drawImage(imagenActual, x,y,null);
    }
     
    public void drawAnimation(Graphics g, int x, int y, int escalaX, int escalaY){
        g.drawImage(imagenActual, x,y,escalaX,escalaY,null);
    }
    
}
