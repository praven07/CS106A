/*
 * File:COlorChangingSquare.java
 * ------------------------------
 * It is a graphics program. It contains a square in the 
 * middle of the canvas and it keeps changing its color
 * which is got from the random generator.
 */
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

public class ColorChangingSquare extends GraphicsProgram{
	
	//size of the square
	private static final int SQ_SIZE = 400;
	//delay time
	private static final double DELAY = 500;
	
	public void run(){
		
		GRect square = new GRect(SQ_SIZE,SQ_SIZE);
		square.setLocation(getWidth()/2-(SQ_SIZE/2),
							getHeight()/2-(SQ_SIZE/2));
		square.setFilled(true);
		add(square);
		while(true){
		square.setColor(rgen.nextColor());
		square.pause(DELAY);
		}
	}
	
	//Instance var Random Generator
	private RandomGenerator rgen = RandomGenerator.getInstance();
}