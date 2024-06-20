/*
 * File:DrawBox.java
 * -----------------
 * It is an graphics program. It uses mouse event to draw boxes on the screen
 * and the color of the box are set to random colors.
 */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;import java.awt.event.*;

//DrawBox class is defined and extends graphics program
public class DrawRect extends GraphicsProgram{
	
	//It has an init function because the program runs only when the mouse event is done
	public void init(){
		
		//adds an mouse listener
		addMouseListeners();
	}
	
	/*
	 * (non-Javadoc)
	 * @see acm.program.Program#mousePressed(java.awt.event.MouseEvent)
	 * It listens for mouse pressed and when the mouse is pressed
	 * First it creates a GPoint to get the current location of the mouse
	 * then it creates an GRect and set it size to the current location of the mouse
	 * and the square does not get added here
	 */
	public void mousePressed(MouseEvent e){
		
		first = new GPoint(e.getPoint());
		square = new GRect(e.getX(),e.getY());
		square.setFilled(true);
		square.setColor(rgen.nextColor());
		square.setLocation(first);
			
	}
	/*
	 * (non-Javadoc)
	 * @see acm.program.Program#mouseDragged(java.awt.event.MouseEvent)
	 * When the mouse is dragged it set the active square size 
	 * to the current location minus the first point
	 * and then adds the square. 
	 */
	public void mouseDragged(MouseEvent e){
		
		double x = Math.min(e.getX(),first.getX());
		double y = Math.min(e.getY(),first.getY());
		double width = Math.abs(first.getX() - e.getX());
		double height = Math.abs(first.getY() - e.getY());
		square.setBounds(x, y, width, height);
		add(square);
	}
	
	/*
	 * There are three instance variable 
	 * 1.GRect
	 * 2.GPoint
	 * 3.RandomGenerator
	 */
	private GRect square;
	private GPoint first;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}