import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class GradingFrame {

	// background
	private JFrame gradingFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;

	// foreground
	private JTextField courseNameComboBox;
	private JTextField studentComboBox;
	private JTextField courseIDLabel;
	private JLabel instructorLabel;
	private JTextField ladderGradeField;
	private JTextField creditField;

	// Button
	private JButton submitButton;
	private JButton backButton;
	private JButton checkButton;
	private JButton challengeButton;
	private String username;
	private String password;
	private String identity;

	private int count = 0;
	private boolean isChallenging = false;

	// Below are used to rewrite CourseInfo:
	private File courseInfoFile = new File("bin/Project Data/Course Info.txt");
	private List<Course> courseInfo;

	private Scanner courseInfoReader;

	public GradingFrame(String username, String password, String identity) {
		// Initialize variable:
		this.username = username;
		this.password = password;
		this.identity = identity;

		courseInfo = new LinkedList<>();

		// Make JFrame
		gradingFrame = new JFrame();
		gradingFrame.setTitle("Grading");
		gradingFrame.setLocation(350, 100);
		gradingFrame.setSize(618, 540);
		gradingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the
																	// window
		gradingFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		gradingFrame.getContentPane().setLayout(null);

		// Setting Background
		// make ContentPane transparent
		imagePanel = (JPanel) gradingFrame.getContentPane();
		imagePanel.setOpaque(false);

		// set the background image
		backgroundLabel = new JLabel();
		backgroundImage = new ImageIcon("bin/Project Pictures/Grading.jpg");
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),
				backgroundImage.getIconHeight());

		// put the image to the bottom
		gradingFrame.getLayeredPane().add(backgroundLabel,
				new Integer(Integer.MIN_VALUE));

		// Make Components
		courseNameComboBox = new JTextField();
		courseNameComboBox.setFont(new Font("Times New Roman", 0, 15));
		courseNameComboBox.setForeground(new Color(23, 52, 72));
		courseNameComboBox.setBounds(220, 65, 130, 20);
		courseNameComboBox.setEnabled(true);

		studentComboBox = new JTextField();
		studentComboBox.setFont(new Font("Times New Roman", 0, 15));
		studentComboBox.setForeground(new Color(23, 52, 72));
		studentComboBox.setBounds(220, 250, 130, 20);
		studentComboBox.setEnabled(true);

		courseIDLabel = new JTextField();
		courseIDLabel.setFont(new Font("Times New Roman", 0, 20));
		courseIDLabel.setForeground(new Color(23, 52, 72));
		courseIDLabel.setBounds(220, 110, 130, 20);

		instructorLabel = new JLabel();
		if (identity.equals("Faculty")) {
			instructorLabel = new JLabel(username);
			instructorLabel.setFont(new Font("Times New Roman", 0, 20));
			instructorLabel.setForeground(new Color(23, 52, 72));
			instructorLabel.setBounds(240, 150, 350, 20);
		}// end if

		else if (identity.equals("Student")) {
			instructorLabel = new JLabel();
			instructorLabel.setFont(new Font("Times New Roman", 0, 20));
			instructorLabel.setForeground(new Color(23, 52, 72));
			instructorLabel.setBounds(240, 150, 350, 20);
		}// end else if

		ladderGradeField = new JTextField(10);
		ladderGradeField.setBounds(220, 340, 130, 20);
		if (identity.equals("Student"))
			ladderGradeField.setEditable(false);

		creditField = new JTextField(10);
		creditField.setBounds(220, 380, 130, 20);
		if (identity.equals("Faculty") || identity.equals("Student"))
			creditField.setEditable(false);

		// Button
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Times New Roman", 0, 15));
		submitButton.setForeground(new Color(23, 52, 72));
		submitButton.setBounds(430, 350, 90, 50);
		submitButton.addMouseListener(new MyMouseListener());
		if (identity.equals("Student"))
			submitButton.setEnabled(false);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Times New Roman", 0, 15));
		backButton.setForeground(new Color(23, 52, 72));
		backButton.setBounds(520, 465, 70, 30);
		backButton.addMouseListener(new MyMouseListener());

		challengeButton = new JButton("Challenge");
		challengeButton.setFont(new Font("Times New Roman", 0, 20));
		challengeButton.setForeground(new Color(23, 52, 72));
		challengeButton.setBounds(380, 225, 150, 50);
		challengeButton.addMouseListener(new MyMouseListener());
		if(identity.equals("Faculty"))
			challengeButton.setEnabled(false);

		checkButton = new JButton("Check");
		checkButton.setFont(new Font("Times New Roman", 0, 25));
		checkButton.setForeground(new Color(23, 52, 72));
		checkButton.setBounds(380, 115, 150, 50);
		checkButton.addMouseListener(new MyMouseListener());

		// Add components
		gradingFrame.add(courseNameComboBox);
		gradingFrame.add(studentComboBox);
		gradingFrame.add(courseIDLabel);
		gradingFrame.add(instructorLabel);
		// gradingFrame.add(gradeField);
		gradingFrame.add(ladderGradeField);
		gradingFrame.add(creditField);
		gradingFrame.add(submitButton);
		gradingFrame.add(backButton);
		gradingFrame.add(challengeButton);
		gradingFrame.add(checkButton);

		// set JFrame visible
		gradingFrame.setVisible(true);

	}// end constructor

	class MyMouseListener extends MouseAdapter {
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == submitButton) {
				writeModifiedGrade();
				JOptionPane.showMessageDialog(gradingFrame,
						"Grade successfully modified! ");
			}// end if

			else if (e.getSource() == backButton) {
				if (identity.equals("Faculty")) {
					@SuppressWarnings("unused")
					FacultyFrame ff = new FacultyFrame(username, password);
					gradingFrame.hide();
				}// end else if

				else if (identity.equals("Student")) {
					@SuppressWarnings("unused")
					StudentFrame ff = new StudentFrame(username, password);
					gradingFrame.hide();
				}// end inner else if
			}// end else if

			else if (e.getSource() == checkButton) {
				getCourseInfo();

				if (count == 0) {
					JOptionPane
							.showMessageDialog(
									gradingFrame,
									""
											+ "Professors: Input course name to check courses."
											+ "\n and press check to view the whole grades of a course."
											+ "\nStudents: Press enter your course name, id and your name"
											+ "\n, click check to check your own grades. "
											+ "\nPress challenge if you are not satisfied with the result.");
					count++;
				}//end if

				String gradeInfo = "";

				if (identity.equals("Faculty")) {
					for (Course eachCourse : courseInfo) {
						if (courseNameComboBox.getText().equals(
								eachCourse.getCourseName())) {
							for (Student eachStudent : eachCourse
									.getCourseStudentList()) {
								gradeInfo += eachStudent.getName() + " "
										+ eachStudent.getLadderGrade() + "\n";
							}// end inner-2 for
						}// end inner-2 if
					}// end inner-1 for

					JOptionPane.showMessageDialog(gradingFrame,
							"The grades are" + "showing below: \n" + gradeInfo);
				}// end if

				if (identity.equals("Student")) {
					for (Course eachCourse : courseInfo) {
						if (courseNameComboBox.getText().equals(
								eachCourse.getCourseName())) {
							for (Student eachStudent : eachCourse
									.getCourseStudentList()) {
								if (eachStudent.getName().equals(
										studentComboBox.getText())) {
									gradeInfo = "Student "
											+ eachStudent.getName() + " "
											+ " get "
											+ eachStudent.getLadderGrade()
											+ " in "
											+ eachCourse.getCourseName();
								}// end inner-3 if
							}// end inner-2 for
						}// end inner-2 if
					}// end inner-1 for

					JOptionPane.showMessageDialog(gradingFrame, gradeInfo
							+ "\nClick challenge if you are not satisfied!");
				}// end if
			}// end else if: Check score

			else if (e.getSource() == challengeButton) {

				if (identity.equals("Faculty")) {
					JOptionPane.showMessageDialog(gradingFrame,
							"This button is not for you!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}// end if
				JOptionPane.showMessageDialog(gradingFrame,
						"Challenge received!");
				isChallenging = true;
				writeModifiedGrade();
			}// end else if
		}// end method
	}// end inner class

	private void getCourseInfo() {

		courseInfo = new ArrayList<>();

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

				courseInfo.add(eachCourse);
			}// end for

			courseInfoReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}// end try-catch
	}// end method

	@SuppressWarnings("deprecation")
	private synchronized void writeModifiedGrade() {
		getCourseInfo();

		if (identity.equals("Faculty")) {
			out: for (Course eachCourse : courseInfo) {
				for (Student eachStudent : eachCourse.getCourseStudentList()) {

					if (courseNameComboBox.getText().equals(
							eachCourse.getCourseName())
							&& courseIDLabel.getText().equals(
									eachCourse.getCourseId())
							&& username.equals(eachCourse.getInstructorName())) {
						if (eachStudent.getName().equals(
								studentComboBox.getText())) {
							eachStudent.setLadderGrade(ladderGradeField
									.getText());
							JOptionPane.showMessageDialog(gradingFrame,
									"Change grade successful!");
							break out; // Use break to speed up.
						}// end inner if
					}// end if
				}// end inner for
			}// end for
		}// end outter if

		if (isChallenging == true) {
			out: for (Course eachCourse : courseInfo) {
				if (courseNameComboBox.getText().equals(
						eachCourse.getCourseName())
						&& courseIDLabel.getText().equals(
								eachCourse.getCourseId())) {
					for (Student eachStudent : eachCourse
							.getCourseStudentList()) {
						if (eachStudent.getName().equals(
								studentComboBox.getText())) {
							eachStudent.setLadderGrade(eachStudent
									.getLadderGrade() + "?");
							JOptionPane.showMessageDialog(gradingFrame,
									"Challenge grade successful!");
							break out; // Use break to speed up.
						}// end inner if
					}// end if
				}// end inner for
			}// end for

		}// end if: Adding challenge

		try {
			Formatter formatter = new Formatter(courseInfoFile);
			formatter.close();

			PrintWriter writer = new PrintWriter(courseInfoFile);
			writer.println();
			writer.println();

			for (Course eachCourse : courseInfo) {
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
				writer.println(eachCourse.getCredit() + " ");
				writer.print((eachCourse.getStartDate().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachCourse.getStartDate().getTime().getMonth() + 1)
						+ " ");
				writer.println(eachCourse.getStartDate().getTime().getDate()
						+ " ");
				writer.print((eachCourse.getEndDate().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachCourse.getEndDate().getTime().getMonth() + 1)
						+ " ");
				writer.print(eachCourse.getEndDate().getTime().getDate() + " ");
				writer.println();
				writer.println();
			}// end for

			writer.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}// end try-catch

	}// end method
}// end class