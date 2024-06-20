/*
 * File:CheckerBoard.java
 * ----------------------
 * It is a graphics program. It draws checker boards in black nad white.
 */
import acm.program.*;
import acm.graphics.*;

public class Calander extends GraphicsProgram{
	
	//number of rows
	private static final int NROWS = 10;
	//number of columns
	private static final int NCOLUMNS = 10;
	
	public void run(){
		
		//gets the size of the box to be drawn
		int sqSize = getHeight()/NCOLUMNS;
		//draws the board
		for(int i=0; i<NROWS; i++){
			for(int j=0; j<NCOLUMNS; j++){
				int x = j*sqSize;
				int y = i*sqSize;
				GRect square = new GRect(x,y,sqSize,sqSize);
				add(square);
				GLabel number = new GLabel("");
				number.setLocation(x+10, y+35);
				number.setLabel(""+j);
				add(number);
			}
		}
		
	}	
}