import acm.program.*;

public class FindRange extends ConsoleProgram{
	
	private static final int SENTINEL =0;
	
	public void run(){
		
		int x = 0;
		int y = 0;
		
		println("This program finds the largest and smallest numbers");
		
		while(true){
			int value = readInt("?");
			if(value==SENTINEL){
				break;
			}else{
				if(value>=x){
					x =value;
				}else{
					y =value;
				}
			}
		}	
		if(x!=SENTINEL && y!=SENTINEL){
			println("largest: " + x);
			println("smallest: " + y);
		}else if(x!=SENTINEL && y==SENTINEL){
			println("larget:" + x);
			println("smallest: " + x);
		}else{
			println("No value has been entered");
		}
	}
}