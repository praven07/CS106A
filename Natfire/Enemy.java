import acm.graphics.GImage;
import acm.util.RandomGenerator;


public class Enemy extends GImage implements Runnable{

	public Enemy(int id,double width, double height,Game context) {
		super("res/fighter_enemy.png");
		this.context = context;
		this.id = id;
		setLocation(rgen.nextInt(10,(int)(context.getWidth()-getWidth())), 0);
	}

	@Override
	public void run() {
		int delay = rgen.nextInt(10, 100);
		int xD = 0;
		int yD = 1;
		if(rgen.nextBoolean(0.1)){
			xD = 1;
			yD = 2;
		}
		if(rgen.nextBoolean(0.1)){
			xD = -1;
			yD = 2;
		}
		while(getY() < context.getHeight() && !gameOver){
			move(xD,yD);
			pause(delay);
			if(rgen.nextBoolean(0.1)){
				int x = (int) (getX()+getWidth()/2);
				int y = (int) (getY()+getHeight());
				EnemyGun gun = new EnemyGun(Gun.SOUTH, x, y, context);
				Thread tr = new Thread(gun);
				tr.start();
			}
		}
		context.remove(this);
	}
	
	
	public void delete(){
		
		gameOver = true;
		context.deleteThread(id);
	}

	private int id;
	private Game context;
	private boolean gameOver = false;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
