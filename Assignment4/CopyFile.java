import acm.program.*;
import java.io.*;

import acm.util.*;


public class CopyFile extends ConsoleProgram{
	
	public void run(){
		
		String promt = "Enter a filename to read: ";
		BufferedReader rd = openFile(promt);
		

		try{
			String filename = readLine("Enter a new filename to copy the file: ");
			PrintWriter rw = new PrintWriter(new FileWriter(filename));
			while(true){				
				String line = rd.readLine();
				if(line == null)break;
				rw.println(line);
				println("copying[ " + line + " ]");
			}
			rd.close();
			rw.close();
			println("Successfully copied the file to " + filename);
		}catch (IOException ex){
			throw new ErrorException(ex);
		}
		
		
	}
	
	private BufferedReader openFile(String promt){
		
		BufferedReader rd = null;
		while(rd == null){
			try{
			
				String filename = readLine(promt);
				rd = new BufferedReader(new FileReader(filename)); 
			}catch(IOException ex){
				println("file does not exist.");
			}	
		}
		return rd;
	}
}