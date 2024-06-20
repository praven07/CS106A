
public class FireManager implements Runnable{

	
	public FireManager(Tank object,Game context){
		
		this.object = object;
		this.context = context;
	}


	@Override
	public void run() {
		
		
	}
	
	public void fire(){
		
		int direction = object.getDirection();
		setBulletPosition(direction);
		gun = new ShotGun(direction, x, y, context,object);
		Thread gunThread = new Thread(gun);
		gunThread.start();
	}
	
	private void setBulletPosition(int direction){
		
		x = object.getX() + (object.getWidth()/2 - ShotGun.SIZE/2);
		y = object.getY() + (object.getHeight()/2 - ShotGun.SIZE/2);
	}
	
	
	private ShotGun gun;
	private Tank object;
	private Game context;
	private double x,y;
}
