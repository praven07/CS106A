import acm.program.*;
import acm.graphics.*;
import java.awt.Color;


public class TraficLights extends GraphicsProgram{
	
	
	public void run(){
		
		createBody();
		createLights();
		checkForColor();
		while(true){
			changeSignal();
			waitForClick();
		}
	}	
	
	private void createBody(){
		
		rect = new GRect(75,150);
		rect.setFilled(true);
		rect.setColor(Color.DARK_GRAY);
		rect.setLocation((getWidth() - rect.getWidth())/2,
							(getHeight() - rect.getHeight())/2);
		add(rect);
	}
	
	private void createLights(){
		
		lights = new GOval(50,50);
		lights.setFilled(true);
		lights.setLocation((getWidth() - lights.getWidth())/2,
							(getHeight() - lights.getHeight())/2);
		add(lights);
	}
	
	private void checkForColor(){
		
		color = new StopLight();
	}
	
	private void changeSignal(){
		
		lights.setColor(color.getStatus());
		color.changeStatus();
	}
	
	private GRect rect;
	private GOval lights;
	private StopLight color; 
}