import acm.graphics.GObject;
import acm.graphics.GOval;


public class EnemyGun extends Gun {

	
	public static final int SIZE = 2;
	
	
	public EnemyGun(int direction,double d, double e, Game context) {
		super(direction,d, e, context);
	}

	@Override
	public void run() {
		
		x = 0;
		y = 0;
		fire();
	}

	@Override
	protected void fire() {

		context = getContext();
		bullet = new GOval(getX(), getY(), SIZE, SIZE);
		bullet.setFilled(true);
		context.add(bullet);
		context.println("Shot fired");
		setBulletDirection(getDirection());
		while(onScreen()){
			bullet.move(x, y);
			//context.println(x +" " + y);
			if(checkForCollision())break;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		context.remove(bullet);
		context.println("bullet removed");
	}
	
	
	private void setBulletDirection(int i){
		
		context.println("Direction " + i);
		if(i == Gun.NORTH){
			y = -5;
			x = 0;
			context.println("north");
		}else if(i == Gun.SOUTH){
			y = 5;
			x = 0;
			context.println("south");
		}else if(i == Gun.EAST){
			x = 5;
			y = 0;
			context.println("east");
		}else if(i == Gun.WEST){
			x = -5;
			y = 0;
			context.println("west");
		}
	}
	
	
	private boolean onScreen(){
		
		boolean result = false;
		if(bullet.getX() >= 0 && bullet.getY() >= 0){
			if(bullet.getX() < context.getWidth() && bullet.getY() < context.getHeight())
				result = true;
		}
		return result;
	}
	
	
	public double getWidth(){
		
		return bullet.getWidth();
	}
	
	
	public double getHeight(){
		
		return (int) bullet.getHeight();
	}
	
	
	private boolean checkForCollision(){
		
		obj = context.getElementAt(bullet.getLocation());
		if(obj != null){
			if(obj.getClass().equals(Tank.class)){
				if(((Tank) obj).getLife() < 1){
					context.remove(obj);
					context.gameOver();
				}else{
					((Tank) obj).setLose(0);
				}
				return true;
			}
		}
		return false;
	}
	
	
	private int x,y;
	private Game context;
	private GOval bullet;
	private GObject obj;
}
