/*Password changing page
 * student,faculty,Admin 
 * can change their password
 * by this.....
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

class Eee extends JFrame implements ActionListener
{
	 JButton b= new JButton("Save Change");
	 JButton b1= new JButton("Cancel");
	User u;
	Color c2= Color.white;
	Color c1= Color.gray;
	
	JLabel  label = new JLabel("Welcome to Password Changing Page");
    JLabel  label1 = new JLabel("Old Password");
    JLabel  label2 = new JLabel("New Password");
    JLabel  label3 = new JLabel("Confirm Password");
    JPasswordField t=new JPasswordField();
	JPasswordField t1=new JPasswordField();
	JPasswordField t2=new JPasswordField();
	
	public Eee(User u)
	{
	this.u=u;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setSize(700,700);
	setVisible(true);
	setLayout(null);
	setTitle("Changing Password");
	
	b1.setForeground(c2);
	b1.setBackground(c1);
	b.setForeground(c2);
	b.setBackground(c1);
	
	label.setBounds(70,10+30,550,40);
	label1.setBounds(50,50+24+30+30,170,40);
	label2.setBounds(50,50+40+20+24+30+30,170,40);
	label3.setBounds(50,50+40+20+40+20+24+30+30,170,40);
	
	t.setBounds(50+170+10,50+30+30+30,150,25);
	t1.setBounds(50+170+10,50+40+20+30+30+30,150,25);
	t2.setBounds(50+170+10,50+40+20+40+20+30+30+30,150,25);
	b.setBounds(30+100+10,50+40+20+40+20+50+40+30+30+30,170,40);
	b1.setBounds(30+100+10+170+50,50+40+20+40+20+50+40+30+30+30,150,40);
	
	   label.setFont(new Font("Times New Roman",Font.BOLD,30));
	   label1.setFont(new Font("Times New Roman",Font.BOLD,20));
	   label2.setFont(new Font("Times New Roman",Font.BOLD,20));
	   label3.setFont(new Font("Times New Roman",Font.BOLD,20));
	   
	   t2.setFont(new Font("Times New Roman",Font.BOLD,15));
	   t.setFont(new Font("Times New Roman",Font.BOLD,15));
	   t1.setFont(new Font("Times New Roman",Font.BOLD,15));
	   b.setFont(new Font("Times New Roman",Font.BOLD,20));
	   b1.setFont(new Font("Times New Roman",Font.BOLD,20));
	   
		b.addActionListener(this);
		b1.addActionListener(this);
		
		add(label);
		add(label1);
		add(label2);
		add(label3);
		add(t);
		add(t1);
		add(t2);
		add(b);
		add(b1);
		   
		    } 
	public void actionPerformed(ActionEvent a)
	{
		String m1=new String(u.getU());
		
		if(a.getSource()==b)
	    {	
			String p1=new String(t.getPassword());
			String p2=new String(t1.getPassword());
			String p3=new String(t2.getPassword());
			
        // get old password and match then match new password thn Update password
			
       if(m1.length()<=4)
       {
			String j="select * from adminInformation where userId='"+u.getU()+"'";

			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(j);
			
			while(rs.next())
			{		   
				String n=new String((rs.getString(4)));		
				if(n.equals(p1)){		
					if(p2.equals(p3)){

					
								
								String i ="UPDATE `adminInformation` SET `password` = '"+p2+"' WHERE `adminInformation`.`userId` = '"+u.getU()+"';";
								try
								{
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
								Statement stmt1=con1.createStatement();
								stmt1.executeUpdate(i);
								}
								catch(SQLException g)
								{
									JOptionPane.showMessageDialog(this,"Error");
								}
								catch(Exception eq){
									JOptionPane.showMessageDialog(this,"Error");
								}
					}
					else{
						JOptionPane.showMessageDialog(this,"Password  didn't match");
						Eee e =new Eee(u);
						this.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Wrong Password");
					Eee e =new Eee(u);
					this.setVisible(false);
				}
				
			}
			}
					catch(SQLException g)
					{
						JOptionPane.showMessageDialog(this,"Error");
					}
					catch(Exception eq){
						JOptionPane.showMessageDialog(this,"Error");
					}
		
			
		   this.setVisible(false);
	    } 
       
      
       
       else if(m1.length()==5||m1.length()==6)
       {
			String j="select * from facultyinformation where userId='"+u.getU()+"'";

			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(j);
			
			while(rs.next())
			{
			   
				 String n=new String((rs.getString(4)));
					
				if(n.equals(p1)){
					
					if(p2.equals(p3)){

					
								
								String i ="UPDATE `facultyinformation` SET `password` = '"+p2+"' WHERE `facultyinformation`.`userId` = '"+u.getU()+"';";
								try
								{
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
								Statement stmt1=con1.createStatement();
								stmt1.executeUpdate(i);
								}
								catch(SQLException g)
								{
									JOptionPane.showMessageDialog(this,"Error");
								}
								catch(Exception eq){
									JOptionPane.showMessageDialog(this,"Error");
								}
					}
					else{
						JOptionPane.showMessageDialog(this,"Password  didn't match");
						Eee e =new Eee(u);
						this.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Wrong Password");
					Eee e =new Eee(u);
					this.setVisible(false);
				}
				
			}
			}
					catch(SQLException g)
					{
						JOptionPane.showMessageDialog(this,"Error");
					}
					catch(Exception eq){
						JOptionPane.showMessageDialog(this,"Error");
					}
				   this.setVisible(false);
	    } 
       else if(m1.length()>=8)
       {
			String j="select * from studentinformation where userId='"+u.getU()+"'";

			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(j);
			
			while(rs.next())
			{
			   
				 String n=new String((rs.getString(4)));
					
				if(n.equals(p1)){
					
					if(p2.equals(p3)){	
								
								String i ="UPDATE `studentinformation` SET `password` = '"+p2+"' WHERE `studentinformation`.`userId` = '"+u.getU()+"';";
								try
								{
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
								Statement stmt1=con1.createStatement();
								stmt1.executeUpdate(i);
								}
								catch(SQLException g)
								{
									JOptionPane.showMessageDialog(this,"Error");
								}
								catch(Exception eq){
									JOptionPane.showMessageDialog(this,"Error");
								}
					}
					else{
						JOptionPane.showMessageDialog(this,"Password  didn't match");
						Eee e =new Eee(u);
						this.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Wrong Password");
					Eee e =new Eee(u);
					this.setVisible(false);
				}
				
			}
			}
					catch(SQLException g)
					{
						JOptionPane.showMessageDialog(this,"Error");
					}
					catch(Exception eq){
						JOptionPane.showMessageDialog(this,"Error");
					}
		
		   this.setVisible(false);
	    }
	    }
		 // After pressing cancel what happen is done there
		else if(a.getSource()==b1)
	    {
			 if(m1.length()<=4){
	
			MyAdmin c1=new MyAdmin(u);
		    this.setVisible(false);}
	     
		else if(m1.length()==5||m1.length()==6)
	       {
	    	Faculty c=new Faculty(u);
	    	this.setVisible(false);
	       }
		 else if(m1.length()>=8)
	       {
			 Student c2=new Student(u);
			 this.setVisible(false);
	       }
	}
	}
}
