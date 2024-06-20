import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class JustPaint extends GraphicsProgram{

	
	public void init(){
		setSize(1000, 800);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { }
		
		addMouseListeners();
		createUI();
	}
	
	
	private void createUI(){
		
		ImageIcon icond = new ImageIcon("Design_0j3.png");
		ImageIcon icone = new ImageIcon("Untitled-1_01.png");
		ImageIcon iconf = new ImageIcon("Design_03.png");
		JButton draw = new JButton(icond);
		draw.setPreferredSize(new Dimension(icond.getIconWidth()-2,icond.getIconHeight()-1));
		draw.setBorderPainted(true);
		draw.setCursor(new Cursor(12));
		draw.setRolloverEnabled(true);
		draw.setRolloverIcon(iconf);
		draw.setActionCommand("Draw");
		draw.setToolTipText("Draw");
		add(draw,EAST);
		JButton erase = new JButton(icone);
		erase.setActionCommand("Erase");
		erase.setToolTipText("Erase");
		add(erase,EAST);
		addActionListeners();
		eraser = new GRect(0, 0 , 5, 5);
		eraser.setColor(Color.darkGray);
		eraser.setFilled(true);
		eraser.setFillColor(Color.BLACK);
		eraser.setVisible(false);
		add(eraser);
	}
	
	
	public void mousePressed(MouseEvent e){
		
		oldX = e.getX();
		oldY = e.getY();
	}
	
	
	public void mouseDragged(MouseEvent e){
		
		newX = e.getX();
		newY = e.getY();
		if(draw){
			add(new GLine(oldX,oldY,newX,newY));
		}else{
			eraseScreen(e.getPoint());
		}			
		oldX = newX;
		oldY = newY;
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand() == "Draw"){
			draw = true;		
			eraser.setVisible(false);
		}else if(e.getActionCommand() == "Erase"){
			draw = false;
			eraser.setVisible(true);
		}
	}
	
	
	private void eraseScreen(Point e){
		
		eraser.setLocation(e.getX()-eraser.getWidth()/2,e.getY()-eraser.getHeight()/2);
		obj = getElementAt(newX, newY);
		if(obj != null && obj != eraser)
			remove(obj);
	}
	
	
	private int oldX,oldY;
	private int newX,newY;
	private boolean draw = true;
	private GObject obj;
	private GRect eraser;
}