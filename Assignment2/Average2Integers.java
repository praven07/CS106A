/*
 * File: Average2Integers.java
 * ---------------------------
 * This is a console program
 * In this program in takes two integers from the user 
 * and finds the average and makes it a double 
 * and prints the average on the screen.
 */
import acm.program.*;

public class Average2Integers extends ConsoleProgram{
	
	public void run(){
		
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		double avg =(double)(n1+n2)/2;
		println("The average is: "+ avg+ ".");
	}
}