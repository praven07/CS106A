/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3562321637020873518L;
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph(){
		
		setBackground(Color.BLACK);
		addComponentListener(this);
	}
	
	
	/*
	 * It draws the graphLayout to display the graph
	 */
	private void drawGraphLayout(){
		
		space = getWidth()/NDECADES;
		int year = START_DECADE;
		for(int i=0; i<NDECADES; i++){
			int x = space*i;
			int y = 0;
			int x1 = x;
			int y1 = getHeight();
			GLine line = new GLine(x,y,x1,y1);
			line.setColor(Color.WHITE);
			add(line);
			GLabel yearLabel = new GLabel("" + year);
			yearLabel.setColor(Color.WHITE);
			yearLabel.setLocation(x+5, getHeight()-5);
			add(yearLabel);
			year += 20;
		}
		
		GLine topBorder = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		topBorder.setColor(Color.WHITE);
		add(topBorder);
		
		GLine bottomBorder = new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE);
		bottomBorder.setColor(Color.WHITE);
		add(bottomBorder);
	}
	
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {

		for(int i=0; i<activeList.size(); i++){
			activeList.removeAll(activeList);
		}
		update();
	}
	
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		
		if(entry != null){
			activeList.add(entry);
			update();
		}
	}

	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGraphLayout();
		drawActiveObjects();
	}
	
	
	/*
	 * It redraws all the data present on the screen
	 */
	private void drawActiveObjects(){
		
		for(int i=0; i<activeList.size(); i++){
			NameSurferEntry nameData = activeList.get(i);
			drawGraph(nameData,i);
		}
	}
	
	
	/*
	 * It finds the location of various points to diaplay the objects on the screen
	 * then it creates a graph and then it creates a label to set the rank of 
	 * the graphpoint and the it create a rectangle to represent the location of 
	 * the graph plot
	 */
	private void drawGraph(NameSurferEntry nameData, int entryNumber){
		
		double scale = (double)(getHeight()- GRAPH_MARGIN_SIZE*2)/MAX_RANK;
		for(int i=0; i<NDECADES; i++){
			int rank1 = nameData.getRank(i);
			int rank2 = 0;
			if(i != 10){ //It checks to see if there is any ranks remaining in the list
				rank2 = nameData.getRank(i+1);
			}
			double x1 = i*space;
			double y1 = (getHeight()-GRAPH_MARGIN_SIZE) - (scale*rank1);
			double x2 = x1;
			double y2 = y1; 
			if(i != 10){ //It checks to see if there is any ranks remaining in the list
				x2 = x1 + space;
				y2 = (getHeight()-GRAPH_MARGIN_SIZE) - (scale*rank2);
			}
			
			String text = nameData.getName() + " " + rank1;
			
			GLine graph = createLine(x1,y1,x2,y2);
			
			GLabel name = createLabel(text);
			name.setLocation(x1, y1);
			name.setFont("Arial-15");
			
			GRect plot = createRect();
			plot.setLocation(x1 - plot.getWidth()/2, y1 - plot.getHeight()/2);
			
			
			if(entryNumber%4 == 0){
				graph.setColor(Color.CYAN);
				name.setColor(Color.CYAN);
				plot.setColor(Color.CYAN);
			}else if(entryNumber%4 == 1){
				graph.setColor(Color.RED);
				name.setColor(Color.RED);
				plot.setColor(Color.RED);
			}else if(entryNumber%4 == 2){
				graph.setColor(Color.ORANGE);
				name.setColor(Color.ORANGE);
				plot.setColor(Color.ORANGE);
			}else if(entryNumber%4 == 3){
				graph.setColor(Color.MAGENTA);
				name.setColor(Color.MAGENTA);
				plot.setColor(Color.MAGENTA);
			}
			
			add(graph);
			add(name);
			add(plot);
		}
		
	}
	
	
	/*
	 * creates a line
	 */
	private GLine createLine(double x1, double y1, double x2, double y2){
		
		GLine line = new GLine(x1,y1,x2,y2);
		return line;
	}
	
	
	/*
	 * creates a label
	 */
	private GLabel createLabel(String name){
		
		GLabel label = new GLabel(name);
		return label;
	}
	
	
	/*
	 * create a rect
	 */
	private GRect createRect(){
		
		GRect rect = new GRect(5,5);
		rect.setFilled(true);
		return rect;
	}
	
	
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	

	private ArrayList<NameSurferEntry> activeList = new ArrayList<NameSurferEntry>();
	private int space;
}
