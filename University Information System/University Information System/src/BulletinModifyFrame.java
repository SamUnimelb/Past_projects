import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BulletinModifyFrame {
	//background
		private JFrame bulletinModifyFrame;
		private JPanel imagePanel;
		private JLabel backgroundLabel;
		private ImageIcon backgroundImage;
		
		//foreground
		private JLabel bulletinModifyLabel;
		private TextArea bulletinLabel;
		private JButton modifyButton;
		private JButton removeButton;
		private JButton addButton;
		private JButton cancelButton;
		private JButton sureButton;
		
		private String adminName;
		private String adminPassword;
		
		private List<Bulletin> bulletinInfo;
		private Admin admin;
		
		public BulletinModifyFrame(String username, String password){
			admin = new Admin();
			bulletinInfo = new LinkedList<>();
			bulletinInfo = admin.getBulletinInfo();

			adminName = username;
			adminPassword = password;
			//Make JFrame:
			bulletinModifyFrame = new JFrame();
			bulletinModifyFrame.setTitle("Modifying Bulletin");
			bulletinModifyFrame.setLocation(350, 100);
			bulletinModifyFrame.setSize(600, 520);
			bulletinModifyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
			bulletinModifyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			bulletinModifyFrame.getContentPane().setLayout(null);
			bulletinModifyFrame.addWindowListener(new MyWindowListener());
			
			//Setting Background
			//make ContentPane transparent
			imagePanel = (JPanel) bulletinModifyFrame.getContentPane();
	        imagePanel.setOpaque(false);
			
	        //set the background image
	        backgroundLabel = new JLabel();
	        backgroundImage = new ImageIcon("bin/Project Pictures/Admin Surface.jpg");
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
	        
	        //put the image to the bottom
	        bulletinModifyFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
	        
	        //Make Components
			//Name
	        bulletinModifyLabel = new JLabel();
	        bulletinModifyLabel.setFont(new Font("Times New Roman",0,30));
	        bulletinModifyLabel.setForeground(new Color(23,52,72));
	        bulletinModifyLabel.setBounds(220, 25, 350, 30);
	        bulletinModifyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	   			
	        //Bulletin
	        bulletinLabel = new TextArea("");
	        bulletinLabel.setFont(new Font("Times New Roman",0,20));
	        bulletinLabel.setForeground(new Color(23,52,72));
	        bulletinLabel.setBounds(57, 276, 500, 153);
	        bulletinLabel.setEditable(false);
	        
	        //Button
	        modifyButton = new JButton("Modify");
	        modifyButton.setFont(new Font("Times New Roman",0,20));
	        modifyButton.setForeground(new Color(23,52,72));
	        modifyButton.setBounds(87, 80, 130, 50);
	        modifyButton.addMouseListener(new MyMouseListener());
			
	        removeButton = new JButton("Remove");
	        removeButton.setFont(new Font("Times New Roman",0,20));
	        removeButton.setForeground(new Color(23,52,72));
	        removeButton.setBounds(87, 150, 130, 50);
	        removeButton.addMouseListener(new MyMouseListener());
			
	        addButton = new JButton("Add");
	        addButton.setFont(new Font("Times New Roman",0,20));
	        addButton.setForeground(new Color(23,52,72));
	        addButton.setBounds(390, 80, 130, 50);
	        addButton.addMouseListener(new MyMouseListener());
	        
	        cancelButton = new JButton("Cancel");
	        cancelButton.setFont(new Font("Times New Roman",0,20));
	        cancelButton.setForeground(new Color(23,52,72));
	        cancelButton.setBounds(390, 150, 130, 50);
	        cancelButton.addMouseListener(new MyMouseListener());
  
	        sureButton = new JButton("sure");
	        sureButton.setFont(new Font("Times New Roman",0,20));
	        sureButton.setForeground(new Color(23,52,72));
	        sureButton.setBounds(255, 225, 100, 45);
	        sureButton.addMouseListener(new MyMouseListener());
	        
	        //Add components
	        bulletinModifyFrame.add(bulletinModifyLabel);
	        bulletinModifyFrame.add(bulletinLabel);
	        bulletinModifyFrame.add(modifyButton);
	        bulletinModifyFrame.add(removeButton);
	        bulletinModifyFrame.add(addButton);
	        bulletinModifyFrame.add(cancelButton);
	        bulletinModifyFrame.add(sureButton);
	        
	        //Set JFrame visible
	        bulletinModifyFrame.setVisible(true);		
		}//end constructor
		
		class MyMouseListener extends MouseAdapter{

			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e){
				
				if(e.getSource() == modifyButton){
					boolean isInputValid = false;
				
					while(! isInputValid){
						try{
							int num = Integer.parseInt(
									JOptionPane.showInputDialog(bulletinModifyFrame, 
									"Enter the number of bulletin you want to modify: ") );
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"Bulletin \""+ bulletinInfo.get(num - 1).getInformation() + "\" removed.");
							bulletinLabel.setText(bulletinInfo.get(num - 1).getInformation());
							bulletinInfo.remove(bulletinInfo.get(num - 1));							
							isInputValid = true;
						}catch(NumberFormatException nfe){
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"Invalid input, try again!", "Invalid input", JOptionPane.ERROR_MESSAGE);
						}catch(IndexOutOfBoundsException iobe){
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"The information doesn't exist!", "Invalid input", JOptionPane.ERROR_MESSAGE);
						}//end try-catch										 
					}//end while					

					JOptionPane.showMessageDialog(bulletinModifyFrame, 
								"Enter the correct content of the modifying bulletin in the text"
								+ " below: ");

					bulletinLabel.setEditable(true);						
				}//end if
				
				else if (e.getSource() == removeButton){
					boolean isInputValid = false;

					outter: while(! isInputValid){
						try{
							int num = Integer.parseInt(
									JOptionPane.showInputDialog(bulletinModifyFrame, 
									"Enter the number of bulletin you want to remove: \n"
									+ "If you don't want to remove, enter -1: ") );
							
							if(num == -1){					
								bulletinModifyFrame.hide();
								@SuppressWarnings("unused")
								AdminFrame admin = new AdminFrame
										(adminName,	adminPassword);
								break outter;

							}//end if								
							
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"Bulletin \""+ bulletinInfo.get(num - 1).getInformation() + "\" removed.");
							
							bulletinInfo.remove(bulletinInfo.get(num - 1));
							isInputValid = true;
							
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"Successfully removed!");
						}catch(NumberFormatException nfe){
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"Invalid input, try again!", "Invalid input", JOptionPane.ERROR_MESSAGE);
						}catch(IndexOutOfBoundsException iobe){
							JOptionPane.showMessageDialog(bulletinModifyFrame, 
									"The information doesn't exist!", "Invalid input", JOptionPane.ERROR_MESSAGE);
						}//end try-catch
					}//end while				
					
					writeModifiedBulletin();
				}//end else if
			
				else if (e.getSource() == addButton){
					JOptionPane.showMessageDialog(bulletinModifyFrame, 
							"Enter the correct content of the adding bulletin in the text"
							+ " below: ");					
					bulletinLabel.setEditable(true);	
				}
				
				else if(e.getSource() == cancelButton){
					bulletinModifyFrame.hide();
					@SuppressWarnings("unused")
					AdminFrame admin = new AdminFrame
							(adminName,	adminPassword);
				}//end else if
				
				else if(e.getSource() == sureButton){
					checkText();
				}//end else if
			}//end method
		}//end inner class
		
		class MyWindowListener extends WindowAdapter{
			@SuppressWarnings("deprecation")
			public void windowClosing(WindowEvent e){
				bulletinModifyFrame.hide();
				@SuppressWarnings("unused")
				AdminFrame admin = new AdminFrame
						(adminName,	adminPassword);
			}//end method
		}//end class
		
		private boolean checkText(){
			
			bulletinLabel.setEditable(false);
			
			if(bulletinLabel.getText().equals(" ") || bulletinLabel.getText().equals("") ){
				 JOptionPane.showMessageDialog(bulletinModifyFrame, 
							"Can't input null information! Try again!", "Invalid input", 
							JOptionPane.ERROR_MESSAGE);
				 return false;
			 }//end inner if
		
			 else{
				 Bulletin newBulletin = new Admin();
				 newBulletin.setInformation(bulletinLabel.getText());				 
				 bulletinInfo.add(newBulletin);
				 writeModifiedBulletin();
				 JOptionPane.showMessageDialog(bulletinModifyFrame, 
						 "Modified successfully!");
				return true;
			 }//end else
		}//end method
		
		private void writeModifiedBulletin(){
			File bulletinInfoFile = new File
					("bin/Project Data/Bulletin.txt");
			try{
				Formatter format = new Formatter(bulletinInfoFile);
				format.close();
				
				PrintWriter writer = new PrintWriter(bulletinInfoFile);
				
				for(Bulletin eachBulletin : bulletinInfo){
					writer.println();
					writer.println(eachBulletin.getInformation());					
				}//end for	
				
				writer.close();		
				
			}catch(FileNotFoundException e){
				System.out.println("File not found!");
			}//end try-catch
		}//end method
}//end class
