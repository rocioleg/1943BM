import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class POW extends PowerUps {

    public POW(String filename) {
        super(filename);
        nombre= "POW";
    }

    @Override
    public int getWidth() {
        return imagen.getWidth();

    }

    @Override
    public int getHeight() {
        return imagen.getHeight();

    }

    @Override
    public void setPosicion(double x, double y) {
        posicion.setLocation(x, y);
    }

    @Override
    public void display(Graphics2D g2) {
        g2.drawImage(imagen,(int) this.positionX,(int) this.positionY,null);
    }

    @Override
    public double getX() {
        return positionX;

    }

    @Override
    public double getY() {
        return positionY;

    }

    @Override
    public BufferedImage getImage() {
        return this.imagen;

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

    @Override
    public void update(double delta) {

    }
    
}
