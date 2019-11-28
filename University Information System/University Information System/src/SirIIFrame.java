import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SirIIFrame {

	// background
	private JFrame sirIIFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;

	// foreground
	private JTextField nameTextField;
	private JTextField courseNameTextField;
	private JTextField teachScoreTextField;
	private JTextField projectScoreTextField;
	private JButton submitButton;
	private JButton backButton;
	private JButton checkButton;
	private String username;
	private String identity;
	private String password;

	// Data fields for Sir-II Frame: private Scanner courseInfoReader;
	private File courseInfoFile = new File("bin/Project Data/Course Info.txt");
	private File projectInfoFile = new File("bin/Project Data/Project Info.txt");
	private Scanner courseInfoReader;
	private Scanner projectInfoReader;
	private List<Course> courseTaken;
	private List<Project> projectList;
	private List<Faculty> facultyList;
	private List<Admin> adminList;
	private PeopleInfo peopleInfo;
	private int sirIIScore = 0;

	public SirIIFrame(String userName, String password, String identity) {
		// Initialize variables:
		this.username = userName;
		this.identity = identity;
		this.password = password;
		courseTaken = new LinkedList<>();
		projectList = new LinkedList<>();
		facultyList = new LinkedList<>();
		adminList = new LinkedList<>();
		peopleInfo = new PeopleInfo();

		// JFrame
		sirIIFrame = new JFrame();
		sirIIFrame.setTitle("SirII");
		sirIIFrame.setLocation(350, 100);
		sirIIFrame.setSize(625, 550);
		sirIIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sirIIFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		sirIIFrame.getContentPane().setLayout(null);

		// Background
		// make ContentPane transparent
		imagePanel = (JPanel) sirIIFrame.getContentPane();
		imagePanel.setOpaque(false);

		// Set the background image
		backgroundLabel = new JLabel();
		backgroundImage = new ImageIcon("bin/Project Pictures/SirII.jpg");
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),
				backgroundImage.getIconHeight());

		// Put the image to the bottom
		sirIIFrame.getLayeredPane().add(backgroundLabel,
				new Integer(Integer.MIN_VALUE));

		courseNameTextField = new JTextField("Input course name here: ");
		courseNameTextField.setFont(new Font("Times New Roman", 0, 20));
		courseNameTextField.setForeground(new Color(23, 52, 72));
		courseNameTextField.setBounds(300, 100, 200, 25);
		courseNameTextField.setEnabled(true);

		// Make Components
		nameTextField = new JTextField("Input name of the porf here: ");
		nameTextField.setFont(new Font("Times New Roman", 0, 20));
		nameTextField.setForeground(new Color(23, 52, 72));
		nameTextField.setBounds(300, 150, 200, 25);
		nameTextField.setEnabled(true);
		if (identity.equals("Faculty")) {
			nameTextField.setText(username);
			nameTextField.setEditable(false);
		}// end if

		teachScoreTextField = new JTextField("");
		teachScoreTextField.setFont(new Font("Times New Roman", 0, 15));
		teachScoreTextField.setForeground(new Color(23, 52, 72));
		teachScoreTextField.setBounds(300, 205, 100, 25);
		teachScoreTextField.setEnabled(true);
		if (identity.equals("Admin") || identity.equals("Faculty"))
			teachScoreTextField.setEditable(false);

		projectScoreTextField = new JTextField("");
		projectScoreTextField.setFont(new Font("Times New Roman", 0, 15));
		projectScoreTextField.setForeground(new Color(23, 52, 72));
		projectScoreTextField.setBounds(300, 265, 100, 25);
		projectScoreTextField.setEnabled(true);
		if (identity.equals("Student") || identity.equals("Faculty"))
			projectScoreTextField.setEditable(false);

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Times New Roman", 0, 15));
		submitButton.setForeground(new Color(23, 52, 72));
		submitButton.setBounds(298, 328, 100, 40);
		submitButton.setEnabled(true);
		submitButton.addMouseListener(new MyMouseListener());

		backButton = new JButton("Back");
		backButton.setFont(new Font("Times New Roman", 0, 15));
		backButton.setForeground(new Color(23, 52, 72));
		backButton.setBounds(520, 465, 70, 30);
		backButton.addMouseListener(new MyMouseListener());
		
		checkButton = new JButton("Check");
		checkButton.setFont(new Font("Times New Roman", 0, 15));
		checkButton.setForeground(new Color(23, 52, 72));
		checkButton.setBounds(298, 375, 100, 40);
		checkButton.addMouseListener(new MyMouseListener());
		if(identity.equals("Faculty"))
			checkButton.setEnabled(false);

		// Add components
		sirIIFrame.add(courseNameTextField);
		sirIIFrame.add(nameTextField);
		sirIIFrame.add(teachScoreTextField);
		sirIIFrame.add(projectScoreTextField);
		sirIIFrame.add(submitButton);
		sirIIFrame.add(backButton);
		sirIIFrame.add(checkButton);

		// set JFrame visible
		sirIIFrame.setVisible(true);

		// Show hints:
		JOptionPane
				.showMessageDialog(
						sirIIFrame,
						"For students and administers, \n"
								+ "Click submit if you modified the result.\n"
								+ "Click check if you want to check your previous results."
								+ "For Faculty, enter corresponding information\n"
								+ "and click submit to check your score.");

		if (identity.equals("Admin")) {
			JOptionPane.showMessageDialog(sirIIFrame,
					"Enter project name in the course name column: ");
		}// end if
	}// end constructor

	class MyMouseListener extends MouseAdapter {

		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {

			if (e.getSource() == backButton) {
				if (identity.equals("Faculty")) {
					@SuppressWarnings("unused")
					FacultyFrame ff = new FacultyFrame(username, password);
				}// end inner if
				else if (identity.equals("Student")) {
					@SuppressWarnings("unused")
					StudentFrame ff = new StudentFrame(username, password);
				}// end else if
				else {
					@SuppressWarnings("unused")
					AdminFrame admin = new AdminFrame(username, password);
				}// end inner else
				sirIIFrame.hide();
			}// end if: backButton

			else if (e.getSource() == submitButton) {
				readStudentSirIIData();
				JOptionPane.showMessageDialog(sirIIFrame, "Get your response!");

				if (identity.equals("Student")) {
					outter: for (Course eachCourse : courseTaken) {
						if (courseNameTextField.getText().equals(
								eachCourse.getCourseName())) {
							for (Student eachStudent : eachCourse
									.getCourseStudentList()) {
								if (username.equals(eachStudent.getName())) {
									eachStudent.setSirIIScore(Integer
											.parseInt(teachScoreTextField
													.getText()));
									break outter;
								}// end if
							}// end inner for: Finding the student
						}// end inner if
					}// end for
					writeModifiedStudentSirII();
				}// if evaluator is a student

				// Still have bug here:
				else if (identity.equals("Faculty")) {
					facultyList = peopleInfo.getFacultyList();
					for (Faculty eachFaculty : facultyList) {
						if (username.equals(eachFaculty.getName())) {
							teachScoreTextField
									.setText(calculateSirIITeachScore() + "");
						}// end if
					}// end outter for: Find the course

					readProjectData();

					outter: for (Project eachProject : projectList) {
						if (username.equals(eachProject.getInstructorName())) {
							projectScoreTextField.setText(eachProject
									.getProjectScore() + "");
							break outter;
						}// end if
					}// Show project score

				}// end else if:User is faculty

				else {
					adminList = peopleInfo.getAdminList();
					readProjectData();
					outter: for (Admin eachAdmin : adminList) {
						if (eachAdmin.getName().equals(username)) {
							for (Project eachProject : projectList) {
								if (courseNameTextField.getText().equals(
										eachProject.getProjectName())) {
									eachProject.setProjectScore(Integer
											.parseInt(projectScoreTextField
													.getText()));
									break outter;
								}// end if
							}// end for: Find the corresponding project.
						}// end if: Find the admin
					}// end inner for: Finding the Admin
					writeModifiedProjectScore();
				}// end else: User is an admin.
			}// end else if: User click submit
			
			else if(e.getSource() == checkButton){
				 readStudentSirIIData();				 
				if(identity.equals("Student")){
					outter: for(Course eachCourse : courseTaken){
						if(courseNameTextField.getText().
								equals(eachCourse.getCourseName())){
							for(Student eachStudent : eachCourse.getCourseStudentList()){
								if(username.equals(eachStudent.getName())){
									teachScoreTextField.setText
										(eachStudent.getSirIIScore() + "");
									break outter;
								}//end if
							}//end for: find the student
						}//end inner if: Find the course
					}//end for: Finding the course
				}//end if
				
				else if(identity.equals("Admin")){
					readProjectData();
					outter: for(Project eachProject : projectList){
						if(courseNameTextField.getText().
								equals(eachProject.getProjectName())){
							projectScoreTextField.setText
								(eachProject.getProjectScore() + "");
							break outter;
						}//end inner if: Find the project
					}//end for: Finding the project
					
					readStudentSirIIData();					
					teachScoreTextField.setText(calculateSirIITeachScore() + "");
				}//end else if: User is Administer
			}//end else if: User click check
		}// end method

	}// end inner class

	private void readStudentSirIIData() {
		courseTaken = new ArrayList<>();
		try {
			courseInfoReader = new Scanner(courseInfoFile);

			while (courseInfoReader.hasNext()) {
				Course eachCourse = new Student();
				@SuppressWarnings("unused")
				String s = courseInfoReader.nextLine();
				s = courseInfoReader.nextLine();

				eachCourse.setCourseName(courseInfoReader.nextLine());
				eachCourse.setInstructorName(courseInfoReader.nextLine());
				eachCourse.setCourseType(courseInfoReader.nextLine());
				eachCourse.setMeetTime(courseInfoReader.nextLine());
				eachCourse.setCourseIntroduction(courseInfoReader.nextLine());
				eachCourse.setCourseStudentList(courseInfoReader.nextLine());
				eachCourse.setCourseId(courseInfoReader.nextLine());
				eachCourse.setCredit(courseInfoReader.nextInt());
				eachCourse.setStartDate(new GregorianCalendar(courseInfoReader
						.nextInt(), courseInfoReader.nextInt() - 1,
						courseInfoReader.nextInt()));
				eachCourse.setEndDate(new GregorianCalendar(courseInfoReader
						.nextInt(), courseInfoReader.nextInt() - 1,
						courseInfoReader.nextInt()));
				courseTaken.add(eachCourse);
			}// end for
			courseInfoReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}// end try-catch
	}// end method

	private int calculateSirIITeachScore() {

		while (courseNameTextField.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(sirIIFrame,
					"Please fill the course name!");
		}// end if

		int totalScore = 0;
		int studentNum = 0;
		for (Course eachCourse : courseTaken) {
			if (nameTextField.getText().equals(username)) {
				if (courseNameTextField.getText().equals(
						eachCourse.getCourseName())) {
					for (Student eachStudent : eachCourse
							.getCourseStudentList()) {
						totalScore += eachStudent.getSirIIScore();
						studentNum++;
					}// inner for: Adding up all the sirIIscore
				}// end inner if
			}// outter if: Ensure the prof is checking his or her own course.
			
			else if(identity.equals("Admin")){
				if (courseNameTextField.getText().equals(
						eachCourse.getCourseName())) {
					for (Student eachStudent : eachCourse
							.getCourseStudentList()) {
						totalScore += eachStudent.getSirIIScore();
						studentNum++;
					}// inner for: Adding up all the sirIIscore
				}// end inner if
			}//end else if
		}// end outter for

		sirIIScore = (int) (totalScore * 1.0 / studentNum);
		return sirIIScore;
	}// end method

	@SuppressWarnings("deprecation")
	private synchronized void writeModifiedStudentSirII() {
		try {
			Formatter formatter = new Formatter(courseInfoFile);
			formatter.close();

			PrintWriter writer = new PrintWriter(courseInfoFile);
			writer.println();
			writer.println();

			for (Course eachCourse : courseTaken) {
				writer.println(eachCourse.getCourseName());
				writer.println(eachCourse.getInstructorName());
				writer.println(eachCourse.getCourseType());
				writer.println(eachCourse.getMeetTime());
				writer.println(eachCourse.getCourseIntroduction());

				for (Student eachStudent : eachCourse.getCourseStudentList()) {
					writer.print(eachStudent.getName() + "#"
							+ eachStudent.getLadderGrade() + "#"
							+ eachStudent.getSirIIScore() + ",");
				}// end inner for

				writer.println();
				writer.println(eachCourse.getCourseId());
				writer.println(eachCourse.getCredit());
				writer.print((eachCourse.getStartDate().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachCourse.getStartDate().getTime().getMonth() + 1)
						+ " ");
				writer.println(eachCourse.getStartDate().getTime().getDate()
						+ " ");
				/*
				 * GregorianCalendar view December as month 0 for next year
				 */
				writer.print((eachCourse.getEndDate().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachCourse.getEndDate().getTime().getMonth() + 1)
						+ " ");
				writer.println(eachCourse.getEndDate().getTime().getDate()
						+ " ");
				writer.println();
			}// end outter for
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("Writting failed!");
		}// end try-catch
	}// end method

	private synchronized void readProjectData() {
		try {
			projectInfoReader = new Scanner(projectInfoFile);

			while (projectInfoReader.hasNext()) {
				Project eachProject = new Admin();
				@SuppressWarnings("unused")
				String s = projectInfoReader.nextLine();
				s = projectInfoReader.nextLine();
				eachProject.setProjectId(projectInfoReader.nextLine());
				eachProject.setProjectName(projectInfoReader.nextLine());
				eachProject.setInstructorName(projectInfoReader.nextLine());
				eachProject.setProjectStudentList(projectInfoReader.nextLine());
				eachProject.setProjectProgress(projectInfoReader.nextInt());
				eachProject.setProjectDueDate(projectInfoReader.nextInt(),
						projectInfoReader.nextInt() - 1,
						projectInfoReader.nextInt());
				eachProject.setProjectCost(projectInfoReader.nextBigInteger());
				eachProject.setProjectScore(projectInfoReader.nextInt());
				projectList.add(eachProject);
			}// end while

			projectInfoReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}// end try-catch

	}// end method

	@SuppressWarnings("deprecation")
	private synchronized void writeModifiedProjectScore() {

		try {

			Formatter formatter = new Formatter(projectInfoFile);
			formatter.close();

			PrintWriter writer = new PrintWriter(projectInfoFile);
			writer.println();
			writer.println();

			for (Project eachProject : projectList) {
				writer.println(eachProject.getProjectId());
				writer.println(eachProject.getProjectName());
				writer.println(eachProject.getInstructorName());

				for (Student eachStudent : eachProject.getProjectStudentList()) {
					writer.print(eachStudent.getName() + ",");
				}// end inner for

				writer.println();
				writer.print(eachProject.getProjectProgress() + " ");
				writer.print((eachProject.getProjectDueDate().getTime()
						.getYear() + 1900)
						+ " ");
				writer.print((eachProject.getProjectDueDate().getTime()
						.getMonth() + 1)
						+ " ");
				writer.print((eachProject.getProjectDueDate().getTime()
						.getDate()) + " ");
				writer.print(eachProject.getProjectCost() + " ");
				writer.println(eachProject.getProjectScore());
				writer.println();
			}// end for

			writer.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(sirIIFrame,
					"Writting message failed!");
		}// end try-catch

	}// end method

}// end class
