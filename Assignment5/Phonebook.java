import acm.program.*;
import java.util.*;

public class Phonebook extends ConsoleProgram{
	
	
	public void run(){
		
		getEntries();
		displayEntries();
	}
	
	/*
	 * This method get in the name and the number for the phonebook
	 * and stores it in a Map
	 */
	private void getEntries(){
		
		while(true){
			String name = readLine("Enter a Name: ");
			if(name.equals(""))break;
			int number = readInt("Enter PhoneNumber: ");
			
			
			phonebook.put(name, number);
		}
	}
	
	/*
	 * It uses the foreach loop to get all the values in the phonebook 
	 * and displayes it on the console
	 */
	private void displayEntries(){
		
		for (String name : phonebook.keySet()) {
			Integer number = phonebook.get(name);
			println("Name: " + name + " Number: " + number);
		}
	}
	
	//HashMap instance variable
	private HashMap<String,Integer> phonebook = new HashMap<String,Integer>();;
}