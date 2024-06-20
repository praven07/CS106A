import java.awt.Dimension;
import java.util.ArrayList;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Game extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	public static final int APPLICATION_WIDTH = 300;
	public static final int APPLICATION_HEIGHT = 600;
	
	
	public void run(){
		
		println(getClass());
		setMaximumSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
		player = new Tank(this);
		player.setLocation(getWidth()/2, getHeight()-player.getHeight()-10);
		add(player);
		addKeyListeners(player);
		Thread playerThread = new Thread(player);
		playerThread.start();
		waitForClick();
		int id = 0;
		while(!gameOver){
			Enemy e = new Enemy(id,20, 20,this);
			add(e);
			enenyList.add(e);
			Thread t = new Thread(e);
			t.start();
			pause(rgen.nextInt(0, 4)*1000);
			id++;
		}
		GLabel label = new GLabel("Game Over");
		label.setFont("Arial-Bold-30");
		label.setLocation(getWidth()/2-label.getWidth()/2, getHeight()/2-label.getAscent()/2);
		add(label);
		deleteEnemy();
	}
	
	
	public void gameOver(){
		
		removeAll();
		gameOver = false;
	}
	
	
	private void deleteEnemy(){
		
		for(int i = 0; i < enenyList.size(); i++){
			Enemy e = enenyList.get(i);
			e.delete();
		}
	}
	
	
	public boolean deleteThread(int id){
		
		Enemy e = enenyList.get(id);
		remove(e);
		return true;
	}
	
	private Tank player;
	private boolean gameOver = false;
	private ArrayList<Enemy> enenyList = new ArrayList<Enemy>();
	private RandomGenerator rgen = new RandomGenerator();
}
