/*
 * File:UnitedNationsKarel.java
 * ----------------------------
 * In this program karel is programmed to build house 
 * where there is a damage which is a beeper.
 * it is designed to work in any type of world.
 * and any number of damages.
 */
import stanford.karel.*;

public class UnitedNationsKarel extends SuperKarel{
	
	public void run(){

       //the program is done with a while loop.
		while(frontIsClear()){
			move();
			if(beepersPresent()){
				buildHouse();
			}
		}
}
	//it builds the house
	public void buildHouse(){
		
		takePosition();
		buildThreeWalls();
		returnToGround();
	}
	//it takes the position to start building
	private void takePosition(){
		turnAround();
		pickBeeper();
		move();
		turnRight();
	}
	
	//it builds three walls
	private void buildThreeWalls(){
		firstWall();
		secondWall();
		thirdWall();
	}
	
	//it builds the first wall
	private void firstWall(){
		if(frontIsClear()){
			for(int i = 0; i <3; i++){
				putBeeper();
				move();
			}
		}
	}
	
	//it builds the second wall
	private void secondWall(){
		if(frontIsClear()){
			turnRight();
			move();
			turnRight();
			for(int i = 0; i <3; i++){
				putBeeper();
				move();
			}
		}
	}
	
	//it builds the third wall
	private void thirdWall(){
		if(frontIsBlocked()){
			turnLeft();
			move();
			turnLeft();
			for(int i = 0; i <3; i++){
				putBeeper();
				move();
			}
		}
	}
	
	
	//it returns karel to the floor
	private void returnToGround(){
		turnAround();
		while(rightIsClear()){
			move();
			if(frontIsBlocked()){
				turnLeft();
				if(frontIsClear()){
				move();
				}
			}
		}
	}
	
}