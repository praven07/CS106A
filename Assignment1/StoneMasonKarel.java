/*
 * File: StoneMasonKarel.java
 * --------------------------
 *In this program karel is programmed to repair the damaged
 *stone archers. It can repair the damage even in unknown number of archers
 *in various worlds. 
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// archfix to done twice to confirm that the problem is solved completely
	public void run(){
		while(frontIsClear()){
			archFixSetup();
		}	
		if(frontIsBlocked()){
			if(rightIsBlocked()){
			archFixSetup();
			}
		}
	}
	
	// in this method all the programming instruction is entered.
	private void archFixSetup(){
		fixArch();
		moveToNextArch();
		moveToBottom();
	}
	
	//it fixes the arch
	private void fixArch(){
		turnLeft();
		while (frontIsClear()){
			if (beepersPresent()){
				move();
		}else{
			putBeeper();
		}
			if(noBeepersPresent()){
				putBeeper();
			}
		}
	}
	
	//it move the karel to the next arch
	private void moveToNextArch(){
		if(frontIsBlocked()){
			turnRight();
				if (frontIsClear()){
					move();
					while(leftIsClear()){
						if(frontIsClear()){
						move();
						}
					}
				}	
		}
	}
	
	// it moves karel to the bottom to start the repair process again.
	private void moveToBottom(){
		turnRight();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
}

	


