/**
 * Class:Incrementor.java
 * @author Praven
 * ------------------------
 * In this class it keeps the count of number and provides the next number from the number 
 * given in the parameters
 * if no parameters it countes from 1.
 */
public class Incrementor {

	/**
	 * It creates a new Incrementor and the counter is set to the start value
	 * @param startValue
	 */
	public Incrementor(int startValue){
		counter = startValue;
	}
	
	/**
	 * It creates a new Incrementor and the counter is set to a default
	 * start value 1.
	 */
	public Incrementor(){
		counter = 1;
	}
	
	/**
	 * It given the next value by adding 1 to the current value
	 * @return the next value
	 */
	public int nextValue(){
		int temp = counter;
		counter++;
		return(temp);
	}
	
	/*
	 * It is an Instance variable
	 */
	private int counter;
}
