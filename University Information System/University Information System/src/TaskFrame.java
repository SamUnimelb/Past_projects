import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class TaskFrame {

	//background
	private JFrame taskFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground
	private JTextField taskNameField;
	private JTextField dueDateYField;
	private JTextField dueDateMField;
	private JTextField dueDateDField;
	private JTextField emergencyRateField;
	private TextArea noteTextArea;
	
	//Radio Button
	private JRadioButton goodButton;
	private JRadioButton badButton;
	private ButtonGroup evaluateGroup;
	
	//Button
	private JButton submitButton;
	private JButton finishButton;
	private JButton backButton;		
	private String username;
	private String password;
	private String identity;
	
	//Data field for TaskFrame:
	private int emergyLevel;
	private File taskInfo = new File("bin/Project Data"
			+ "/Task Info.txt");
	private Scanner taskInfoScanner;
	private List<Task> taskList;
	private int taskNum = 0;
	@SuppressWarnings("unused")
	private AdminFrame adminFrame;
	@SuppressWarnings("unused")
	private HeadFrame headFrame;
	
	@SuppressWarnings("deprecation")
	public TaskFrame(String username, String password,
			String identity){
		this.username = username;
		this.password = password;
		this.identity = identity;
		
		if(identity.equals("Head"))
			JOptionPane.showMessageDialog(taskFrame, 
				"Input emergency level in integer between(1-5), "
				+ "\nyou should fill in all the information: ");
		
		//JFrame
		taskFrame = new JFrame();
		taskFrame.setTitle("Task");
		taskFrame.setLocation(350, 100);
		taskFrame.setSize(618, 540);
		taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
		taskFrame.getContentPane().setLayout(null);
		taskFrame.addWindowListener(new MyWindowListener());
		//Background
		
		//make ContentPane transparent
		imagePanel = (JPanel) taskFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //Set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Task.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //Put the image to the bottom
        taskFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
		//Make Components
        taskNameField = new JTextField();
        taskNameField.setFont(new Font("Times New Roman",0,15));
        taskNameField.setForeground(new Color(23,52,72));
        taskNameField.setBounds(260, 75, 250, 25);
        taskNameField.setEnabled(true);
        
        if(identity.equals("Admin"))
        	taskNameField.setEditable(false);

        dueDateYField = new JTextField();
        dueDateYField.setFont(new Font("Times New Roman",0,15));
        dueDateYField.setForeground(new Color(23,52,72));
        dueDateYField.setBounds(260, 142, 40, 20);
        dueDateYField.setEnabled(true);
        
        dueDateMField = new JTextField();
        dueDateMField.setFont(new Font("Times New Roman",0,15));
        dueDateMField.setForeground(new Color(23,52,72));
        dueDateMField.setBounds(305, 142, 40, 20);
        dueDateMField.setEnabled(true);
        
        dueDateDField = new JTextField();
        dueDateDField.setFont(new Font("Times New Roman",0,15));
        dueDateDField.setForeground(new Color(23,52,72));
        dueDateDField.setBounds(350, 142, 40, 20);
        dueDateDField.setEnabled(true);

        emergencyRateField = new JTextField("");
        emergencyRateField.setFont(new Font("Times New Roman",0,15));
        emergencyRateField.setForeground(new Color(23,52,72));
        emergencyRateField.setBounds(260, 175, 100, 20);
  
        noteTextArea = new TextArea("Note of the task is written here: ");
        noteTextArea.setFont(new Font("Times New Roman",0,20));
        noteTextArea.setForeground(new Color(23,52,72));
        noteTextArea.setBounds(260, 245, 330, 70);
        noteTextArea.setEnabled(true);
        
        //Radio Button
        goodButton = new JRadioButton("Good");
        goodButton.setFont(new Font("Bell MT",0,20));
        goodButton.setBounds(260, 210, 90, 20);
        goodButton.setEnabled(true);
        
        badButton = new JRadioButton("Bad");
        badButton.setFont(new Font("Bell MT",0,20));
        badButton.setBounds(370, 210, 90, 20);
        badButton.setEnabled(true);
        
        evaluateGroup = new ButtonGroup();
        evaluateGroup.add(goodButton);
        evaluateGroup.add(badButton);
      
        submitButton = new JButton("Create Task");
        submitButton.setFont(new Font("Times New Roman",0,20));
        submitButton.setForeground(new Color(23,52,72));
        submitButton.setBounds(218, 350, 180, 40);
        submitButton.setEnabled(true);
        submitButton.addMouseListener(new MyMouseListener());
        if(identity.equals("Admin"))
        	submitButton.setEnabled(false);
        
        finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Times New Roman",0,20));
        finishButton.setForeground(new Color(23,52,72));
        finishButton.setBounds(425, 350, 100, 40);
        finishButton.setEnabled(true);
        finishButton.addMouseListener(new MyMouseListener());
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman",0,15));
        backButton.setForeground(new Color(23,52,72));
        backButton.setBounds(520, 465, 70, 30);
        backButton.addMouseListener(new MyMouseListener());		
		
        //Add components
        taskFrame.add(taskNameField);
        taskFrame.add(dueDateYField);
        taskFrame.add(dueDateMField);
        taskFrame.add(dueDateDField);
        taskFrame.add(emergencyRateField);
        taskFrame.add(noteTextArea);        
        taskFrame.add(goodButton);
        taskFrame.add(badButton);
        taskFrame.add(finishButton);
        taskFrame.add(submitButton);
        taskFrame.add(backButton);
        
        //set JFrame visible
        taskFrame.setVisible(true);
        
        taskList = new LinkedList<>();
        readTaskInfo();
        
        if(identity.equals("Admin")){
        	taskNameField.setEditable(false);
        	dueDateYField.setEditable(false);
        	dueDateMField.setEditable(false);
        	dueDateDField.setEditable(false);
        	emergencyRateField.setEditable(false);
        	noteTextArea.setEditable(false);
        }//end if
        
        taskNameField.setText(taskList.get(taskNum).getTaskName());
		dueDateYField.setText((taskList.get(taskNum).
				getTaskDueDate().getTime().getYear() + 1900) + "");
        dueDateMField.setText((taskList.get(taskNum).
				getTaskDueDate().getTime().getMonth() + 1) + "");
        dueDateDField.setText(taskList.get(taskNum).
				getTaskDueDate().getTime().getDate() + "");
        emergencyRateField.setText(taskList.get(taskNum).getEmergyLevel() + "");
        noteTextArea.setText(taskList.get(taskNum).getTaskNote());	
        taskList.get(0).setTaskProgress("Finished");		
	}//end constructor
	
	class MyMouseListener extends MouseAdapter{		

		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e){					
				
			//New Task created.
			if(e.getSource() == submitButton){
				JOptionPane.showMessageDialog(taskFrame, 
						"Requirement received!");
				addNewTask();
				modifyTaskInfo();
			}//end if
			
			else if (e.getSource() == finishButton){
				if(identity.equals("Head"))
					JOptionPane.showMessageDialog(taskFrame, 
							"Evaluate finished!");
				else{
					JOptionPane.showMessageDialog(taskFrame, 
							"Get your response!");
					taskNum ++;
					readNextTask();					
				}//end else			
				modifyTaskInfo();
			}//end else if

			else if (e.getSource() == backButton){
				if(identity.equals("Admin")){
					@SuppressWarnings("unused")
					AdminFrame admin = new AdminFrame
							(username, password);
					taskFrame.hide();
				}//end if
				
				else{
					@SuppressWarnings("unused")
					HeadFrame head = new HeadFrame
							(username, password);
					taskFrame.hide();
				}//end inner else if
			}//end else if: Back action	
			
		}//end method
		
	}//end inner class

	class MyWindowListener extends WindowAdapter{
		@SuppressWarnings("deprecation")
		public void windowClosing(WindowEvent e){
			if(identity.equals("Admin")){
				@SuppressWarnings("unused")
				AdminFrame admin = new AdminFrame(username, password);
				taskFrame.hide();
			}//end if
			else{
				@SuppressWarnings("unused")
				HeadFrame hf = new HeadFrame(username, password);
				taskFrame.hide();
			}//end else
		}//end method
	}//end class
	
	@SuppressWarnings("deprecation")
	private void readNextTask(){
		if(taskNum >= taskList.size()){
			JOptionPane.showMessageDialog(taskFrame, 
					"Congratulations! You finished all the tasks!");
			
			if(identity.equals("Admin"))
				adminFrame = new AdminFrame(username, password);
			else if(identity.equals("Head"))
				headFrame = new HeadFrame(username, password);
			
			taskFrame.hide();
			taskFrame.dispose();
		}//end if
		
		if(taskNum < taskList.size()){
			taskNameField.setText(taskList.get(taskNum).getTaskName());
			dueDateYField.setText((taskList.get(taskNum).
					getTaskDueDate().getTime().getYear() + 1900) + "");
	        dueDateMField.setText((taskList.get(taskNum).
					getTaskDueDate().getTime().getMonth() + 1)+ "");
	        dueDateDField.setText(taskList.get(taskNum).
					getTaskDueDate().getTime().getDate() + "");
	        emergencyRateField.setText(taskList.get(taskNum).getTaskEvaluate());
	        noteTextArea.setText(taskList.get(taskNum).getTaskNote());
	        
	        for(Task eachTask : taskList){
	        	if(eachTask.getTaskName().equals(taskNameField.getText()))
	        		eachTask.setTaskProgress("Finished");
	        }//end for
		}//Prevent indexOutOfBounds		
        
        modifyTaskInfo();
	}//end method	
	
	private synchronized void addNewTask(){
		emergyLevel = Integer.parseInt
				(emergencyRateField.getText());	
		
		Task newTask = new Admin();
		newTask.setTaskName(taskNameField.getText());
		newTask.setTaskNote(noteTextArea.getText());
		newTask.setTaskProgress("Unfinished");
		
		if(goodButton.isSelected())
			newTask.setTaskEvaluate("good");		
		else
			newTask.setTaskEvaluate("bad");	
		
		newTask.setEmergyLevel(emergyLevel);
		int year = Integer.parseInt(dueDateYField.getText());
		int month = Integer.parseInt(dueDateMField.getText());
		int date = Integer.parseInt(dueDateDField.getText());
		newTask.setTaskDueDate(new GregorianCalendar
				(year, month - 1, date));		
		taskList.add(newTask);
		
		modifyTaskInfo();
		JOptionPane.showMessageDialog(taskFrame, "Add new task"
				+ " successfully!");
	}//end method

	private synchronized void readTaskInfo(){
		try{
			taskInfoScanner = new Scanner(taskInfo);
		
			while(taskInfoScanner.hasNext()){
				Task eachTask = new Admin();
				//System.out.println(taskInfoScanner.nextLine());
				@SuppressWarnings("unused")
				String s = taskInfoScanner.nextLine();
				s = taskInfoScanner.nextLine();
				eachTask.setTaskName(taskInfoScanner.nextLine());
				eachTask.setTaskNote(taskInfoScanner.nextLine());
				eachTask.setTaskProgress(taskInfoScanner.nextLine());
				eachTask.setTaskEvaluate(taskInfoScanner.nextLine());
				eachTask.setEmergyLevel(taskInfoScanner.nextInt());
				eachTask.setTaskDueDate(new GregorianCalendar(
						taskInfoScanner.nextInt(), taskInfoScanner.nextInt() - 1,
						taskInfoScanner.nextInt()));
				taskList.add(eachTask);
			}//end for
			
		}catch(FileNotFoundException e){
			System.err.println("Reading error: Task file not found!");
		}//end try-catch
		
		taskInfoScanner.close();
	}//end method
	
	@SuppressWarnings("deprecation")
	private void modifyTaskInfo(){

		try{
			Formatter formatter = new Formatter(taskInfo);
			formatter.close();
			
			PrintWriter writer = new PrintWriter(taskInfo);
			writer.println();
			writer.println();
			for(Task eachTask :  taskList){
				writer.println(eachTask.getTaskName());
				writer.println(eachTask.getTaskNote());
				writer.println(eachTask.getTaskProgress());
				writer.println(eachTask.getTaskEvaluate());
				writer.println(eachTask.getEmergyLevel());
				writer.print((eachTask.getTaskDueDate().
						getTime().getYear() + 1900) + " ");
				writer.print((eachTask.getTaskDueDate().
						getTime().getMonth() + 1) + " ");
				writer.print(eachTask.getTaskDueDate().
						getTime().getDate() + " ");
				writer.println();
				writer.println();
			}//end for
			
			writer.close();
			
		}catch(FileNotFoundException e){
			System.err.println("File not found!");
		}//end try-catch
		
	}//end method	
	
}//end class
