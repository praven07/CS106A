import acm.program.*;


public class LetterTOLowerCase extends ConsoleProgram{
	
	
	public void run(){
		
		String str = readLine("Enter a String: ");
		println(stringToLowerCase(str));
	}
	
	private String stringToLowerCase(String str){
		
		String result = "";
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if((ch >= 'A') && (ch <= 'Z')){
				result = result + (char)((ch - 'A') + 'a');
			}else{
				result = result + ch;
			}
		}
		return result;
	}
}