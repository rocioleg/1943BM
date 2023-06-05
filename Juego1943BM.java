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
	//final double speed=150.0;

    Fondo fondo;

    AvionJugador p38;

    Camara cam;

    public PowerUps obj[] = new PowerUps[1]; // la cant de objetos que se van a mostrar a la vez

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public final int titleState = 0;

    public UI interfaz;

    public static void main(String[] args) {

        Juego1943BM game = new Juego1943BM();
        game.run(1.0 / 60.0);
        System.exit(0);
    }

    public Juego1943BM() {

        super("Juego1943BM", 600, 700);

        System.out.println(appProperties.stringPropertyNames());

    }

    public void gameStartup() {
        
        try{

            Mundo m=Mundo.getInstance();

            fondo= new Fondo("recursos/imagenes/FondoOceano2.png");
            
            BufferedImage imagenAvion = ImageIO.read(getClass().getResource("recursos/imagenes/AvionJugador.png"));
            p38 = new AvionJugador("recursos/imagenes/AvionJugador.png",imagenAvion,this.getKeyboard());
            
            p38.setPosicion(149.5,8058.0);

            cam =new Camara(0,0);

            cam.setRegionVisible(480,600);

            m.setLimitesMundo(fondo.getWidth(), fondo.getHeight());

            obj[0] = new POW("recursos/imagenes/powerup.png");

            gameState = titleState;
            
            interfaz = new UI(this,this.getKeyboard());

        }
        catch(Exception e){
            e.printStackTrace();
        }
       

    }

    public void gameUpdate(double delta) {
        
        Keyboard keyboard = this.getKeyboard();

        // Esc fin del juego
        LinkedList < KeyEvent > keyEvents = keyboard.getEvents();
        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) &&
                (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
                stop();
            }
        }

        for (KeyEvent event: keyEvents) {
            if ((event.getID() == KeyEvent.KEY_PRESSED) && (event.getKeyCode() == KeyEvent.VK_SPACE)) {
                    if(gameState == playState){
                        gameState = pauseState; 
                    } else if(gameState == pauseState){
                        gameState = playState;
            }
          }
        }

        cam.seguirPersonaje(p38);

        if(gameState == playState){
            p38.update(delta);
        }

        if(gameState == pauseState){
            //
        }

        interfaz.update();

    }

    public void gameDraw(Graphics2D g) {

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Mundo m=Mundo.getInstance();

        // contador 
        /* 
    	dAhora= new Date( );
    	long dateDiff = dAhora.getTime() - dInit.getTime();
    	long diffSeconds = dateDiff / 1000 % 60;
		long diffMinutes = dateDiff / (60 * 1000) % 60;

        g.drawImage(img_fondo,0,0,null);// imagen de fondo
        */



        /*
        & -- DESP SE AGREGA - SON LOS POWER UPS --
        &for(int i=0; i< obj.length; i++){
        &    if(obj[i] != null){
        &        obj[i].draw(g);
        &        obj[i].setPosicion(149.5,8058.0);
         }
        }
        */        
        
        // Menu
        if(gameState == titleState){
            interfaz.draw(g);
            
        }
        //OTROS
        else if(gameState == playState || gameState == pauseState){

            g.translate(cam.getX(),cam.getY());

            fondo.display(g);
            m.display(g);
            p38.draw(g);
            
            interfaz.draw(g);

            g.translate(-cam.getX(),-cam.getY());

        }
    }

    public void gameShutdown() {
       //Log.info(getClass().getSimpleName(), "Shutting down game");
    }

}

