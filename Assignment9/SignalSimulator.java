import acm.program.*;
import acm.util.*;
import acm.graphics.*;
import acm.gui.IntField;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;



public class SignalSimulator extends GraphicsProgram{

	private static final long serialVersionUID = 1615001360901939647L;
	public static final int APPLICATION_WIDTH = 1300;
	public static final int APPLICATION_HEIGHT = 600;
	private static final int WIDTH = 25;
	private static final int HEIGHT = 50;
	private static final int NO_OF_TOWERS = 2;
	private static final int MAX_TOWERS = 20;
	
	
	public static void main(String[] args){
		
		new SignalSimulator().start();
	}
	
	
	public void init(){
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ignored){
			
		}
		
		setTitle("Tower Simulator");
		createUI();
		placeTowers();
		placeDevice();
		placeFeatures();
		checkForTower();

		addMouseListeners();
	}
	
	
	private void createUI(){
		
		add(new JLabel("Enter number of towers: "),SOUTH);
		towerNo = new IntField(1,MAX_TOWERS);
		towerNo.setSize(100, 50);
		towerNo.addActionListener(this);
		add(towerNo,SOUTH);
		JButton ok = new JButton("OK");
		add(ok,SOUTH);
		add(new JLabel("    "),SOUTH);
		reGenerate = new JButton("Regenerate Towers");
		add(reGenerate,SOUTH);
		addActionListeners();
	}
	
	
	private void placeTowers(){
		
		for(int i = 0; i <noOfTowers ; i++){
			int x = rgen.nextInt(0, getWidth()-WIDTH);
			int y = rgen.nextInt(0, getHeight()-HEIGHT - 70);
			Tower tower = new Tower(WIDTH, HEIGHT);
			tower.setLocation(x, y);
			tower.setVisible(true);
			towerList.add(tower);
			add(tower);
		}
	}
	
	
	private void placeDevice(){
		
		cell.setFilled(true);
		add(cell);
	}
	
	
	private void placeFeatures(){
		
		signal = new GLine(0, 0, 0, 0);
		add(signal);
		towerId = new GLabel("Tower ID: ", 10 , 40);
		towerId.setFont("Arial-20");
		add(towerId);
		distance = new GLabel("Distance:",10,70);
		distance.setFont("Arial-20");
		add(distance);
		signalStatus = new GLabel("Status: ",10,100);
		signalStatus.setFont("Arial-20");
		add(signalStatus);
	}
	
	
	public void mouseMoved(MouseEvent e){
		
		cell.setLocation(e.getX() - cell.getWidth()/2, e.getY() - cell.getHeight()/2);
		checkForTower();
	}
	
	
	
	private void checkForTower(){
		
		int shortDistance = 0;
		int min = 0;
		for(int i = 0; i < towerList.size(); i++){
			Tower tower = towerList.get(i);
			double x1 = cell.getX();
			double y1 = cell.getY();
			double x2 = tower.getX();
			double y2 = tower.getY();
			int towerDistance  =  (int) Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
			if(i == 0) min = towerDistance;
			if(towerDistance < min){
				min = towerDistance;
				shortDistance = i;
			}
		}
		distance.setLabel("Distance: "+ min);
		towerId.setLabel("Tower ID: " + shortDistance);
		if(min < 300){
			drawSignalLine(shortDistance);
			signalStatus.setLabel("Status: Connected");
		}else{
			signal.setVisible(false);
			signalStatus.setLabel("Status: No Signal");
		}
	}

	
	private void drawSignalLine(int towerIndex){
		
		Tower tower = towerList.get(towerIndex);
		signal.setVisible(true);
		signal.setStartPoint(cell.getX()+cell.getWidth()/2, cell.getY());
		signal.setEndPoint(tower.getX()+ WIDTH/2, tower.getY() + HEIGHT/3);
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == reGenerate){
			towerList.clear();
			removeAll();
			placeTowers();
			placeDevice();
			placeFeatures();
		}
		if(e.getSource() == towerNo || e.getActionCommand() == "OK"){
			noOfTowers = towerNo.getValue();
		}
	}
	
	
	private int noOfTowers = NO_OF_TOWERS;
	private ArrayList<Tower> towerList = new ArrayList<Tower>();
	private GRect cell = new GRect(20, 50);
	private GLine signal;
	private GLabel towerId,distance,signalStatus;
	private JButton reGenerate;
	private IntField towerNo;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

