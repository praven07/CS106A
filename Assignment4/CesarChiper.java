import acm.program.*;


public class CesarChiper extends ConsoleProgram{
	
	public void run(){
		setFont("Arial-25");
		int key = readInt("Enter the key: ");
		str = readLine("Enter String: ");
		String encrypt = cesarEncrypt(str,key);
		println("Encrypted text : " + encrypt);
		while(true){
			decrypt = cesarEncrypt(encrypt,DKey);
			println(DKey);
			if(decrypt.equals(str))break;
			DKey--;
			println(decrypt);
		}
		println(decrypt);
	}
	
	/*
	 * This method encrypts the given text with the given key and it passes to the 
	 * encrypt method to do the real enrypting and returns
	 * a String 
	 */
	private String cesarEncrypt(String str, int key){
		
		if(key < 0){
			key = 26 - (-key % 26);
		}
		String result = "";
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			result += encrypt(ch,key);
		}
		return result;
	}
	
	
	/*
	 * This method does the encryption and returns a char
	 */
	private char encrypt(char ch, int key){
		if(Character.isUpperCase(ch)){
			return (char)('A' + (ch - 'A' + key) % 26);
		}
		return ch;
	}
	
	private int DKey = 0;
	private String str,decrypt;
}