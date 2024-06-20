/*
 * File:KarelMazeSolver.java
 * -------------------------
 * In this program karel is programmed to solve a maze
 */
import stanford.karel.*;

public class KarelMazeSolver extends SuperKarel{
	
	//starts to run
	public void run(){
		
		while(!beepersPresent()){
			
			if(rightIsClear()){
				turnRight();
			}
			
			if(frontIsClear()){
				move();
			}else{
				turnLeft();
			}
		}
	}
}