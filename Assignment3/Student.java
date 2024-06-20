
public class Student {

	
	public Student(String sName,int sYear){
		
		name = sName;
		year = sYear;
	}
	
	public void setName(String cName){
		
		name = cName;
		nameChanged = true;
	}
	
	public String getName(){
		
		return name;
	}
	
	public boolean isNameChanged(){
		
		return nameChanged;
	}
	
	public int getYear(){
		
		return year;
	}
	
	public void setId(int sId){
		
		if(!IdSet){
			id = sId;
			IdSet = true;
		}
	}
	
	public int getId(){
		
		return id;
	}
	
	public boolean isIdSet(){
		
		return IdSet;
	}
	
	private String name;
	private int year;
	private int id;
	private boolean nameChanged = false;
	private boolean IdSet = false;
}
