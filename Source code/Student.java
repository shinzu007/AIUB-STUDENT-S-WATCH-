/*Student profile class,this show details of a particular student
 * and he can update his blood status in this page
 */
package demo1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;

class Student extends JFrame implements ActionListener{   
    
	JButton b1=new JButton("Faculty Choose");
	JButton b2=new JButton("Update");
	
	     JLabel []l=new JLabel[22];
         User u;
	     JLabel back =new JLabel(new ImageIcon("D:\\me.jpg"));

	    JRadioButton rb1= new JRadioButton("I can donate now");
		JRadioButton rb2= new JRadioButton("cannot donate this month");
		JRadioButton rb3= new JRadioButton("Donate if serious");
		JRadioButton rb4= new JRadioButton("not interested to donate");
		
		ButtonGroup bg1 = new ButtonGroup();

		JLabel  label = new JLabel();//image label
		
	public Student(User u)
    {   
		this.u=u;
		setContentPane(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
        setLayout(null);
        setVisible(true);
	    setSize(1000,1000);
	    setTitle("Student's Profile");
	
		l[0]=new JLabel("Welcome");
		l[1]=new JLabel("Id :");
		l[2]=new JLabel("Name :");
		l[3]=new JLabel("Email :");
		l[4]=new JLabel("Gender  :");
		l[5]=new JLabel("Contract No :");
		l[6]=new JLabel("Blood group :");
		l[7]=new JLabel("DOB  :");
		l[8]=new JLabel("Department  :");
		l[9]=new JLabel("Blood Status :");
		
		l[10]=new JLabel(u.getF()+" "+u.getL());
		l[11]=new JLabel(u.getU());
		l[12]=new JLabel(u.getF()+" "+u.getL());
		l[13]=new JLabel(u.getE());
		l[14]=new JLabel(u.getG());
		l[15]=new JLabel(u.getC());
		l[16]=new JLabel(u.getB());
		l[17]=new JLabel(u.getD());
		l[18]=new JLabel(u.getDp());
		l[19]=new JLabel(u.getS());
		l[20]=new JLabel("If you Want to change Please choose one from bellow and click on update");
		l[20].setForeground (Color.red);
		
		for(int i=0;i<=9;i++){
			add(l[i]);
		}
		for(int i=10;i<=20;i++){
			add(l[i]);
		}
		
		
		for(int i=0;i<=9;i++){
			l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
		}
		
		for(int i=10;i<=20;i++){
			l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
		}
		
			
			add(b1);
			b1.setBounds(750,800,150,40);
			b1.addActionListener(this);
			

			add(b2);
			b2.setBounds(280,800,120,40);
			b2.addActionListener(this);
			
			l[0].setBounds(300,50,80,30);
			l[1].setBounds(155+27,50+30+50+5,120,30);
			l[2].setBounds(150,50+30+50+30+10+10,120,30);
			l[3].setBounds(150,50+30+50+30+10+40+10,120,30);
			l[4].setBounds(127,50+30+50+30+10+40+40+10,120,30);
			l[5].setBounds(93,50+30+50+30+10+40+40+40+10,120,30);
			l[6].setBounds(93,50+30+50+30+10+40+40+40+40+10,120,30);
			l[7].setBounds(143,50+30+50+30+10+40+40+40+40+40+10,120,30);
			l[8].setBounds(85,50+30+50+30+10+40+40+40+40+40+40+10,120,30);
			l[9].setBounds(85,50+30+50+30+10+40+40+40+40+40+40+40+10,120,30);
			
			l[10].setBounds(300+80+10,50,200,30);
			l[11].setBounds(155+55+10,50+30+50+5,100,30);
			l[12].setBounds(150+60+10,50+30+50+30+10+10,200,30);
			l[13].setBounds(150+60+10,50+30+50+30+10+40+10,200,30);
			l[14].setBounds(127+83+10,50+30+50+30+10+40+40+10,100,30);
			l[15].setBounds(93+110+10,50+30+50+30+10+40+40+40+10,150,30);
			l[16].setBounds(93+110+10,50+30+50+30+10+40+40+40+40+10,100,30);
			l[17].setBounds(143+60+10,50+30+50+30+10+40+40+40+40+40+10,200,30);
			l[18].setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10,200,30);
			l[19].setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+40+10,400,30);
			l[20].setBounds(85,50+30+50+30+10+40+40+40+40+40+40+40+40+10,650,30);
			
			
			

			rb1.setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10+40+80,200,35);
			rb2.setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10+40+120,200,35);
			rb3.setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10+40+160,200,35);
			rb4.setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10+40+200,200,35);
			
			add(rb1);
			add(rb2);
			add(rb3);
			add(rb4);
			
			rb1.setFont(new Font("Times New Roman",Font.BOLD,16));
			rb2.setFont(new Font("Times New Roman",Font.BOLD,16));
			rb3.setFont(new Font("Times New Roman",Font.BOLD,16));
			rb4.setFont(new Font("Times New Roman",Font.BOLD,16));
			
			
			bg1.add(rb1);
			bg1.add(rb2);
			bg1.add(rb3);
			bg1.add(rb4);
			
			
			 label.setBounds(650,50,250,250); 
			 add(label);
			  
			    // coloring the button
			    Color c2= Color.white;
				Color c1= Color.gray;
				b1.setForeground(c2);
				b1.setBackground(c1);
				b2.setForeground(c2);
				b2.setBackground(c1);  
			    
			    // Creating Menu bar
			    JMenuBar menubar = new JMenuBar();
			    JMenu fileMenu = new JMenu("Option");
			    
                //adding Menu Item
		        ImageIcon iconNew = new ImageIcon(" password");		        
		        ImageIcon iconExit = new ImageIcon("exit.png");
		        ImageIcon iconNew1 = new ImageIcon("Log Out.png");

		        JMenuItem newMi = new JMenuItem("Change password", iconNew);
		        JMenuItem newMi1 = new JMenuItem("Log Out", iconNew1);
		        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
		        exitMi.setToolTipText("Exit application");
		        
		        fileMenu.add(newMi);		       
		        fileMenu.addSeparator();
		        fileMenu.add(newMi1);
		        fileMenu.addSeparator();
		        fileMenu.add(exitMi);
		        menubar.add(fileMenu);
		        setJMenuBar(menubar);

		        
		        fileMenu.setFont(new Font("Times New Roman",Font.BOLD,20));
		        newMi.setFont(new Font("Times New Roman",Font.BOLD,15));
		        newMi1.setFont(new Font("Times New Roman",Font.BOLD,15));
		        
		        // Menu item action listener
		        exitMi.addActionListener((ActionEvent event) -> {
		            System.exit(0);
		        });
		        
		        
		        newMi.addActionListener((ActionEvent event) -> {
		        	Eee r=new Eee(u);
		        	this.setVisible(false);
		        });

		        newMi1.addActionListener((ActionEvent event) -> {
		        	Login r=new Login();
		        	this.setVisible(false);
		        });

		     	        
		        // coloring menu bar
		        fileMenu.setForeground (Color.black);
		        newMi.setBackground (Color.blue);
		        newMi.setForeground (Color.white);
		        exitMi.setBackground (Color.red);
		        exitMi.setForeground (Color.white);
		        newMi1.setBackground (Color.blue);
		        newMi1.setForeground (Color.white);
			    
		        // for displaying image
		        
			        try{
			            	
			           String item1=(String)u.getU();
			           Class.forName("com.mysql.jdbc.Driver");  
			           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			           Statement st = con.createStatement();
			            ResultSet rs = st.executeQuery("select * from image where id = '"+item1+"'");
			            
			             if(rs.next()){
			                  byte[] img = rs.getBytes("Image");

			                    //Resize The ImageIcon
			                  
			                    ImageIcon image = new ImageIcon(img);
			                    Image im = image.getImage();
			                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
			                    ImageIcon newImage = new ImageIcon(myImg);
			                    label.setIcon(newImage);
			                   }
			                
			                else{
			                	
			                	JOptionPane.showMessageDialog(null, "Image is not available or not inserted");			                    }
			            }
			                 catch(Exception ex){
			            	JOptionPane.showMessageDialog(this,"Error");
			                 }	
			
    }
	
	  public void actionPerformed(ActionEvent a){
		if(a.getSource()==b1)
	  {
		  Cse c=new Cse(u);
		  this.setVisible(false);
	  }	
		// update blood status
		
		else
	        {

			if(rb1.isSelected()){
				u.setS(rb1.getText());
			}else if(rb2.isSelected()){
				u.setS(rb2.getText());
			}
			else if(rb3.isSelected()){
				u.setS(rb3.getText());
			}else if(rb4.isSelected()){
				u.setS(rb4.getText());
			}
			
			
			String dsql="UPDATE `studentInformation` SET `bloodstatus` = '"+u.getS()+"' WHERE `studentInformation`.`userId` = '"+u.getU()+"';";
						try{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate(dsql);
				
			}
			catch(SQLException g){
				JOptionPane.showMessageDialog(this,"Error");
				
			}
			catch(Exception eq){
				JOptionPane.showMessageDialog(this,"Error");
			
			}
			
			new Student(u);
			this.setVisible(false);
	        }
}
}
	

