import java.util.ArrayList;

import acm.program.*;



public class PixelList extends ConsoleProgram{
	
	
	public void run(){
		
		int r = 0;
		int g = 0;
		int b = 0;
		
		array = new ArrayList<Elem>();
		
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 256; j++){
				for(int k = 0; k < 256; k++){
					Elem list = new Elem();
					list.r = r+i;
					list.g = g+j;
					list.b = b+k;
					array.add(list);
				}
			}
		}
		
		
		println(array.size());
//		for(int a = 0; a < array.size(); a++){
//			ArrayList<Integer> elem = array.get(a);
//			pause(1);
//			println(elem.get(0) + " " + elem.get(1) + " " + elem.get(2));
//		}
	}
	
	
	private ArrayList<Elem> array;

	
	
	private class Elem{
		
		int r,g,b;
	}
}
