/*
 * File:SteepleChase.java
 * ----------------------
 * In this program karel jumps hurdles.
 */
import stanford.karel.*;

public class SteepleChase extends SuperKarel{
	
	//runs the program
	public void run(){
		
		for(int i = 0; i < 6; i++){
			while(frontIsClear()){
				move();
			}
			if(frontIsBlocked()){
				jumpHurdle();
			}
		}
	}
	
	
	private void jumpHurdle(){
		
		climbUp();
		moveToNextLane();
		climbDown();
	}
	
	
	private void climbUp(){
		
		turnLeft();
		while(rightIsBlocked()){
			move();
		}
	}
	
	private void moveToNextLane(){
		
		turnRight();
		move();
		turnRight();
	}
	
	
	private void climbDown(){
		
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
}





