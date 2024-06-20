/*
 * File:CheckerboardKarel.java
 * ----------------------------
 * In this program karel is programmed to draw checkerboards using 
 * beepers and it is programmed to work on any world 
 */
import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel{
	
	
	public void run(){
		while(frontIsClear()){
			drawTowardEast();
			moveNextLineForWest();
			drawTowardsWest();
			moveNextLineForEast();
		}
		turnRight();
	}
	//It draws checkerboard towards east with beepers 
	private void drawTowardEast(){
		putBeeper();
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
		}
	}
	
	//it moves to next line to draw checkers toward west
	private void moveNextLineForWest(){
		if(frontIsBlocked()){
			turnLeft();
			if(frontIsClear()){
			move();
			turnLeft();
			}
		}
	}
	
	//it draws checkers toward west and it has got boolean type of checkers with two pattern
	private void drawTowardsWest(){
		turnLeft();
		move();
		turnLeft();
		if(noBeepersPresent()){
		moveNextLineForWest();
		putBeeper();
			while(frontIsClear()){
				move();
				if(frontIsClear()){
					if(noBeepersPresent()){
						move();
						putBeeper();
					}
				}
			}
		}else{
			moveNextLineForWest();
			while(frontIsClear()){
				move();
				if(noBeepersPresent()){
						putBeeper();
						move();
				}
			}
		}
	}
	
	//moves to next line towards east
	private void moveNextLineForEast(){
		if(frontIsBlocked()){
			turnRight();
			if(frontIsClear()){
			move();
			turnRight();
			}
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
