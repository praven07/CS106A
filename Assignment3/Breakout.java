/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	//private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;


	
	/* Method: run() */
/** Runs the Breakout program. */
	public void run(){
		
		addKeyListeners();
		for(int i=0; i<3; i++){
				setupGame();
				playGame();
		}
		
		if(score >= 900){
			result = "You win";
		}else{
			result = "You Loose";
		}
		displayResult();
	}	
	
	
	/**SetsUp the structure of the game*/
	private void setupGame(){
		
		setupBrick();
		setupPaddle();
		pause(50);
		setupBall();
		setupScoreBoard();
		pause(50);
	}
	
	
	/**creates a group of bricks and adds it to the screen*/
	private void setupBrick(){
		
		for(int i=0; i<NBRICKS_PER_ROW; i++){
			for(int j=0; j<NBRICK_ROWS; j++){
				int x = j*(BRICK_WIDTH + BRICK_SEP);
				int y = i*(BRICK_HEIGHT + BRICK_SEP)+BRICK_Y_OFFSET;
				brick = new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setLocation(x, y);
				add(brick);
				numBricks++;
				paintBrick(i,j);
				pause(60);
			}
		
		}
	}
	
	/**colours the bricks in patterns*/
	private void paintBrick(int i,int j){
		
		if(i<2){
			brick.setColor(Color.RED);
		}else if(i<4){
			brick.setColor(Color.ORANGE);
		}else if(i<6){
			brick.setColor(Color.YELLOW);
		}else if(i<8){
			brick.setColor(Color.GREEN);
		}else if (i<10){
			brick.setColor(Color.CYAN);
		}
	}
	
	/**creates the paddle and adds it to the screen and adds an mouseEvent listener 
	 * to move the paddle according to the mouse current location*/
	private void setupPaddle(){
		
		paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setLocation(getWidth()/2 - paddle.getWidth()/2,
							getHeight() - paddle.getHeight()-PADDLE_Y_OFFSET);
		paddle.setColor(Color.MAGENTA);
		add(paddle);
		addMouseListeners();
		addKeyListeners();
	}
	
	/**Displays the score board and the num of life on the screen*/
	private void setupScoreBoard(){
		
		scoreCount = new GLabel("");
		scoreCount.setFont("ARIAL-15");
		scoreCount.setLabel("Score : "+score);
		scoreCount.setLocation(0,20);
		add(scoreCount);
		int i = 0;
		while(i<5){
			scoreCount.move(i,0);
			i++;
			pause(60);
		}
		
		
		numTurns = new GLabel("");
		numTurns.setFont("ARIAL-15");
		numTurns.setLocation(250,20);
		numTurns.setLabel("Lifes remaining: "+turnsLeft);
		add(numTurns);
	
	}
	
	/**Displays the result weather the player won or lost at the end of the game*/
	private void displayResult(){
		resultPanel = new GLabel("");
		resultPanel.setFont("ARIAL-30");
		resultPanel.setLabel(result);
		resultPanel.setLocation(getWidth()/2 - resultPanel.getWidth()/2,
								getHeight()/2 - resultPanel.getAscent()/2);
		add(resultPanel);
		
		scoreCount.setLabel("Your Score : "+score);
		scoreCount.setLocation(getWidth()/2 - scoreCount.getWidth()/2,
								getHeight()/2 - scoreCount.getAscent()/2+50);
		add(scoreCount);
	}
	
	/**with the mouse listener it sets the location of
	 * the paddle to the calculated position*/
	public void keyPressed(KeyEvent e){
		
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			paddleX = 5;
		}else if(key == KeyEvent.VK_LEFT){
			paddleX = -5;
		}
	}
	
	
	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			paddleX = 0;
		}else if(key == KeyEvent.VK_LEFT){
			paddleX = 0;
		}
	}
	
	/**sets up the ball on the screen*/
	private void setupBall(){
		
		ball = new GOval(BALL_RADIUS,BALL_RADIUS);
		ball.setFilled(true);
		ball.setLocation(getWidth()/2 - ball.getWidth()/2,
							getHeight()/2 - ball.getHeight()/2);
		add(ball);
	}
	
	/**moves the ball around by bouncing of the paddle and walls 
	 * If the ball collides with an object it removes it of the screen
	 */
	private void playGame(){
		getBallVelocity();
		pause(3000);
		while(ball!=null){
			
			paddle.move(paddleX, paddleY);

			if(numBricks <= 0){
				removeAll();
				break;
			}
			ball.move(vx, vy);
			if(ball.getY() <= 0){
				vy = -vy;
			}
			
			if(ball.getY()+ball.getHeight() >= getHeight()){
				numBricks = 0;
				removeAll();
				turnsLeft--;
				break;
			}
			
			if(ball.getX()+ball.getWidth() >= getWidth() || ball.getX() <= 0){
				vx = -vx;
			}
			
			
			getCollidingObject(ball.getX(),ball.getY());
			
			if(collider == null){
				getCollidingObject(ball.getX(), ball.getY()+ball.getWidth());
				if(collider == null){
					getCollidingObject(ball.getX()+ball.getWidth(), ball.getY()+ball.getHeight());
					if(collider == null){
						getCollidingObject(ball.getX(), ball.getY()+ball.getHeight());
					}
				}
			}
			
			if(collider == paddle){
				bounceClip.play();
				vy = -vy;
			}else{
				if(collider !=null && collider != scoreCount && collider != numTurns){
					remove(collider);
					bounceClip.play();
					if(collider.getColor() == Color.CYAN){
						score +=10;
					}else if(collider.getColor() == Color.GREEN){
						score +=20;
					}else if(collider.getColor() == Color.YELLOW){
						score +=30;
					}else{
						score +=50;
					}
					vy = -vy;
					numBricks--;
					scoreCount.setLabel("Score : "+score);
				}
			}
			pause(15);
		}
	}
	
	/**get the object at the given location*/
	private void getCollidingObject(double x,double y){
		collider = getElementAt(x,y);
	}
	
	/**gets the velocity of the ball*/
	private void getBallVelocity(){
		vy = rgen.nextDouble(3.0,+3.0);
		vx = rgen.nextDouble(1.0,3.0);
		if(rgen.nextBoolean(0.5)){
			vx = -vx;
		}
	}
	
	
	/**Instance variables */
	private GRect brick,paddle;
	private GOval ball;
	private GLabel scoreCount,numTurns,resultPanel;
	private double vx,vy;
	public GObject collider;
	private int numBricks;
	private int score = 0;
	private int turnsLeft = NTURNS;
	private int paddleX = 0;
	private int paddleY = 0;
	private String result;
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
	
	