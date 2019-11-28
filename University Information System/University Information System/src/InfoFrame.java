import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class InfoFrame {
	// background
	private JFrame infoFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;

	// foreground
	private JLabel studentLabel;
	private TextField usernameTextField;
	private TextField passwordTextField;
	// / private TextField idTextField;
	private TextField emailTextField;
	private TextField majorTextField;
	private TextField dateInYTextField;// date in year
	private TextField dateInMTextField;// date in month
	private TextField dateInDTextField;// date in day

	private TextField hobbyTextField;
	private TextField incomeTextField;

	// Button are used to set information:
	private JButton passwordButton;
	private JButton emailButton;
	private JButton backButton;

	// Label are used to show prompt:
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel idLabel;
	private JLabel emailLabel;
	private JLabel majorLabel;
	private JLabel birthdayLabel;

	private JLabel hobbyLabel;
	private JLabel incomeLabel;

	private String identity;
	private String name;
	private String password;
	private String newPassword;
	private String newEmailAddress;
	// private String email;

	private List<Student> studentList;
	private List<Faculty> facultyList;
	private List<Admin> adminList;
	private List<HeadMaster> headMasterList;
	private PeopleInfo peopleInfo;

	private File studentInfoFile = new File("bin/Project Data/Student Info.txt");
	private File facultyInfoFile = new File("bin/Project Data/Faculty Info.txt");
	private File adminInfoFile = new File("bin/Project Data/Admin Info.txt");
	private File headInfoFile = new File("bin/Project Data/Head Info.txt");

	public InfoFrame(String username, String password, String identity) {
		// Get the person's info:
		studentList = new LinkedList<>();
		facultyList = new LinkedList<>();
		adminList = new LinkedList<>();
		headMasterList = new LinkedList<>();
		peopleInfo = new PeopleInfo();
		studentList = peopleInfo.getStudentList();
		facultyList = peopleInfo.getFacultyList();
		adminList = peopleInfo.getAdminList();
		headMasterList = peopleInfo.getHeadMasterList();

		name = username;
		this.password = password;
		this.identity = identity;

		// Add labels:
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(90, 50, 120, 50);
		usernameLabel.setFont(new Font("Bell MT", 0, 20));

		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(90, 100, 120, 50);
		passwordLabel.setFont(new Font("Bell MT", 0, 20));

		idLabel = new JLabel("Id: ");
		idLabel.setBounds(90, 150, 120, 50);
		idLabel.setFont(new Font("Bell MT", 0, 20));

		emailLabel = new JLabel("E-mail: ");
		emailLabel.setBounds(90, 200, 120, 50);
		emailLabel.setFont(new Font("Bell MT", 0, 20));

		majorLabel = new JLabel("Major: ");
		majorLabel.setBounds(90, 250, 120, 50);
		majorLabel.setFont(new Font("Bell MT", 0, 20));

		birthdayLabel = new JLabel("Date in: ");
		birthdayLabel.setBounds(90, 300, 120, 50);
		birthdayLabel.setFont(new Font("Bell MT", 0, 20));

		hobbyLabel = new JLabel("Hobby: ");
		hobbyLabel.setBounds(90, 350, 120, 50);
		hobbyLabel.setFont(new Font("Bell MT", 0, 20));

		incomeLabel = new JLabel("Income: ");
		incomeLabel.setBounds(90, 400, 120, 50);
		incomeLabel.setFont(new Font("Bell MT", 0, 20));

		// JFrame
		infoFrame = new JFrame();
		infoFrame.setTitle("information ");
		infoFrame.setLocation(350, 100);
		infoFrame.setSize(615, 540);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		infoFrame.getContentPane().setLayout(null);

		// Background:
		// make ContentPane transparent
		imagePanel = (JPanel) infoFrame.getContentPane();
		imagePanel.setOpaque(false);

		// set the background image
		backgroundLabel = new JLabel();
		backgroundImage = new ImageIcon("bin/Project Pictures/student_Info.jpg");
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),
				backgroundImage.getIconHeight());

		// put the image to the bottom
		infoFrame.getLayeredPane().add(backgroundLabel,
				new Integer(Integer.MIN_VALUE));

		// Make components:
		// Name
		studentLabel = new JLabel();
		studentLabel.setFont(new Font("Times New Roman", 0, 30));
		studentLabel.setForeground(new Color(23, 52, 72));
		studentLabel.setBounds(70, 190, 120, 50);

		// UsernameTextField
		usernameTextField = new TextField(" ");
		usernameTextField.setFont(new Font("Times New Roman", 0, 20));
		usernameTextField.setForeground(new Color(23, 52, 72));
		usernameTextField.setBounds(200, 60, 200, 35);
		usernameTextField.setEditable(false);
		// passwordTextField
		passwordTextField = new TextField(" ");
		passwordTextField.setFont(new Font("Times New Roman", 0, 20));
		passwordTextField.setForeground(new Color(23, 52, 72));
		passwordTextField.setBounds(200, 110, 200, 35);
		passwordTextField.setEchoChar('*');
		passwordTextField.addMouseListener(new MyMouseListener());
		passwordTextField.setEditable(false);

		// EmailTextField
		emailTextField = new TextField(" ");
		emailTextField.setFont(new Font("Times New Roman", 0, 20));
		emailTextField.setForeground(new Color(23, 52, 72));
		emailTextField.setBounds(200, 210, 200, 35);

		// MajorTextField
		majorTextField = new TextField(" ");
		majorTextField.setFont(new Font("Times New Roman", 0, 20));
		majorTextField.setForeground(new Color(23, 52, 72));
		majorTextField.setBounds(200, 260, 200, 35);
		majorTextField.setEditable(false);

		dateInYTextField = new TextField(" ");
		dateInYTextField.setFont(new Font("Times New Roman", 0, 20));
		dateInYTextField.setForeground(new Color(23, 52, 72));
		dateInYTextField.setBounds(200, 310, 50, 35);

		dateInMTextField = new TextField(" ");
		dateInMTextField.setFont(new Font("Times New Roman", 0, 20));
		dateInMTextField.setForeground(new Color(23, 52, 72));
		dateInMTextField.setBounds(260, 310, 50, 35);

		dateInDTextField = new TextField(" ");
		dateInDTextField.setFont(new Font("Times New Roman", 0, 20));
		dateInDTextField.setForeground(new Color(23, 52, 72));
		dateInDTextField.setBounds(320, 310, 50, 35);

		hobbyTextField = new TextField(" ");
		hobbyTextField.setFont(new Font("Times New Roman", 0, 20));
		hobbyTextField.setForeground(new Color(23, 52, 72));
		hobbyTextField.setBounds(200, 360, 200, 35);

		incomeTextField = new TextField(" ");
		incomeTextField.setFont(new Font("Times New Roman", 0, 20));
		incomeTextField.setForeground(new Color(23, 52, 72));
		incomeTextField.setBounds(200, 410, 200, 35);
		// Button
		passwordButton = new JButton("Reset");
		passwordButton.setFont(new Font("Times New Roman", 0, 20));
		passwordButton.setForeground(new Color(23, 52, 72));
		passwordButton.setBounds(410, 100, 100, 50);
		passwordButton.addMouseListener(new MyMouseListener());

		emailButton = new JButton("Reset");
		emailButton.setFont(new Font("Times New Roman", 0, 20));
		emailButton.setForeground(new Color(23, 52, 72));
		emailButton.setBounds(410, 200, 100, 50);
		emailButton.addMouseListener(new MyMouseListener());

		backButton = new JButton("Go Back");
		backButton.setFont(new Font("Times New Roman", 0, 16));
		backButton.setForeground(new Color(23, 52, 72));
		backButton.setBounds(410, 465, 170, 30);
		backButton.addMouseListener(new MyMouseListener());

		// Add components:
		infoFrame.add(studentLabel);
		infoFrame.add(usernameTextField);
		infoFrame.add(passwordTextField);
		// infoFrame.add(idTextField);
		infoFrame.add(emailTextField);
		infoFrame.add(majorTextField);
		infoFrame.add(dateInYTextField);
		infoFrame.add(dateInMTextField);
		infoFrame.add(dateInDTextField);
		infoFrame.add(hobbyTextField);
		infoFrame.add(incomeTextField);

		// Add Label
		infoFrame.add(usernameLabel);
		infoFrame.add(passwordLabel);
		infoFrame.add(idLabel);
		infoFrame.add(emailLabel);
		infoFrame.add(majorLabel);
		infoFrame.add(birthdayLabel);
		infoFrame.add(hobbyLabel);
		infoFrame.add(incomeLabel);

		// Button:
		infoFrame.add(passwordButton);
		infoFrame.add(emailButton);
		infoFrame.add(backButton);

		infoFrame.setVisible(true);
	}// end constructor

	class MyMouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (e.getSource() == backButton) {
				backToCertainFrame();
			}// end if

			else if (e.getSource() == passwordTextField) {
				searchPeople();

				String userEntered = JOptionPane.showInputDialog(infoFrame,
						"Please input your former password: ");

				while (!userEntered.equals(password)) {
					JOptionPane.showMessageDialog(infoFrame,
							"You are enterning wrong password! Try again!",
							"Error information", JOptionPane.WARNING_MESSAGE);
					userEntered = JOptionPane.showInputDialog(infoFrame,
							"Please input your former password: ");
				}// end while

				JOptionPane
						.showMessageDialog(
								infoFrame,
								"You can change your password, \nif another silly"
										+ " box ask you to input password again,\nyou can just"
										+ " close it.");

				passwordTextField.setEditable(true);
			}// end else if

			else if (e.getSource() == passwordButton) {
				passwordTextField.setEditable(false);

				if (passwordTextField.getText().equals("")
						|| passwordTextField.getText().equals(" ")) {
					JOptionPane.showMessageDialog(infoFrame,
							"Password can't be empty!! Log off and try again!");
					System.exit(1);
				}// end if

				newPassword = passwordTextField.getText();
				setPersonPassword();
			}// end else if

			else if (e.getSource() == emailButton) {
				emailTextField.setEditable(false);

				if (emailTextField.getText().equals("")
						|| emailTextField.getText().equals(" ")) {
					JOptionPane.showMessageDialog(infoFrame,
							"Password can't be empty!! Log off and try again!");
					System.exit(1);
				}// end if

				newEmailAddress = emailTextField.getText();
				setPersonEmailAddress();
			}// end else if

		}// end method
	}// end class

	class MyWindowListener extends WindowAdapter {
		@SuppressWarnings("deprecation")
		public void windowClosing(WindowEvent e) {
			infoFrame.hide();
		}// end method
	}// end class

	private void searchPeople() {

		if (identity.equals("Student")) {
			for (Student student : studentList) {
				if (name.equals(student.getName())) {
					password = student.getPassword();
				}// end if
			}// end for
		}// end method

		else if (identity.equals("Faculty")) {
			for (Faculty faculty : facultyList) {
				if (name.equals(faculty.getName())) {
					password = faculty.getPassword();
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Admin")) {
			for (Admin admin : adminList) {
				if (name.equals(admin.getName())) {
					password = admin.getPassword();
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Head")) {
			for (HeadMaster head : headMasterList) {
				if (name.equals(head.getName())) {
					password = head.getPassword();
				}// end if
			}// end for
		}// end else if

	}// end method

	@SuppressWarnings("deprecation")
	private void backToCertainFrame() {
		if (identity.equals("Student")) {
			@SuppressWarnings("unused")
			StudentFrame sf = new StudentFrame(name, password);
		}// end method

		else if (identity.equals("Faculty")) {
			@SuppressWarnings("unused")
			FacultyFrame ff = new FacultyFrame(name, password);
		}// end else if

		else if (identity.equals("Admin")) {
			@SuppressWarnings("unused")
			AdminFrame af = new AdminFrame(name, password);
		}// end else if

		else if (identity.equals("Head")) {
			@SuppressWarnings("unused")
			HeadFrame hf = new HeadFrame(name, password);
		}// end else if

		infoFrame.hide();
	}// end method

	private void setPersonPassword() {

		// Having problem here!!
		if (identity.equals("Student")) {
			for (Student student : studentList) {
				if (name.equals(student.getName())) {
					student.setPassword(newPassword);
				}// end if
			}// end for
		}// end method

		else if (identity.equals("Faculty")) {
			for (Faculty faculty : facultyList) {
				if (name.equals(faculty.getName())) {
					faculty.setPassword(newPassword);
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Admin")) {
			for (Admin admin : adminList) {
				if (name.equals(admin.getName())) {
					admin.setPassword(newPassword);
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Head")) {
			for (HeadMaster head : headMasterList) {
				if (name.equals(head.getName())) {
					head.setPassword(newPassword);
				}// end if
			}// end for
		}// end else if

		writeModifiedPeopleInfo();

		JOptionPane.showMessageDialog(infoFrame, "Password successfully set!");
	}// end mthod

	private void setPersonEmailAddress() {

		// Having problem here!!
		if (identity.equals("Student")) {
			for (Student student : studentList) {
				if (name.equals(student.getName())) {
					student.setEmailAddress(newEmailAddress);
				}// end if
			}// end for
		}// end method

		else if (identity.equals("Faculty")) {
			for (Faculty faculty : facultyList) {
				if (name.equals(faculty.getName())) {
					faculty.setEmailAddress(newEmailAddress);
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Admin")) {
			for (Admin admin : adminList) {
				if (name.equals(admin.getName())) {
					admin.setEmailAddress(newEmailAddress);
				}// end if
			}// end for
		}// end else if

		else if (identity.equals("Head")) {
			for (HeadMaster head : headMasterList) {
				if (name.equals(head.getName())) {
					head.setEmailAddress(newEmailAddress);
				}// end if
			}// end for
		}// end else if

		writeModifiedPeopleInfo();

		JOptionPane.showMessageDialog(infoFrame,
				"EmailAddress successfully set!");
	}// end mthod

	@SuppressWarnings("deprecation")
	private synchronized void writeModifiedPeopleInfo() {
		try {
			Formatter formatter = new Formatter(studentInfoFile);
			formatter.close();
			PrintWriter writer = new PrintWriter(studentInfoFile);
			writer.println();
			writer.println();

			for (Student eachStudent : studentList) {
				writer.println("Student");
				writer.println(eachStudent.getName());
				writer.println(eachStudent.getPassword());
				writer.println(eachStudent.getHobby());
				writer.println(eachStudent.getId());
				writer.println(eachStudent.getEmailAddress());
				writer.println(eachStudent.getCareerInfo());
				writer.print(eachStudent.getSalary() + " ");
				writer.print((eachStudent.getDateIn().getTime().getYear() + 1900)
						+ " ");
				writer.print(eachStudent.getDateIn().getTime().getMonth() + " ");
				writer.print(eachStudent.getDateIn().getTime().getDate() + " ");
				writer.print((eachStudent.getBirthday().getTime().getYear() + 1900)
						+ " ");
				writer.print(eachStudent.getBirthday().getTime().getMonth()
						+ " ");
				writer.print(eachStudent.getBirthday().getTime().getDate());
				writer.println();
				writer.println();
			}// end for
			writer.close();

			formatter = new Formatter(facultyInfoFile);
			formatter.close();
			writer = new PrintWriter(facultyInfoFile);
			writer.println();
			writer.println();

			for (Faculty eachFaculty : facultyList) {
				writer.println("Faculty");
				writer.println(eachFaculty.getName());
				writer.println(eachFaculty.getPassword());
				writer.println(eachFaculty.getHobby());
				writer.println(eachFaculty.getId());
				writer.println(eachFaculty.getEmailAddress());
				writer.println(eachFaculty.getOfficeHours());
				writer.println(eachFaculty.getOfficeLocation());
				writer.print(eachFaculty.getSalary() + " ");
				writer.print((eachFaculty.getDateIn().getTime().getYear() + 1900)
						+ " ");
				writer.print(eachFaculty.getDateIn().getTime().getMonth() + " ");
				writer.print(eachFaculty.getDateIn().getTime().getDate() + " ");
				writer.print((eachFaculty.getBirthday().getTime().getYear() + 1900)
						+ " ");
				writer.print(eachFaculty.getBirthday().getTime().getMonth()
						+ " ");
				writer.print(eachFaculty.getBirthday().getTime().getDate());
				writer.println();
				writer.println();
			}// end for
			writer.close();

			formatter = new Formatter(adminInfoFile);
			formatter.close();
			writer = new PrintWriter(adminInfoFile);
			writer.println();
			writer.println();

			for (Admin eachAdmin : adminList) {
				writer.println("Admin");
				writer.println(eachAdmin.getName());
				writer.println(eachAdmin.getPassword());
				writer.println(eachAdmin.getHobby());
				writer.println(eachAdmin.getId());
				writer.println(eachAdmin.getEmailAddress());
				writer.print(eachAdmin.getSalary() + " ");
				writer.print((eachAdmin.getDateIn().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachAdmin.getDateIn().getTime().getMonth() + 1)
						+ " ");
				writer.print(eachAdmin.getDateIn().getTime().getDate() + " ");
				writer.print((eachAdmin.getBirthday().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachAdmin.getBirthday().getTime().getMonth() + 1)
						+ " ");
				writer.print(eachAdmin.getBirthday().getTime().getDate());
				writer.println();
				writer.println();
			}// end for
			writer.close();
			formatter = new Formatter(headInfoFile);
			formatter.close();
			writer = new PrintWriter(headInfoFile);
			writer.println();
			writer.println();

			for (HeadMaster eachHead : headMasterList) {
				writer.println("Head");
				writer.println(eachHead.getName());
				writer.println(eachHead.getPassword());
				writer.println(eachHead.getHobby());
				writer.println(eachHead.getId());
				writer.println(eachHead.getEmailAddress());
				writer.print(eachHead.getSalary() + " ");
				writer.print((eachHead.getDateIn().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachHead.getDateIn().getTime().getMonth() + 1)
						+ " ");
				writer.print(eachHead.getDateIn().getTime().getDate() + " ");
				writer.print((eachHead.getBirthday().getTime().getYear() + 1900)
						+ " ");
				writer.print((eachHead.getBirthday().getTime().getMonth() + 1)
						+ " ");
				writer.print(eachHead.getBirthday().getTime().getDate());
				writer.println();
				writer.println();
			}// end for
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}// end try-catch
	}// end method

}// end class

