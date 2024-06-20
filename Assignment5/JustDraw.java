import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.ArrayList;
import acm.program.*;
import acm.graphics.*;



public class JustDraw extends GraphicsProgram{

	
	
	public void run(){

		setCursor(new Cursor(5));
		setBackground(Color.BLACK);
		addMouseListeners();
		addActionListeners();
		
	}
	
	
	public void mouseClicked(MouseEvent e){
		int iX = e.getX();
		int iY = e.getY();
		for(int i = 0; i < 70; i++){
			GOval rect = new GOval(1+(i/3),1+(i/3));
			rect.setFilled(true);
			rect.setColor(Color.getHSBColor(i, i+100, i+100));
			rect.setLocation(iX+(i/4),iY+(i/4));
			list.add(rect);
			add(rect);
		}
	}
	
	
	public void mouseMoved(MouseEvent e){
		
		if(location < 70){
			ev.add(e);
			location++;
		}else{
			ev.add(e);
			update();
		}
	}
	
	
	public void update(){
		
		int size = ev.size();
		for(int i = 0; i < list.size(); i++){
			GOval rect = list.get(i);
			double x = rect.getX();
			double y = rect.getY();
			rect.move(ev.get(size-i-1).getX()-x,ev.get(size-i-1).getY()-y);
		}
	}

	private int location = 0;
	private ArrayList<GOval> list = new ArrayList<GOval>();
	private ArrayList<MouseEvent> ev = new ArrayList<MouseEvent>();
}