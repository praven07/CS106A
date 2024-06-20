/*
 * File:RandomCircle.java
 * -----------------------
 * This program draws a set of 10 circles with different sizes,
 * positions, and colors. Each circle has a randomly chosen
 * color, a randomly chosen radius between 5 and 50 pixels,
 * and a randomly chosen position on the canvas, subject to
 * the condition that the entire circle must fit inside the
 * canvas without extending past the edge.
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram{
	
	//number of circles
	private static final int MAX_CIRCLE = 10;
	
	//minimum circle radius
	private static final int MIN_RADIUS = 5;
	
	//maximum circle radius
	private static final int MAX_RADIUS = 100;
	
	public void run(){
		
		for(int i=0; i<MAX_CIRCLE; i++){
			int size = rgen.nextInt(MIN_RADIUS,MAX_RADIUS);

			GOval circle = new GOval(size,size);
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			circle.setLocation(rgen.nextInt(getWidth()-size), rgen.nextInt(getHeight()-size));
			add(circle);
		}
		
	}
	
	//private instance variable
	private RandomGenerator rgen = RandomGenerator.getInstance();
}