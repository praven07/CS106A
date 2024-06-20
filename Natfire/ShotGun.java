import java.applet.AudioClip;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.MediaTools;


public class ShotGun extends Gun {

	
	public static final int SIZE = 2;
	
	
	public ShotGun(int direction,double d, double e, Game context,Tank player) {
		super(direction,d, e, context);
		this.player = player;
	}

	@Override
	public void run() {
		
		x = 0;
		y = 0;
		shot = MediaTools.loadAudioClip("res/scifi.wav");
		shot.play();
		fire();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void fire() {

		int soundPause = 100;
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
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			soundPause--;
			if(soundPause == 0){
				shot.stop();
			}
		}
		//shot.stop();
		context.remove(bullet);
		Thread.currentThread().suspend();
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
			if(obj.getClass().equals(Enemy.class)){
				((Enemy) obj).delete();
				AudioClip sound = MediaTools.loadAudioClip("res/battle.wav");
				context.remove(obj);
				player.setPower(1);
				sound.play();
				return true;
			}
		}
		return false;
	}
	
	
	private int x,y;
	private Game context;
	private GOval bullet;
	private GObject obj;
	private AudioClip shot;
	//private String objDect;
	private Tank player;
}
