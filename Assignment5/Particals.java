import acm.graphics.GImage;
import acm.program.*;
import acm.util.RandomGenerator;



public class Particals extends Program{
	
	
	public void run(){
		
		
		add(canvas);
		
		for(int i = 0; i < 10; i++){
			int size = 40;
			Ball ball = new Ball(size, size, canvas,image);
			ball.setLocation(1, getHeight()/2 );
			pause(50);
			Thread th = new Thread(ball);
			canvas.add(ball);
			th.start();
		}
	}
	
	public synchronized static void paintImage(double x,double y){
		
		int[][] newArray = image.getPixelArray();
		newArray[(int) x][(int) y] = GImage.createRGBPixel(255, 255, 255);
		canvas.remove(image);
		image = new GImage(newArray);
		canvas.add(image);
	}
	
	
	public static GImage getIma(){
		return image;
		
	}
	private static int[][] pixels;
	private static Display canvas = new Display();
	private static GImage image;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}