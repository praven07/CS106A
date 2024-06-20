import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.junit.rules.Stopwatch;

import acm.program.*;
import acm.util.MediaTools;
import acm.util.RandomGenerator;
import acm.graphics.*;


public class DotConnector extends GraphicsProgram{
	
	
	private static final int SIZE = 1;
	private static final int NUM_CONNECTIONS = 5000;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	private static final int DELAY = 1;
	
	
	public void run(){
		
		setSize(WIDTH,HEIGHT);
		initList();
		waitForClick();
		watch = new Stopwatch();
		createConnection();
		createNetwork();
		time = watch.elapsedTime();
		println(time);
		addMouseListeners();
	}
	
	
	private void initList(){
		
		list = new ArrayList<GOval>();
		detailList = new ArrayList<GRoundRect>();
	}

	
	private void createConnection(){
		
		for(int i=0; i<NUM_CONNECTIONS; i++){
			createDots();
		}
	}
	
	
	private void createDots(){
		
		GOval dot = new GOval(SIZE,SIZE);
		int x = rgen.nextInt(50,getWidth()-SIZE-50);
		int y = rgen.nextInt(30,getHeight()-SIZE-30);
		dot.setLocation(x, y);
		dot.setFilled(true);
		GRoundRect rect = new GRoundRect(x,y,100,30,5);
		rect.setVisible(false);
		rect.setFilled(true);
		rect.setColor(Color.ORANGE);
		add(rect);
		add(dot);
		list.add(dot);
		detailList.add(rect);
	}
	
	
	private void createNetwork(){
		
		for(int i=0; i<NUM_CONNECTIONS-1; i++){
			GOval oval1 = list.get(i);
			GOval oval2 = list.get(i+1);
			double x1 = oval1.getX()+SIZE/2;
			double y1 = oval1.getY()+SIZE/2;
			double x2 = oval2.getX()+SIZE/2;
			double y2 = oval2.getY()+SIZE/2;
			GLine line = new GLine(x1, y1, x2, y2);
			line.setEndPoint(x2, y2);
			if((x1-x2)>WIDTH/2){
				line.setColor(Color.RED);
			}else if((x1-x2)>WIDTH/3){
				line.setColor(Color.yellow);
			}else{
				line.setColor(Color.BLUE);
			}
			line.setVisible(true);
			//sound.play();
			add(line);
			pause(DELAY);
		}
	}
	
	
	
	private RandomGenerator rgen = new RandomGenerator().getInstance();
	private ArrayList<GOval> list;
	private ArrayList<GRoundRect> detailList;
	private AudioClip sound = MediaTools.loadAudioClip("bounce.au");
	private double time;
	private Stopwatch watch;
}