/**
Compilar
javac -cp ".;bucleJuego.jar" DemoJuego02.java 

Ejecutar
java -cp ".;bucleJuego.jar" DemoJuego02
  */
 

 
import java.awt.*;
import java.awt.event.*; //eventos

import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes

import java.awt.Graphics2D;

import java.awt.geom.*; //Point2d
import java.util.LinkedList;

import java.util.*;
import java.text.*;

public class Juego1943BM extends JGame {
 

	Date dInit = new Date();
	Date dAhora;
	SimpleDateFormat ft = new SimpleDateFormat ("mm:ss");
	final double speed=150.0;

    Fondo fondo;

    AvionJugador p38;

    Camara cam;

    public static void main(String[] args) {

        Juego1943BM game = new Juego1943BM();
        game.run(1.0 / 60.0);
        System.exit(0);
    }

    public Juego1943BM() {

        super("Juego1943BM", 800, 600);

        System.out.println(appProperties.stringPropertyNames());

    }

    public void gameStartup() {
        
        try{

            Mundo m=Mundo.getInstance();

            fondo= new Fondo("recursos/imagenes/FondoOceano2.png");
            
            BufferedImage imagenAvion = ImageIO.read(getClass().getResource("recursos/imagenes/AvionJugador.png"));
            p38 = new AvionJugador("recursos/imagenes/AvionJugador.png",imagenAvion);

            p38.setPosicion(getWidth() / 2,getHeight() / 2 );

            cam =new Camara(0,0);

            cam.setRegionVisible(640,480);

            m.setLimitesMundo(fondo.getWidth(), fondo.getHeight());
        }
        catch(Exception e){
            e.printStackTrace();
        }
       

    }

    public void gameUpdate(double delta) {
        
        Keyboard keyboard = this.getKeyboard();
         // Procesar teclas de direccion
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
            p38.setY( p38.getY() - speed * delta);
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            p38.setY( p38.getY() + speed * delta);
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)){
            p38.setX( p38.getX() - speed * delta);
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)){
            p38.setX( p38.getX() + speed * delta);
        }
        // Esc fin del juego
        LinkedList < KeyEvent > keyEvents = keyboard.getEvents();
        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) &&
                (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
                stop();
            }
        }


        p38.update(delta);

        cam.seguirPersonaje(p38);

    }

    public void gameDraw(Graphics2D g) {

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Mundo m=Mundo.getInstance();

        g.translate(cam.getX(),cam.getY());
        // contador 
        /*
    	dAhora= new Date( );
    	long dateDiff = dAhora.getTime() - dInit.getTime();
    	long diffSeconds = dateDiff / 1000 % 60;
		long diffMinutes = dateDiff / (60 * 1000) % 60;

        g.drawImage(img_fondo,0,0,null);// imagen de fondo
        */

        fondo.display(g);
        m.display(g);
        p38.draw(g);

        g.translate(-cam.getX(),-cam.getY());
        
    }

    public void gameShutdown() {
       //Log.info(getClass().getSimpleName(), "Shutting down game");
    }
}
