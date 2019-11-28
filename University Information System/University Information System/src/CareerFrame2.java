//queastionnaire part 2 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class CareerFrame2 extends JFrame implements ActionListener
{
	//background
	private JFrame CareerFrame2;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
	
	//foreground//QuestionLabels
	private JLabel studentLabel;
	private JLabel QLabel7;
	private JLabel QLabel8;
	private JLabel QLabel9;
	private JLabel QLabel10;
	private JLabel QLabel11;
	private JLabel QLabel12;
	private JButton FinishButton;
	
  	//AnswerTextFields
	private JTextField ATextField7;
	private JTextField ATextField8;
	private JTextField ATextField9;
	private JTextField ATextField10;
	private JTextField ATextField11;
	private JTextField ATextField12;
	
	//Data filed used for career plan method
	private String studentName;
	private String studentPassword;
	private File scoreFile = new File
    		("bin/Project Data/career score2.txt");
	private int[] charList;
	
    public CareerFrame2(String username, String password,String identity)
    {
      
    	studentName = username;
		studentPassword = password;
		//currentUser=new Student(username);
		charList=new int[6];
        CareerFrame2 = new JFrame();
		CareerFrame2.setTitle("Career plan " + "XXX");
		CareerFrame2.setLocation(350, 250);
		CareerFrame2.setSize(615, 540);
		CareerFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
		CareerFrame2.getContentPane().setLayout(null);
        
		/**
		 * Background
		 */
		//make ContentPane transparent
		imagePanel = (JPanel) CareerFrame2.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/careerplan.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        CareerFrame2.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        
        
        /**
         * Make Components
         */
		//Name
        studentLabel = new JLabel("Student "+ studentName);
        studentLabel.setFont(new Font("Times New Roman",0,30));
        studentLabel.setForeground(new Color(23,52,72));
        studentLabel.setBounds(275, 25, 2000, 30);
        
      //questionlabel 7-12
        QLabel7 = new JLabel("Q7.Do you like sports?" );
        QLabel7.setFont(new Font("Times New Roman",0,20));
        QLabel7.setForeground(new Color(23,52,72));
        QLabel7.setBounds(50, 100, 300, 30);
        
        QLabel8 = new JLabel("Q8.Do you like coding? " );
        QLabel8.setFont(new Font("Times New Roman",0,20));
        QLabel8.setForeground(new Color(23,52,72));
        QLabel8.setBounds(50, 150, 300, 30);
        
        QLabel9 = new JLabel("Q9.Do you like party?" );
        QLabel9.setFont(new Font("Times New Roman",0,20));
        QLabel9.setForeground(new Color(23,52,72));
        QLabel9.setBounds(50, 200, 300, 30);
        
        QLabel10 = new JLabel("Q10.Do you like writing?" );
        QLabel10.setFont(new Font("Times New Roman",0,20));
        QLabel10.setForeground(new Color(23,52,72));
        QLabel10.setBounds(50, 250, 300, 30);
        
        QLabel11 = new JLabel("Q10.Do you like traveling?" );
        QLabel11.setFont(new Font("Times New Roman",0,20));
        QLabel11.setForeground(new Color(23,52,72));
        QLabel11.setBounds(50, 300, 300, 30);
        
        QLabel12 = new JLabel("Q10.Do you like math/logic ?" );
        QLabel12.setFont(new Font("Times New Roman",0,20));
        QLabel12.setForeground(new Color(23,52,72));
        QLabel12.setBounds(50, 350, 300, 30);
        
        
        // answer Textfield 7-12
        ATextField7 = new JTextField(" ");
        ATextField7.setFont(new Font("Times New Roman",0,20));
        ATextField7.setForeground(new Color(23,52,72));
        ATextField7.setBounds(400, 100, 50, 35);
        ATextField7.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();  
                charList[0]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField7.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        ATextField8 = new JTextField(" ");
        ATextField8.setFont(new Font("Times New Roman",0,20));
        ATextField8.setForeground(new Color(23,52,72));
        ATextField8.setBounds(400, 150, 50, 35);
        ATextField8.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();    
                charList[1]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField8.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        ATextField9 = new JTextField(" ");
        ATextField9.setFont(new Font("Times New Roman",0,20));
        ATextField9.setForeground(new Color(23,52,72));
        ATextField9.setBounds(400, 200, 50, 35);
        ATextField9.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();      
                charList[2]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField9.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        ATextField10 = new JTextField(" ");
        ATextField10.setFont(new Font("Times New Roman",0,20));
        ATextField10.setForeground(new Color(23,52,72));
        ATextField10.setBounds(400, 250, 50, 35);
        ATextField10.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();
                charList[3]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField10.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        ATextField11 = new JTextField(" ");
        ATextField11.setFont(new Font("Times New Roman",0,20));
        ATextField11.setForeground(new Color(23,52,72));
        ATextField11.setBounds(400, 300, 50, 35);
        ATextField11.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();     
                charList[4]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField11.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        ATextField12 = new JTextField(" ");
        ATextField12.setFont(new Font("Times New Roman",0,20));
        ATextField12.setForeground(new Color(23,52,72));
        ATextField12.setBounds(400, 350, 50, 35);
        ATextField12.addKeyListener(new KeyAdapter()
        {   
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();
                charList[5]=e.getKeyChar(); 
                if(keyChar >= KeyEvent.VK_1 && keyChar <= KeyEvent.VK_5 ){  
                	// UsernameTextField.setMaxLength(1);
                	         }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
              
            }

        });  
        ATextField12.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        FinishButton = new JButton("Finish");
        FinishButton.setFont(new Font("Times New Roman",0,16));
        FinishButton.setForeground(new Color(23,52,72));
        FinishButton.setBounds(480, 465, 70, 30);
        FinishButton.addActionListener(this);
        FinishButton.setActionCommand("Open");
        
        CareerFrame2.add(studentLabel);
        CareerFrame2.add(QLabel7);
        CareerFrame2.add(QLabel8);
        CareerFrame2.add(QLabel9);
        CareerFrame2.add(QLabel10);
        CareerFrame2.add(QLabel11);
        CareerFrame2.add(QLabel12);
        
        CareerFrame2.add(ATextField7); 
        CareerFrame2.add(ATextField8); 
        CareerFrame2.add(ATextField9); 
        CareerFrame2.add(ATextField10); 
        CareerFrame2.add(ATextField11); 
        CareerFrame2.add(ATextField12); 
        
        CareerFrame2.add(FinishButton);
        
        
        /**
         * set JFrame visible
         */
        
        CareerFrame2.setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();

        if(cmd.equals("Open")){
        	CareerFrame2.dispose();
        	//Write the result of questionnaire to txt file
        	 Formatter formatter;
 			try {
 				formatter = new Formatter(scoreFile);
 				formatter.close();
 			} catch (FileNotFoundException e2) {
 				e2.printStackTrace();
 			}//end try-catch
         	 
        	PrintWriter writer;
			try {
				writer = new PrintWriter(scoreFile);
				for(int eachElement:charList){
	        	//System.out.println(charList[i]);
	        	writer.println(eachElement);
	        	}//end for
				writer.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}//end try-catch
			
		
            try {
				new CareerOutputFrame(studentName,studentPassword,"Student");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}//end try catch
            
        }//end if
    }//end method
}//end class