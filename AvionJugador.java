import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AvionJugador extends VehiculoGuerra {
    public AvionJugador(String filename, BufferedImage imagen) {
        super(filename);
        this.imagen = imagen;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
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
    }
}
