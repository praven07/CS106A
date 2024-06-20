import acm.program.*;

public class Hailstone extends ConsoleProgram{
	
	private static final int SENTINEL =1;
	
	public void run(){
		
		int n = readInt("Enter a number: ");
		
		while(true){
			
			if(n==SENTINEL)break;
			
			int temp =n;
			
			if(n%2 ==0){
				n /=2;
				println(temp + "is even,so i take half:" + n);
				COUNTER++;
			}else{
				n = 3*n+1;
				println(temp + "is odd, so i take 3n+1:" + n);
				COUNTER++;
			}
		}
		
		println("The process took " + COUNTER +" to reach 1");
	}
	
	private int COUNTER;
}