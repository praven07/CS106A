import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GRect;


public class Grid extends GCompound{

	
	public Grid(int w,int h,int row,int col){
		
		width = w;
		height = h;
		numRows = row;
		numCols = col;
		drawGrid();
	}
	
	
	private void drawGrid(){
		
		rectList = new ArrayList<GRect>();
		int rectWidth = width/numCols;
		int rectHeight = height/numRows;
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				GRect rect = new GRect(rectWidth, rectHeight);
				rect.setLocation(rectWidth*i, rectHeight*j);
				rectList.add(rect);
				add(rect);
			}
		}
	}
	
	
	public void setFilled(boolean fill){
		
		for(int i = 0; i < rectList.size(); i++){
			GRect rect = rectList.get(i);
			rect.setFilled(fill);
		}
	}
	
	
	private int width;
	private int height;
	private int numRows,numCols;
	private ArrayList<GRect> rectList;
}
