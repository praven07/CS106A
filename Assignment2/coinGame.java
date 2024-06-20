import acm.program.*;
import acm.util.*;


public class coinGame extends ConsoleProgram{
	
	
	public void run(){
		int heads = 0;
		int tails = 0;
		for(int i=0; i<20; i++){
			int x = rgen.nextInt(0,10);
			if(x > 5){
				println("HEADS");
				heads++;
			}else{
				println("TAILS");
				tails++;
			}
		}
		println("Total Heads: " + heads);
		println("Total Tails: " + tails);
	}
	
	private RandomGenerator  rgen = RandomGenerator.getInstance();
}