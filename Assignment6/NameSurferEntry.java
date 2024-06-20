/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;


public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		parseText(line);
	}
	
	
	/*
	 * Reads in the text and stores all the values in an hashMap
	 */
	private void parseText(String line){
		
		StringTokenizer tokens = new StringTokenizer(line," ");
		for(int i=0; tokens.hasMoreTokens(); i++){
			if(i==0){
				name = tokens.nextToken();
			}else{
				int value = Integer.parseInt(tokens.nextToken());
				rank.add(value);
			}
		}
	}

	
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		
		return name;
	}


/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		
		return rank.get(decade);
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		
		String value = "[" + name + " ";
		Iterator<Integer> it = rank.iterator();
		while(it.hasNext()){
			value += it.next() + " ";
		}
		value += "]";
		return value;
	}
	
	
	private String name;
	private ArrayList<Integer> rank = new ArrayList<Integer>();
}

