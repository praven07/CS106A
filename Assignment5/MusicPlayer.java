import acm.program.*;
import acm.graphics.*;
import acm.util.*;


public class MusicPlayer extends GraphicsProgram{
	
	public void run(){
		
		MovieClip clip = new MovieClip("MVI_1591.MOV");
		clip.play();
		add(clip);
		
	}
}