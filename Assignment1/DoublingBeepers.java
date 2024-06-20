/*
 * File:DoublingBeepers.java
 * -------------------------
 * In this karel is programmed to do math problem
 * karel doubles the number of beepers 
 */
import stanford.karel.*;

public class DoublingBeepers extends SuperKarel{
	
	//program starts here
	public void run(){
		
		while(frontIsClear()){
			if(beepersPresent()){
				doubleBeepers();
			}
			move();
		}
	}
	
	
	private void doubleBeepers(){
		
		shiftBeeper();
		replaceBeeper();
	}
	
	private void shiftBeeper(){
		
		while(beepersPresent()){
			pickBeeper();
			turnLeft();
			move();
			putDoubleBeeper();
			turnAround();
			move();
			turnLeft();
		}
	}
	
	
	private void replaceBeeper(){
		
		turnLeft();
		move();
		turnAround();
		while(beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
		move();
		turnLeft();
		move();
	}
	
	
	private void putDoubleBeeper(){
		
		putBeeper();
		putBeeper();
	}
}