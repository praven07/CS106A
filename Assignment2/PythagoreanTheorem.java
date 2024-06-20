/*
 * File:PythagoreanTheorem.java
 * -----------------------------
 * It takes two values and computes it to output Pythagorean theorem
 */
import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram{
	
	public void run(){
		
		//prints the statement on the screen
		println("Enter value to compute Pythagorean theorem.");
		
		//reads two doubles and outputs the answer
		double a = readDouble("a:");
		double b = readDouble("b:");
		double c = Math.sqrt((a*a)+(b*b));
		println("c:" + c);
	}
}