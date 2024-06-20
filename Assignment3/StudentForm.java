import acm.program.*;

public class StudentForm extends ConsoleProgram{
	
	public void run(){
		
		Student s1 = new Student("John",1);
		println(s1.isIdSet());
		s1.setId(6546);
		println(s1.isNameChanged());
		s1.setName("sam");
		println(s1.isNameChanged());
	}
}