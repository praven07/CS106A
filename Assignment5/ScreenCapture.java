import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.program.*;
import acm.graphics.*;



public class ScreenCapture extends GraphicsProgram{
	

	public void run(){
		
		int x = 0; 
		int y = 0;
		int w = 1360;
		int h = 700;
		for(int i = 0 ; i < 15; i++){
			Rectangle rect = new Rectangle(x,y,w,h);
			try {
				BufferedImage image = new Robot().createScreenCapture(rect);
				list.add(image);
			} catch (AWTException e) {
				println("error");
			}
			rect = null;
			pause(50);
		}
		waitForClick();
		for(int i = 0 ; i < 15; i++){
			removeAll();
			GImage image = new GImage(list.get(i));
			add(image,0,0);
			pause(100);
		}
	}
	
	
	private ArrayList<BufferedImage> list = new ArrayList<BufferedImage>(500);
}