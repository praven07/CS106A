import acm.graphics.*;
import acm.program.*;


public class BouncingBall extends GraphicsProgram{
	
	private static final int DIAM_BALL = 30;
	private static final int X_START = 30;
	private static final int Y_START = 30;
	private static final int GRAVITY = 3;
	private static final double BOUNCE_REDUCED = 0.9;
	private static final double X_VEL = 5;
	private static final double DELAY = 50;
	
	private double X_VEl = X_VEL;
	private double Y_Vel = 0.0;
	
	private GOval ball;
	
	public void run(){
		
		setup();
		waitForClick();
		while(ball.getX()<getWidth()){
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}
	
	private void setup(){
		ball = new GOval(X_START,Y_START,DIAM_BALL,DIAM_BALL);
		ball.setFilled(true);
		add(ball);
	}
	
	private void moveBall(){
		Y_Vel +=GRAVITY;
		ball.move(X_VEl,Y_Vel);
	}
	
	private void checkForCollision(){
		if(ball.getY()+DIAM_BALL>getHeight()){
			Y_Vel = -Y_Vel*BOUNCE_REDUCED;
			
		double diff = ball.getY() - (getHeight() - DIAM_BALL);
		ball.move(0, -2 * diff);
		}
	}
}