import acm.program.*;
import acm.graphics.*;

public class BouncingBall extends GraphicsProgram{
	
	//ball size
	private static final int DIAM_BALL = 25;
	
	//gravity or ball moving in y direction
	private static final int GRAVITY = 3;
	
	//velocity of the ball in x moving in x direction
	private static final int X_VEL =5;
	
	//loss of speed on each bounce of the ball due to gravity
	private static final double BOUNCE_REDUCED =0.9;
	
	//delay time on each update of the ball
	private static final int DELAY =50;
	
	//intial xVel of the ball
	private double xVel =X_VEL;
	
	//intial yVel of the ball 
	private double yVel = 0.0;
	
	//create a ivar object ball
	private GOval ball;
	
	
	public void run(){
		
		//calls setup function
		setup();
		
		//waits until the user presses the mouse to proceed
		waitForClick();
		
		//while the given condition is true it does the folling set of functions
		while(ball.getX()<getWidth()){
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}
	
	
	//create a ball and adds it to the screen at a given location
	private void setup(){
		
		ball = new GOval(DIAM_BALL,DIAM_BALL);
		ball.setFilled(true);
		ball.setLocation(20,20);
		add(ball);
	}
	
	
	//moves the ball in x and y direction and increases the gravity in each method calls
	private void moveBall(){
		
		yVel += GRAVITY;
		ball.move(xVel, yVel);
	}
	
	
	//checks if the ball has reached the floor of the screen and if it has reached 
	//it would make the yVel negative so the ball would move upwards
	private void checkForCollision(){
		
		if(ball.getY() >getHeight()-DIAM_BALL){
			yVel = -yVel *BOUNCE_REDUCED;
	
			
			// assume bounce will move ball an amount above the
			// floor equal to the amount it would have dropped
			// below the floor.			
			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2 * diff);
		}
	}
}