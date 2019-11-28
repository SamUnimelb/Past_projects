import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class StudentFrame {
		//background
		private JFrame studentFrame;
		private JPanel imagePanel;
		private JLabel backgroundLabel;
		private ImageIcon backgroundImage;
		
		//foreground
		private JLabel studentLabel;
		private TextArea bulletinLabel;
		private JButton scheduleButton;
		private JButton informationButton;
		private JButton projectButton;
		private JButton gradeButton;
		private JButton sirIIButton;
		private JButton quitButton;
		private JButton careerButton;
		
		private String studentName;
		private String studentPassword;
		
		//Implements Bulletin:
		private List<Bulletin> bulletinList;
		private Admin admin;

		public StudentFrame(String username, String password){
			
			studentName = username;
			studentPassword = password;
			
			//Create Frame:
			studentFrame = new JFrame();
			studentFrame.setTitle("Student");
			studentFrame.setLocation(350, 100);
			studentFrame.setSize(620, 545);
			studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			studentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			studentFrame.getContentPane().setLayout(null);
	        
			//Below are codes setting background:
			//make ContentPane transparent
			imagePanel = (JPanel) studentFrame.getContentPane();
	        imagePanel.setOpaque(false);
			
	        //set the background image
	        backgroundLabel = new JLabel();
	        backgroundImage = new ImageIcon("bin/Project Pictures/Student Surface.jpg");
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
	        
	        //put the image to the bottom
	        studentFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));

	    //Below are codes making components:
			//Name
	        studentLabel = new JLabel(studentName);
	        studentLabel.setFont(new Font("Times New Roman",0,30));
	        studentLabel.setForeground(new Color(23,52,72));
	        studentLabel.setBounds(220, 25, 350, 30);
	        studentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			
	        //Bulletin
	        bulletinLabel = new TextArea("");
	        bulletinLabel.setFont(new Font("Times New Roman",0,20));
	        bulletinLabel.setForeground(new Color(23,52,72));
	        bulletinLabel.setBounds(55, 265, 500, 153);
	        bulletinLabel.setRows(5);
	        bulletinLabel.setEditable(false);
	        showBulletin();
	        
	        //Button
	        scheduleButton = new JButton("Schedule");
	        scheduleButton.setFont(new Font("Times New Roman",0,20));
	        scheduleButton.setForeground(new Color(23,52,72));
	        scheduleButton.setBounds(70, 30, 120, 50);
	        scheduleButton.addMouseListener(new MyMouseListener());
			
	        informationButton = new JButton("Information");
	        informationButton.setFont(new Font("Times New Roman",0,20));
	        informationButton.setForeground(new Color(23,52,72));
	        informationButton.setBounds(70, 100, 130, 50);
	        informationButton.addMouseListener(new MyMouseListener());
			
	        projectButton = new JButton("Project");
	        projectButton.setFont(new Font("Times New Roman",0,25));
	        projectButton.setForeground(new Color(23,52,72));
	        projectButton.setBounds(410, 80, 130, 50);
	        projectButton.addMouseListener(new MyMouseListener());
	        
	        gradeButton = new JButton("My Grades");
	        gradeButton.setFont(new Font("Times New Roman",0,18));
	        gradeButton.setForeground(new Color(23,52,72));
	        gradeButton.setBounds(230, 80, 130, 50);
	        gradeButton.addMouseListener(new MyMouseListener());
			
	        sirIIButton = new JButton("SirII");
	        sirIIButton.setFont(new Font("Times New Roman",0,22));
	        sirIIButton.setForeground(new Color(23,52,72));
	        sirIIButton.setBounds(400, 147, 140, 50);
	        sirIIButton.addMouseListener(new MyMouseListener());
			
	        quitButton = new JButton("Quit");
	        quitButton.setFont(new Font("Times New Roman",0,18));
	        quitButton.setForeground(new Color(23,52,72));
	        quitButton.setBounds(505, 465, 70, 30);
	        quitButton.addMouseListener(new MyMouseListener());

	        careerButton = new JButton("Career Plan");
	        careerButton.setFont(new Font("Times New Roman",0,20));
	        careerButton.setForeground(new Color(23,52,72));
	        careerButton.setBounds(70, 170, 130, 50);
	        careerButton.addMouseListener(new MyMouseListener());

	        //Add components:
	        studentFrame.add(studentLabel);
	        studentFrame.add(bulletinLabel);
	        studentFrame.add(scheduleButton);
	        studentFrame.add(informationButton);
	        studentFrame.add(gradeButton);
	        studentFrame.add(projectButton);
	        studentFrame.add(careerButton);
	        studentFrame.add(sirIIButton);
	        studentFrame.add(quitButton);
				        
	        //set JFrame visible
	        studentFrame.setVisible(true);
	        
		}//end constructor
		
		class MyMouseListener extends MouseAdapter{
			
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e){
				
				if(e.getSource() == scheduleButton){
					@SuppressWarnings("unused")
					ScheduleFrame infoFrame = new ScheduleFrame
						(studentName, studentPassword, "Student");
				}//end if
				
				else if (e.getSource() == informationButton){
					@SuppressWarnings("unused")
					InfoFrame infoFrame = new InfoFrame(studentName, 
							studentPassword, "Student");
					studentFrame.hide();
				}//end else if
				
				else if (e.getSource() == projectButton){
					@SuppressWarnings("unused")
					ProjectFrame pf = new ProjectFrame
							(studentName, studentPassword, "Student");
				}
				else if (e.getSource() == sirIIButton){
					@SuppressWarnings("unused")
					SirIIFrame pf = new SirIIFrame
							(studentName, studentPassword, "Student");
				}//end else if
				
				else if (e.getSource() == quitButton){
					studentFrame.hide();
					@SuppressWarnings("unused")
					LoginFrame login = new LoginFrame();
				}//end else if
				
				else if(e.getSource() == gradeButton){
					@SuppressWarnings("unused")
					GradingFrame gf = new GradingFrame
							(studentName, studentPassword, "Student");
					studentFrame.hide();
				}//end else if
				
				else if(e.getSource() == careerButton){
					@SuppressWarnings("unused")
					CareerFrame1 pf = new CareerFrame1
					(studentName, studentPassword,"Student");
					studentFrame.hide();
				}//end if

				studentFrame.hide();
			}//end method
		}//end inner class

		public void showBulletin(){
	        admin = new Admin();
			bulletinList = new ArrayList<>();
			bulletinList = admin.getBulletinInfo();
			
			String s = "";
			for(Bulletin eachInfo : bulletinList){
				s += eachInfo.getInformation() + "\n";
				s += "\n";
			}//end for		
			
			bulletinLabel.setText(s);
		}//end method
	
}//end class
