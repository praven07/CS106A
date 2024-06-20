import acm.program.*;


public class PlaneteryMotion extends ConsoleProgram{

	
	public void run(){
		setFont("Arial-25");
		String planetName = readLine("Enter the planets name: ");
		double astronomicalUnits = readDouble("Enter number of Astronomical units: ");
		double Au = (double) Math.pow(astronomicalUnits, 3);
		double period =  Math.floor(Math.sqrt(Au));
		println(planetName + " takes about " + period + "yrs to orbit the Sun");
	}
}