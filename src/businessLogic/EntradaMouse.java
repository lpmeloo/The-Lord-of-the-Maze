package businessLogic;

import UI.Game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntradaMouse implements MouseListener{

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
         int mx=e.getX();
        int my=e.getY();
         
        System.out.println("mx:"+mx);
        System.out.println("my: "+my);
        /*
        public Rectangle iniciar= new Rectangle(Game.WIDTH/2,200,100,50);
        public Rectangle salir= new Rectangle(Game.WIDTH/2 ,400,100,50);
        public Rectangle ayuda= new Rectangle(Game.WIDTH/2 ,300,100,50);
        
        */
        if(mx>=Game.WIDTH/2-75&&mx<=Game.WIDTH/2+100){
            if(my>=200&&my<=250){
                Game.estado=Game.Estado.GAME;
            }
             
              if(my>=400&&my<=450){
                System.exit(1);
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
       
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
