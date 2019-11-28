import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;

public class FacultyFrame {

	//background
	private JFrame facultyFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground
	private JLabel facultyLabel;
	private TextArea bulletinLabel;
	private JButton scheduleButton;
	private JButton informationButton;
	private JButton projectButton;
	private JButton sirIIButton;
	private JButton gradingButton;
	private JButton quitButton;

	private String facultyName;
	private String facultyPassword;
	
	//Implements Bulletin:
	private List<Bulletin> bulletinList;
	private Admin admin;
		
	public static void main(String[] args) {		
		@SuppressWarnings("unused")
		FacultyFrame facultyFrame = new FacultyFrame("","");
	}//end main

	public FacultyFrame(String username, String password){
		
		facultyName = username;
		facultyPassword = password;
		
		//Make JFrame:
		facultyFrame = new JFrame();
		facultyFrame.setTitle("Faculty");
		facultyFrame.setLocation(350, 100);
		facultyFrame.setSize(620, 550);
		facultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
		facultyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		facultyFrame.getContentPane().setLayout(null);
		
		//Setting Background
		//make ContentPane transparent
		imagePanel = (JPanel) facultyFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Faculty.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        facultyFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
        
        //Make Components
		//Name
        facultyLabel = new JLabel(facultyName);
        facultyLabel.setFont(new Font("Times New Roman",0,30));
        facultyLabel.setForeground(new Color(23,52,72));
        facultyLabel.setBounds(220, 25, 350, 30);
        facultyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
        //Bulletin

		
        bulletinLabel = new TextArea("");
        bulletinLabel.setFont(new Font("Times New Roman",0,20));
        bulletinLabel.setForeground(new Color(23,52,72));
        bulletinLabel.setBounds(55, 264, 500, 153);
		bulletinLabel.setEditable(false);
		showBulletin();
		
        //Button
        scheduleButton = new JButton("Schedule");
        scheduleButton.setFont(new Font("Times New Roman",0,20));
        scheduleButton.setForeground(new Color(23,52,72));
        scheduleButton.setBounds(87, 80, 130, 50);
        scheduleButton.addMouseListener(new MyMouseListener());
		
        informationButton = new JButton("Information");
        informationButton.setFont(new Font("Times New Roman",0,20));
        informationButton.setForeground(new Color(23,52,72));
        informationButton.setBounds(87, 150, 130, 50);
        informationButton.addMouseListener(new MyMouseListener());
		
        projectButton = new JButton("Project");
        projectButton.setFont(new Font("Times New Roman",0,20));
        projectButton.setForeground(new Color(23,52,72));
        projectButton.setBounds(390, 80, 130, 50);
        projectButton.addMouseListener(new MyMouseListener());
		
        sirIIButton = new JButton("SirII");
        sirIIButton.setFont(new Font("Times New Roman",0,20));
        sirIIButton.setForeground(new Color(23,52,72));
        sirIIButton.setBounds(390, 150, 130, 50);
        sirIIButton.addMouseListener(new MyMouseListener());
		
        gradingButton = new JButton("Grading");
        gradingButton.setFont(new Font("Times New Roman",0,20));
        gradingButton.setForeground(new Color(23,52,72));
        gradingButton.setBounds(235, 130, 140, 50);
        gradingButton.addMouseListener(new MyMouseListener());
        
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Times New Roman",0,15));
        quitButton.setForeground(new Color(23,52,72));
        quitButton.setBounds(520, 465, 70, 30);
		quitButton.addMouseListener(new MyMouseListener());

        //Add components
        facultyFrame.add(facultyLabel);
        facultyFrame.add(bulletinLabel);
        facultyFrame.add(scheduleButton);
        facultyFrame.add(informationButton);
        facultyFrame.add(projectButton);
        facultyFrame.add(sirIIButton);
        facultyFrame.add(gradingButton);
        facultyFrame.add(quitButton);

        //Set JFrame visible
        facultyFrame.setVisible(true);
	}//end constructor
	
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
	
	class MyMouseListener extends MouseAdapter{
		
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e){
			
			if(e.getSource() == scheduleButton){
				@SuppressWarnings("unused")
				ScheduleFrame sf = new ScheduleFrame
						(facultyName, facultyPassword, "Faculty");
				facultyFrame.hide();
			}//end if
			
			else if (e.getSource() == informationButton){
				facultyFrame.hide();
				@SuppressWarnings("unused")
				InfoFrame infoFrame = new InfoFrame(facultyName, 
						facultyPassword, "Faculty");
			}//end else if
			
			else if (e.getSource() == projectButton){
				@SuppressWarnings("unused")
				ProjectFrame pf = new ProjectFrame
						(facultyName, facultyPassword, "Faculty");
				facultyFrame.hide();
			}//end else if
			
			else if (e.getSource() == sirIIButton){
				@SuppressWarnings("unused")
				SirIIFrame sirII = new SirIIFrame
						(facultyName, facultyPassword, "Faculty");
				facultyFrame.hide();
			}//end else if
			
			else if (e.getSource() == gradingButton){
				@SuppressWarnings("unused")
				GradingFrame gf = new GradingFrame
						(facultyName, facultyPassword, "Faculty");
				facultyFrame.hide();
			}//end else if
			
			else if (e.getSource() == quitButton){				
				@SuppressWarnings("unused")
				LoginFrame login = new LoginFrame();
				facultyFrame.hide();
			}//end else if
			
		}//end method		
	}//end inner class	
}//end class
