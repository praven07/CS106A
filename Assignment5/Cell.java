import acm.graphics.GPolygon;


public class Cell extends GPolygon{
	
	
	public Cell(int width, int height){
		super(width,height);
		this.width = width;
		this.height = height;
		createCells();
	}
	
	
	
	private void createCells(){
		
		addVertex(0, height/2);
		addVertex(width/3, 0);
		addVertex(width/1.4, 0);
		addVertex(width, height/2);
		addVertex(width/1.4, height);
		addVertex(width/3.5, height);
		addVertex(0, height/2);
	}
	
	
	private int width,height;
}
