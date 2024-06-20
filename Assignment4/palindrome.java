/*
 * File:palindrome.java
 * ---------------------
 * This program checks weather the given input(Word) by the user is a 
 * palindrome or not and gives the answer
 */
import acm.program.*;


public class palindrome extends ConsoleProgram{
	
	
	public void run(){
		setFont("Arial-25");
		while(true){
			String word = readLine("Enter a word: ");
			
			//if the user entered '0' as input the program quits
			if(word.equals("0")){
				println("Thanks for playing..");
				break;
			}
			
			//checks to see if the given word is palindrome or not
			if(isPalindrome(word)){
				println(word + " is a Palindrome");
			}else{
				println(word + " is not a Palindrome");
			}
		}
	}
	
	/*
	 * checks each character and return true or false
	 */
	private boolean isPalindrome(String word){

		for(int i=0; i<word.length()/2; i++){
			if(word.charAt(i) != word.charAt(word.length()-(i+1))){
				return false;
			}
		}
		return true;
	}
}