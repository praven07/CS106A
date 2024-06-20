import acm.graphics.GPoint;



public abstract class Gun implements Runnable{

	
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	
	
	public Gun(int direction,double d, double e,Game context){
		
		this.x = d;
		this.y = e;
		this.direction = direction;
		this.context = context;
	}
	
	public abstract void run();
	
	protected abstract void fire();
	
	
	public double getX() {
		
		return x;
	}
	
	public double getY() {
		
		return y;
	}
	
	public GPoint getLocation() {
		
		return new GPoint(x, y);
	}
	
	
	protected int getDirection() {
		
		return direction;
	}
	
	protected Game getContext() {
		
		return context;
	}
	
	private double x,y;
	private Game context;
	private int direction;
}
