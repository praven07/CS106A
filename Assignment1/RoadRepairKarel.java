/*
 * File:RoadRepairKarel.java
 * -------------------------
 * In this program karel is programmed to find pot holes on the road
 * and repairs it by filling it with a beeper
 */
import stanford.karel.*;

public class RoadRepairKarel extends SuperKarel{
	
	//starts running
	public void run(){
	
		while(frontIsClear()){
			checkForPotHoles();
			move();
		}
		checkForPotHoles();
	}
	
	//checks for pot holes
	private void checkForPotHoles(){
		
		if (rightIsClear()){
			fillPotHoles();
		}
	}
	
	//fills the pot holes
	private void fillPotHoles(){
	
		turnRight();
		move();
		if(noBeepersPresent()){
			putBeeper();
		}
		turnAround();
		move();
		turnRight();		
		}
}
