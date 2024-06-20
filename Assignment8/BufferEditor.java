import java.util.ArrayList;


public class BufferEditor{
	
	public BufferEditor(){
		buffer = new ArrayList<Character>();
		cursor = 0;
	}
	
	public void moveForward(){
		
		if(cursor < buffer.size()){
			cursor++;
		}
	}
	
	
	public void moveBackward(){
		
		if(cursor > 0){
			cursor--;
		}
	}
	
	public void insetAt(int index,char ch){
		
		buffer.add(index,ch);
		cursor++;
	}
	
	public void removeAt(int index){
		
		if(index >= 0 && index < buffer.size()){
			buffer.remove(index);
			cursor--;
		}
	}
	
	public int getCursorLocation(){
		
		return cursor;
	}

	
	public ArrayList<Character> getValues(){
		
		return buffer;
	}
	
	
	private ArrayList<Character> buffer;
	private int cursor;
}