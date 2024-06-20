import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import acm.graphics.GLabel;


public class MyButton extends JButton implements MouseListener{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5309201629311927271L;



	public MyButton(){
		setPreferredSize(new Dimension(100, 50));
		setRolloverEnabled(true);
		
		setBackground(Color.GREEN);
		repaint();
		addMouseListener(this);
	}
	
	
	
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		setBorderPainted(false);
		g.setColor(Color.darkGray);
		Image icon = new ImageIcon("Design_0j3.png").getImage();
	//	g.drawImage(icon, 0,0,getWidth(),getHeight(),null);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		GLabel label = new GLabel("Hello world");
		g.setColor(Color.WHITE);
		g.drawString(label.getLabel(), (int)(getWidth()/2-label.getWidth()/2), (int)(getHeight()/2+label.getAscent()/2));
		re();
	}
	
	public void settext(String name){
		
		this.name = name;
	}
	
	
	
	private void re(){
		//setText(name);
	}
	
	
	private String name;



	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
