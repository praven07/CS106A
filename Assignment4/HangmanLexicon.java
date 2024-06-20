/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;

import java.util.*;

import java.io.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	}
	
/**
 * This method opens a file and reads in all the words in that file
 * @return a random word from a file
 */
	public String getWord(){
		
		String result = "";
		
		try{
			BufferedReader wordFile = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			ArrayList<String> list = loadWords(wordFile);
			result = pulloutWord(list);
		}catch (Exception ex) {
			throw new ErrorException(ex);
		}
		return result;
	}

	/**
	 * These are private methods to the class
	 * It loads the words read by the getWord method into an ArrayList
	 * @param wordList
	 * @return an ArrayList
	 */
	private ArrayList<String> loadWords(BufferedReader wordList){
		
		ArrayList<String> list = new ArrayList<String>();
		try{
			while(true){
				String readLine = wordList.readLine();
				if(readLine == null)break;
				list.add(readLine);
			}
		}catch (Exception ex) {
			throw new ErrorException(ex);
		}
		return list;
	}
	
/**
 * This method takes an ArrayList and pulls out one word at random from that list 	
 * @param list
 * @return a String word 
 */
	private String pulloutWord(ArrayList<String> list){
		
		int index = rgen.nextInt(0, list.size());
		String result = list.get(index);
		return result;
	}
	
	
	//Ivar//
	//RandomGenerator
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
