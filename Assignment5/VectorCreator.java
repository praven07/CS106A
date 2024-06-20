import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VectorCreator extends GraphicsProgram{
	
	public void init(){
		try {
		     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		initObjectSelector();
		initColorSelector();
		initFilled();
		initDelete();
		initClear();
		addActionListeners();
		addMouseListeners();
	}
	
	private void initDelete(){
		
		delete = new JButton("Delete");
		add(delete,EAST);
	}
	
	private void initClear(){
		
		clear = new JButton("Clear");
		add(clear,EAST);
	}
	
	private void initObjectSelector(){
		
		JLabel lb = new JLabel("Select Object");
		add(lb,EAST);
		objectPicker = new JComboBox();
		objectPicker.addItem("Rect");
		objectPicker.addItem("Oval");
		objectPicker.setSelectedItem("Rect");
		objectPicker.setEditable(false);
		add(objectPicker,EAST);
	}
	
	private void initColorSelector(){
		
		JLabel lb = new JLabel("Select Color");
		add(lb,EAST);
		colorPicker = new JComboBox();
		colorPicker.addItem("Black");
		colorPicker.addItem("Red");
		colorPicker.addItem("Green");
		colorPicker.addItem("Yellow");
		colorPicker.addItem("Blue");
		colorPicker.addItem("Gray");
		colorPicker.addItem("Cyan");
		colorPicker.addItem("Pink");
		colorPicker.setSelectedItem("Black");
		colorPicker.setEditable(false);
		add(colorPicker,EAST);
	}
		
	private void initFilled(){
		
		fill = new JCheckBox("Filled");
		fill.setSelected(true);
		fill.setEnabled(true);
		add(fill,EAST);
	}
	
	public void mousePressed(MouseEvent e){
		
		clickedPosition = new GPoint(e.getPoint());
		selected = getElementAt(clickedPosition);
		if(selected != null){
			if(boundingBox != null){
				remove(boundingBox);
			}
			addBoundingBox();
		}else{
			if(selected == null && boundingBox != null)remove(boundingBox);
			String object = (String) objectPicker.getSelectedItem();
			setColor();
			setFill();
			if(object.equals("Rect")){
				drawRect(e);
			}else if(object.equals("Oval")){
				drawOval(e);
			}
		}
	}

	public void mouseDragged(MouseEvent e){
		
		if(selected != null){
			if(selected != boundingBox){
				selected.move(e.getX()-clickedPosition.getX(), e.getY()-clickedPosition.getY());
				boundingBox.move(e.getX()-clickedPosition.getX(), e.getY()-clickedPosition.getY());
				clickedPosition = new GPoint(e.getPoint());
			}
		}else{
			double x = Math.min(clickedPosition.getX() , e.getX());
			double y = Math.min(clickedPosition.getY(),e.getY());
			double width = Math.abs(clickedPosition.getX()-e.getX());
			double height = Math.abs(clickedPosition.getY()-e.getY());
			((GResizable) activeObject).setBounds(x, y, width, height);
			add(activeObject);
		}
	}

	private void drawRect(MouseEvent e){
		
		clickedPosition = new GPoint(e.getPoint());
		rect = new GRect(0,0);
		rect.setLocation(e.getX(),e.getY());
		rect.setFilled(getFilled);
		rect.setColor(selectedColor);
		activeObject = rect;
	}
	
	private void drawOval(MouseEvent e){
		
		clickedPosition = new GPoint(e.getPoint());
		oval = new GOval(0,0);
		oval.setLocation(e.getX(),e.getY());
		oval.setFilled(getFilled);
		oval.setColor(selectedColor);
		activeObject = oval;
	}
	
	private void setColor(){
		
		String color = (String) colorPicker.getSelectedItem();
		if(color.equals("Black")){
			selectedColor = Color.BLACK;
		}else if(color.equals("Red")){
			selectedColor = Color.RED;
		}else if(color.equals("Green")){
			selectedColor = Color.GREEN;
		}else if(color.equals("Yellow")){
			selectedColor = Color.YELLOW;
		}else if(color.equals("Blue")){
			selectedColor = Color.BLUE;
		}else if(color.equals("Gray")){
			selectedColor = Color.GRAY;
		}else if(color.equals("Cyan")){
			selectedColor = Color.CYAN;
		}else if(color.equals("Pink")){
			selectedColor = Color.PINK;
		}
	}
	
	private void setFill(){
		
		if(fill.isSelected()){
			getFilled = true;
		}else{
			getFilled = false;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		
		String cmd = e.getActionCommand();
		if(cmd.equals("Clear")){
			clearScreen();
		}else if(cmd.equals("Delete")){
			deleteObject();
		}
	}
	
	private void addBoundingBox(){
		
		boundingBox = new GRect(0,0);
		boundingBox.setLocation(selected.getX()-2,selected.getY()-2);
		boundingBox.setSize(selected.getWidth()+4,selected.getHeight()+4);
		boundingBox.setColor(Color.DARK_GRAY);
		add(boundingBox);
		boundingBox.sendBackward();
	}
	
	private void deleteObject(){
		
		if(selected != null){
			remove(selected);
			remove(boundingBox);
		}
	}
	
	private void clearScreen(){
		
		removeAll();
	}
	
	private JButton clear,delete;
	private JComboBox objectPicker,colorPicker;
	private JCheckBox fill;
	private GRect rect,boundingBox;
	private GOval oval;
	private GObject activeObject,selected;
	private Color selectedColor;
	private GPoint clickedPosition;
	private boolean getFilled;
}