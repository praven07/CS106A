/*
 * File:AreaofCircle.java
 * ----------------------
 * In this program it a the radius of the circle 
 * and computes and displays the area of the circle.
 */
import acm.program.*;

//It extends consoleProgram.
public class AreaofCircle extends ConsoleProgram{

	//PI value keept as instance constant variable
	private static final double PI = 3.14;
	
	public void run(){
		int r = readInt("Enter the radius:");
		double area = r*r*PI;
		println("The area of the circle:" + area);
	}	
}