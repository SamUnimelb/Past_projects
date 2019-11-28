import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class StudentInfo {

	//Data fields for PeopleInfo:
	private List<Student> studentList;
	
	private File studentInfoFile = new File
			("bin/Project Data/Student Info3.txt");
	private Scanner studentInfoScanner;
	//private String identity;

	private synchronized void readStudentData(){
		studentList = new ArrayList<>();
		
		try{
			studentInfoScanner = new Scanner(studentInfoFile);
			while(studentInfoScanner.hasNext()){	
				@SuppressWarnings("unused")
				String s = studentInfoScanner .nextLine();
				s = studentInfoScanner .nextLine();				
				Student studentInfo = new Student();
				studentInfo.setIdentity(studentInfoScanner .nextLine());
				studentInfo.setName(studentInfoScanner .nextLine());
				studentInfo.setPassword(studentInfoScanner .nextLine());
				studentInfo.setHobby(studentInfoScanner .nextLine());
				studentInfo.setId(studentInfoScanner .nextLine());
				studentInfo.setEmailAddress(studentInfoScanner .nextLine());
				studentInfo.setCareerInfo(studentInfoScanner .nextLine());
				studentInfo.setSalary(studentInfoScanner .nextInt());
				studentInfo.setDateIn(new GregorianCalendar
			(studentInfoScanner .nextInt(), studentInfoScanner .nextInt(), 
					studentInfoScanner .nextInt()));
				studentInfo.setBirthday(new GregorianCalendar
						(studentInfoScanner .nextInt(), studentInfoScanner .nextInt(), 
								studentInfoScanner .nextInt()));
				studentList.add(studentInfo);
				}//end while		
			studentInfoScanner.close();			
		}catch(FileNotFoundException e){
			System.out.println("Fatal mistake! Landing file"
					+ " not found!");
		}//end try-catch		
	}//end method

	@SuppressWarnings({ "deprecation", "unused" })
	private synchronized void writeModifiedStudentInfo(){
		
   	 try {
   		 Formatter formatter = new Formatter(studentInfoFile);
       	 formatter.close();
			
			PrintWriter writer = new PrintWriter(studentInfoFile);
			
			writer.println();
			writer.println();
			
			for(Student eachStudent : studentList){
				writer.println(eachStudent.getIdentity());
				writer.println(eachStudent.getName());
				writer.println(eachStudent.getPassword());
				writer.println(eachStudent.getHobby());
				writer.println(eachStudent.getId());
				writer.println(eachStudent.getEmailAddress());
				writer.println(eachStudent.getCareerInfo());
				writer.print(eachStudent.getSalary()+" ");
				writer.print((eachStudent.getDateIn().
						getTime().getYear() + 1900) + " ");
				writer.print((eachStudent.getDateIn().
						getTime().getMonth() + 1) + " ");
				writer.print(eachStudent.getDateIn().
						getTime().getDate()+" ");	
				writer.print((eachStudent.getBirthday().
						getTime().getYear() + 1900) + " ");
				writer.print((eachStudent.getBirthday().
						getTime().getMonth() + 1) + " ");
				writer.print(eachStudent.getBirthday().
						getTime().getDate());	
			
				writer.println();
				writer.println();
			}//end for

			writer.close();

		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}//end try-catch
    }//end method
	
	public synchronized   List<Student> getStudentList(){
		readStudentData();
		return studentList;
	}//end method

}//end class