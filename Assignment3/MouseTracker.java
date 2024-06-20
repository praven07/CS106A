import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram{
	
	public void run(){
		label = new GLabel("");
		label.setFont("Times Roman-30");
		label.setLocation(50,50);
		add(label);
	
		addMouseListeners();
		addKeyListeners();
	}
	
	public void mouseMoved(MouseEvent e){
	
		label.setLabel("Mouse Location: ("+ e.getX()+","+e.getY()+")");
	}
	
	private GLabel label;
}