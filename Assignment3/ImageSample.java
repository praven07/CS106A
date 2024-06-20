import acm.graphics.*;
import acm.program.*;

public class ImageSample extends GraphicsProgram{
	
	public void run(){
		GImage image = new GImage("Title.jpg");
		image.scale(0.8);
		add(image,0,0);
	}
	
}