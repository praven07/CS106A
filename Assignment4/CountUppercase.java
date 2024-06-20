/*
 * File:countUppercase.java
 * -------------------------
 * In this program it counts the number of uppercase characters in the string 
 * and prints it on the screen
 */
import acm.program.*;


public class CountUppercase extends ConsoleProgram{
	
	
	public void run(){
		
		//gets the input from the user
		String str = readLine("Enter String: ");
		println("There was: " + countUppercaseCharacters(str) + " Uppercase characters");
	}
	
	/*
	 * counts the number of uppercase characters and returns the count
	 */
	private int countUppercaseCharacters(String str){
		
		int count = 0;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)){
				count++;
			}
		}
		return count;
	}
}