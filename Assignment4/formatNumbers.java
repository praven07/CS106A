import acm.program.*;


public class formatNumbers extends ConsoleProgram{
	
	//Program starts
	public void run(){
		

		//Keeps the programming running untill '0' is entered 
		while(true){
			String digits = readLine("Enter a numeric value: ");
			if(digits.equals("0")){
				println("Program closed");
				break;
			}
			
			//prints the final digits with proper format
			println(addCommasToNumericString(digits));
		}
	}
	
	/*
	 * add commas to the numeric strings
	 * and returns the final result
	 */
	private String addCommasToNumericString(String digits){
		
		String result = "";
		int length = digits.length();
		int currentPosition = 0;
		for(int i=length-1; i>=0; i--){
			result = digits.charAt(i) + result;
			currentPosition++;
			if((currentPosition % 3)==0 && (i>0)){
				result = "," + result;
			}
		}
		return result;
	}
}