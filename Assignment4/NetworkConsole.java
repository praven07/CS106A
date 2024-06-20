import java.net.*;
import java.util.StringTokenizer;

import acm.program.*;



public class NetworkConsole extends ConsoleProgram{
	
	
	public void run(){
		
		initSetup();
		while(true){
			String input = readLine(" >>");
			if(input.equals("exit") || input.equals("quit"))break;
			processInput(input);
		}
		exit();
	}
	
	
	private void initSetup(){
		setFont("courier new-20");
	}

	
	private void processInput(String line){
		
		String command = "";
		String value = "";
		StringTokenizer tokens = new StringTokenizer(line, " ");
		if(tokens.countTokens() == 2){
			command = tokens.nextToken();
			value = tokens.nextToken();
		}
		checkFunction(command,value);
	}
	
	
	private void checkFunction(String command,String value){
		
		if(command.equals("whois")){
			lookUp(0,value);
		}else if(command.equals("ip")){
			lookUp(1,value);
		}
	}
	
	
	private void lookUp(int index,String value){
		
		if(connection(value)){
			switch (index) {
			case 0:
				println(address.getHostName());
				break;
			case 1:
				println(address.getHostAddress());
			default:
				break;
			}
		}
	}
	
	
	private boolean connection(String url){
		
		try {
			address = InetAddress.getByName(url);
			return true;
		} catch (UnknownHostException e) {
			println("Either an error occured or the given address does not exits");
		}
		return false;
	}
		
	
	private InetAddress address;
}