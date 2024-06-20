import acm.program.*;


public class DeleteCharacter extends ConsoleProgram{
	
	
	public void run(){
		
		
		while(true){
			String word = readLine("Enter a word: ");
			String character = readLine("Enter one character: ");
			if(character.length() == 1){
				char ch = character.charAt(0);
				println(removeCharacter(word,ch));
			}else{
				println("! Invalid character input...");
				println("Result: " + word);
			}
		}
	}
	
	private String removeCharacter(String word, char ch){
		
		String result = "";
		for(int i=0; i<word.length(); i++){
			if(word.charAt(i) != ch){
				result = result + word.charAt(i);
			}
		}
		return result;
	}
}