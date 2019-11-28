import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Implemented by Sam:
public class Admin implements Project, Task, Bulletin, PublicProperty,
		Comparable<Admin> {
	// Data fields for Admin class:
	private PeopleInfo peopleInfo;
	
	// Data fields for Project Interface:
	private String projectId;
	private String projectName;
	private GregorianCalendar projectDueDate;
	private BigInteger projectCost;
	private String instructorName;
	private List<Student> projectStudentList;
	private int projectScore = 0;
	private int projectProgress = 0;

	// Data fields for Task Interface:
	private String taskName;
	private String evaluate;
	private int emergyLevel;
	private GregorianCalendar taskDueDate;
	private String taskNote;
	private String progress;

	// Data fields for Bulletin Interface:
	private String information;

	// Data fields for PublicProperty Interface:
	private String name;
	private String emailAddress;
	private String careerNow;
	private String password;
	private String identity;
	private int salary;
	private String id;
	private GregorianCalendar dateComeIn;
	private GregorianCalendar birthday;
	private String hobby;

	// Data fields used to manage Bulletin:
	private List<Bulletin> bulletinList;
	private File bulletinFile = new File("bin/Project Data/Bulletin.txt");
	private Scanner bulletinInfoReader;

	private synchronized void getBulletin() {
		try {
			bulletinInfoReader = new Scanner(bulletinFile);
			bulletinList = new LinkedList<>();

			while (bulletinInfoReader.hasNext()) {
				Bulletin eachInfo = new Admin();
				@SuppressWarnings("unused")
				String s = bulletinInfoReader.nextLine();
				eachInfo.setInformation(bulletinInfoReader.nextLine());
				bulletinList.add(eachInfo);
			}// end while
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}// end try-catch
	}// end method

	public List<Bulletin> getBulletinInfo() {
		getBulletin();
		return bulletinList;
	}// end method

	// Below are codes for Project Interface:
	public void setProjectId(String id) {
		projectId = id;
	}// end method

	public String getProjectId() {
		return projectId;
	}// end method

	public void setProjectName(String name) {
		projectName = name;
	}// end method

	@Override
	public String getProjectName() {
		return projectName;
	}// end method

	@Override
	public void setProjectProgress(int progress) {
		projectProgress = progress;
	}// end method

	@Override
	public int getProjectProgress() {
		return projectProgress;
	}// end method

	@Override
	public void setProjectDueDate(int year, int month, int day) {
		projectDueDate = new GregorianCalendar(year, month, day);
	}// end method

	@Override
	public GregorianCalendar getProjectDueDate() {
		return projectDueDate;
	}// end method

	@Override
	public void setProjectCost(BigInteger cost) {
		projectCost = cost;
	}// end method

	@Override
	public BigInteger getProjectCost() {
		return projectCost;
	}// end method

	@Override
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}// end method

	@Override
	public String getInstructorName() {
		return instructorName;
	}// end method
	
	@Override
	public void setProjectStudentList(String stName){
		List<Student> everyStudent  = new ArrayList<>();
		peopleInfo = new PeopleInfo();
		everyStudent = peopleInfo.getStudentList();		
		projectStudentList = new ArrayList<>();
		String[] everyStudentName = stName.split("[,]");
		
		for(String eachName : everyStudentName){			
			for(Student eachStudent : everyStudent){				
				if(eachName.equals(eachStudent.getName())){					
					eachStudent.setName(eachName);
					projectStudentList.add(eachStudent);					
				}//end if
			}//end inner for
		}//end outter for	
	}//end method
	
	public List<Student> getProjectStudentList(){
		return projectStudentList;
	}//end method

	public void setProjectScore(int score) {
		projectScore = score;
	}// end method

	public int getProjectScore() {
		return projectScore;
	}// end method

	// This is the end of Project Interface.

	// Below are codes for Task Interface:
	@Override
	public void setTaskName(String name) {
		taskName = name;
	}// end method

	@Override
	public String getTaskName() {
		return taskName;
	}// end method

	public void setTaskProgress(String progress) {
		this.progress = progress;
	}// end method

	public String getTaskProgress() {
		return progress;
	}// end method

	@Override
	public void setEmergyLevel(int level) {
		emergyLevel = level;
	}// end method

	@Override
	public int getEmergyLevel() {
		return emergyLevel;
	}// end method

	@Override
	public void setTaskDueDate(GregorianCalendar date) {
		taskDueDate = date;
	}// end method

	@Override
	public GregorianCalendar getTaskDueDate() {
		return taskDueDate;
	}// end method

	@Override
	public void setTaskNote(String note) {
		taskNote = note;
	}// end method

	@Override
	public String getTaskNote() {
		return taskNote;
	}// end method

	@Override
	public boolean ableToModifyTask() {
		return false;
	}// end method

	public void setTaskEvaluate(String evaluateInfo) {
		evaluate = evaluateInfo;
	}

	public String getTaskEvaluate() {
		return evaluate;
	}

	// This is the end of Task Interface.

	// Below are codes for Bulletin Interface:
	@Override
	public void setInformation(String info) {
		information = info;
	}// end method

	@Override
	public String getInformation() {
		return information;
	}// end method

	@Override
	// Let the admin able to set information
	public boolean ableToSetInformation() {
		return true;
	}// end method
		// This is the end of Bulletin Interface.

	// This is the start of PublicProperty Interface:
	public void setIdentity(String identity) {
		this.identity = identity;
	}// end method

	public String getIdentity() {
		return identity;
	}// end method

	public void setName(String name) {
		this.name = name;
	}// end method

	public String getName() {
		return name;
	}// end method

	public void setEmail(String email) {
		emailAddress = email;
	}// end method

	public String getEmail() {
		return emailAddress;
	}// end method

	public void setCareer(String career) {
		careerNow = career;
	}// end method

	public String getCareer() {
		return careerNow;
	}// end method

	public void setPassword(String password) {
		this.password = password;
	}// end method

	public String getPassword() {
		return password;
	}// end method

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}// end method

	public String getHobby() {
		return this.hobby;
	}// end method

	public void setId(String id) {
		this.id = id;
	}// end method

	public String getId() {
		return id;
	}// end method

	public void setSalary(int salary) {
		this.salary = salary;
	}// end class

	public int getSalary() {
		return salary;
	}// end method

	public void setDateIn(GregorianCalendar dateIn) {
		dateComeIn = dateIn;
	}// end method

	public GregorianCalendar getDateIn() {
		return dateComeIn;
	}// end method

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}// end method

	public GregorianCalendar getBirthday() {
		return birthday;
	}// end method
		// This is the end of PublicProperty Interface.

	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}// end method

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}// end method

	@Override
	public int compareTo(Admin o) {
		if (getName().compareTo(o.getName()) > 0)
			return 1;
		else
			return -1;
	}// end method

}// end class
