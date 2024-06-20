import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.event.*;

public class DragObjects extends GraphicsProgram{
	
	public void run(){
		
		GRect box = new GRect(100,100,50,50);
		GOval ball = new GOval(0,0,50,50);
		box.setFilled(true);
		ball.setFilled(true);
		add(box);
		add(ball);	
		addMouseListeners();
		addKeyListeners();
	}
	
	public void mousePressed(MouseEvent e){
		last = new GPoint(e.getPoint());
		gobject = getElementAt(last);
		if(gobject !=null){
			gobject.sendToFront();
		}
	}
	
	public void mouseDragged(MouseEvent e){
		if(gobject !=null){
			gobject.move(e.getX()-last.getX(), e.getY()-last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	public void keyPressed(KeyEvent e){
		if(gobject !=null){
			gobject.setColor(rgen.nextColor());
		}
	}
	
	private GObject gobject;
	private GPoint last;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}