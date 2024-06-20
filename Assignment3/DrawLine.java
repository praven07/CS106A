/**
 * File:DrawLine.java
 * ------------------
 * In this program the user can draw line on the screen 
 * using the mouse.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class DrawLine extends GraphicsProgram{
	
	
	public void init(){
		addMouseListeners();
	}
	
	/*
	 * (non-Javadoc)
	 * @see acm.program.Program#mousePressed(java.awt.event.MouseEvent)
	 * It creates an GLine and sets the location and the startingPoint to the current mouse location
	 * and does not add the line here
	 */
	public void mousePressed(MouseEvent e){
		line = new GLine(e.getX(),e.getY(),e.getX(),e.getY());
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see acm.program.Program#mouseDragged(java.awt.event.MouseEvent)
	 * It sets the line endPoint to the current location of the mouse
	 * and then add the line on the screen.
	 */
	public void mouseDragged(MouseEvent e){	
		line.setEndPoint(e.getX(),e.getY());
		add(line);
	}
	
	//Ivar
	private GLine line;
}