import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class HeadFrame {
		//background
		private JFrame headFrame;
		private JPanel imagePanel;
		private JLabel backgroundLabel;
		private ImageIcon backgroundImage;
		
		//foreground
		private JLabel headLabel;
		private TextArea bulletinLabel;
		private JButton scheduleButton;
		private JButton informationButton;
		private JButton quitButton;
		
		private String headName;
		private String headPassword;
		
		//Implements Bulletin:
		private List<Bulletin> bulletinList;
		private Admin admin;
	
		public static void main(String[] args) {
			@SuppressWarnings("unused")
			HeadFrame headSurface = new HeadFrame("rfawefawfawf","");
		}//end main
		
		public HeadFrame(String username, String password){
			
			headName = username;
			headPassword = password;
			
			//Make JFrame:
			headFrame = new JFrame();
			headFrame.setTitle("HeadMaster");
			headFrame.setLocation(350, 100);
			headFrame.setSize(618, 540);
			headFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			headFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			headFrame.getContentPane().setLayout(null);
		
			//Setting Background
			//make ContentPane transparent
			imagePanel = (JPanel) headFrame.getContentPane();
	        imagePanel.setOpaque(false);
			
	        //set the background image
	        backgroundLabel = new JLabel();
	        backgroundImage = new ImageIcon("bin/Project Pictures/Head Surface.jpg");
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
	        
	        //put the image to the bottom
	        headFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));

	        //Make Components
			//Name
	        headLabel = new JLabel(headName);
	        headLabel.setFont(new Font("Times New Roman",0,40));
	        headLabel.setForeground(new Color(23,52,72));
	        headLabel.setBounds(220, 25, 350, 30);
	        headLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			
	        //Bulletin
	        bulletinLabel = new TextArea();
	        bulletinLabel.setFont(new Font("Times New Roman",0,20));
	        bulletinLabel.setForeground(new Color(23,52,72));
	        bulletinLabel.setBounds(55, 265, 500, 153);
	        bulletinLabel.setRows(5);
	        bulletinLabel.setEditable(false);
	        showBulletin();
	        	        
	        //Button
	        scheduleButton = new JButton("Task");
	        scheduleButton.setFont(new Font("Times New Roman",0,23));
	        scheduleButton.setForeground(new Color(23,52,72));
	        scheduleButton.setBounds(70, 72, 120, 50);
	        scheduleButton.addMouseListener(new MyMouseListener());
			
	        informationButton = new JButton("Information");
	        informationButton.setFont(new Font("Times New Roman",0,20));
	        informationButton.setForeground(new Color(23,52,72));
	        informationButton.setBounds(70, 142, 130, 50);
	        informationButton.addMouseListener(new MyMouseListener());
			
	        quitButton = new JButton("Quit");
	        quitButton.setFont(new Font("Times New Roman",0,15));
	        quitButton.setForeground(new Color(23,52,72));
	        quitButton.setBounds(505, 470, 60, 25);
	        quitButton.addMouseListener(new MyMouseListener());
				
	        //Add components
	        headFrame.add(headLabel);
	        headFrame.add(bulletinLabel);
	        headFrame.add(scheduleButton);
	        headFrame.add(informationButton);
	        headFrame.add(quitButton);

	        //set JFrame visible
	        headFrame.setVisible(true);
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
					TaskFrame sf = new TaskFrame
							(headName, headPassword, "Head");
					headFrame.hide();
				}//end if
				
				else if (e.getSource() == informationButton){
					@SuppressWarnings("unused")
					InfoFrame infoFrame = new InfoFrame(headName, 
							headPassword, "Head");
					headFrame.hide();
				}//end else if
				
				else if (e.getSource() == quitButton){
					headFrame.hide();
					@SuppressWarnings("unused")
					LoginFrame login = new LoginFrame();
				}
			}//end method
		}//end inner class
		
		public String getUsername(){
			return headName;
		}//end method
		
}//end class
