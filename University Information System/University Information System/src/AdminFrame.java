import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class AdminFrame {

	//background
	private JFrame adminFrame;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground
	private JLabel adminLabel;
	private TextArea bulletinLabel;
	private JButton informationButton;
	private JButton manageButton;
	private JButton projectButton;
	private JButton sirIIButton;
	private JButton taskButton;
	private JButton bulletinButton;
	private JButton quitButton;
	
	private String adminName;
	private String adminPassword;
	private Admin admin;
	private List<Bulletin> bulletinInfo;
	
	public AdminFrame(String username, String password){
		admin = new Admin();
		bulletinInfo = new LinkedList<>();
		bulletinInfo = admin.getBulletinInfo();
		
		adminName = username;
		adminPassword = password;
		
		//Make JFrame:
		adminFrame = new JFrame();
		adminFrame.setTitle("Admin");
		adminFrame.setLocation(350, 100);
		adminFrame.setSize(625, 550);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		adminFrame.getContentPane().setLayout(null);

		//Setting Background
		//make ContentPane transparent
		imagePanel = (JPanel) adminFrame.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/Admin Surface.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        adminFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
        //Make Components
		//Name
        adminLabel = new JLabel(adminName);
        adminLabel.setFont(new Font("Times New Roman",0,30));
        adminLabel.setForeground(new Color(23,52,72));
        adminLabel.setBounds(220, 25, 350, 30);
        adminLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
        //Bulletin
        admin.getBulletinInfo();
        bulletinLabel = new TextArea("");
        bulletinLabel.setFont(new Font("Times New Roman",0,20));
        bulletinLabel.setForeground(new Color(23,52,72));
        bulletinLabel.setBounds(57, 276, 500, 153);
        bulletinLabel.setEditable(false);
        bulletinLabel.setEditable(false);
		showBulletin();
		
        //Button
        informationButton = new JButton("Information");
        informationButton.setFont(new Font("Times New Roman",0,20));
        informationButton.setForeground(new Color(23,52,72));
        informationButton.setBounds(87, 80, 130, 50);
        informationButton.addMouseListener(new MyMouseListener());
		
        manageButton = new JButton("Manage");
        manageButton.setFont(new Font("Times New Roman",0,20));
        manageButton.setForeground(new Color(23,52,72));
        manageButton.setBounds(87, 150, 130, 50);
        manageButton.addMouseListener(new MyMouseListener());
		
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
		
        taskButton = new JButton("Task");
        taskButton.setFont(new Font("Times New Roman",0,20));
        taskButton.setForeground(new Color(23,52,72));
        taskButton.setBounds(235, 150, 140, 50);
        taskButton.addMouseListener(new MyMouseListener());
		
        bulletinButton = new JButton("Bulletin");
        bulletinButton.setFont(new Font("Times New Roman",0,20));
        bulletinButton.setForeground(new Color(23,52,72));
        bulletinButton.setBounds(235, 210, 140, 50);
        bulletinButton.addMouseListener(new MyMouseListener());
                
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Times New Roman",0,15));
        quitButton.setForeground(new Color(23,52,72));
        quitButton.setBounds(520, 467, 70, 30);
        quitButton.addMouseListener(new MyMouseListener());
        
        //Add components
        adminFrame.add(adminLabel);
        adminFrame.add(bulletinLabel);
        adminFrame.add(informationButton);
        adminFrame.add(taskButton);
        adminFrame.add(manageButton);
        adminFrame.add(projectButton);
        adminFrame.add(sirIIButton);
        adminFrame.add(quitButton);
        adminFrame.add(bulletinButton);
        
        //Set JFrame visible
        adminFrame.setVisible(true);		
	}//end constructor
	
	class MyMouseListener extends MouseAdapter{
		
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e){
			
			if(e.getSource() == manageButton){
				@SuppressWarnings("unused")
				ManageFrame manage = new ManageFrame
					(adminName, adminPassword);
				adminFrame.hide();		
			}//end if
			
			else if (e.getSource() == informationButton){
				@SuppressWarnings("unused")
				InfoFrame informationFrame = new InfoFrame(adminName,
						adminPassword, "Admin");
				adminFrame.hide();				
			}//end else if
			
			else if (e.getSource() == projectButton){
				@SuppressWarnings("unused")
				ProjectFrame pf = new ProjectFrame
						(adminName, adminPassword, "Admin");
				adminFrame.hide();
			}
			else if (e.getSource() == sirIIButton){
				@SuppressWarnings("unused")
				SirIIFrame sirII = new SirIIFrame
						(adminName, adminPassword, "Admin");
				adminFrame.hide();
			}
			
			else if (e.getSource() == taskButton){
				@SuppressWarnings("unused")
				TaskFrame pf = new TaskFrame
					(adminName, adminPassword, "Admin");
				adminFrame.hide();
			}//end else if
			
			else if (e.getSource() == bulletinButton){
				@SuppressWarnings("unused")
				BulletinModifyFrame bulletinModify = new BulletinModifyFrame
						(adminName, adminPassword);
				adminFrame.hide();		
			}//end else if
			
			else if (e.getSource() == quitButton){				
				@SuppressWarnings("unused")
				LoginFrame login = new LoginFrame();
				adminFrame.hide();
			}//end else if
		}//end method
	}//end inner class
	
	public void showBulletin(){
        admin = new Admin();
		bulletinInfo = new ArrayList<>();
		bulletinInfo = admin.getBulletinInfo();
		
		String s = "";
		for(Bulletin eachInfo : bulletinInfo){
			s += eachInfo.getInformation();
			s += "\n\n";
		}//end for		
		
		bulletinLabel.setText(s);
	}//end method
	
	public String getUsername(){
		return adminName;
	}//end method
	
}//end class
