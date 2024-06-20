import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.KeyEvent;




public class BallZoomer extends GraphicsProgram{
	
	
	private static final int SIZE = 100;
	private static final int ZOOM_RATE = 5;
	
	
	
	public void run(){
		
		setBackground(Color.BLACK);
		ball = new GOval(SIZE,SIZE);
		ball.setFilled(true);
		ball.setLocation((getWidth()-SIZE)/2, (getHeight()-SIZE)/2);
		ball.setColor(Color.WHITE);
		add(ball);
		ball2 = new GOval(0,0);
		ball2.setFilled(true);
		ball2.setLocation((getWidth()-0)/2, (getHeight()-0)/2);
		ball2.setColor(Color.BLACK);
		add(ball2);
		addKeyListeners();
	}
	
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			zoomIn();
		}else if(key == KeyEvent.VK_DOWN){
			zoomOut();
		}
	}
	
	
	
	private void zoomIn(){
		
			double size = ball.getWidth();
			double size2 = ball2.getWidth();
			if(size > 1)
				ball.setVisible(true);
			if(size > 500){
				ball2.setSize(size2+5, size2+5);
				ball2.setLocation((getWidth()-size2)/2, (getHeight()-size2)/2);
			}
			ball.setSize(size + ZOOM_RATE, size + ZOOM_RATE);
			ball.setLocation((getWidth()-size)/2, (getHeight()-size)/2);
			println(size);
	}
	
	
	private void zoomOut(){

			double size = ball.getWidth();
			double size2 = ball2.getWidth();
			if(size < 1)
				ball.setVisible(false);
			if(size2 > 0){
				ball2.setSize(size2-5, size2-5);
				ball2.setLocation((getWidth()-size2)/2, (getHeight()-size2)/2);
			}
			if(size > 1){
				ball.setSize(size - ZOOM_RATE, size - ZOOM_RATE);
				ball.setLocation((getWidth()-size)/2, (getHeight()-size)/2);
			}
			println(size);
	}
	
	
	private GOval ball;
	private GOval ball2;
}