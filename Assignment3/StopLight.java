import java.awt.Color;

public class StopLight {

	private static final Color RED = Color.RED;
	private static final Color YELLOW = Color.YELLOW;
	private static final Color GREEN = Color.GREEN;
	
	
	public StopLight(){
		
		currentStatus = RED;
	}
	
	public void changeStatus(){
		if(currentStatus == RED){
			currentStatus = YELLOW;
		}else if(currentStatus == YELLOW){
			currentStatus = GREEN;
		}else if(currentStatus == GREEN){
			currentStatus = RED;
		}
	}
	
	public Color getStatus(){
		return currentStatus;
	}
	
	private Color currentStatus;
}
