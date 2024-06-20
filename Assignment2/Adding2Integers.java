/*
 * File:Adding2Integers.java
 * --------------------------
 * In this program it takes two integers from the user and 
 * adds them and displays it on the screen.
 */
import acm.program.*;


/*The program extends a ConsoleProgram*/
public class Adding2Integers extends ConsoleProgram{
	
	public void run(){
		
		/*Takes the input from the user*/
		int x = readInt("Enter n1: ");
		int y = readInt("Enter n2:");
		int total = x+y;
		/*Displays the answer*/
		println("The the total is: "+total);		
	}
}