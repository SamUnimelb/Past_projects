//Implemented by Sam, tested by Leon:
import java.util.GregorianCalendar;
import java.util.List;
//import java.util.List;

interface Course{
	//Name of the course:
	String getCourseName();
	void setCourseName(String courseName);
	String getCourseId();
	void setCourseId(String courseId);
	
	//Date info of the course:
	void setStartDate(GregorianCalendar startDate);
	GregorianCalendar getStartDate();
	void setEndDate(GregorianCalendar endDate);
	GregorianCalendar getEndDate();
	
	//Get/set CourseInfo:
	void setInstructorName(String instructorName);
	String getInstructorName();
	
	//Grade info:
	void setGrade(int score);
	int getGrade();	
	
	void setCredit(int credit);
	int getCredit();
	
	void setLadderGrade(String ladderGrade);
	String getLadderGrade();
	
	void setSirIIScore(int score);
	int getSirIIScore();

	//Thinking later may have more complicated ladder grades.
	
	//Set course Type
	void setCourseType(String courseType);
	String getCourseType();
	
	void setMeetTime(String meetDate);
	String getMeetTime();
	
	//Other information:
	void setCourseIntroduction(String courseInfo);
	String getCourseIntroduction();
	
	void setCourseStudentList(String studentInfo);
	List<Student> getCourseStudentList(); 
	
	boolean ableToCheckCourse();
	boolean ableToModifyCourse();	
	boolean ableToChallengeScore();
}//end interface
