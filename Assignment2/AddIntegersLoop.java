/*
 * File:AddIntegersLoop.java
 * -------------------------
 * In this program it takes multiple inputs from the user 
 * and add them the program outputs the answer when SENTINEL is entered.
 */
import acm.program.*;

//It extends a consoleProgram.
public class AddIntegersLoop extends ConsoleProgram{
	
	private static final int SENTENIEL = 0;
	
	public void run(){
		
		//keeps the total value.
		int total = 0;
		
		while(true){
		int value = readInt("Enter the value: ");
		if(value==SENTENIEL)break;
		total +=value;
		}
		//displays the answer on the screen.
		println("The answer is:" + total);
	}	
}