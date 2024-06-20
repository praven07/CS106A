/*
 * File:DayFinder.java
 * -------------------
 * It takes a number from the user and checks for the according day of the week
 * and displays the day.
 */
import acm.program.*;

public class DayFinder extends ConsoleProgram{
	
	public void run(){
		int n = readInt("Enter the number:");
		
		//uses switch case to find the answer and display.
		switch(n){
		
			case 1:
				println("Monday");
				break;
			
			case 2: 
				println("Tuesday");;
				break;
				
			case 3: 
				println("Wednesday");
				break;
				
			case 4:
				println("Thursday");
				break;
				
			case 5:
				println("Friday");
				break;
				
			case 6:
				println("Saturday");
				break;
				
			case 7:
				println("Sunday");
				break;
				
			default:
				println("Invalid input");
				break;
			
		}
	}
}