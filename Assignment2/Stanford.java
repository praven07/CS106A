import acm.program.*;

public class Stanford extends ConsoleProgram{
	
	public void run(){
		
		Student student = new Student("Ben Newmen",10000);
		student.setUnits(170.0);
		println(student.getId());
		println(student.hasEnoughUnits());
		student.incrementUnits(20);
		println(student.hasEnoughUnits());
		println(student.toString());
		
		Frosh stud = new Frosh("Ben",100001);
		println(stud.getUnits());
		println(stud.toString());
	}
	
	
}