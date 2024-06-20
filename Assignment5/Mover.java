import java.awt.event.KeyEvent;

import acm.program.*;
import acm.graphics.*;




public class Mover extends GraphicsProgram{
	
	
	public void run(){
		
		rect = new GRect(10,10);
		rect.setLocation(getWidth()/2-10,getHeight()/2-10);
		rect.setFilled(true);
		add(rect);
		addKeyListeners();
	}
	
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			rect.move(-1, 0);
		}else if(key == KeyEvent.VK_RIGHT){
			rect.move(1, 0);
		}else if(key == KeyEvent.VK_UP){
			rect.move(0, -1);
		}else if(key == KeyEvent.VK_DOWN){
			rect.move(0, 1);
		}
	}
	
	
	private GRect rect;
}