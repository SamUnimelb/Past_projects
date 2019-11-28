import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class ScheduleFrame {
	//background
	private JFrame scheduleFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;	
	private JButton backButton;
	private String username;
	private String password;
	private String identity;
	private String courseInfo1 = "";
	private String courseInfo2 = "Web Programming\n";
	
	private File scheduleFile = new File
			("bin/Project Data/Course Schedule.txt");
	private Scanner scheduleScanner;
	
	public ScheduleFrame
		(String username, String password, String identity){
		this.username = username;
		this.password = password;
		this.identity = identity;
		
		//Make JFrame:
		scheduleFrame = new JFrame();
		scheduleFrame.setTitle("Schedule");
		scheduleFrame.setLocation(365, 115);
		scheduleFrame.setSize(625, 550);
		scheduleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
		scheduleFrame.getContentPane().setLayout(null);

		//Setting Background
		//make ContentPane transparent
		imagePanel = (JPanel) scheduleFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Schedule.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        scheduleFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman",0,15));
        backButton.setForeground(new Color(23,52,72));
        backButton.setBounds(520, 465, 70, 30);
        backButton.addMouseListener(new MyMouseListener());

        //Add components
        scheduleFrame.add(backButton);
 
        //set JFrame visible
        scheduleFrame.setVisible(true);
        
        getCourseInfo();
        JOptionPane.showMessageDialog(scheduleFrame, courseInfo1);
        JOptionPane.showMessageDialog(scheduleFrame, courseInfo2);

	}//end constructor
	
	class MyMouseListener extends MouseAdapter{
		@SuppressWarnings({ "unused", "deprecation" })
		public void mouseClicked(MouseEvent e){
			if(e.getSource() == backButton){
				if(identity.equals("Student")){
					StudentFrame ff = new StudentFrame(username, password);
					scheduleFrame.hide();
				}//end if
				
				else if(identity.equals("Faculty")){
					FacultyFrame ff = new FacultyFrame(username, password);
					scheduleFrame.hide();
				}//end else if
				
				else if(identity.equals("Head")){
					HeadFrame ff = new HeadFrame(username, password);
					scheduleFrame.hide();
				}//end else if
				
				else{
					AdminFrame ff = new AdminFrame(username, password);
					scheduleFrame.hide();
				}//end else
				
			}//end if
		}//end method
	}//end inner class
	
	private void getCourseInfo(){
		try{
			scheduleScanner = new Scanner(scheduleFile);

			while(scheduleScanner.hasNext()){
					String s = scheduleScanner.nextLine();						
					if(s.equals("Web Programming"))
						break;					
					courseInfo1 += s + "\n";	
			}//end while
			
			while(scheduleScanner.hasNext()){
				String s = scheduleScanner.nextLine();		
				courseInfo2 += s + "\n";	
			}//end while

		}catch(FileNotFoundException e){
			System.err.println("Fatal: Schedule file not found!");
		}//end try-catch
		
	}//end method
}//end class
