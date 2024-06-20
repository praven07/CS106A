/*
 * File:GObjectsSamples.java
 * -------------------------
 * In this program is display a label with hello world
 * a square, a rectangle, a oval and a line.
 * it is just put in random.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class GObjectsSamples extends GraphicsProgram{
	
	public void run(){
		//it displays a label 
		GLabel label = new GLabel("Hello World",10,100);
		label.setFont("Sanreif-40");
		label.setColor(Color.CYAN);
		add(label);
		
		//it displays a square
		GRect square = new GRect(10,10,50,50);
		square.setFilled(false);
		add(square);
		
		//it displays a rectangle
		GRect rect = new GRect(500,100,300,200);
		rect.setFilled(true);
		rect.setColor(Color.lightGray);
		add(rect);
		
		//it displays a oval 
		GOval oval = new GOval(500,100,300,200);
		oval.setFilled(true);
		oval.setFillColor(Color.GREEN);
		add(oval);
		
		//it displays a line
		GLine line = new GLine(10,300,500,350);
		line.setColor(Color.BLUE);
		add(line);
		
		//it displays a arc
		GArc arc1 = new GArc(50,350,100,100,45,270);
		arc1.setFilled(true);
		add(arc1);
		
		GArc arc2 = new GArc(300,350,150,50,0,180);
		add(arc2);
	}
	
}