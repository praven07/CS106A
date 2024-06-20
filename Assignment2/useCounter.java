import acm.program.*;

public class useCounter extends ConsoleProgram{
	
	public void run(){
		
		Incrementor count1 = new Incrementor(10000);
		Incrementor count2 = new Incrementor();
		
		println("five values of count1");
		nextFiveValues(count1);
		println("five values of count2");
		nextFiveValues(count2);
		println("five values of count1");
		nextFiveValues(count1);
	}

	private void nextFiveValues(Incrementor count) {
		for(int i=0; i<5; i++){
			println(count.nextValue());
		}
	}
}
