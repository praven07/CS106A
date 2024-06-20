import acm.program.*;
import acm.graphics.*;

public class Polygon extends GraphicsProgram{
	
	public void run(){
		GPolygon diamond = createDiamond(100,150);
		diamond.setFilled(true);
		GPolygon triangle = createTriangle(100,150);
		add(diamond,100,100);
		add(triangle ,200,200);
	}
	
	private GPolygon createDiamond(double width, double height){
		GPolygon diamond = new GPolygon();
		diamond.addVertex(-width/2, 0);
		diamond.addVertex(0, -height/2);
		diamond.addVertex(width/2,0);
		diamond.addVertex(0,height/2);
		return diamond;
	}
	
	private GPolygon createTriangle(double width, double height){
		GPolygon triangle = new GPolygon();
		triangle.addVertex(-width/2,height/2);
		triangle.addVertex(0,-height/2);
		triangle.addVertex(width/2,height/2);
		return triangle;
	}
}