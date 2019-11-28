import java.util.GregorianCalendar;

//Implemented by Miner:
public class Faculty implements Faculty_Info, 
	PublicProperty, Comparable<Faculty>
{
	// Data field for SirII Interface:
	private int teachScore;
	private int projectScore;
	private String facultyName;

	// Data Fields for Faculty Class:
	private String emailAddress = "";
	private String officeHours;
	private String officeLocation = "";
       
  //Data fields for Faculty class:
  	//Data fields for PublicProperty
  	private String name;
  	private String password;
  	private String identity;
  	private String hobby;
  	private int salary;
  	private String id;
  	private GregorianCalendar dateComeIn;
  	private GregorianCalendar birthday;
    
    //The main method is a testing program:
    public static void main(String[] args) throws InterruptedException{
    	//Faculty fa = new Faculty();   
    }//The main method used to test the program
    
    //This is the start of Career Plan Interface:
		public void setFacultyName(String name){
			facultyName = name;
		}//end method
		
		public String getFacultyName(){
			return facultyName;
		}//end method
		
		public void setTeachScore(int score) {
			teachScore = score;	
		}//end method

		public int getTeachScore() {
			return teachScore;
		}//end method

		public void setProjectScore(int score) {
		    projectScore = score;	
		}//end method

		public int getProjectScore() {
			return projectScore;
		}//end method
		//This is the end of SirII Interface.

	@Override
	public void setEmailAddress(String email) {
	    emailAddress = email;	
	}//end method

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}//end method

	public void setOfficeHours(String day){
		this.officeHours = day;
	}//end method	
	
	public String getOfficeHours(){
		return officeHours;
	};//end method

	@Override
	public void setOfficeLocation(String location) {
		officeLocation = location;		
	}//end method

	@Override
	public String getOfficeLocation() {
		return officeLocation;
	}//end method
	//This is the end of Faculty_Info Interface.
	
	//This is the start of PublicProperty Interface:
	public void setIdentity(String identity) {
		this.identity = identity;		
	}//end method

	public String getIdentity() {
		return identity;
	}//end method
	
	public void setName(String name) {
		this.name = name;		
	}//end method

	public String getName() {
		return name;
	}//end method

	public void setPassword(String password) {
		this.password = password;		
	}//end method

	public String getPassword() {
		return password;
	}//end method

	public void setHobby(String hobby){
		this.hobby = hobby;
	}//end method
	
	public String getHobby(){
		return this.hobby;
	}//end method
	
	public void setId(String id) {
		this.id = id;	
	}//end method

	public String getId() {
		return id;
	}//end method
	
	public void setSalary(int salary) {
		this.salary = salary;		
	}//end class

	public int getSalary() {
		return salary;
	}//end method

	public void setDateIn(GregorianCalendar date) {
		dateComeIn = date;		
	}//end method

	public GregorianCalendar getDateIn() {
		return dateComeIn;
	}//end method

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;		
	}//end method

	public GregorianCalendar getBirthday() {
		return birthday;
	}//end method
	//This is the end of PublicProperty Interface.

	@Override
	public int compareTo(Faculty o) {
		if(getName().compareTo(o.getName()) > 0)
			return 1;
		else
			return -1;
	}//end compare method
	
}//end class
