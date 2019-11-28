import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LoginFrame {

	// Background:
	private JFrame loginFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;

	// Foreground:
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JRadioButton studentButton;
	private JRadioButton facultyButton;
	private JRadioButton headButton;
	private JRadioButton adminButton;
	private ButtonGroup identityGroup;
	private JButton loginButton;
	private JButton cleanButton;
	private JButton quitButton;

	// For checking usage:
	private List<Student> studentList;
	private List<Faculty> facultyList;
	private List<Admin> adminList;
	private List<HeadMaster> headMasterList;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LoginFrame loginFrame = new LoginFrame();
	}// end main

	public LoginFrame() {
		// Adding JFrame:
		loginFrame = new JFrame();
		loginFrame.setTitle("University Information System");
		loginFrame.setLocation(350, 100);
		loginFrame.setSize(600, 520);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the
																	// window
		loginFrame.getContentPane().setLayout(null);

		/*
		 * Adding background and make ContentPane transparent:
		 */
		imagePanel = (JPanel) loginFrame.getContentPane();
		imagePanel.setOpaque(false);

		// set the background image
		backgroundLabel = new JLabel();
		backgroundImage = new ImageIcon(
				"bin/Project Pictures/Login Surface.jpg");
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),
				backgroundImage.getIconHeight());

		// put the image to the bottom
		loginFrame.getLayeredPane().add(backgroundLabel,
				new Integer(Integer.MIN_VALUE));

		// Make Components:
		// Name and password
		nameLabel = new JLabel("User name: ");
		nameLabel.setFont(new Font("Bell MT", 0, 20));
		nameLabel.setBounds(65, 50, 135, 30);

		passwordLabel = new JLabel("Passward: ");
		passwordLabel.setFont(new Font("Bell MT", 0, 20));
		passwordLabel.setBounds(65, 85, 135, 30);

		nameField = new JTextField();
		nameField.setBounds(200, 50, 150, 30);

		passwordField = new JPasswordField();
		passwordField.setBounds(200, 85, 150, 30);

		// Identity
		studentButton = new JRadioButton("Student");
		studentButton.setFont(new Font("Bell MT", 0, 20));
		studentButton.setBounds(65, 150, 120, 30);
		studentButton.setSelected(true);

		facultyButton = new JRadioButton("Professor");
		facultyButton.setFont(new Font("Bell MT", 0, 20));
		facultyButton.setBounds(65, 200, 120, 30);

		headButton = new JRadioButton("Headmaster");
		headButton.setFont(new Font("Bell MT", 0, 20));
		headButton.setBounds(200, 150, 140, 30);

		adminButton = new JRadioButton("Administer");
		adminButton.setFont(new Font("Bell MT", 0, 20));
		adminButton.setBounds(200, 200, 140, 30);

		identityGroup = new ButtonGroup();
		identityGroup.add(studentButton);
		identityGroup.add(facultyButton);
		identityGroup.add(headButton);
		identityGroup.add(adminButton);

		// Button
		loginButton = new JButton("log in");
		loginButton.setFont(new Font("", 0, 15));
		loginButton.setBounds(55, 260, 100, 40);
		loginButton.addMouseListener(new MyMouseListener());

		cleanButton = new JButton("clean");
		cleanButton.setFont(new Font("", 0, 15));
		cleanButton.setBounds(170, 260, 100, 40);
		cleanButton.addMouseListener(new MyMouseListener());

		quitButton = new JButton("quit");
		quitButton.setFont(new Font("", 0, 15));
		quitButton.setBounds(285, 260, 100, 40);
		quitButton.addMouseListener(new MyMouseListener());

		// Add components:
		loginFrame.add(nameLabel);
		loginFrame.add(passwordLabel);
		loginFrame.add(nameField);
		loginFrame.add(passwordField);
		loginFrame.add(studentButton);
		loginFrame.add(facultyButton);
		loginFrame.add(headButton);
		loginFrame.add(adminButton);
		loginFrame.add(loginButton);
		loginFrame.add(cleanButton);
		loginFrame.add(quitButton);

		loginFrame.setVisible(true);
	}// end constructor

	class MyMouseListener extends MouseAdapter {

		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == cleanButton) {
				loginFrame.hide();
				@SuppressWarnings("unused")
				LoginFrame landing = new LoginFrame();
			}// end if

			else if (e.getSource() == quitButton) {
				JOptionPane.showMessageDialog(loginFrame,
						"Quiting successfully!");
				System.exit(0);
			}// end else if

			else {
				// Means user input right Information:
				checkIdentity();
				if (checkIdentity() == true) {
					if (studentButton.isSelected()) {
						/*
						 * Pass the student's name together with password to the
						 * class that needs it to do further operation.
						 */
						@SuppressWarnings("unused")
						StudentFrame sf = new StudentFrame(nameField.getText(),
								passwordField.getText());
						loginFrame.hide();
					}// end inner if

					else if (facultyButton.isSelected()) {
						@SuppressWarnings("unused")
						FacultyFrame ff = new FacultyFrame(nameField.getText(),
								passwordField.getText());
						loginFrame.hide();
					}// end inner else if

					else if (adminButton.isSelected()) {
						@SuppressWarnings("unused")
						AdminFrame ff = new AdminFrame(nameField.getText(),
								passwordField.getText());
						loginFrame.hide();
					}// end inner else if

					else if (headButton.isSelected()) {
						@SuppressWarnings("unused")
						HeadFrame hf = new HeadFrame(nameField.getText(),
								passwordField.getText());
						loginFrame.hide();
					}// end else
				}// end if

				// Means user input wrong information:
				else {
					// Prompt user with wrong input information:
					System.out.println("Input wrong information!");
				}// end inner else
			}// end else

		}// end method

	}// end inner class

	class MyWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}// end method
	}// end inner class

	// If user press log-in, check user's identity:
	@SuppressWarnings("deprecation")
	public boolean checkIdentity() {
		PeopleInfo peopleInfo = new PeopleInfo();

		if (studentButton.isSelected()) {
			studentList = new ArrayList<>();
			studentList = peopleInfo.getStudentList();

			for (Student studentInfo : studentList) {
				if (studentInfo.getName().equals(nameField.getText())
						&& passwordField.getText().equals(
								studentInfo.getPassword()))
					return true;
			}// end for
			return false;
		}// end if

		else if (facultyButton.isSelected()) {
			facultyList = new ArrayList<>(peopleInfo.getFacultyList());

			for (Faculty facultyInfo : facultyList) {
				if (nameField.getText().equals(facultyInfo.getName())
						&& passwordField.getText().equals(
								facultyInfo.getPassword()))
					return true;
			}// end for
			return false;
		}// end else if

		else if (adminButton.isSelected()) {
			adminList = new ArrayList<>(peopleInfo.getAdminList());

			for (Admin adminInfo : adminList) {
				if (nameField.getText().equals(adminInfo.getName())
						&& passwordField.getText().equals(
								adminInfo.getPassword()))
					return true;
			}// end for*/
			return false;
		}// end else if

		else {
			headMasterList = new ArrayList<>(peopleInfo.getHeadMasterList());

			for (HeadMaster headMasterInfo : headMasterList) {
				if (nameField.getText().equals(headMasterInfo.getName())
						&& passwordField.getText().equals(
								headMasterInfo.getPassword()))
					return true;
			}// end for
			return false;
		}// end else
	}// end method

}// end class
