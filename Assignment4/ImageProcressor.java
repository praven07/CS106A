import acm.program.*;
import acm.graphics.*;

public class ImageProcressor extends GraphicsProgram{
	
	public void run(){
		
		GImage original = new GImage("jack.JPG");
		GImage flip = flipImage(original);
		
		
		original.scale(0.2);
		add(original);
		waitForClick();
		flip.scale(0.2);
		add(flip);
	}
	
	private GImage flipImage(GImage original){
		
		int[][] array = original.getPixelArray();
		
		int width = array[0].length;
		int height = array.length;
		for(int row=0; row <height; row++){
			for(int p1=0; p1<width/2; p1++){
				int p2 = width - p1-1;
				int temp = array[row][p1];
				array[row][p1] = array[row][p2];
				array[row][p2] = temp;
			}
		}
		
		return new GImage(array);
	}
}