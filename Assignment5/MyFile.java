import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import acm.program.*;

public class MyFile extends ConsoleProgram{
	
	
	public void run(){
	
		setFont("Courier new-Bold-18");
		File directory = new File("P:\\");
		File[] list = directory.listFiles();
		setForeground(Color.GREEN);
		while(true){
			String input = readLine("("+directory.getAbsoluteFile()+") >> ");
			if(input.equals(""))break;
			if(input.equals("exit")){
				exit();
			}else if(input.startsWith("cd ")){
				directory = new File(directory.getAbsoluteFile()+"\\"+input.substring(3));
				list = directory.listFiles();
			}else if(input.startsWith("open ")){
				try {
					BufferedReader rd = new BufferedReader(new FileReader(directory.getAbsolutePath()+"\\"+input.substring(5)));
					while(true){				
						String line = rd.readLine();
						if(line == null)break;
						println(line);
					}
					rd.close();
				} catch (FileNotFoundException e) {
					println("File does not exits");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(input.equals("ls")){
				for(int i=0; i<list.length; i++){
					
					println(list[i].getName() + " " + list[i].length());
				}
			}
		}
	}
}
