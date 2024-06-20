import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.program.*;
import acm.graphics.*;



public class TextEditor extends GraphicsProgram{

	
	private static final long serialVersionUID = -4379857062827326653L;


	public void run(){
		
		editor = new BufferEditor();
		text = new GLabel("", 10, 30);
		text.setFont("Arial-20");
		add(text);
		addKeyListeners();
		update();
	}
	
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			editor.moveBackward();
		}else if(key == KeyEvent.VK_RIGHT){
			editor.moveForward();
		}else if(key == KeyEvent.VK_BACK_SPACE){
			editor.removeAt(editor.getCursorLocation()-1);
		}else{
			editor.insetAt(editor.getCursorLocation(), e.getKeyChar());
		}
		update();
	}
	
	
	private void update(){
		
		removeAll();
		String str = "";
		ArrayList<Character> value = editor.getValues();
		for(int i = 0; i <= value.size(); i++){
			if(i == editor.getCursorLocation()){
				str += "|";
			}
			if(i < value.size())
				str += value.get(i);
		}
		text.setLabel(str);
		text.setLocation(10, 30);
		add(text);
	}
	
	
	private BufferEditor editor;
	private GLabel text;
}