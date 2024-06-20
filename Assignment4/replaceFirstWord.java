/*
 * File:replaceFirsrWord.java
 * ---------------------------
 * This program replaces the first occurrence of a word from a string with a given string
 * It does not apply for multiple words in a string
 */
import acm.program.*;


public class replaceFirstWord extends ConsoleProgram{
	
	
	public void run(){
		
		String str = readLine("Enter a String: ");
		String find = readLine("Enter the String to find: ");
		String replace = readLine("Enter a String to replace: ");
		println(replaceFirstOccurrence(str,find,replace));
	}
	
	
	/*
	 * finds the first occurrence word in the string and replaces it with the given string
	 * and result is returned 
	 */
	private String replaceFirstOccurrence(String str, String find, String replace){
		
		String result = "";
		int index = str.indexOf(find);
		if(index != -1){
			result = str.substring(0,index) + replace + str.substring(index + find.length());
		}
		return result;
	}
}