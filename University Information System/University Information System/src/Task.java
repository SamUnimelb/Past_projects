//Implemented by Sam, tested by Vincent:
import java.util.GregorianCalendar;

interface Task {
	void setTaskName(String taskName);
	String getTaskName();
	
	void setEmergyLevel(int emergyLevel);
	int getEmergyLevel();
	
	void setTaskDueDate(GregorianCalendar date);
	GregorianCalendar getTaskDueDate();
	
	void setTaskNote(String note);
	String getTaskNote();
	
	void setTaskProgress(String progress);
	String getTaskProgress();
	
	void setTaskEvaluate(String evaluateInfo);
	String getTaskEvaluate();
	
	boolean ableToModifyTask();	
	
}//end interface
