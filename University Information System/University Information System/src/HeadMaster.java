//Implemented by Vincent:
import java.util.GregorianCalendar;

public class HeadMaster implements Task, PublicProperty, Bulletin,
Comparable<HeadMaster>
{
	//Data fields for HeadMater class:
	//Data fields for PublicProperty
	private String name;
	private String password;
	private String identity;
	private String hobby;
	private String emailAddress;
	private int salary;
	private String id;
	private GregorianCalendar dateComeIn;
	private GregorianCalendar birthday;
	
	//Data field for Task:
	private String informationContent;
	private String taskName;
	private String taskNote;
	private String progress;
	private int emergyLevel;
	private GregorianCalendar dueDate;
	private String taskEvaluate;
		
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
	
	public void setEmailAddress(String address){
		emailAddress = address;
	}//end method
	
	public String getEmailAddress(){
		return emailAddress;
	}//end method
	
	public void setSalary(int salary) {
		this.salary = salary;		
	}//end class

	public int getSalary() {
		return salary;
	}//end method

	public void setDateIn(GregorianCalendar dateIn) {
		dateComeIn = dateIn;		
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
	
	//This is the start of Bulletin interface:
	public void setInformation(String info) {
		informationContent = info;		
	}//end method

	public String getInformation() {
		return informationContent;
	}//end method

	public boolean ableToSetInformation() {
		return false;
	}//end method
	//This is the end of Bulletin Interface.

	//This is the start of Task Interface:
	public void setTaskName(String taskName) {
		this.name = taskName;
	}//end method

	public String getTaskName() {
		return taskName;
	}//end method

	public void setEmergyLevel(int level) {
		emergyLevel = level;
	}//end method

	public int getEmergyLevel() {
		return emergyLevel;
	}//end method

	public void setTaskDueDate(GregorianCalendar date) {
		dueDate = date;
	}//end method

	public GregorianCalendar getTaskDueDate() {
		return dueDate;
	}//end method

	public boolean ableToModifyTask() {
		return true;
	}//end method

	@Override
	public void setTaskNote(String note) {
		taskNote = note;		
	}//end method
	
	public void setTaskProgress(String progress){
		this.progress = progress;
	}//end method
	
	public String getTaskProgress(){
		return progress;
	}//end method

	@Override
	public String getTaskNote() {
		return taskNote;
	}//end method
	

	@Override
	public void setTaskEvaluate(String evaluateInfo) {
		taskEvaluate = evaluateInfo;		
	}//end method

	@Override
	public String getTaskEvaluate() {
		return taskEvaluate;
	}
	//This is the end of Task Interface.
	
	@Override
	public int compareTo(HeadMaster o) {
		if(getName().compareTo(o.getName()) > 0)
			return 1;
		else
			return -1;
	}//end method
	
}//end class
