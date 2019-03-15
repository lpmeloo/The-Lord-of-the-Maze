/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import businessLogic.CargadorImagenes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Menu extends javax.swing.JFrame {
    
    CargadorImagenes cargador = new CargadorImagenes();
    private BufferedImage bosque=cargador.cargarImagen("/menuBG.png");;
    public Rectangle iniciar= new Rectangle(Game.WIDTH/2-75,200,100,50);
    public Rectangle salir= new Rectangle(Game.WIDTH/2-75,400,100,50);
   
    
    
    public void render(Graphics g){
        
        Graphics2D g2d=(Graphics2D)g;
       
        Font fuente = new Font("arial",Font.BOLD,40);
        g.setFont(fuente);
        g.setColor(Color.DARK_GRAY);
        
        g.drawImage(bosque, -110, 0, 1830, 743, this);
        g.drawString("THE LORDS OF THE MAZE",50+Game.WIDTH/4, 100);
        
        
        
        Font fuente2 = new Font("arial",Font.BOLD,25);
        Font fuente3 = new Font("arial",Font.BOLD,12);
        g.setFont(fuente2);
        g.drawString("Iniciar",iniciar.x+16,iniciar.y+33);
        g2d.draw(iniciar);
        
        
        g.drawString("Salir",salir.x+20,salir.y+33);
        g2d.draw(salir);
        
        
        
        
        
    }
}
