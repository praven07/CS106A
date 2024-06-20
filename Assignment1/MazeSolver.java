import stanford.karel.*;


public class MazeSolver extends SuperKarel{
	
	
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