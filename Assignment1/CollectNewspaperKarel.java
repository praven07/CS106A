/*
 * File:CollectNewspaperKarel.java
 * --------------------------------
 * 
 */
import stanford.karel.*;

public class CollectNewspaperKarel extends Karel{
	
	
	public void run(){
		
		moveToDoor();
		collectNewsPaper();
		goBackHome();
	}
	
	
	private void moveToDoor(){
		
		move();
		move();
		turnRight();
		move();
		turnLeft();
	}
	
	
	
	private void collectNewsPaper(){
		
		move();
		pickBeeper();
	}
	
	
	private void goBackHome(){
		
		turnAround();
		moveThreeTimes();
		turnRight();
		move();
		turnRight();	
	}
	
	private void turnRight(){
		
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	private void turnAround(){
		
		turnLeft();
		turnLeft();
	}
	
	
	
	private void moveThreeTimes(){
		
		move();
		move();
		move();
	}
	
}