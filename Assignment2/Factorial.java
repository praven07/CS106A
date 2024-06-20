/*
 * File:factorial.java
 * -------------------
 * It is a console program. It gets an integer from the user and 
 * calculates the factorial of that number and prints the values on the screen
 */
import acm.program.*;

public class Factorial extends ConsoleProgram{
	
	public void run(){
		
		//gets the value
		int n = readInt("Enter n!");
		for(int i=0; i<n; i++){
			println(i + "! is " + factorial(i));
		}
	}
	
	//finds the factorial
	private int factorial(int n){
		int total = 1;
		
		for(int i =1; i<n; i++){
			total *=n;
		}
		return(total);
	}
}