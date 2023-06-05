import java.awt.*;
import java.awt.geom.*;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public abstract class ObjetoGrafico {
	protected BufferedImage imagen;
	protected Point2D.Double posicion = new Point2D.Double();
	protected double positionX = 0;
	protected double positionY = 0;

	protected boolean collision = false;
	public boolean collisionON;

	protected Rectangle solidArea;
	
    public ObjetoGrafico(String filename) {
    		try {
				imagen= ImageIO.read(getClass().getResource(filename));

			} catch (IOException e) {
				System.out.println(e);
			}
    }

	public abstract int getWidth();
		//return imagen.getWidth();
	
	public abstract int getHeight();
		//return imagen.getHeight();
	
		
    public abstract void setPosicion(double x, double y);

   	public abstract void display(Graphics2D g2);
		//g2.drawImage(imagen,(int) this.positionX,(int) this.positionY,null);
	
	public abstract void draw(Graphics2D g);

	public abstract double getX();
		//return positionX;
	

	public abstract double getY();
		//return positionY;

	public abstract BufferedImage getImage();
		// return this.imagen;

    public abstract void update(double delta);


	public void checkTile(ObjetoGrafico obj){
		
	}
}