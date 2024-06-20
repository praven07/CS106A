import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;


public class Stimulaitor extends GraphicsProgram{
	
	
	public void run(){
		
		drawLine();
		addMouseListeners();
	}
	
	private void drawLine(){
		
		int x1 = getWidth()/2;
		int x2 = getHeight()/2;
		line1 = new GLine(x1,x2,x1,x2);
		line2 = new GLine(x1,x2,x1,x2);
		line2.setColor(Color.MAGENTA);
		add(line1);
		add(line2);
	}
	
	public void mouseMoved(MouseEvent e){
		
		int x2 = (getWidth() - e.getX());
		int x3 = (getHeight() - e.getY());
		int x4 = ( e.getX());
		int x5 = ( e.getY());
		line1.setEndPoint(x2,x3);
		line2.setEndPoint(x4,x5);
	}
	
	private GLine line1,line2;
}