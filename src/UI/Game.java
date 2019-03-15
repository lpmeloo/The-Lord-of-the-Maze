package UI;

import businessLogic.Administrador;
import businessLogic.CargadorImagenes;
import Data.Bloque;
import Data.Enemigo;
import Data.Moneda;
import Data.Personaje;
import Data.Portal;
import businessLogic.Entrada;
import businessLogic.EntradaMouse;
import Data.Identificacion;
import Data.Textura;
import UI.Camara;
import UI.Menu;
import UI.Window;
import businessLogic.Administrador;
import businessLogic.CargadorImagenes;
import businessLogic.Entrada;
import businessLogic.EntradaMouse;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -6261436164361361187L;

    private boolean running = false;
    private Thread thread;

    public static int WIDTH, HEIGHT;
    private BufferedImage level = null;
    private BufferedImage bosque;
    Administrador administrador;
    Camara camara;
    static Textura tex;
    private Menu menu;
    static Random rand = new Random();
    public static int tipoPersonaje = rand.nextInt(4);

    public static int  getTipoPersonaje() {
        return tipoPersonaje;
    }

    public static enum Estado {
        MENU,
        GAME,

    }

    public static Estado estado = Estado.MENU;

    private void init() {
        WIDTH = getWidth();
        HEIGHT = getHeight();
        tex = new Textura();

        CargadorImagenes cargador = new CargadorImagenes();
        level = cargador.cargarImagen("/lvl1.png");
        bosque = cargador.cargarImagen("/bosque1.png");
        administrador = new Administrador();
        camara = new Camara(0, 0);
        menu = new Menu();
        cargarImagenDelNivel(level);

        //administrador.anadirObjeto(new Personaje(100,100,Identificacion.Personaje,administrador));
        //administrador.crearNivel();
        this.addKeyListener(new Entrada(administrador));
        this.addMouseListener(new EntradaMouse());

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        init();
        this.requestFocus();
        System.out.println("Game has started");
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        if (estado == Estado.GAME) {
            administrador.tick();
            for (int i = 0; i < administrador.objetos.size(); i++) {
                if (administrador.objetos.get(i).getId() == Identificacion.Personaje) {
                    camara.tick(administrador.objetos.get(i));
                }
            }
        }

    }

    private void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(31, 150, 109));
        g.fillRect(0, 0, getWidth(), getHeight());

        if (estado == Estado.GAME) {
            g2d.translate(camara.getX(), camara.getY());
            g.drawImage(bosque, -110, 0, 1830, 743, this);
            administrador.render(g);
            g2d.translate(-camara.getX(), -camara.getY());
        } else if (estado == Estado.MENU) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    
    
    private void cargarImagenDelNivel(BufferedImage imagen) {
        int altura = imagen.getHeight();
        int ancho = imagen.getWidth();
        //System.out.println("ancho: "+ancho+"altura: "+altura);
        for (int xx = 0; xx < altura; xx++) {
            for (int yy = 0; yy < ancho; yy++) {
                int pixel = imagen.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255 && green == 255 && blue == 0) {
                    administrador.anadirObjeto(new Moneda(xx * 32, yy * 32, Identificacion.Moneda, administrador));
                }

                if (red == 255 && green == 255 && blue == 255) {
                    administrador.anadirObjeto(new Bloque(xx * 32, yy * 32, Identificacion.Bloque, 0));
                }
                if (red == 150 && green == 150 && blue == 150) {
                    administrador.anadirObjeto(new Bloque(xx * 32, yy * 32, Identificacion.Bloque, 1));
                }
                if (red == 0 && green == 0 && blue == 255) {
                    administrador.anadirObjeto(new Personaje(xx * 32, yy * 32, Identificacion.Personaje, administrador, tipoPersonaje));
                }
                if (red == 0 && green == 255 && blue == 0) {
                    administrador.anadirObjeto(new Enemigo(xx * 32, yy * 32, Identificacion.Enemigo, administrador, rand.nextInt(4)));
                }
                if (red == 255 && green == 0 && blue == 0) {
                    administrador.anadirObjeto(new Portal(xx * 32 - 15, yy * 32 - 32, Identificacion.Portal));
                }

            }
        }
    }

    public static Textura getInstancia() {
        return tex;
    }

    public static void main(String args[]) {
        new Window(1280, 672, "The Lord", new Game());
    }

}
