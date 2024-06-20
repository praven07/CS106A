import acm.program.*;
import acm.graphics.*;
import java.awt.Color;



public class ImageEdit extends GraphicsProgram{
	
	
	public void run(){
		
		GImage colorImage = new GImage("jack.JPG");
		GImage grayImage = createGrayScaleImage(colorImage);
		
		setBackground(Color.DARK_GRAY);
		colorImage.scale(0.3);
		colorImage.setLocation(20, 50);
		add(colorImage);
		
		grayImage.scale(0.3);
		grayImage.setLocation(600,50);
		add(grayImage);
	}
	
	private GImage createGrayScaleImage(GImage image){
		
		int[][] array = image.getPixelArray();
		
		int width = array[0].length;
		int height = array.length;
		
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				
				int pixel = array[i][j];
				
				int r = GImage.getRed(pixel);
				int g = GImage.getGreen(pixel);
				int b = GImage.getBlue(pixel);
				
				int xx = computeLuminosity(r,g,b);
				
				array[i][j] = GImage.createRGBPixel(xx, xx, xx);
			}
		}
		return new GImage(array);
	}
	
	private int computeLuminosity(int r, int g, int b){
		
		return (int)(Math.round(0.299 * r + 0.587 * g + 0.114 * b));
	}
}