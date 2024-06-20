import java.applet.AudioClip;

import acm.program.*;
import acm.util.MediaTools;
import acm.graphics.*;


public class BouncingBall1 extends GraphicsProgram{
	
	private static final int DIAM_BALL = 30;
	private static final double X_VEL = 40;
	private static final double Y_VEL = 8;
	private static final double DELAY = 50;
	
	private double XVel = X_VEL;
	private double YVel = Y_VEL;
	
	private GOval ball;
	
	public void run(){
		
		setup();
		waitForClick();
		while(true){
			moveBall();
			checkBottomHit();
			checkRightHit();
			checkLeftHit();
			pause(DELAY);
		}
		
	}


	private void setup() {
		
		ball = new GOval(DIAM_BALL,DIAM_BALL);
		ball.setFilled(true);
		add(ball,0,0);
		
	}


	private void moveBall() {
		YVel += Y_VEL; 
		ball.move(XVel, YVel);
	}

	private void checkBottomHit() {
		if((ball.getY()+DIAM_BALL)>getHeight()){
			YVel = -YVel;
			ball.move(XVel, YVel);
			bounceClip.play();
		}
		
		
	}
	
	private void checkRightHit(){
		if((ball.getX()+DIAM_BALL)>getWidth()){
			XVel = -X_VEL;
			YVel = Y_VEL;
			ball.move(XVel,YVel);
			bounceClip.play();
		}
	}
	
	
	private void checkLeftHit(){
		if(ball.getX()==0){
			XVel = X_VEL;
			YVel = Y_VEL;
			ball.move(XVel, YVel);
			bounceClip.play();
		}
	}
	
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
}