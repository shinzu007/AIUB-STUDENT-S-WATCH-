/* This is Log in class . From this class users enter their
 * userId and password ,and vary with their userId they go 
 * to their profile page by UserId get their  information
 * from database and set them in user and send reference in
 *  profile class
 */
package demo1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.sql.*;

class Login extends JFrame implements ActionListener{
	
	JButton b=new JButton("Log in");
	JTextField f=new JTextField();
    JPasswordField f2 = new JPasswordField();
	JLabel l=new JLabel("User-Id");
	JLabel l2=new JLabel("Password");
	User u=new User();
	
	JPanel k=new JPanel();
	JPanel k1=new JPanel();
	 
	 Color c1=Color.RED;
	 JLabel back1 =new JLabel(new ImageIcon("D:\\aiub_main_campus.jpg"));
	 JLabel l3=new JLabel("AIUB  Student's  Watch");
	
	
	public Login(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setSize(1630,1000);
		setVisible(true);
		setTitle("Login");
		
		add(b);
		b.setBounds(500+900,550,100,35);
	    setLayout(null);
		add(l);
		l.setBounds(200+900,375,200,80);
		add(f);
		f.setBounds(350+900,400,200,30);
		add(l2);
		l2.setBounds(200+900,450,200,70);
		add(f2);
		f2.setBounds(350+900,470,200,30);
	
		b.setIcon(new ImageIcon("D:\\login-button.png"));
		validate();
		b.addActionListener(this);
		
		l.setFont(new Font("Times New Roman",Font.BOLD,30));
		l2.setFont(new Font("Times New Roman",Font.BOLD,30));
		f.setFont(new Font("Times New Roman",Font.BOLD,20));
		l3.setFont(new Font("Times New Roman",Font.BOLD,40));
		add(k);
		k.setBounds(1,1,1050,1000);
	    k.add(back1);
	    
	   add(l3);
	   l3.setBounds(200+900,200,500,30);
	   
	   l3.setForeground (Color.red);
	   Color c2= Color.white;
	   Color c1= Color.gray;	
	   b.setForeground(c2);
	   b.setBackground(c1);  
	   }
	
	    public void actionPerformed(ActionEvent a){

		 String p=new String(f2.getPassword());
	
	     if(a.getSource()==b)
	    {
		  String s=new String(f.getText());
		  if(s.length()==5||s.length()==6){
		String j="select * from facultyInformation where userId='"+f.getText()+"'";

		try
		{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(j);
		
		if(rs.next())
		{
		 if(p.equals(rs.getString(4)))
		 {
			 
				
			u.setF(rs.getString("firstName"));
			u.setL(rs.getString(3));
			u.setU(rs.getString(1));
			u.setE(rs.getString(5));
			u.setC(rs.getString(7));
			u.setG(rs.getString(6));
			u.setB(rs.getString(8));			
			u.setD(rs.getString(9));
			u.setDp(rs.getString(10));
			u.setS(rs.getString(11));
			//u.setFf(rs.getString(12));
			 Faculty f=new Faculty(u); 
				  this.setVisible(false); 
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
			 }
				 
		 }
		 else {
			 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
		 }
		}

		catch(SQLException g)
		{
			JOptionPane.showMessageDialog(this,"Error");
		}
		catch(Exception eq){
			JOptionPane.showMessageDialog(this,"Error");
		}
		
		  }	
		  else if(s.length()<=4){
			  
				String j="select * from adminInformation where userId='"+f.getText()+"'";

				try
				{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(j);
				
				if(rs.next())
				{
				 if(p.equals(rs.getString(4)))
				 {
					 
					    u.setF(rs.getString(2));
						u.setL(rs.getString(3));
						u.setU(rs.getString(1));
						u.setE(rs.getString(5));
						u.setC(rs.getString(7));
						u.setG(rs.getString(6));
						u.setB(rs.getString(8));			
						u.setD(rs.getString(9));
						u.setDp(rs.getString(10));
						
						
						MyAdmin mmm=new MyAdmin(u); 
						
						 
						
						  this.setVisible(false); 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
					 }
						 
				 }
				 else {
					 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
				 }
				}
				


				catch(SQLException g)
				{
					JOptionPane.showMessageDialog(this,"Error");
				}
				catch(Exception eq){
					JOptionPane.showMessageDialog(this,"Error");
				}
				
				  }	
		       else if(s.length()>=8){
			  
				String j="select * from studentInformation where userId='"+f.getText()+"'";

				try
				{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(j);
				
				if(rs.next())
				{
				 if(p.equals(rs.getString(4)))
				 {
					 u.setF(rs.getString(2));
						u.setL(rs.getString(3));
						u.setU(rs.getString(1));
						u.setE(rs.getString(5));
						u.setC(rs.getString(7));
						u.setG(rs.getString(6));
						u.setB(rs.getString(8));			
						u.setD(rs.getString(9));
						u.setDp(rs.getString(10));
						u.setS(rs.getString(11));
					
					Student m=new Student(u); 
						  this.setVisible(false); 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
					 }
						 
		          }
				 else {
					 JOptionPane.showMessageDialog(this,"Wrong User-ID Or Password !!");
				 }
			    }
				


				catch(SQLException g)
				{
					JOptionPane.showMessageDialog(this,"Error");
				}
				catch(Exception eq){
					JOptionPane.showMessageDialog(this,"Error");
		        }
				
				}	
  }
	}
  }