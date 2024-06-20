/*
 * File:tokenizer.java
 * -------------------
 * In this program it takes a string and makes a token out of that string 
 * It seperates each word entered by the user when ever there is space or a comma in the 
 * string and then the seperated words are printed on the screen
 */
import acm.program.*;
import java.util.*;


public class Tokenizer extends ConsoleProgram{
	
	
	public void run(){
		
		String line = readLine("Enter String: ");
		println("Prints out the tokens");
		printTokens(line);
	}
	
	private void printTokens(String line){
		
		//the tokenizer seperates each word when ever there is a space or comma
		//and prints the tokens on the screen
		StringTokenizer tokenizer = new StringTokenizer(line,", ");
		for(int count=1; tokenizer.hasMoreTokens(); count++){
			println("Token " + count + ": " + tokenizer.nextToken());
		}
	}
}