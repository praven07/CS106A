import acm.program.*;


public class GradeFinder extends ConsoleProgram{
	
	public void run(){
		
		int percentage = readInt("Enter your marks:");
		
		if(percentage>=90 && percentage<=100){
			println("YOu earned 'A' Grade");
		}else if(percentage>=70 && percentage<90){
			println("You have earned 'B' Grade");
		}else if(percentage>=50 && percentage<70){
			println("You have earned 'C' Grade");
		}else if(percentage>=0 && percentage<50){
			println("Bad Times");
		}else{
			println("Invalid input");
		}
	}
}