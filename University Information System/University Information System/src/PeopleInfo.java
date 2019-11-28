import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Speed of this class needs improving!
public class PeopleInfo {
	// Data fields for PeopleInfo:
	private List<Student> studentList;
	private List<Faculty> facultyList;
	private List<Admin> adminList;
	private List<HeadMaster> headMasterList;
	private File studentInfoFile = new File("bin/Project Data/Student Info.txt");
	private File facultyInfoFile = new File("bin/Project Data/Faculty Info.txt");
	private File adminInfoFile = new File("bin/Project Data/Admin Info.txt");
	private File headInfoFile = new File("bin/Project Data/Head Info.txt");
	private Scanner fileScanner;

	// private String identity;

	private synchronized void readStudentData() {
		studentList = new LinkedList<>();
		try {
			fileScanner = new Scanner(studentInfoFile);
			while (fileScanner.hasNext()) {
				@SuppressWarnings("unused")
				String s = fileScanner.nextLine();
				s = fileScanner.nextLine();
				Student studentInfo = new Student();
				studentInfo.setIdentity(fileScanner.nextLine());
				studentInfo.setName(fileScanner.nextLine());
				studentInfo.setPassword(fileScanner.nextLine());
				studentInfo.setHobby(fileScanner.nextLine());
				studentInfo.setId(fileScanner.nextLine());
				studentInfo.setEmailAddress(fileScanner.nextLine());
				studentInfo.setCareerInfo(fileScanner.nextLine());
				studentInfo.setSalary(fileScanner.nextInt());
				studentInfo.setDateIn(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt(), fileScanner
						.nextInt()));
				studentInfo.setBirthday(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt(), fileScanner
						.nextInt()));
				studentList.add(studentInfo);
			}// end while
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Can not find student info file!");
		}// end try-catch

	}// end method

	private synchronized void readFacultyData() {
		facultyList = new LinkedList<>();
		try {
			fileScanner = new Scanner(facultyInfoFile);
			while (fileScanner.hasNext()) {
				@SuppressWarnings("unused")
				String s = fileScanner.nextLine();
				s = fileScanner.nextLine();
				Faculty facultyInfo = new Faculty();
				facultyInfo.setIdentity(fileScanner.nextLine());
				facultyInfo.setName(fileScanner.nextLine());
				facultyInfo.setPassword(fileScanner.nextLine());
				facultyInfo.setHobby(fileScanner.nextLine());
				facultyInfo.setId(fileScanner.nextLine());
				facultyInfo.setEmailAddress(fileScanner.nextLine());
				facultyInfo.setOfficeHours(fileScanner.nextLine());
				facultyInfo.setOfficeLocation(fileScanner.nextLine());
				facultyInfo.setSalary(fileScanner.nextInt());
				facultyInfo.setDateIn(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt(), fileScanner
						.nextInt()));
				facultyInfo.setBirthday(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt(), fileScanner
						.nextInt()));

				facultyList.add(facultyInfo);
			}// end while
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Faculty file not found!");
		}// end try-catch
	}// end method

	private synchronized void readAdminData() {
		adminList = new LinkedList<>();
		try {
			fileScanner = new Scanner(adminInfoFile);
			while (fileScanner.hasNext()) {
				@SuppressWarnings("unused")
				String s = fileScanner.nextLine();
				s = fileScanner.nextLine();
				Admin adminInfo = new Admin();
				adminInfo.setIdentity(fileScanner.nextLine());
				adminInfo.setName(fileScanner.nextLine());
				adminInfo.setPassword(fileScanner.nextLine());
				adminInfo.setHobby(fileScanner.nextLine());
				adminInfo.setId(fileScanner.nextLine());
				adminInfo.setEmailAddress(fileScanner.nextLine());
				adminInfo.setSalary(fileScanner.nextInt());
				adminInfo.setDateIn(new GregorianCalendar(
						fileScanner.nextInt(), fileScanner.nextInt() - 1,
						fileScanner.nextInt()));
				adminInfo.setBirthday(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt() - 1, fileScanner
						.nextInt()));
				adminList.add(adminInfo);
			}// end while
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Admin File not found!");
		}// end try-catch
	}// end method

	private synchronized void readHeadData() {
		headMasterList = new LinkedList<>();

		try {
			fileScanner = new Scanner(headInfoFile);
			while (fileScanner.hasNext()) {
				@SuppressWarnings("unused")
				String s = fileScanner.nextLine();
				s = fileScanner.nextLine();
				HeadMaster headInfo = new HeadMaster();
				headInfo.setIdentity(fileScanner.nextLine());
				headInfo.setName(fileScanner.nextLine());
				headInfo.setPassword(fileScanner.nextLine());
				headInfo.setHobby(fileScanner.nextLine());
				headInfo.setId(fileScanner.nextLine());
				headInfo.setEmailAddress(fileScanner.nextLine());
				headInfo.setSalary(fileScanner.nextInt());
				headInfo.setDateIn(new GregorianCalendar(fileScanner.nextInt(),
						fileScanner.nextInt() - 1, fileScanner.nextInt()));
				headInfo.setBirthday(new GregorianCalendar(fileScanner
						.nextInt(), fileScanner.nextInt() - 1, fileScanner
						.nextInt()));
				headMasterList.add(headInfo);
			}// end while

		} catch (FileNotFoundException e) {
			System.out.println("Fatal mistake! Landing file" + " not found!");
		}// end try-catch
	}// end method

	public synchronized List<Student> getStudentList() {
		readStudentData();
		return studentList;
	}// end method

	public synchronized List<Faculty> getFacultyList() {
		readFacultyData();
		return facultyList;
	}// end method

	public synchronized List<Admin> getAdminList() {
		readAdminData();
		return adminList;
	}// end method

	public synchronized List<HeadMaster> getHeadMasterList() {
		readHeadData();
		return headMasterList;
	}// end method

}// end class
