/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class NameSurfer extends Program implements NameSurferConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8377908976570990564L;
	public static void main(String[] args){
		
		try {
		     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		new NameSurfer().start(args);
	}
	
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public NameSurfer() {
			   
		createInteractor(); 
		createCanvas();
		createDataEntry();
	}
	
	
	/*
	 * Creates the required Interactors(GUI) for the application
	 */
	private void createInteractor(){
		
		createLabel();
		createTextField();
		createGraphButton();
		createClearButton();
		addActionListeners();
	}
	
	
	/*
	 * creates a label before the textField to indicate that 
	 * the text field is used to enter a name
	 */
	private void createLabel(){
		
		name = new JLabel("Name");
		add(name,SOUTH);
	}
	
	
	/*
	 * Creates a textField for the user to enter a name
	 */
	private void createTextField(){
		
		text = new JTextField(20);
		text.setActionCommand("name");
		text.addActionListener(this);
		add(text,SOUTH);
	}

	
	/*
	 * It creates a button for the user to click 
	 * after they enter a name to look for on the database
	 */
	private void createGraphButton(){
		
		graphButton = new JButton("Graph");
		graphButton.setActionCommand("name");
		graphButton.setPreferredSize(new Dimension(95,30));
		add(graphButton,SOUTH);
	}
	
	
	/*
	 * It creates a button for the user to clear 
	 * all the recently searched data
	 */
	private void createClearButton(){
		
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(95,30));
		add(clearButton,SOUTH);
	}
	
	
	/*
	 * creates a dataEntry to store the name list and there values
	 */
	private void createDataEntry(){
		
		nameDatabase = new NameSurferDataBase(NAMES_DATA_FILE); 
	}
	
	
	/*
	 * It creates a canvas to display the graph
	 */
	private void createCanvas(){
		
		canvas = new NameSurferGraph();
		add(canvas);
		canvas.update();
	}
	
	
/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("name")){
			String value = text.getText();
			if(!value.equals("")){
				canvas.addEntry(nameDatabase.findEntry(value));
			}
		}else if(e.getSource() == clearButton){
			canvas.clear();
		}
	}
	
	
	
	/*Ivar
	 * */
	private JLabel name;
	private JTextField text;
	private JButton graphButton,clearButton;
	private NameSurferDataBase nameDatabase;
	private NameSurferGraph canvas;
}
