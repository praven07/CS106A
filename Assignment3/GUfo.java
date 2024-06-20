import acm.graphics.*;


public class GUfo extends GCompound{
	
	private static final double ENGINE = 0.25;  
	private static final double SHELL = 0.50;
	
	
	private GArc shell;
	private GPolygon engine;
	
	public  GUfo(int size){
		
		shell = new GArc(size*SHELL,size*SHELL,0,180);
		engine = createEngine(size*ENGINE,size*ENGINE);
		engine.setFilled(true);
		
		add(shell, getWidth()/2 - 2*shell.getWidth(),
					getHeight()/2 - shell.getHeight());
		add(engine, getWidth()/2 - engine.getWidth()/2,
						getHeight()/2);
	}
	
	private GPolygon createEngine(double width, double height){
		
		engine = new GPolygon();
		engine.addVertex(-width, -height/2);
		engine.addVertex(+width, -height/2);
		engine.addVertex(width/0.25, height/2);
		engine.addVertex(-width/0.25, height/2);
		return(engine);
	}
}