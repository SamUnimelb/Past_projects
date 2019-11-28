//Implemented by Sam, tested by Sam:
import java.util.GregorianCalendar;

interface PublicProperty {
	void setIdentity(String identity);
	String getIdentity();
	
	void setName(String name);
	String getName();
	
	void setPassword(String password);
	String getPassword();
	
	void setHobby(String hobby);
	String getHobby();
	
	void setId(String id);
	String getId();

	void setSalary(int salary);
	int getSalary();
	
	void setDateIn(GregorianCalendar dateIn);
	GregorianCalendar getDateIn();
	
	void setBirthday(GregorianCalendar birthday);
	GregorianCalendar getBirthday();
	
	void setEmailAddress(String emailAddress);
	String getEmailAddress();

	
}//end interface
