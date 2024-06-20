/*
 * File: Target.java
 * Name: Praven Moorthy
 * -----------------
 * This program draws a target with red and white circle
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	//size of outer circle
	private static final int OUTER_CIRCLE = 72;
	
	//size of middle circle
	private static final int MIDDLE_CIRCLE = 48;
	
	//size of inner circle
	private static final int INNER_CIRCLE = 22;
	
	//it runs the program with the setup

	public void run(){
		
		drawOuterCircle();
		drawMiddleCircle();
		drawInnerCircle();		
	}

	private void drawInnerCircle(){
		GOval innerCircle = new GOval(INNER_CIRCLE,INNER_CIRCLE);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.RED);
		add(innerCircle,getWidth()/2 - innerCircle.getWidth()/2,
							getHeight()/2 - innerCircle.getHeight()/2);
	}
	
	private void drawMiddleCircle() {
		GOval middleCircle = new GOval(MIDDLE_CIRCLE,MIDDLE_CIRCLE);
		middleCircle.setFilled(true);
		middleCircle.setColor(Color.WHITE);
		add(middleCircle,getWidth()/2 - middleCircle.getWidth()/2,
							getHeight()/2 - middleCircle.getHeight()/2);
		
	}
	
	private void drawOuterCircle() {
		GOval outerCircle = new GOval(OUTER_CIRCLE,OUTER_CIRCLE);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.RED);
		add(outerCircle,getWidth()/2 - outerCircle.getWidth()/2,
							getHeight()/2 - outerCircle.getHeight()/2);
		
	}
}

