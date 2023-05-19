import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class VehiculoGuerra extends ObjetoGrafico implements ObjetoMovible{
    protected BufferedImage imagen;
    protected Point2D.Double posicion = new Point2D.Double();
    protected final double speed = 150.0;

    //protected double worldX, worldY;

import java.awt.image.BufferedImage;

public abstract class VehiculoGuerra extends ObjetoGrafico implements ObjetoMovible{
    
    public VehiculoGuerra(String filename) {
        super(filename);
    }

    public abstract void setImagen(BufferedImage img);

    public abstract void setPosicion(double x, double y);

    public abstract void setX(double x);    

    public abstract void setY(double y);
    
    public abstract double getX();

    public abstract double getY();

    public abstract void update(double delta);

    public abstract void draw(Graphics2D g);
  
    public abstract double getX();

    public abstract double getY();

    public abstract void update(double delta);

    public abstract void draw(Graphics2D g);
    /* 
    public abstract double getWorldX ();

    public abstract double  getWorldY ();

    public abstract void setWorldX(double worldX);

    public abstract void setWorldY(double worldY);
    */
}
