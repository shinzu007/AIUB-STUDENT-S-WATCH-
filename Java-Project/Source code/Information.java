/* Faculty information
 * are shown here
 */
package demo1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

class Information extends JFrame implements ActionListener
{
	  JButton b=new JButton("back");
	  JLabel []l=new JLabel[21];
	  User u,m;
	  JLabel back =new JLabel(new ImageIcon("D:\\me.jpg"));      
      JLabel  label = new JLabel();
      
	public Information(User u,User m)
	    { 
		this.u=u;
		this.m=m;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(false);
	        setLayout(null);
	        setVisible(true);
		    setSize(1000,1000);
			setTitle("Faculty's Profile");
				
		l[0]=new JLabel("Welcome");
		setContentPane(back);
		l[1]=new JLabel("Id :");
		l[2]=new JLabel("Name :");
		l[3]=new JLabel("Email :");
		l[4]=new JLabel("Gender  :");
		l[5]=new JLabel("Contract No :");
		l[6]=new JLabel("Blood group :");
		l[7]=new JLabel("DOB  :");
		l[8]=new JLabel("Department  :");
		l[9]=new JLabel("Current Status :");
		
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
		
		for(int i=0;i<=9;i++){
			add(l[i]);
		}
		for(int i=10;i<=19;i++){
			add(l[i]);
		}
		
		
		for(int i=0;i<=9;i++){
			l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
		}
		
		for(int i=10;i<=19;i++){
			l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
		}
		
			add(b);
			b.setBounds(50,750,95,40);
			b.addActionListener(this);
			
			l[0].setBounds(300,50,80,30);
			l[1].setBounds(155+27,50+30+50+5,120,30);
			l[2].setBounds(150,50+30+50+30+10+10,120,30);
			l[3].setBounds(150,50+30+50+30+10+40+10,120,30);
			l[4].setBounds(127,50+30+50+30+10+40+40+10,120,30);
			l[5].setBounds(93,50+30+50+30+10+40+40+40+10,120,30);
			l[6].setBounds(93,50+30+50+30+10+40+40+40+40+10,120,30);
			l[7].setBounds(143,50+30+50+30+10+40+40+40+40+40+10,120,30);
			l[8].setBounds(85,50+30+50+30+10+40+40+40+40+40+40+10,120,30);
			l[9].setBounds(60,50+30+50+30+10+40+40+40+40+40+40+10+40,150,30);
			
			l[10].setBounds(300+80+10,50,200,30);
			l[11].setBounds(155+55+10,50+30+50+5,100,30);
			l[12].setBounds(150+60+10,50+30+50+30+10+10,200,30);
			l[13].setBounds(150+60+10,50+30+50+30+10+40+10,200,30);
			l[14].setBounds(127+83+10,50+30+50+30+10+40+40+10,100,30);
			l[15].setBounds(93+110+10,50+30+50+30+10+40+40+40+10,150,30);
			l[16].setBounds(93+110+10,50+30+50+30+10+40+40+40+40+10,100,30);
			l[17].setBounds(143+60+10,50+30+50+30+10+40+40+40+40+40+10,100,30);
			l[18].setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10,200,30);	
			l[19].setBounds(85+120+10,50+30+50+30+10+40+40+40+40+40+40+10+40,100,35);
					   
		    label.setBounds(650,50,250,250); 	    
		    add(label);		    
		    Color c2= Color.white;
			Color c1= Color.gray;
			b.setForeground(c2);
			b.setBackground(c1);  
		    
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
		                    JOptionPane.showMessageDialog(null, "No Data");
		                }
		            }catch(Exception ex){
		                ex.printStackTrace();
		            }

			
	    }
	
	  
		public void actionPerformed(ActionEvent a)
		{
			
		  if(a.getSource()==b)
		  {	
			  Cse l=new Cse(m);		 
			this.setVisible(false);
		  }
		  
		}	
	}



