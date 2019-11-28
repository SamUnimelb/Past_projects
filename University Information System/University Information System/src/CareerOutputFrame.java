
//finish questionnaire's part 

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CareerOutputFrame extends JFrame implements ActionListener{
	    //background
		private JFrame studentFrame;
		private JPanel imagePanel;
		private JLabel backgroundLabel;
		
		private ImageIcon backgroundImage;
		private ImageIcon JobImage;
		//foreground
		private JLabel studentLabel;
		private JLabel ImageJobLabel;
		
		private JLabel  JobNameLabel;
		private JLabel  SalaryLabel;
		private JLabel  IntroductLabel;
		
		private TextArea IntroductArea;
		private int count;
		private JButton BackButton;
		private JButton NextButton;
		
		//Data filed for career plan methods
		private String studentName;
		private String studentPassword;
		private String studentIdentity;
		private List<String> careerInfo;
		private Scanner careerInfoReader;
		private File careerInfoFile = new File
		    		("bin/Project Data/Career Info.txt");
		List<String>careerNames;
			
		private Scanner gradeSheetReader;
		private File gradingInfoFile = new File
			    ("bin/Project Data/Grading Sheet.txt");
		private List<String> gradingSheet;
		private List<String> courseList;
		private List<String> courseCount;
		private List<String> CareerPlan;
		private List<Student> studentList;
		String careerPlanString;
		
		//the data filed to get the questionnaire answers
		private int[] careerEle;
		/*private File studentInfoFile = new File
				("bin/Project Data/Student Info.txt"); */
		private Scanner scoreReader;
		private File scoreFile = new File
				("bin/Project Data/career score.txt");
		private Scanner scoreReader2;
		private File scoreFile2 = new File
				("bin/Project Data/career score2.txt");
		
		//the data filed to get career models
		private Scanner careerModelCAISMReader;
		private File careerCAISMFile = new File
				("bin/Project Data/CareerModel/CAISM.txt");
		private List<String> careerModelCAISM;
		private Scanner careerModelCHEReader;
		private File careerCHEFile = new File
				("bin/Project Data/CareerModel/CHE.txt");
		private List<String> careerModelCHE;
		private Scanner careerModelCPReader;
		private File careerCPFile = new File
				("bin/Project Data/CareerModel/CP.txt");
		private List<String> careerModelCP;
		private Scanner careerModelCSAReader;
		private File careerCSAFile = new File
				("bin/Project Data/CareerModel/CSA.txt");
		private List<String> careerModelCSA;
		private Scanner careerModelCSEReader;
		private File careerCSEFile = new File
				("bin/Project Data/CareerModel/CSE.txt");
		private List<String> careerModelCSE;
		private Scanner careerModelCSSReader;
		private File careerCSSFile = new File
				("bin/Project Data/CareerModel/CSS.txt");
		private List<String> careerModelCSS;
		private Scanner careerModelNSAReader;
		private File careerNSAFile = new File
				("bin/Project Data/CareerModel/NSA.txt");
		private List<String> careerModelNSA;
		private Scanner careerModelSDReader;
		private File careerSDFile = new File
				("bin/Project Data/CareerModel/SD.txt");
		private List<String> careerModelSD;
		private Scanner careerModelWDReader;
		private File careerWDFile = new File
				("bin/Project Data/CareerModel/WD.txt");
		private List<String> careerModelWD;
		private Scanner careerModelWMReader;
		private File careerWMFile = new File
				("bin/Project Data/CareerModel/WM.txt");	
		private List<String> careerModelWM;
		
		public CareerOutputFrame(String username, String password,String identity) throws FileNotFoundException{
			//JFrame
			studentName = username;
			studentPassword = password;
			studentIdentity = identity;
			
			careerInfo= new LinkedList<String>();
			careerInfoReader = new Scanner(careerInfoFile);
	    	while(!careerInfo.contains("END")){ 
	    		careerInfo.add(careerInfoReader.nextLine());
	    	}
	    	careerInfo.remove("END");
	    	careerInfoReader.close();
	    	count=0;
			studentFrame = new JFrame();
			studentFrame.setTitle("Career Plan");
			studentFrame.setLocation(350, 250);
			studentFrame.setSize(615, 540);
			studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window		
			studentFrame.getContentPane().setLayout(null);
			
			/**
			 * Background
			 */
			//make ContentPane transparent
			imagePanel = (JPanel) studentFrame.getContentPane();
	        imagePanel.setOpaque(false); 
			
	        //set the background image
	        backgroundLabel = new JLabel();
	        backgroundImage = new ImageIcon("bin/Project Pictures/careerplan.jpg");
	        backgroundLabel.setIcon(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
	        
	        //put the image to the bottom
	        studentFrame.getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
	        
	        
	        /**
	         * Make Components
	         */
			//Name
	        studentLabel = new JLabel("Student " + studentName);
	        studentLabel.setFont(new Font("Times New Roman",0,30));
	        studentLabel.setForeground(new Color(23,52,72));
	        studentLabel.setBounds(275, 25, 2000, 30);
	        
	        ImageJobLabel = new JLabel();
	        JobImage = new ImageIcon("bin/job.gif");
	        ImageJobLabel.setIcon(JobImage);
	        ImageJobLabel.setBounds(275, 50, JobImage.getIconWidth(),JobImage.getIconHeight());
	        
	       
	        JobNameLabel = new JLabel( );
	        JobNameLabel.setFont(new Font("Times New Roman",0,20));
	        JobNameLabel.setForeground(new Color(23,52,72));
	        JobNameLabel.setBounds(25, 100, 700, 30);
	        
	        SalaryLabel = new JLabel();
	        SalaryLabel.setFont(new Font("Times New Roman",0,20));
	        SalaryLabel.setForeground(new Color(23,52,72));
	        SalaryLabel.setBounds(25, 150, 300, 30);
	        
	        IntroductLabel = new JLabel("Introduction: " );
	        IntroductLabel.setFont(new Font("Times New Roman",0,20));
	        IntroductLabel.setForeground(new Color(23,52,72));
	        IntroductLabel.setBounds(25, 200, 300, 30);
	
			
	        // TextArea
	        IntroductArea = new TextArea();
	        
	        //use getCareer method to get the career plan for the user
	        careerNames= getCareer();
	        
	        //Show user the result on screen
	        if(careerNames.size()==0){
	        	IntroductArea.setText("Sorry, there is no very suitable job for you in the system");
	        }
	        else{
	        		JobNameLabel.setText("Job Name: "+careerNames.get(0));
	        		SalaryLabel.setText("Salary: " + careerInfo.get(careerInfo.indexOf(careerNames.get(0))+1));
	        		IntroductArea.setText(careerInfo.get(careerInfo.indexOf(careerNames.get(0))+2));	
	        }//end if-else
	        
	        //IntroductArea = new TextArea();
	        IntroductArea.setFont(new Font("Times New Roman",0,20));
	        IntroductArea.setForeground(new Color(23,52,72));
	        IntroductArea.setBounds(25, 250, 500, 150);
	        IntroductArea.setRows(4);
	 
	        //Buttons
	        BackButton = new JButton("Back");
	        BackButton.setFont(new Font("Times New Roman",0,16));
	        BackButton.setForeground(new Color(23,52,72));
	        BackButton.setBounds(480, 465, 70, 30);
	        BackButton.addActionListener(this);
	        BackButton.setActionCommand("Back");
			
	        NextButton = new JButton("Next");
	        NextButton.setFont(new Font("Times New Roman",0,16));
	        NextButton.setForeground(new Color(23,52,72));
	        NextButton.setBounds(400, 465, 70, 30);
	        NextButton.addActionListener(this);
	        NextButton.setActionCommand("Next");
	        /**
	         * Add components
	         */
	        studentFrame.add(studentLabel);
	        studentFrame.add(JobNameLabel);
	        studentFrame.add(SalaryLabel);
	        studentFrame.add(IntroductLabel);
	        studentFrame.add(ImageJobLabel);
	        studentFrame.add(IntroductArea);

	        studentFrame.add(BackButton);
	        studentFrame.add(NextButton);
	        
	        /**
	         * set JFrame visible
	         */
	        studentFrame.setVisible(true);
			
			
		}//end constructor
		 @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e){
			  String cmd = e.getActionCommand();
			
			  //use count to control the job showing in the window
		        if(cmd.equals("Next")){
		        	if (count==0&&careerNames.size()>=2){
		        		JobNameLabel.setText("Job Name: "+careerNames.get(1));
		        		SalaryLabel.setText("Salary: " + careerInfo.get(careerInfo.indexOf(careerNames.get(1))+1));
		        		IntroductArea.setText(careerInfo.get(careerInfo.indexOf(careerNames.get(1))+2));
		        	}
		        	else if (count==1&&careerNames.size()>=3){
		        		JobNameLabel.setText("Job Name: "+careerNames.get(2));
		        		SalaryLabel.setText("Salary: " + careerInfo.get(careerInfo.indexOf(careerNames.get(2))+1));
		        		IntroductArea.setText(careerInfo.get(careerInfo.indexOf(careerNames.get(2))+2));
		        	}//end if-else
		        	count++;
		        }//end if	
		        if (cmd.equals("Back")){
		        	if(studentIdentity.equals("Student")){
		        	@SuppressWarnings("unused")
					StudentFrame sf = new StudentFrame
							(studentName, studentPassword);
		        	}//end if
		        	studentFrame.hide();
		        }//end if
		    }//end action listener
		 
		 //method to get career plans for the user
		 public List<String> getCareer() throws FileNotFoundException {
				//get the list for career models
				careerModelCAISM = new LinkedList<>();
				careerModelCHE = new LinkedList<>();
				careerModelCP = new LinkedList<>();
				careerModelCSA = new LinkedList<>();
				careerModelCSE = new LinkedList<>();
				careerModelCSS = new LinkedList<>();
				careerModelNSA = new LinkedList<>();
				careerModelSD = new LinkedList<>();
				careerModelWD = new LinkedList<>();
				careerModelWM = new LinkedList<>();
				courseList = new LinkedList<>();
				courseCount = new LinkedList<>();
				CareerPlan = new LinkedList<>();
				gradingSheet = new LinkedList<>();
				careerEle=new int [12];
				 
				try{
					//get the questionnaire answers
						scoreReader = new Scanner(scoreFile);
						for(int i=0;i<6;i++){
							careerEle[i]=scoreReader.nextInt();
						}//end for
						scoreReader2 = new Scanner(scoreFile2);
						for(int i=6;i<careerEle.length;i++){
							careerEle[i]=scoreReader2.nextInt();
						}//end for
						
				//get the career models		
				careerModelCAISMReader = new Scanner(careerCAISMFile);
		    	while(!careerModelCAISM.contains("END")){ 
		    		careerModelCAISM.add(careerModelCAISMReader.next());
		    	}
		    	careerModelCAISM.remove("END");
		    	careerModelCAISMReader.close();
		    	
		    	careerModelCHEReader = new Scanner(careerCHEFile);
		    	while(!careerModelCHE.contains("END")){ 
		    		careerModelCHE.add(careerModelCHEReader.next());
		    	}
		    	careerModelCHE.remove("END");
		    	careerModelCHEReader.close();
		    	
		    	careerModelCPReader = new Scanner(careerCPFile);
		    	while(!careerModelCP.contains("END")){ 
		    		careerModelCP.add(careerModelCPReader.next());
		    	}
		    	careerModelCP.remove("END");
		    	careerModelCPReader.close();
		    	
		    	careerModelCSAReader = new Scanner(careerCSAFile);
		    	while(!careerModelCSA.contains("END")){ 
		    		careerModelCSA.add(careerModelCSAReader.next());
		    	}
		    	careerModelCSA.remove("END");
		    	careerModelCSAReader.close();
		    	
		    	careerModelCSEReader = new Scanner(careerCSEFile);
		    	while(!careerModelCSE.contains("END")){ 
		    		careerModelCSE.add(careerModelCSEReader.next());
		    	}
		    	careerModelCSE.remove("END");
		    	careerModelCSEReader.close();
		    	
		    	careerModelCSSReader = new Scanner(careerCSSFile);
		    	while(!careerModelCSS.contains("END")){ 
		    		careerModelCSS.add(careerModelCSSReader.next());
		    	}
		    	careerModelCSS.remove("END");
		    	careerModelCSSReader.close();
		    	
		    	careerModelNSAReader = new Scanner(careerNSAFile);
		    	while(!careerModelNSA.contains("END")){ 
		    		careerModelNSA.add(careerModelNSAReader.next());
		    	}
		    	careerModelNSA.remove("END");//end while
		    	careerModelNSAReader.close();
		    	
		    	careerModelSDReader = new Scanner(careerSDFile);
		    	while(!careerModelSD.contains("END")){ 
		    		careerModelSD.add(careerModelSDReader.next());
		    	}
		    	careerModelSD.remove("END");
		    	careerModelSDReader.close();
		    	
		    	careerModelWDReader = new Scanner(careerWDFile);
		    	while(!careerModelWD.contains("END")){ 
		    		careerModelWD.add(careerModelWDReader.next());
		    	}
		    	careerModelWD.remove("END");
		    	careerModelWDReader.close();
		    	
		    	careerModelWMReader = new Scanner(careerWMFile);
		    	while(!careerModelWM.contains("END")){ 
		    		careerModelWM.add(careerModelWMReader.next());
		    	}
		    	careerModelWM.remove("END");
		    	careerModelWMReader.close();
		    	
		    	gradeSheetReader = new Scanner(gradingInfoFile);
		    	while(!gradingSheet.contains("ENDAll")){ 
		    		gradingSheet.add(gradeSheetReader.nextLine());
		    	}
		    	gradingSheet.remove("ENDAll");
		    	gradeSheetReader.close();
		    	
			}catch(FileNotFoundException e){
				System.err.println("File not found!");
			}//end try-catch
				
				int pos=gradingSheet.indexOf(studentName)+1;
				for(pos=gradingSheet.indexOf(studentName)+1; pos<gradingSheet.size();pos++){
					if(courseList.contains("END"))
						break;
					else
						courseList.add(gradingSheet.get(pos));
				}//end for
		    	courseList.remove("END");
		    	
		    	//fill up the list of criteria
		    	for (int i=0; i<careerModelCAISM.size();i=i+2){
		    		if (courseList.contains(careerModelCAISM.get(i))){
		    			courseCount.add(courseList.get(courseList.indexOf(careerModelCAISM.get(i))+1));
		    		}
		    		else{
		    			courseCount.add("F");
		    		}//end if-else
		    	}//end for
		    	
		        //get the comparision result and store them in an array of size 10
		    	int[] courseDiff=new int[10];
		    	courseDiff[0]= getCareerDifference(careerModelCAISM );	
		    	courseDiff[1]= getCareerDifference(careerModelCHE );
		    	courseDiff[2]= getCareerDifference(careerModelCP );	
		    	courseDiff[3]= getCareerDifference(careerModelCSA);	
		    	courseDiff[4]= getCareerDifference(careerModelCSE );	
		    	courseDiff[5]= getCareerDifference(careerModelCSS);	
		    	courseDiff[6]= getCareerDifference(careerModelNSA );	
		    	courseDiff[7]= getCareerDifference(careerModelSD );	
		    	courseDiff[8]= getCareerDifference(careerModelWD);	
		    	courseDiff[9]= getCareerDifference(careerModelWM);
		    	
		    	//find the best three
		    	getMins(courseDiff);
		    	//write the best three in a string for the output to files
		    	if(CareerPlan.size()==0){
		    		careerPlanString="Unknow";
		    		}
		    	else{
		    		StringBuilder careerBuilder= new StringBuilder(50);
		    		for (int i =0; i<CareerPlan.size();i++){
		    			careerBuilder.append(CareerPlan.get(i));
		    			careerBuilder.append(", ");
		    		}//end for
		    		careerPlanString=careerBuilder.toString();	
		    	}//end if-else
		    	//change the career property of the student object
		    	getStudentInfo();
		    	 for(Student eachStudent : studentList){
					 if(eachStudent.getName().equals(studentName)){
						 eachStudent.setCareerInfo(careerPlanString) ;
						// eachStudent.setCareerTime() ;
					 }//end inner if
				 }//end for
		    
		    	// modify the file to write the career result for current user
		    	 //writeModifiedStudentInfo();
		
		    	return CareerPlan;
			}//end method
			
			public int getCareerDifference(List<String> careerType){
				int diff=0;
				 List<String> careerGrade = new ArrayList<>();
				 for(int i =1;i<careerType.size();i=i+2){
					 careerGrade.add(careerType.get(i));
				 }//end for
				for(int i=0;i<careerGrade.size();i++){
					//calculate the difference, sum up the difference with different weight
					int match=courseCount.get(i).compareTo(careerType.get(i));
					if(match<0){
						diff=diff+2*match;
					}
					else{
						diff=diff+match;
					}// end if-else
				}//end for
				return diff;
			}//end method
			
			//Below is the method to find the best three jobs and return the index of the job
			public void getMins(int[] arr){
				int indx1=0;
				int indx2=0;
				int indx3=0;
				int min=1000;
				for(int i=0;i<arr.length;i++){  
					if(arr[i]<min){
						min=arr[i];
						indx1=i;
					}//end if
				}//end for
				
				//reset the value 
				arr[indx1]=1000;
				min=500;
				for(int i=0;i<arr.length;i++){
					if(arr[i]<min){
						min=arr[i];
						indx2=i;
					}//end if
				}//end for
				arr[indx2]=1000;
				min=500;
				for(int i=0;i<arr.length;i++){
					if(arr[i]<min){
						min=arr[i];
						indx3=i;
					}//end if
				}//end for
				 List<Integer> careerIndx = new ArrayList<>();
				 careerIndx.add(indx1);
				 careerIndx.add(indx2);
				 careerIndx.add(indx3);
				 //check for each career, whether the user working habits and personality suit the job
				 for(int i=0;i<3;i++){
					 if(careerIndx.get(i)==0){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[2]>50&&careerEle[3]>50&&careerEle[4]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Computer and Information Systems Manager");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==1){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[3]>50&&careerEle[4]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Computer Systems Analyst");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==2){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[3]>50&&careerEle[5]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Computer Software Engineer");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==3){
						 if(careerEle[1]>50&&careerEle[3]>50&&careerEle[5]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Computer Hardware Engineer");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==4){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[3]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Computer Programmer");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==5){
						 if(careerEle[1]>50&&careerEle[4]>50){
							 CareerPlan.add("Computer Support Specialist");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==6){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[3]>50&&careerEle[5]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Network Systems Analyst");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==7){
						 if(careerEle[0]>50&&careerEle[1]>50&&careerEle[3]>50&&careerEle[5]>50&&careerEle[7]>50&&careerEle[11]>50){
							 CareerPlan.add("Software Developer");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==8){
						 if(careerEle[1]>50&&careerEle[3]>50&&careerEle[5]>50&&careerEle[7]>50){
							 CareerPlan.add("Web Developer");
						 }//end inner if
					 }//end if
					 if(careerIndx.get(i)==9){
						 if(careerEle[1]>50&&careerEle[3]>50&&careerEle[4]>50&&careerEle[5]>50&&careerEle[11]>50){
							 CareerPlan.add("Web Master");
						 }//end inner if
					 }//end if
				 }//end for	
			}//end method
			
		
			//get student list
			public synchronized void getStudentInfo(){
				 StudentInfo studentInfo = new StudentInfo();
		    	 studentList=new LinkedList<>(studentInfo.getStudentList());
			 }
			
			/*
			//modify student information file to take down the career plan result
				/*private synchronized void writeModifiedStudentInfo() throws FileNotFoundException{
		    	 try {
		    		 Formatter formatter = new Formatter(studentInfoFile);
		        	 formatter.close();
		        	 PrintWriter writer = new PrintWriter(studentInfoFile);
		        	 writer.println();
		        	 writer.println();
					
		        	 for(Student eachStudent : studentList){
		        		 writer.println(eachStudent.getIdentity());
		 				writer.println(eachStudent.getName());
		 				writer.println(eachStudent.getPassword());
		 				writer.println(eachStudent.getHobby());
		 				writer.println(eachStudent.getId());
		 				writer.println(eachStudent.getEmailAddress());
		 				writer.println(eachStudent.getCareerInfo());
		 				writer.print(eachStudent.getSalary()+" ");
		 				writer.print((eachStudent.getDateIn().
		 						getTime().getYear() + 1900) + " ");
		 				writer.print((eachStudent.getDateIn().
		 						getTime().getMonth() + 1) + " ");
		 				writer.print(eachStudent.getDateIn().
		 						getTime().getDate()+" ");	
		 				writer.print((eachStudent.getBirthday().
		 						getTime().getYear() + 1900) + " ");
		 				writer.print((eachStudent.getBirthday().
		 						getTime().getMonth() + 1) + " ");
		 				writer.print(eachStudent.getBirthday().
		 						getTime().getDate());	
		 			
		 				writer.println();
		 				writer.println();
					}//end for
					writer.close();
		    	 }finally{
		    		
		    	 }//end try-catch-finally
			 
			 }//end method*/
			  
}//end class
