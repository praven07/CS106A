import acm.program.*;
import java.io.*;


public class WordCount extends ConsoleProgram{
	
	public void run(){
		
		int lines = 0;
		int words = 0;
		int chars = 0;
		
		String filename = readLine("Enter a filename: ");
		BufferedReader file = openFile(filename);
		
		try{
			while(true){
				String line = file.readLine();
				if(line == null)break;
				lines++;
				words += countWords(line);
				chars += line.length(); 
			}
		}catch (Exception ex) {
			println("Cannot read file.");
		}
		
		println("Lines: " + lines);
		println("Words: " + words);
		println("Chars: "+ chars);
	}
	
	private BufferedReader openFile(String promt){
		
		BufferedReader file = null;
		
		try{
			file = new BufferedReader(new FileReader(promt));
		}catch (Exception e) {
			println("File does not exist.");
		}
		return file;
	}
	
	private int countWords(String line){
		
		boolean isWord = false;
		int words = 0;
		for(int i=0; i<line.length(); i++){
			char ch = line.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				isWord = true;
			}else{
				if(isWord)words++;
				isWord = false;
			}
		}
		if(isWord)words++;
		return words;
	}
}