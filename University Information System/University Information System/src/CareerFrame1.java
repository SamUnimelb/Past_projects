
//queastionnaire part 1
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class CareerFrame1 extends JFrame implements ActionListener
{
  
  //background
    private JFrame CareerFrame1;
	private JPanel imagePanel;
	private JLabel backgroundLabel;
	private ImageIcon backgroundImage;
    
	//foreground//QuestionLabels
	private JLabel studentLabel;
	private JLabel NoteLabel1;
	private JLabel NoteLabel2;
	private JLabel QLabel1;
	private JLabel QLabel2;
	private JLabel QLabel3;
	private JLabel QLabel4;
	private JLabel QLabel5;
   	private JLabel QLabel6;
   	private JButton NextButton;
   	
   	//AnswerTextFields
   	private JTextField ATextField1;
	private JTextField ATextField2;
	private JTextField ATextField3;
	private JTextField ATextField4;
	private JTextField ATextField5;
	private JTextField ATextField6;
    
	//Data filed used for career plan method
	private String studentName;
	private String studentPassword;
	private int[] charList;
	private File scoreFile = new File
    		("bin/Project Data/career score.txt");
	
    public CareerFrame1(String username, String password,String identity)
    {
    	//get username and password
    	studentName = username;
		studentPassword = password;
		charList=new int[6];
		
        CareerFrame1 = new JFrame();
		CareerFrame1.setTitle("Career plan " + "XXX");
		CareerFrame1.setLocation(350, 150);
		CareerFrame1.setSize(615, 540);
		CareerFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
		CareerFrame1.getContentPane().setLayout(null);
		
		//Background: make ContentPane transparent
		imagePanel = (JPanel) CareerFrame1.getContentPane();
        imagePanel.setOpaque(false);
		
        //set the background image
        backgroundLabel = new JLabel();
        backgroundImage = new ImageIcon("bin/Project Pictures/careerplan.jpg");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        
        //put the image to the bottom
        CareerFrame1.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
 
		//Name
        studentLabel = new JLabel("Student " + studentName);
        studentLabel.setFont(new Font("Times New Roman",0,30));
        studentLabel.setForeground(new Color(23,52,72));
        studentLabel.setBounds(275, 25, 2000, 30);
        
        NoteLabel1 = new JLabel("This questionnaire is used for your career plan, please do it carefully.");
        NoteLabel1.setFont(new Font("Times New Roman",0,18));
        NoteLabel1.setForeground(new Color(23,52,72));
        NoteLabel1.setBounds(25, 55, 520, 20);
        
        NoteLabel2 = new JLabel("Use number 1-5, 5 for the best, 1 for the worst.");
        NoteLabel2.setFont(new Font("Times New Roman",0,18));
        NoteLabel2.setForeground(new Color(23,52,72));
        NoteLabel2.setBounds(25, 75, 520, 20);
		
        //questionlabel 1-6
        QLabel1 = new JLabel("Q1. Do you like new technology?" );
        QLabel1.setFont(new Font("Times New Roman",0,20));
        QLabel1.setForeground(new Color(23,52,72));
        QLabel1.setBounds(50, 100, 300, 30);
        
        QLabel2 = new JLabel("Q2. Do you like making plans?  " );
        QLabel2.setFont(new Font("Times New Roman",0,20));
        QLabel2.setForeground(new Color(23,52,72));
        QLabel2.setBounds(50, 150, 300, 30);
        
        QLabel3 = new JLabel("Q3.Do you like being a leader?" );
        QLabel3.setFont(new Font("Times New Roman",0,20));
        QLabel3.setForeground(new Color(23,52,72));
        QLabel3.setBounds(50, 200, 300, 30);
        
        QLabel4 = new JLabel("Q4. Do you like to work indoors?  " );
        QLabel4.setFont(new Font("Times New Roman",0,20));
        QLabel4.setForeground(new Color(23,52,72));
        QLabel4.setBounds(50, 250, 300, 30);
        
        QLabel5 = new JLabel("Q5. Do you like to work with others? " );
        QLabel5.setFont(new Font("Times New Roman",0,20));
        QLabel5.setForeground(new Color(23,52,72));
        QLabel5.setBounds(50, 300, 300, 30);
      
        QLabel6 = new JLabel("Q6.Do you like designing?" );
        QLabel6.setFont(new Font("Times New Roman",0,20));
        QLabel6.setForeground(new Color(23,52,72));
        QLabel6.setBounds(50, 350, 300, 30);
        
        // answer Textfield 1-6
        ATextField1 = new JTextField(" ");
        ATextField1.setFont(new Font("Times New Roman",0,20));
        ATextField1.setForeground(new Color(23,52,72));
        ATextField1.setBounds(400, 100, 50, 35);
        ATextField1.addKeyListener(new KeyAdapter()
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
        ATextField1.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        ATextField2 = new JTextField(" ");
        ATextField2.setFont(new Font("Times New Roman",0,20));
        ATextField2.setForeground(new Color(23,52,72));
        ATextField2.setBounds(400, 150, 50, 35);
        ATextField2.addKeyListener(new KeyAdapter()
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
        ATextField2.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        ATextField3 = new JTextField(" ");
        ATextField3.setFont(new Font("Times New Roman",0,20));
        ATextField3.setForeground(new Color(23,52,72));
        ATextField3.setBounds(400, 200, 50, 35);
        ATextField3.addKeyListener(new KeyAdapter()
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
        ATextField3.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        ATextField4 = new JTextField(" ");
        ATextField4.setFont(new Font("Times New Roman",0,20));
        ATextField4.setForeground(new Color(23,52,72));
        ATextField4.setBounds(400, 250, 50, 35);
        ATextField4.addKeyListener(new KeyAdapter()
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
        ATextField4.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        ATextField5 = new JTextField(" ");
        ATextField5.setFont(new Font("Times New Roman",0,20));
        ATextField5.setForeground(new Color(23,52,72));
        ATextField5.setBounds(400, 300, 50, 35);
        ATextField5.addKeyListener(new KeyAdapter()
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
        ATextField5.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        ATextField6 = new JTextField(" ");
        ATextField6.setFont(new Font("Times New Roman",0,20));
        ATextField6.setForeground(new Color(23,52,72));
        ATextField6.setBounds(400, 350, 50, 35);
        ATextField6.addKeyListener(new KeyAdapter()
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
        ATextField6.setDocument(new PlainDocument(){
            public void insertString(int offset,String str,AttributeSet as)
            throws BadLocationException{
              if(this.getLength()+str.length() > 1){
                java.awt.Toolkit.getDefaultToolkit().beep();
              }
              else
                super.insertString(offset,str,as);
            }
          });
        
        
        
        NextButton = new JButton("Next");
        NextButton.setFont(new Font("Times New Roman",0,16));
        NextButton.setForeground(new Color(23,52,72));
        NextButton.setBounds(480, 465, 70, 30);
        NextButton.addActionListener(this);
        NextButton.setActionCommand("Open");
        
        CareerFrame1.add(studentLabel);
        CareerFrame1.add(NoteLabel1);
        CareerFrame1.add(NoteLabel2);
        CareerFrame1.add(QLabel1); 
        CareerFrame1.add(QLabel2);
        CareerFrame1.add(QLabel3); 
        CareerFrame1.add(QLabel4);
        CareerFrame1.add(QLabel5);
        CareerFrame1.add(QLabel6); 
        
        CareerFrame1.add(ATextField1); 
        CareerFrame1.add(ATextField2); 
        CareerFrame1.add(ATextField3); 
        CareerFrame1.add(ATextField4); 
        CareerFrame1.add(ATextField5); 
        CareerFrame1.add(ATextField6); 
        
        CareerFrame1.add(NextButton);
        
        
        /**
         * set JFrame visible
         */
        
        CareerFrame1.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();

        if(cmd.equals("Open")){
        	CareerFrame1.dispose();
        	//Write the result to txt files
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
	        	writer.println(eachElement);
	        	}
				writer.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}//end try-catch
			//open the next frame for questionnaire
            new CareerFrame2(studentName,studentPassword,"Student");
        }//end if
    }//end method

}//end class