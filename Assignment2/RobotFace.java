/*
 * File:RobotFace.java
 * -------------------
 * In this program it draws a robot face on the screen
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;

public class RobotFace extends GraphicsProgram{
	
	//head width
	private static final int HEAD_WIDTH = 150;
	
	//head height
	private static final int HEAD_HEIGHT = 210;
	
	//eyes size
	private static final int EYE_SIZE = 30;
	
	//mouth width
	private static final int MOUTH_WIDTH = 100 ;
	
	//mouth height
	private static final int MOUTH_HEIGHT = 25;
	
	
	public void run(){
		
		drawHead();
		drawRightEye();
		drawLeftEye();;
		drawMouth();
	}

	private void drawHead(){
		GRect head = new GRect(HEAD_WIDTH,HEAD_HEIGHT);
		head.setLocation(getWidth()/2 - head.getWidth()/2, 
							getHeight()/2 - head.getHeight()/2);
		head.setFilled(true);
		head.setColor(Color.DARK_GRAY);
		add(head);
	}
	
	private void drawRightEye() {
		
		GOval rightEye = new GOval(EYE_SIZE,EYE_SIZE);
		rightEye.setFilled(true);
		rightEye.setColor(Color.YELLOW);
		rightEye.setLocation(getWidth()/2 - (0.25*HEAD_WIDTH)-EYE_SIZE/2,
								getHeight()/2 - 0.30*HEAD_HEIGHT);
		add(rightEye);	
	}

	private void drawLeftEye() {
		GOval leftEye = new GOval(EYE_SIZE,EYE_SIZE);
		leftEye.setFilled(true);
		leftEye.setColor(Color.YELLOW);
		leftEye.setLocation(getWidth()/2 + (0.25*HEAD_WIDTH)-EYE_SIZE/2,
								getHeight()/2 - 0.30*HEAD_HEIGHT);
		add(leftEye);		
	}	
	
	private void drawMouth() {
		
		GRect mouth = new GRect(MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		mouth.setLocation(getWidth()/2 - 0.35*HEAD_WIDTH,getHeight()/2 + 0.45*HEAD_HEIGHT/2);
		add(mouth);
	}	
}