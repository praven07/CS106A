import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.RandomGenerator;


public class Ball extends GOval implements Runnable {

	public Ball(double width, double height,Display canvas,GImage image2) {
		super(width, height);
		setColor(Color.BLACK);
		setFilled(true);
		this.image = image2;
		this.canvas = canvas;
	}
	
	

	@Override
	public void run() {
		setColor(getcolor());
		moveBall();
	}
	
	
	private void moveBall(){
		
	
		//rgen.setSeed(883771157);
		vx = rgen.nextInt(5,10);
		//rgen.setSeed(4524);
		vy = rgen.nextInt(-5,10);
		double delay = 65;
		GLine line = new GLine(getX(),getY(), getX(),getY());
		line.setColor(Color.white);
		//canvas.add(line);
		while(true){
			if(value < 2000)
				value++;
			else
				value = 0;
			pause((int)delay);
			 if(getX()+getWidth() > canvas.getWidth() || getX() < 0){
				vx = -vx;
				if(line == null){
					line = new GLine(getX(),getY(),getX(),getY());
					line.setColor(getcolor());
				//	canvas.add(line);
				}else{
					//line.setStartPoint(line.getStartPoint().getX(),line.getStartPoint().getY());
					line.setEndPoint(getX(),getY());
					line = new GLine(getX(),getY(),getX(),getY());
					line.setColor(getcolor());
				//	canvas.add(line);
				}
			}else if(getY()+getHeight() > canvas.getHeight() || getY() < 0){
				vy = -vy;
				if(line == null){
					line = new GLine(getX(),getY(), getX(),getY());
					line.setColor(getcolor());
				//	canvas.add(line);
				}else{
					//line.setStartPoint(line.getStartPoint().getX(),line.getStartPoint().getY());
					line.setEndPoint(getX(),getY());
					line = new GLine(getX(),getY(),getX(),getY());
					line.setColor(getcolor());
				//	canvas.add(line);
				}
			}
			line.setEndPoint(getX(), getY());
			move(vx,vy);
			sendToFront();
			//Particals.paintImage(getX(), getY());
		}		
	}
	
	
	private Color getcolor(){
		
		if(value < 500){
			return Color.WHITE;
		}else if(value < 1000){
			return Color.YELLOW;
		}else if(value < 1500){
			return Color.BLUE;
		}else if(value < 2000){
			return Color.RED;
		}
		return Color.WHITE;
	}
	
	
	private void change(){
		
		vx = -vx;
		vy = -vy;
	}
	
	
	private boolean checkForCollision(){
		
		boolean result = false;
		getCollidingObject(getX(),getY());
		if(collider == null && collider != Particals.getIma()){
			getCollidingObject(getX(), getY()+getWidth());
			if(collider == null &&collider != Particals.getIma()){
				getCollidingObject(getX()+getWidth(), getY()+getHeight());
				if(collider == null && collider != Particals.getIma()){
					getCollidingObject(getX(), getY()+getHeight());
				}
			}
		}
		if(collider != null && collider != Particals.getIma()){
			//((Ball) collider).change();
		
			result = true;
		}
		return result;
	}
	
	
	private void getCollidingObject(double x,double y){
		collider = canvas.getElementAt(x,y);
	}
	long value = 0;
	private int vx,vy;
	private Display canvas;
	private GObject collider;
	private GImage image;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
