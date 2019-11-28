import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.*;

public class ProjectFrame {

	//background
	private JFrame projectFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground
	private JTextField projectNameField;
	private JTextField progressField;
	private JTextField dueDateFieldY;
	private JTextField dueDateFieldM;
	private JTextField dueDateFieldD;
	private JTextField costField;
	private JTextField facultyTextField;
	private TextArea studentTextArea;
	
	//Button
	private JButton newButton;
	private JButton checkButton;
	private JButton backButton;
	private JButton changeButton;
	private JButton removeButton;
	
	// Data fields for Project Frame: 
	private File projectInfoFile = new File("bin/Project Data/Project Info.txt");
	private Scanner projectInfoReader;
	private Set<Project> projectList;
	private String username;
	private String password;
	private String identity;	

	public ProjectFrame
		(String username, String password, String identity){
		this.username = username;
		this.password = password;
		this.identity = identity;
		projectList = new HashSet<>();
		
		//Make JFrame
		projectFrame = new JFrame();
		projectFrame.setTitle("Project");
		projectFrame.setLocation(350, 100);
		projectFrame.setSize(618, 540);
		projectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		projectFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		projectFrame.getContentPane().setLayout(null);		
		
		//Setting Background
		//make ContentPane transparent
		imagePanel = (JPanel) projectFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Project.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        projectFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
		//Make Components
        projectNameField = new JTextField();
        projectNameField.setFont(new Font("Times New Roman",0,15));
        projectNameField.setForeground(new Color(23,52,72));
        projectNameField.setBounds(230, 60, 130, 20);
        projectNameField.setEnabled(true);
        
        progressField = new JTextField();
        progressField.setBounds(230, 100, 130, 20);
        progressField.setEnabled(true);
        if(identity.equals("Student") || identity.equals("Admin"))
        	progressField.setEditable(false);
		
		dueDateFieldY = new JTextField("Y");
		dueDateFieldY.setBounds(230, 140, 50, 20);
		dueDateFieldY.setEnabled(true);
	    if(identity.equals("Student") || identity.equals("Faculty"))
	    	dueDateFieldY.setEditable(false);
	    
		dueDateFieldM = new JTextField("M");
		dueDateFieldM.setBounds(290, 140, 30, 20);
		dueDateFieldM.setEnabled(true);
	    if(identity.equals("Student") || identity.equals("Faculty"))
	    	dueDateFieldM.setEditable(false);
		
		dueDateFieldD = new JTextField("D");
		dueDateFieldD.setBounds(330, 140, 30, 20);
		dueDateFieldD.setEnabled(true);
	    if(identity.equals("Student") || identity.equals("Faculty"))
	    	dueDateFieldD.setEditable(false);
	    
		costField = new JTextField(10);
		costField.setBounds(230, 177, 130, 20);
		costField.setEnabled(true);
		if(identity.equals("Student") || identity.equals("Faculty"))
			 costField.setEditable(false);			
		
		facultyTextField = new JTextField();
		facultyTextField.setFont(new Font("Times New Roman",0,20));
		facultyTextField.setBounds(230, 215, 160, 20);
		if(identity.equals("Student") || identity.equals("Faculty"))
			facultyTextField.setEditable(false);		
		
		studentTextArea = new TextArea();
		studentTextArea.setFont(new Font("Times New Roman",0,20));
		studentTextArea.setForeground(new Color(23,52,72));
		studentTextArea.setBounds(230, 280, 350, 70);
		if(identity.equals("Student") || identity.equals("Admin"))
			studentTextArea.setEditable(false);		
        
        //Button
		newButton = new JButton("Add");
        newButton.setFont(new Font("Times New Roman",0,15));
        newButton.setForeground(new Color(23,52,72));
        newButton.setBounds(370, 60, 90, 25);
        newButton.setEnabled(true);
        newButton.addMouseListener(new MyMouseListener());
        if(identity.equals("Student") || identity.equals("Faculty"))
        	newButton.setEnabled(false);
		
        checkButton = new JButton("Check");
        checkButton.setFont(new Font("Times New Roman",0,15));
        checkButton.setForeground(new Color(23,52,72));
        checkButton.setBounds(298, 385, 100, 40);
        checkButton.setEnabled(true);
        checkButton.addMouseListener(new MyMouseListener());
        
        changeButton = new JButton("Modify");
        changeButton.setFont(new Font("Times New Roman",0,15));
        changeButton.setForeground(new Color(23,52,72));
        changeButton.setBounds(298, 430, 100, 40);
        changeButton.addMouseListener(new MyMouseListener());
        changeButton.setEnabled(true);
        if(identity.equals("Student"))
        	changeButton.setEnabled(false);
        
        removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Times New Roman",0,15));
        removeButton.setForeground(new Color(23,52,72));
        removeButton.setBounds(405, 385, 100, 40);
        removeButton.addMouseListener(new MyMouseListener());
        removeButton.setEnabled(true);
        if(identity.equals("Student") || identity.equals("Faculty"))
        	removeButton.setEnabled(false);
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman",0,15));
        backButton.setForeground(new Color(23,52,72));
        backButton.setBounds(520, 465, 70, 30);
        backButton.addMouseListener(new MyMouseListener());

        //Add components
        projectFrame.add(projectNameField);
        projectFrame.add(progressField);
        projectFrame.add(dueDateFieldY);
        projectFrame.add(dueDateFieldM);
        projectFrame.add(dueDateFieldD);
        projectFrame.add(costField);
        projectFrame.add(facultyTextField);
        projectFrame.add(studentTextArea);
        projectFrame.add(newButton);
        projectFrame.add(changeButton);
        projectFrame.add(checkButton);
        projectFrame.add(backButton);
        projectFrame.add(removeButton);
	
        //set JFrame visible
        projectFrame.setVisible(true);
        
        JOptionPane.showMessageDialog(projectFrame, 
        		"The added student should be in the university!"
        		+ "\nAnd use comma to seprate each students,"
        		+ "\nStudent names also ends with comma:  ");
		
	}//end constructor
	
	class MyMouseListener extends MouseAdapter{
		
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e){			
			readProjectData();		
			
			if(e.getSource() ==  checkButton){
				for(Project eachProject : projectList){
					if(projectNameField.getText().equals
							(eachProject.getProjectName())){
				        progressField.setText(eachProject.getProjectProgress() + "");
				        dueDateFieldY.setText(
				        		(eachProject.getProjectDueDate().getTime().getYear()+1900) + "");
				        dueDateFieldM.setText(
				        		(eachProject.getProjectDueDate().getTime().getMonth()+1) + "");
				        dueDateFieldD.setText(
				        		eachProject.getProjectDueDate().getTime().getDate() + "");
				        facultyTextField.setText(eachProject.getInstructorName());
				        String studentInfo = "";
				        for(Student eachStudent : eachProject.getProjectStudentList()){
				        	studentInfo +=		eachStudent.getName() + ",";
				        	studentTextArea.setText(studentInfo);
				        }//end for
				        costField.setText(eachProject.getProjectCost() + "");
					}//end if
				}//end for
			}//end if: User want to check project information
			
			else if (e.getSource() == newButton){
				addNewProject();
				JOptionPane.showMessageDialog(projectFrame, 
						"Project Added!");
			}//end else if: User wants to add a project.
			
			else if(e.getSource() == changeButton){
				removeProject();
				addNewProject();
				JOptionPane.showMessageDialog(projectFrame, 
						"Project modified! ");
			}//end else if: User wants to change project information.
			
			else if(e.getSource() == removeButton){
				removeProject();
				JOptionPane.showMessageDialog(projectFrame, 
						"Project Removed!");
			}//end else if: User wants to remove the project.
			
			else if (e.getSource() == backButton){
				if(identity.equals("Student")){
					@SuppressWarnings("unused")
					StudentFrame admin = new StudentFrame
							(username, password);
					projectFrame.hide();
				}//end inner if
				
				else if(identity.equals("Faculty")){
					@SuppressWarnings("unused")
					FacultyFrame admin = new FacultyFrame
							(username, password);
					projectFrame.hide();
				}//end inner if
				
				else if(identity.equals("Head")){
					@SuppressWarnings("unused")
					HeadFrame admin = new HeadFrame
							(username, password);
					projectFrame.hide();
				}//end inner if
				
				else{
					@SuppressWarnings("unused")
					AdminFrame admin = new AdminFrame
							(username, password);
					projectFrame.hide();
				}//end inner else				
			}//end else if: User wants to go back.
			
		}//end method
	}//end inner class
	
	private synchronized void removeProject(){
		out: for(Project eachProject : projectList){
			if(projectNameField.getText().equals(eachProject.getProjectName())){
				projectList.remove(eachProject);
				break out;
			}//end if			
		}//end for
		 writeModifiedProjectData();
	}//end method
	
	private synchronized void addNewProject(){
		Project newProject = new Admin();
		newProject.setProjectId("prj00" + projectList.size());
		newProject.setProjectName(projectNameField.getText());
		newProject.setInstructorName(facultyTextField.getText());
		newProject.setProjectStudentList(studentTextArea.getText());
		newProject.setProjectProgress(Integer.parseInt(
				progressField.getText()));
		//Should be modified:
		int year = Integer.parseInt(dueDateFieldY.getText());
		int month = Integer.parseInt(dueDateFieldM.getText());
		int date = Integer.parseInt(dueDateFieldD.getText());
		newProject.setProjectDueDate(year, month, date);
		newProject.setProjectCost(new BigInteger(costField.getText()));
		newProject.setProjectScore(20);
		projectList.add(newProject);
		writeModifiedProjectData();
	}//end method
	
	private synchronized void readProjectData() {
		projectList.clear();
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
	private synchronized void writeModifiedProjectData() {
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
			JOptionPane.showMessageDialog(projectFrame, "Writting message failed!");
		}// end try-catch
	}// end method
	
}//end class