import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class HelloProgram extends GraphicsProgram{
	
	public void run(){
		
		GLabel label = new GLabel("Hello World");
		label.setFont("Times Roman-Bold-50");
		label.setColor(Color.BLUE);
		label.setLocation(getWidth()/2 - (label.getWidth()/2),
							getHeight()/2 - (label.getAscent()/2));
		add(label);
	}
	
}