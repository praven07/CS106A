import acm.graphics.*;


public class Tower extends GCompound{

	
	public Tower(int width, int height){
		
		this.width = width;
		this.height = height;
		drawTower();
	}
	
	
	private void drawTower(){
		
		reciver = new GOval(width/3,width/3);
		reciver.setLocation(width/2-reciver.getWidth()/2, height/3-reciver.getWidth()/2);
		reciver.setFilled(true);
		add(reciver);
		stand = new GLine(width/2, height/3, width/2, height);
		add(stand);
	}
	
	
	public double getx(){
		
		return reciver.getX();
	}
	
	
	public double gety(){
		
		return reciver.getY();
	}
	
	
	
	private int width;
	private int height;
	private GOval reciver;
	private GLine stand;
}
