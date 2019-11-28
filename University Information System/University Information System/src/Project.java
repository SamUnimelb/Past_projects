//implemented by Sam, tested by Miner and Sam:
import java.util.List;
import java.math.BigInteger;
import java.util.GregorianCalendar;
//import java.util.List;

interface Project {
	void setProjectId(String id);
	String getProjectId();
	
	void setInstructorName(String instructorName);
	String getInstructorName();
	
	void setProjectStudentList(String studentNames);
	List<Student> getProjectStudentList();
	
	void setProjectName(String name);
	String getProjectName();
	
	void setProjectProgress(int progress);
	int getProjectProgress();
	
	void setProjectDueDate(int year, int month, int day);
	GregorianCalendar getProjectDueDate();
	
	void setProjectCost(BigInteger cost);
	BigInteger getProjectCost();	
	
	void setProjectScore(int score);
	int getProjectScore();
	
}//end interface
