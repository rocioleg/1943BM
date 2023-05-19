public class Camara {
    
	private double x,y;

	private double resX,resY;

    public Camara(double x,double y) {
    	this.x=x;
    	this.y=y;
    }

	public void seguirPersonaje(AvionJugador obj){
		Mundo m=Mundo.getInstance();
		//this.x = -b.getX()+(m.getWidth()/8);
		this.y = -obj.getY()+resY/2;
		if (this.x > 0) {
			this.x = 0;
		}
		
		if (this.x < -(m.getHeight() - resX)) {
			this.x = -(m.getHeight() - resX);
		}


	}
	public void setViewPort(double x,double resY){
		setRegionVisible(x,y);
	}
	public void setRegionVisible(double x,double y){
		resX=x;
		resY=y;
	}
    public void setX(double x){
    	this.x=x;

    }
     public void setY(double y){
    	this.y=y;

    }
    public double getX(){
    	return this.x;

    }
     public double getY(){
    	return this.y;

    }

    /////
    /*
     * init
     * g2d.translate(camera.getX(),camera.getY());
     *
     *
     * end
     * g2d.translate(-camera.getX(),-camera.getY());
     **/

}
