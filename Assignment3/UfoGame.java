/** File: UfoGame.java 
 ** ------------------ 
 ** This program plays a game where the user tries to 
 ** shoot a UFO before the UFO "lands". 
 **/ 

import acm.program.*; 
import acm.graphics.*; 

import java.awt.Color;
import java.awt.event.*; 

public class UfoGame extends GraphicsProgram { 
	
	/** Size and speed of UFO */ 
	private static final int UFO_WIDTH = 40; 
	private static final int UFO_HEIGHT = UFO_WIDTH / 2; 
	private static final int UFO_SPEED = 5; 
	private static final double UFO_DOWN_SPEED = 0.3;
	
	/** Size and speed of bullets */ 
	private static final int BULLET_SPEED = 10; 
	private static final int BULLET_DIAM = 10; 
	/** Animation cycle delay */ 
	private static final int DELAY = 10;
	
	
	/**Starts the program*/
	public void run(){
		
		setup();
		addMouseListeners();
		addKeyListeners();
		while(!gameOver()){
			moveUfo();
			moveBullet();
			checkForCollision();
			pause(DELAY);
		}
	}
	
	
	/**Creates the ufo*/
	private void setup(){
		
		ufo = new GUfo(UFO_WIDTH);
		ufo.setLocation(getWidth(), 0);
		add(ufo);
		moveToLeft = true;
	}
	
	/**checks to see if game is over and returns true or false*/
	private boolean gameOver(){
		return(ufo == null);
	}
	
	/**moves the ufo from left to right and right to left*/
	private void moveUfo(){
	
		if(moveToLeft){
			ufo.move(-UFO_SPEED, UFO_DOWN_SPEED);
			if(ufo.getX() <=0){	
				moveToLeft = false;
				ufo.move(0, UFO_HEIGHT);
			}
			
		}else{
				
			ufo.move(UFO_SPEED, 0);
			
			if(ufo.getX()+UFO_WIDTH >= getWidth()){
				moveToLeft = true;
				ufo.move(UFO_DOWN_SPEED, UFO_HEIGHT);
			}
		}
	}
	
	/**waits for a mouse click and when it is clicked 
	 * it create a new bullet*/
	public void keyPressed(KeyEvent e){
		
		if(bullet != null){
			remove(bullet);
		}
		createBullet();
	}
	
	/**It create a new bullet using GOval 
	 * when ever this method is called*/
	private void createBullet(){
		
		bullet = new GOval(BULLET_DIAM,BULLET_DIAM);
		bullet.setFilled(true);
		bullet.setColor(Color.MAGENTA);
		bullet.setLocation(getWidth()/2 - bullet.getWidth()/2, getHeight());
		add(bullet);
	}
	
	/**shoots the bullet from the bottom to top
	 * if only bullet present on the screen*/
	private void moveBullet(){
		
		if(bullet != null){
			bullet.move(0, -BULLET_SPEED);
		}
	}
	
	/**It checks for three different types of collision
	 * it checks if the ufo has reached the bottom of the screen
	 * it checks to see if the ufo has been hit
	 * it checks to see if the bullet has gone of the screen*/
	private void checkForCollision(){
		
		ufoHit();
		ufoLanded();
		bulletOfScreen();
	}
	
	/**It checks weather the bullet has hit the ufo and 
	 * if the bullet has hit the ufo the ufo and the bullet is removed 
	 * and the gameOver is set to true*/
	private void ufoHit(){
		
		if(bullet != null){
			GObject collobj = getElementAt(bullet.getX(),bullet.getY());
			if(collobj == ufo){
				remove(ufo);
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}
	
	/**If the ufo is landed by reaching the bottom of the screen
	 * ufo is removed and the gameOver is set to true*/
	private void ufoLanded(){
		
		if(ufo!= null){
			if(ufo.getY()>=getHeight()){
				remove(ufo);
				ufo = null;
			}
		}
	}
	
	/**if the bullet has gone off the screen bullet is set to null
	 * and removed so that another bullet can be created*/
	private void bulletOfScreen(){
		
		if(bullet != null){
			if(bullet.getY() == 0){
				remove(bullet);
				bullet = null;
			}
		}
	}
	
	
	/**List of instance variable*/
	private GUfo ufo;
	private boolean moveToLeft;
	private GOval bullet;
}