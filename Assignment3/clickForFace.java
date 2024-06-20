import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;


@SuppressWarnings("unused")
public class clickForFace extends GraphicsProgram{

	private static final int FACE_SIZE = 100;
	
	private GFace face;	
	

	public void init(){
		
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e){
		face = new GFace(FACE_SIZE,FACE_SIZE);
		add(face,e.getX()-(FACE_SIZE/2),e.getY()-(FACE_SIZE/2));
	}
	
}