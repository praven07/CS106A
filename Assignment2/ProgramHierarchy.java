/*
 * File:ProgramHierarchy.java
 * ---------------------------
 * This program draw the hierarchy of acm libiary on the screen using squares,
 * line and labels.
 */
import acm.program.*;
import acm.graphics.*;

public class ProgramHierarchy extends GraphicsProgram{
	
	//width of the box
	private static final int WIDTH = 150;
	//height of the box
	private static final int HEIGHT =40;
	
	
	public void run(){
		
		drawProgramBox();
		drawConsoleBox();
		drawConsoleLine();
		drawGraphicsBox();
		drawGraphicsLine();
		drawDialogBox();
		drawDialogLine();
	}

	//draws the program box and label
	private void drawProgramBox(){
		
		GRect box = new GRect(WIDTH,HEIGHT);
		box.setLocation(getWidth()/2 - box.getWidth()/2,
						  getHeight()/2 - box.getHeight()/2);
		
		GLabel label = new GLabel("Program");
		label.setLocation(getWidth()/2 -label.getWidth()/2,
							getHeight()/2 + label.getAscent()/2);
		add(box);
		add(label);
	}
	
	//draws console box and label
	private void drawConsoleBox(){
		
		GRect box = new GRect(WIDTH,HEIGHT);
		box.setLocation(getWidth()/2 - box.getWidth()/2,
						  getHeight()/2 + 1.5*HEIGHT);
		
		GLabel label = new GLabel("Console Program");
		label.setLocation(getWidth()/2 -label.getWidth()/2,
							getHeight()/2 + label.getAscent()/2 + 2*HEIGHT);
		add(box);
		add(label);
	}
	
	//draws console line
	private void drawConsoleLine(){
		
		int x1 = getWidth()/2;
		int y1 = getHeight()/2 + HEIGHT/2;
		int x2 = x1;
		int y2 = y1 + HEIGHT;
		GLine line = new GLine(x1,y1,x2,y2);
		add(line);
	}
	
	//draws graphics box and label
	private void drawGraphicsBox(){
		
		GRect box = new GRect(WIDTH,HEIGHT);
		box.setLocation(getWidth()/2 - 2*box.getWidth(),
						  getHeight()/2 + 1.5*HEIGHT);
		
		GLabel label = new GLabel("Console Program");
		label.setLocation(getWidth()/2 - 2.5*WIDTH + label.getWidth(),
							getHeight()/2 + label.getAscent()/2 + 2*HEIGHT);
		add(box);
		add(label);
	}
	
	//draws graphics line
	private void drawGraphicsLine(){
		
		int x1 = getWidth()/2;
		int y1 = getHeight()/2 + HEIGHT/2;
		int x2 = (int) (x1 - (1.5*WIDTH));
		int y2 = y1 + HEIGHT;
		GLine line = new GLine(x1,y1,x2,y2);
		add(line);
	}
	
	//draws dialog box and label
	private void drawDialogBox(){
		
		GRect box = new GRect(WIDTH,HEIGHT);
		box.setLocation(getWidth()/2 + box.getWidth(),
						  getHeight()/2 + 1.5*HEIGHT);
		
		GLabel label = new GLabel("Console Program");
		label.setLocation(getWidth()/2 + 1.5*WIDTH - label.getWidth()/2,
							getHeight()/2 + label.getAscent()/2 + 2*HEIGHT);
		add(box);
		add(label);
	}
	
	//draw dialog line
	private void drawDialogLine(){
		
		int x1 = getWidth()/2;
		int y1 = getHeight()/2 + HEIGHT/2;
		int x2 = (int) (x1 + (1.5*WIDTH));
		int y2 = y1 + HEIGHT;
		GLine line = new GLine(x1,y1,x2,y2);
		add(line);
	}
}