import acm.program.*;


public class LetterCapitalizer extends ConsoleProgram{
	
	public void run(){
		
		String str = readLine("Enter a String: ");
		println(letterToUppercase(str));
	}
	
	
	private String letterToUppercase(String str){
		
		String result = "";
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch >= 'a' && ch<= 'z'){
				result += (char)((ch - 'a') + 'A'); 
			}else{
				result += ch;
			}
		}
		return result;
	}
}