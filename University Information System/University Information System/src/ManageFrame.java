import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

//Speed of this class needs improving!
public class ManageFrame {

	//background
	private JFrame manageFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground
	private JTextField nameField;
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private JTextField idField;
	private JTextField passwordField;
	private JTextField emailField;
	private JTextField identityField;
	
	//Button
	private JButton addButton;
	private JButton kickButton;
	private JButton clearButton;
	private JButton backButton;
	
	private String name;
	private String password;
	
	//Data fields used to manage people:
	private Set<Student> studentList;
	private Set<Faculty> facultyList;
	private Set<Admin> adminList;
	private Set<HeadMaster> headMasterList;
	private File studentInfoFile = new File
			("bin/Project Data/Student Info.txt");
	private File facultyInfoFile = new File
			("bin/Project Data/Faculty Info.txt");
	private File adminInfoFile = new File
			("bin/Project Data/Admin Info.txt");
	private File headInfoFile = new File
			("bin/Project Data/Head Info.txt");
	
	//Using Set together with HashSet to provide duplication.
	public ManageFrame(String username, String password){
	   	 PeopleInfo peopleInfo = new PeopleInfo();
	   	 studentList = new HashSet<>(peopleInfo.getStudentList());
	   	 facultyList = new HashSet<>(peopleInfo.getFacultyList());
	   	 adminList = new HashSet<>(peopleInfo.getAdminList());
	   	 headMasterList = new HashSet<>(peopleInfo.getHeadMasterList());

		name = username;
		this.password = password;
		//Make JFrame
		manageFrame = new JFrame();
		manageFrame.setTitle("Manage");
		manageFrame.setLocation(350, 100);
		manageFrame.setSize(618, 540);
		manageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manageFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		manageFrame.getContentPane().setLayout(null);
		
		//Setting Background
		//make ContentPane transparent
		imagePanel = (JPanel) manageFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Manage.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        manageFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
        //Make Components
        nameField = new JTextField(10);
        nameField.setBounds(200, 77, 125, 20);
        nameField.setText("");
        nameField.setEnabled(true);
		
        yearField = new JTextField(5);
        yearField.setBounds(200, 110, 55, 20);
        yearField.setText("");
        yearField.setEnabled(true);
		
        monthField = new JTextField(5);
        monthField.setBounds(270, 110, 55, 20);
        monthField.setText("");
        monthField.setEnabled(true);
        
        dayField = new JTextField(5);
        dayField.setBounds(345, 110, 55, 20);
        dayField.setText("");
        dayField.setEnabled(true);
		
        idField = new JTextField(10);
        idField.setBounds(200, 295, 125, 20);
        idField.setText("");
        idField.setEnabled(true);
        
        passwordField = new JTextField(10);
        passwordField.setBounds(200, 325, 125, 20);
        passwordField.setText("");
        passwordField.setEnabled(true);
        
        emailField = new JTextField(10);
        emailField.setBounds(200, 355, 125, 20);
        emailField.setText("");
        emailField.setEnabled(true);
        
        identityField = new JTextField(10);
        identityField.setBounds(200, 185, 125, 20);
        identityField.setText("");
        identityField.setEnabled(true);
        
        //Button
        kickButton = new JButton("Kick");
        kickButton.setFont(new Font("Times New Roman",0,15));
        kickButton.setForeground(new Color(23,52,72));
        kickButton.setBounds(420, 250, 100, 40);
        kickButton.setEnabled(true);
        kickButton.addMouseListener(new MyMouseListener());
        
        addButton = new JButton("Add");
        addButton.setFont(new Font("Times New Roman",0,15));
        addButton.setForeground(new Color(23,52,72));
        addButton.setBounds(420, 375, 100, 40);
        addButton.setEnabled(true);
        addButton.addMouseListener(new MyMouseListener());
        
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Times New Roman",0,15));
        clearButton.setForeground(new Color(23,52,72));
        clearButton.setBounds(200, 430, 100, 40);
        clearButton.setEnabled(true);
        clearButton.addMouseListener(new MyMouseListener());
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman",0,15));
        backButton.setForeground(new Color(23,52,72));
        backButton.setBounds(520, 465, 70, 30);
        backButton.addMouseListener(new MyMouseListener());

        //Add components
        manageFrame.add(nameField);
        manageFrame.add(yearField);
        manageFrame.add(monthField);
        manageFrame.add(dayField);
        
        manageFrame.add(idField);
        manageFrame.add(passwordField);
        manageFrame.add(emailField);        
        manageFrame.add(identityField);
        
        manageFrame.add(addButton);
        manageFrame.add(kickButton);
        manageFrame.add(clearButton);
        manageFrame.add(backButton);
		
        //set JFrame visible
        manageFrame.setVisible(true);	
        
        JOptionPane.showMessageDialog(manageFrame, 
				"You should enter identity of that person "
				+ "\ntogether with name to remove that person. "
				+ "\nShould fill all the information to add a person.");
        
	}//end constructor

	class MyMouseListener extends MouseAdapter{
		
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e){
			
			if(e.getSource() == addButton){
				addPeople();
			}//end else if
			
			else if (e.getSource() == kickButton){				
				removePeople();
			}//end else if
			
			else if (e.getSource() == clearButton){				
				@SuppressWarnings("unused")
				ManageFrame mf = new ManageFrame
						(name, password);
				manageFrame.hide();
			}//end else if
			
			else if (e.getSource() == backButton){
				manageFrame.hide();
				@SuppressWarnings("unused")
				AdminFrame admin = new AdminFrame(name, password);
			}//end else if		
		}//end method		
	}//end inner class

	public synchronized void addPeople(){
   	 
		String identity =  identityField.getText();
		String name =  nameField.getText();
		String initialPassword = passwordField.getText();
		String hobby = "Unknown";
	   	String id = idField.getText();
	   	String email = emailField.getText();
	   	int salary = 0;
	   	
		   	try{
			   		int enterYear = Integer.parseInt(yearField.getText());
			   		int enterMonth = Integer.parseInt(monthField.getText());
			   		int enterDate = Integer.parseInt(dayField.getText());
		   	
			   	 if(identity.equals("Student")){
			   		 Student newStudent = new Student();
			   		 newStudent.setIdentity("Student");
			   		 newStudent.setName(name);
			   		 newStudent.setPassword(initialPassword);
			   		 newStudent.setHobby(hobby);
			   		 newStudent.setId(id);
			   		 newStudent.setEmailAddress(email);
			   		 newStudent.setCareerInfo("Unknown 2013 9 1");
			   		 newStudent.setSalary(salary);
			   		 newStudent.setDateIn(new GregorianCalendar
			   				 (enterYear, enterMonth, enterDate));
			   		 newStudent.setBirthday(new GregorianCalendar(2000, 1, 1));	   		 
			   		 studentList.add(newStudent);
			   	 }//end if
			   	 
			   	 else if(identity.equals("Faculty")){
			   		 Faculty newFaculty = new Faculty();
			   		 newFaculty.setIdentity("Faculty");
			   		 newFaculty.setName(name);
			   		 newFaculty.setPassword(initialPassword);
			   		 newFaculty.setHobby(hobby);
			   		 newFaculty.setId(id);
			   		 newFaculty.setEmailAddress(email);
			   		 newFaculty.setOfficeHours("Not specified");
			   		 newFaculty.setOfficeLocation("TBA");
			   		 newFaculty.setSalary(salary);
			   		 newFaculty.setDateIn(new GregorianCalendar
			   				 (enterYear, enterMonth, enterDate));
			   		 newFaculty.setBirthday(new GregorianCalendar(2000, 1, 1));	   		 
			   		 facultyList.add(newFaculty);	
			   	 }//end if
			   	 
			   	 else if(identity.equals("Admin")){
			   		 Admin newAdmin = new Admin();
			   		 newAdmin.setIdentity("Admin");
			   		 newAdmin.setName(name);
			   		 newAdmin.setPassword(initialPassword);
			   		 newAdmin.setHobby(hobby);
			   		 newAdmin.setId(id);
			   		 newAdmin.setEmailAddress(email);
			   		 newAdmin.setSalary(salary);
			   		 newAdmin.setDateIn(new GregorianCalendar
			   				 (enterYear, enterMonth, enterDate));
			   		 newAdmin.setBirthday(new GregorianCalendar(2000, 1, 1));	   		 
			   		 adminList.add(newAdmin);
		   	 }//end else if
			   	 
			   	else if(identity.equals("Head")){
			   		 HeadMaster newHead = new HeadMaster();
			   		 newHead.setIdentity("Head");
			   		 newHead.setName(name);
			   		 newHead.setPassword(initialPassword);
			   		 newHead.setHobby(hobby);
			   		 newHead.setId(id);
			   		 newHead.setEmailAddress(email);
			   		newHead.setSalary(salary);
			   		 newHead.setDateIn(new GregorianCalendar
			   				 (enterYear, enterMonth, enterDate));
			   		 newHead.setBirthday(new GregorianCalendar(2000, 1, 1));	   		 
			   		 headMasterList.add(newHead);
		  	 }//end else if

		   	 else{
		   		 //Prompt user with invalid information:
		   		 JOptionPane.showMessageDialog(null, "Invalid input"
		   				 , "Error Message", JOptionPane.ERROR_MESSAGE);
		   	 }//end else    	
			   	 
			 JOptionPane.showMessageDialog(manageFrame, 
					 "Get your requriement already!");
	   	 
	    }catch(NumberFormatException e){
		   		JOptionPane.showMessageDialog(manageFrame, 
		   				"Integers should be input int the year, month, date field. ");
		 }//end try-catch
	   	 
		   writeModifiedPeopleInfo(); 	 
    }//end method
	
	public synchronized void removePeople(){
	        String removedIdentity = identityField.getText();
	        String removingName = nameField.getText();
	        
	   	 	if(removedIdentity.equals("Student")){	   		 
		   		 for(Student eachStudent : studentList){
		   			 if(eachStudent.getName().equals(removingName)){
		   				 studentList.remove(eachStudent);
		   			 }//end inner if
		   		 }//end for
	   	 	}//end outter if
	   	 	
	   	 	else if(removedIdentity.equals("faculty")){	   		 
		   		 for(Faculty eachfaculty : facultyList){
		   			 if(eachfaculty.getName().equals(removingName)){
		   				 facultyList.remove(eachfaculty);
		   			 }//end inner if
		   		 }//end for
	   	 	}//end outter if
	   	 	
	   	 	else if(removedIdentity.equals("admin")){	   		 
		   		 for(Admin eachadmin : adminList){
		   			 if(eachadmin.getName().equals(removingName)){
		   				 adminList.remove(eachadmin);
		   			 }//end inner if
		   		 }//end for
	   	 	}//end outter if
	   	 	
	   	 if(removedIdentity.equals("headMaster")){	   		 
	   		 for(HeadMaster eachheadMaster : headMasterList){
	   			 if(eachheadMaster.getName().equals(removingName)){
	   				 headMasterList.remove(eachheadMaster);
	   			 }//end inner if
	   		 }//end for
   	 	}//end outter if
	 
	   	 writeModifiedPeopleInfo();

    }//end method

	 @SuppressWarnings("deprecation")
	private synchronized void writeModifiedPeopleInfo(){		
		try {   		 
			
				Formatter formatter = new Formatter(studentInfoFile);
		       	 formatter.close();			
		       	 PrintWriter writer = new PrintWriter(studentInfoFile);			
		       	 writer.println();
		       	 writer.println();
					
				for(Student eachStudent : studentList){
					writer.println("Student");
					writer.println(eachStudent.getName());
					writer.println(eachStudent.getPassword());
					writer.println(eachStudent.getHobby());
					writer.println(eachStudent.getId());
					writer.println(eachStudent.getEmailAddress());
					writer.println(eachStudent.getCareerInfo());
					writer.print(eachStudent.getSalary() + " ");
					writer.print((eachStudent.getDateIn().
							getTime().getYear() + 1900) + " ");
					writer.print(eachStudent.getDateIn().
							getTime().getMonth()+ " ");
					writer.print(eachStudent.getDateIn().
							getTime().getDate() + " ");	
					writer.print((eachStudent.getBirthday().
							getTime().getYear() + 1900) + " ");
					writer.print(eachStudent.getBirthday().
							getTime().getMonth() + " ");
					writer.print(eachStudent.getBirthday().
							getTime().getDate());
					writer.println();
					writer.println();
				}//end for	
				
				writer.close();
					
				formatter = new Formatter(facultyInfoFile);
		      	formatter.close();			
				writer = new PrintWriter(facultyInfoFile);			
				writer.println();
				writer.println();
					
				for(Faculty eachFaculty : facultyList){
					writer.println("Faculty");
					writer.println(eachFaculty.getName());
					writer.println(eachFaculty.getPassword());
					writer.println(eachFaculty.getHobby());
					writer.println(eachFaculty.getId());
					writer.println(eachFaculty.getEmailAddress());
					writer.println(eachFaculty.getOfficeHours());
					writer.println(eachFaculty.getOfficeLocation());
					writer.print(eachFaculty.getSalary() + " ");
					writer.print((eachFaculty.getDateIn().
							getTime().getYear() + 1900) + " ");
					writer.print(eachFaculty.getDateIn().
							getTime().getMonth() + " ");
					writer.print(eachFaculty.getDateIn().
							getTime().getDate() + " ");	
					writer.print((eachFaculty.getBirthday().
							getTime().getYear() + 1900) + " ");
					writer.print(eachFaculty.getBirthday().
							getTime().getMonth() + " ");
					writer.print(eachFaculty.getBirthday().
							getTime().getDate());
					writer.println();
					writer.println();
				}//end for		
				writer.close();
		
				formatter = new Formatter(adminInfoFile);
		      	formatter.close();			
				writer = new PrintWriter(adminInfoFile);			
				writer.println();
				writer.println();
					
				for(Admin eachAdmin : adminList){
					writer.println("Admin");
					writer.println(eachAdmin.getName());
					writer.println(eachAdmin.getPassword());
					writer.println(eachAdmin.getHobby());
					writer.println(eachAdmin.getId());
					writer.println(eachAdmin.getEmailAddress());
					writer.print(eachAdmin.getSalary() + " ");
					writer.print((eachAdmin.getDateIn().
							getTime().getYear() + 1900) + " ");
					writer.print((eachAdmin.getDateIn().
							getTime().getMonth() + 1 ) + " ");
					writer.print(eachAdmin.getDateIn().
							getTime().getDate() + " ");	
					writer.print((eachAdmin.getBirthday().
							getTime().getYear() + 1900) + " ");
					writer.print((eachAdmin.getBirthday().
							getTime().getMonth() + 1) + " ");
					writer.print(eachAdmin.getBirthday().
							getTime().getDate());
					writer.println();
					writer.println();
				}//end for		
				writer.close();
				
				formatter = new Formatter(headInfoFile);
		      	formatter.close();			
				writer = new PrintWriter(headInfoFile);			
				writer.println();
				writer.println();
					
				for(HeadMaster eachHead : headMasterList){
					writer.println("Head");
					writer.println(eachHead.getName());
					writer.println(eachHead.getPassword());
					writer.println(eachHead.getHobby());
					writer.println(eachHead.getId());
					writer.println(eachHead.getEmailAddress());
					writer.print(eachHead.getSalary() + " ");
					writer.print((eachHead.getDateIn().
							getTime().getYear() + 1900) + " ");
					writer.print((eachHead.getDateIn().
							getTime().getMonth() + 1 ) + " ");
					writer.print(eachHead.getDateIn().
							getTime().getDate() + " ");	
					writer.print((eachHead.getBirthday().
							getTime().getYear() + 1900) + " ");
					writer.print((eachHead.getBirthday().
							getTime().getMonth() + 1) + " ");
					writer.print(eachHead.getBirthday().
							getTime().getDate());
					writer.println();
					writer.println();
				}//end for	
				
				writer.close();				
				JOptionPane.showMessageDialog(manageFrame, "Modified successfully!");
			
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			}//end try-catch
    }//end method
    
}//end class
