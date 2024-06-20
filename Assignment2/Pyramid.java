/*
 * File:Pyramid.java
 * -----------------
 * It draws a Pyramid on the canvas.
 */
import acm.program.*;
import acm.graphics.*;

public class Pyramid extends GraphicsProgram{
	
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;
	
	public void run(){
		
		//draws the pyramid
		drawPyramid(BRICKS_IN_BASE);
	}
	
	//finds the y and numbricks 
	private void drawPyramid(int BRICKS_IN_BASE){
		
		int y = getHeight();
		int numBricks = BRICKS_IN_BASE;
		for(int i=0; i<BRICKS_IN_BASE; i++){
			y -=BRICK_HEIGHT;
			numBricks--;	
			centerBrick(y,numBricks);
		}
	}
	
	//finds x 
	private void centerBrick(int y, int numBricks){
		
		int x = (getWidth()/2) - (numBricks*BRICK_WIDTH)/2;
		for(int i=0; i<numBricks; i++){
			x += BRICK_WIDTH;
			drawBrick(x,y,numBricks);
		}
	}
	
	//draws bricks using x,y,numbricks.
	private void drawBrick(int x,int y, int numBricks){
		
		GRect brick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
		add(brick);
	}
}

