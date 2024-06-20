
public class Frosh extends Student {

	public Frosh(String name, int ID) {
		super(name, ID);
		setUnits(0);
	}
	
	public String toString(){
		return("Frosh" + getName() + "(#" + getId() + ")" );
	}

}
