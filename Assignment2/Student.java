/**
 * class:Student.java
 * @author Praven
 * --------------------
 *
 */
public class Student {

	public Student(String name, int ID){
		studentName = name;
		studentID = ID;
	}
	
	public String getName(){
		return(studentName);
	}
	
	public int getId(){
		return(studentID);
	}
	
	public double getUnits(){
		return(unitsEarned);
	}
	
	public void setUnits(double units){
		unitsEarned = units;
	}
	
	public void incrementUnits(double additionalUnits){
		unitsEarned += additionalUnits;
	}
	
	public String toString(){
		return (studentName + ",#" + studentID) ;
	}
	
	public boolean hasEnoughUnits(){
		return(unitsEarned >= UNITS_TO_GRADUATE);
	}
	
	private static final double UNITS_TO_GRADUATE = 180.0;
	
	private String studentName;
	private int studentID;
	private double unitsEarned;
}
