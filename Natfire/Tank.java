import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.GImage;
import acm.util.MediaTools;


public class Tank extends GImage implements KeyListener,Runnable{

	
	
	private static final int SPEED = 3;
	private static final int STOP = 0;
	
	
	public Tank(Game context){
		super("res/fighterJet_up.png");
		this.context = context;
		alive = true;
		x = y = 0;
		life = 10;
	}
	
	
	public void run(){
		
		sound = MediaTools.loadAudioClip("res/aircraft.wav");
		fire = new FireManager(this,context);
		Thread tr = new Thread(fire);
		tr.start();
		direction = 0;
		while(alive){
			move(x,y);
			pause(20);
		}
		context.gameOver();
		//Thread.currentThread().suspend();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			y = -SPEED;
			x = STOP;
			//this.setImage("res/fighterJet_up.png");
			//direction = Gun.NORTH;
			context.println("Player: Clicked up arrow");
			if(!isPlaying){
				sound.play();
				isPlaying = true;
			}
			
		}else if(key == KeyEvent.VK_DOWN){
			y = SPEED;
			x = STOP;
			//this.setImage("res/fighterJet_down.png");
			//direction = Gun.SOUTH;
			context.println("Player: Clicked down arrow");
			if(!isPlaying){
				sound.play();
				isPlaying = true;
			}
		}else if(key == KeyEvent.VK_RIGHT){
			x = SPEED;
			y = STOP;
		//	this.setImage("res/fighterJet_right.png");
			//direction = Gun.EAST;
			context.println("Player: Clicked right arrow");
			if(!isPlaying){
				sound.play();
				isPlaying = true;
			}
		}else if(key == KeyEvent.VK_LEFT){
			x = -SPEED;
			y = STOP;
		//	this.setImage("res/fighterJet_left.png");
			//direction = Gun.WEST;
			context.println("Player: Clicked left arrow");
			if(!isPlaying){
				sound.play();
				isPlaying = true;
			}
		}else if(key == KeyEvent.VK_SPACE){
			createBullet();
			context.println("Fired");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			y = STOP;
			context.println("Player: Released up arrow");
			sound.stop();
			isPlaying = false;
		}else if(key == KeyEvent.VK_DOWN){
			y = STOP;
			context.println("Player: Released down arrow");
			sound.stop();
			isPlaying = false;
		}else if(key == KeyEvent.VK_RIGHT){
			x = STOP;
			context.println("Player: Released right arrow");
			sound.stop();
			isPlaying = false;
		}else if(key == KeyEvent.VK_LEFT){
			x = STOP;
			context.println("Player: Released left arrow");
			sound.stop();
			isPlaying = false;
		}else if(key == KeyEvent.VK_SPACE){
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
	private void createBullet(){
		
		fire.fire();
	}
	
	
	public int getDirection(){
		
		return direction;
	}
	
	
	public int getLife(){
		
		return life;
	}
	
	
	public void setLose(int i){
		
		life -= i;
	}

	
	public void setPower(int i){
		
		life += i;
	}
	
	private Game context;
	private boolean alive;
	private int x,y;
	private int direction;
	private int life;
	private FireManager fire;
	private AudioClip sound;
	private boolean isPlaying;
}
