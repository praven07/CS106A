import java.io.BufferedReader;
import java.io.FileReader;
import acm.util.ErrorException;
import java.util.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) {
	
		createEntry(filename);
	}
	
	
	
	/*
	 * It reads in the file and makes an NameSurferEntry and puts it in the Map	
	 */
	private void createEntry(String filename){
		
		try{
			rd = new BufferedReader(new FileReader(filename));
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				NameSurferEntry entry = new NameSurferEntry(line);
				nameList.put(entry.getName(), entry);
			}
		}catch (Exception ex) {
			throw new ErrorException(ex);
		}		
	}
	
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		
		String value = formatText(name);
		if(nameList.containsKey(value)){
			return nameList.get(value);
		}else{
			return null;
		}
	}
	
	
	/*
	 * formats the given text to make it error resistance to query the nameList
	 */
	private String formatText(String name){
		
		String result = "";
		for(int i=0; i<name.length(); i++){
			char ch = name.charAt(i);
			if(i == 0){	
				result += Character.toUpperCase(ch);
			}else{
				result += Character.toLowerCase(ch);
			}
		}
		return result;
	}
	
	
	
	private BufferedReader rd;
	private HashMap<String,NameSurferEntry> nameList = new HashMap<String,NameSurferEntry>();
}

