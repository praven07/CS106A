/*
 * File:BoarderDrawingKarel.java
 * -----------------------------
 * In this program karel is programmed to draw a boarder on all four sides 
 * using beeper.
 */
import stanford.karel.SuperKarel;

public class BoarderDrawingKarel extends SuperKarel{
	
	//the program starts here 
	public void run(){
		takePosition();
		drawBoarder();
		turnAround();
	}
	
	//karel takes position to draw the boarder 
	private void takePosition(){
		turnLeft();
		move();
		turnRight();
	}
	
	//karel starts to draw boarder 
	private void drawBoarder(){
		while(frontIsClear()){
			move();
			while(frontIsClear()){
				if(noBeepersPresent()){
					putBeeper();
					move();
				}
			}
			if(frontIsBlocked()){
				turnAround();
				move();
				turnRight();
			}
		}
	}
}

