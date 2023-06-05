import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AvionJugador extends VehiculoGuerra {
    
    private Keyboard keyboard; // 
    private final double vida_disminucion = 0.01;

    public AvionJugador(String filename, BufferedImage imagen, Keyboard keyboard) {
        super(filename);
        this.imagen = imagen;
        this.keyboard = keyboard;
        vida=100;
        solidArea = new Rectangle(0,0,getWidth(),getHeight()); // esto desp lo tenemos q achicar 
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    
        // Dibujar la barra de vida
        int barraX = 22; // Coordenada X de la barra de vida
        int barraY = (int)this.getY()+380; // Coordenada Y de la barra de vida

        int barraAncho = 200; // Ancho total de la barra de vida
        int barraAlto = 20; // Alto de la barra de vida
    
        int longitudVida = (int) (barraAncho * (vida / 100.0));
    
        if(vida > 30){
            g.setColor(Color.GRAY);
            g.fillRect(barraX, barraY, barraAncho, barraAlto);
    
            g.setColor(Color.RED);
            g.fillRect(barraX, barraY, longitudVida, barraAlto);
        } else if(vida <= 30){
            g.setColor(Color.GRAY);
            g.fillRect(barraX, barraY, barraAncho, barraAlto);
    
            g.setColor(Color.ORANGE);
            g.fillRect(barraX, barraY, longitudVida, barraAlto);
        }        

    }

    @Override
    public double getX() {
        return posicion.getX();
    }

    @Override
    public double getY() {
        return posicion.getY();
    }

    @Override
    public void setImagen(BufferedImage img) {
        this.imagen=img;
    }

    @Override
    public void setPosicion(double x, double y) {
        posicion.setLocation(x, y);
    }
    

    @Override
    public void setX(double x) {
        posicion.x=x;
    }

    @Override
    public void setY(double y) {
        posicion.y=y;
    }

    @Override
    public void update(double delta) {
    
        Mundo m = Mundo.getInstance();

        // Procesar teclas de direccion

       if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
           this.setY( this.getY() - speed * delta);
       }

       if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            this.setY( this.getY() + speed * delta);
       }

       if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)){
            this.setX( this.getX() - speed * delta);
       }

       if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)){
            this.setX( this.getX() + speed * delta);
       }

       vida -= vida_disminucion;
       if(vida < 0){
        vida = 0;
       }

    }

    @Override
    public int getWidth() {
        return imagen.getWidth();
    }

    @Override
    public int getHeight() {
        return imagen.getHeight();
    }

    @Override //
    public void display(Graphics2D g2) {
        g2.drawImage(imagen,(int) this.positionX,(int) this.positionY,null);
    }

    @Override
    public BufferedImage getImage() {
        return this.imagen;
    }



}
