package UI;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
    
    public Window(int ancho, int alto, String titulo, Game game){
        game.setPreferredSize(new Dimension(ancho, alto));
        game.setMaximumSize(new Dimension(ancho,alto));
        game.setMinimumSize(new Dimension(ancho,alto));
        
        JFrame frame = new JFrame(titulo);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }

    
     
}
