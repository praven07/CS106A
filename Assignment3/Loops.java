import acm.program.*;

public class Loops extends ConsoleProgram{
	 
	public void run(){
		
		setFont("Courier-18");
		String name = readLine("enter name : ");
		if (name.equals("praven")){
			praven();
		}else if (name.equals("yogi")){
			yogi();
		}else if (name.equals("john")){
			john();
		}else{
			println("user not found");	
		}
		
	}
	  
	private void praven(){
		 
		println("praven");
	}
	
	private void yogi(){
		
		println("yogi");	
	}
	
	
	private void john(){
		
		println("john");
	}
	
 }
 