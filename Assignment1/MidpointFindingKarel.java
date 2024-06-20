/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * In this program karel finds the midpoint in the world and puts a beeper in that place
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	//runs the program 
	public void run(){
		
		drawLine();
		takePosition();
		findMidPoint();
		markMidPoint();
	}
	
	//draws the line with beepers
	private void drawLine(){
		
		while(frontIsClear()){
			move();
			putBeeper();
		}
	}
	
	//takes the position to find the midpoint
	private void takePosition(){
			turnAround();
	}
	
	//it finds the midpoint
	private void findMidPoint(){
		
		if(beepersPresent()){
			pickBeeper();
			move();
		}else{
			move();
			pickBeeper();
			move();
		}
			while(beepersPresent()){
			move();
			if(noBeepersPresent()){
				turnAround();
				findMidPoint();
			}
			}
	}
	
	//marks the midpoint by putting a beeper
	private void markMidPoint(){
		if(noBeepersPresent()){
		turnAround();
		move();
		putBeeper();
		}
	}

}
