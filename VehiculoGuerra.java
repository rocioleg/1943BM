import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class VehiculoGuerra extends ObjetoGrafico implements ObjetoMovible{

    protected double vida;
    protected final double speed = 200.0;

    public VehiculoGuerra(String filename) {
        super(filename);
    }

    public abstract void setImagen(BufferedImage img);

    public abstract void setX(double x);    

    public abstract void setY(double y);
    
    public abstract double getX();

    public abstract double getY();

}
