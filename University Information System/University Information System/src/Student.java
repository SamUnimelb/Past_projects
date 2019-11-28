import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Student implements Course, PublicProperty, Comparable<Student> {
	// Data fields for Student class
	// Data fields for PublicProperty Interface:
	private String name;
	private String password;
	private String identity;
	private int salary;
	private String id;
	private GregorianCalendar dateComeIn;
	private GregorianCalendar birthday;
	private String hobby;
	private String emailAdd;
	private String careerInfo;

	// Data fields for Student class
	// Data fields for Course Interface:
	private String courseName;
	private String instructorName;
	private String courseType;
	private String meetTime;
	private int score = 0;
	private int credit = 0;
	private String ladderGrade;
	private String courseInfo;

	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private String courseId;

	private List<Student> courseStudentList;
	private PeopleInfo peopleInfo;

	// Assisting SirII:
	private int sirIIScore;

	public Student() {
		peopleInfo = new PeopleInfo();
	}// end constructor

	// This is the start of Course Interface:
	@Override
	public String getCourseName() {
		return courseName;
	}// end method

	@Override
	public void setCourseName(String name) {
		courseName = name;
	}// end method

	@Override
	public void setStartDate(GregorianCalendar date) {
		startDate = date;
	}// end method

	@Override
	public GregorianCalendar getStartDate() {
		return startDate;
	}// end method

	@Override
	public void setEndDate(GregorianCalendar date) {
		endDate = date;
	}// end method

	@Override
	public GregorianCalendar getEndDate() {
		return endDate;
	}// end method

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}// end method

	public String getCourseType() {
		return courseType;
	};// end method

	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}// end method

	public String getMeetTime() {
		return meetTime;
	}// end method

	public void setInstructorName(String insName) {
		instructorName = insName;
	}// end method

	@Override
	public String getInstructorName() {
		return instructorName;
	}// end method

	@Override
	public void setGrade(int score) {
		this.score = score;
	}// end method

	@Override
	public int getGrade() {
		return score;
	}// end method

	@Override
	public void setCredit(int credit) {
		this.credit = credit;
	}// end method

	@Override
	public int getCredit() {
		return credit;
	}// end method

	@Override
	public void setLadderGrade(String ladderGrade) {
		this.ladderGrade = ladderGrade;
	}// end method

	@Override
	public String getLadderGrade() {
		return ladderGrade;
	}// end method

	@Override
	public void setCourseIntroduction(String courseInfo) {
		this.courseInfo = courseInfo;
	}// end method

	@Override
	public String getCourseIntroduction() {
		return courseInfo;
	}// end method

	public void setCourseStudentList(String stInfo) {
		List<Student> everyStudent = new ArrayList<>();
		everyStudent = peopleInfo.getStudentList();
		courseStudentList = new ArrayList<>();
		String[] everyStudentName = stInfo.split("[,]");

		for (String eachEle : everyStudentName) {
			String eachName = eachEle.split("#")[0];
			String eachScore = eachEle.split("#")[1];
			sirIIScore = Integer.parseInt(eachEle.split("#")[2]);

			for (Student eachStudent : everyStudent) {
				if (eachName.equals(eachStudent.getName())) {
					eachStudent.setName(eachName);
					eachStudent.setLadderGrade(eachScore);
					eachStudent.setSirIIScore(sirIIScore);
					courseStudentList.add(eachStudent);
				}// end if
			}// end inner for
		}// end outter for
	}// end method

	public List<Student> getCourseStudentList() {
		return courseStudentList;
	}// end method

	@Override
	public boolean ableToCheckCourse() {
		return true;
	}// end method

	@Override
	public boolean ableToModifyCourse() {
		return false;
	}// end method

	@Override
	public boolean ableToChallengeScore() {
		return false;
	}// end method

	@Override
	public String getCourseId() {
		return courseId;
	}// end method

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}// end method: Student can't setCourseId
		// This is the end of Course Interface.

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

	public void setEmailAddress(String emailAddress) {
		emailAdd = emailAddress;
	};// end method

	public String getEmailAddress() {
		return emailAdd;
	}// end method

	public void setCareerInfo(String nextLine) {
		careerInfo = nextLine;
	}// end method

	public String getCareerInfo() {
		return careerInfo;
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
	public int compareTo(Student o) {
		if (getName().compareTo(o.getName()) > 0)
			return 1;
		else
			return -1;
	}// end method

	// Assisting SirII class
	public void setSirIIScore(int score) {
		sirIIScore = score;
	}// end method

	public int getSirIIScore() {
		return sirIIScore;
	}// end method
}// end class
