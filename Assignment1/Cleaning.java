import stanford.karel.*;


public class Cleaning extends SuperKarel{
	
	
	public void run(){
		
		for(int i = 0; i < 10; i++){
			
			while(frontIsClear()){
				
				if(beepersPresent()){
					pickBeeper();
				}
				move();
			}
			
			if(facingEast()){
				leftSideMoment();
			}else{
				rightSideMoment();
			}
		}
		
	}
	
	
	
	private void nineMove(){
		
		move();
		move();
		move();
		move();
		move();
		move();
		move();
		move();
		move();
	}
	
	
	private void leftSideMoment(){
		
		turnLeft();
		if(frontIsClear()){
			move();
		}
		turnLeft();
	}
	
	
	private void rightSideMoment(){
		
		turnRight();
		if(frontIsClear()){
			move();
		}
		turnRight();
	}
}