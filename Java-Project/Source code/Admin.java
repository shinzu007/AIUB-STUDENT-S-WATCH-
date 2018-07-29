/* Admin panel page... 
 * From this page Admin can add new student,Faculty,Admin
 * Can update and and delete any student or Faculty or Admin
 * Also view profiles of them
 */
package demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Admin extends JFrame implements ActionListener{
	  
	  User u;

	  JButton b=new JButton("Back");
	  JButton b1=new JButton("Add Student");
	  JButton b2=new JButton("Add Faculty");
	  JButton b3=new JButton("Add Admin");
	  
	  JButton b4=new JButton("Delete ");
	  JButton b5=new JButton(" Update");
	  
	  JLabel back =new JLabel(new ImageIcon("D:\\me.jpg"));
	  JLabel l1=new JLabel("Welcome To Admin panel");
	  JLabel l2=new JLabel("N/B: Remember this system mostly depends on your Responsibility");
      JLabel l3=new JLabel("User Id :");
      JTextField t=new JTextField();
      JButton b6=new JButton("View Profile");
      
	
      
      public Admin(User u)
	    {
		this.u=u;
		
		    setContentPane(back);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(false);
	        setLayout(null);
	        setVisible(true);
		    setSize(1000,1000);
		    
			add(l1);
			add(l2);
			setTitle("Administator");
			l1.setBounds(300,20,500,30);
			l2.setBounds(100,50+30,700,30);
			l1.setFont(new Font("Times New Roman",Font.BOLD,30));
			l2.setFont(new Font("Times New Roman",Font.BOLD,20));
			l3.setFont(new Font("Times New Roman",Font.BOLD,20));
			t.setFont(new Font("Times New Roman",Font.BOLD,20));
			b1.setFont(new Font("Times New Roman",Font.BOLD,15));
			b2.setFont(new Font("Times New Roman",Font.BOLD,15));
			b3.setFont(new Font("Times New Roman",Font.BOLD,15));
			b4.setFont(new Font("Times New Roman",Font.BOLD,15));
			b5.setFont(new Font("Times New Roman",Font.BOLD,15));
			b6.setFont(new Font("Times New Roman",Font.BOLD,15));
			add(b);
			b.setBounds(50,700,100,40);
			b.addActionListener(this);
			
			add(b1);
			b1.setBounds(100,200,150,40);
			b1.addActionListener(this);
			
			add(b2);
			b2.setBounds(100,200+40+15,150,40);
			b2.addActionListener(this);
			
			add(b3);
			b3.setBounds(100,250+60,150,40);
			b3.addActionListener(this);
			
			add(b4);
			b4.setBounds(100,250+60+60,150,40);
			b4.addActionListener(this);
			
			add(b5);
			b5.setBounds(100,250+60+120,150,40);
			b5.addActionListener(this);
	
			add(l3);
			add(t);
			add(b6);
			
			l3.setBounds(500,200,100,35);
			t.setBounds(500+100+10,200,200,30);
			b6.setBounds(650,200+35+20,120,35);
			b6.addActionListener(this);
			
			// Button coloring
					Color c2= Color.white;
					Color c1= Color.gray;
				
					b1.setForeground(c2);
					b1.setBackground(c1);
					b.setForeground(c2);
					b.setBackground(c1);  
			
					b2.setForeground(c2);
					b2.setBackground(c1);
					b3.setForeground(c2);
					b3.setBackground(c1);  
					
					b4.setForeground(c2);
					b4.setBackground(c1);
					b5.setForeground(c2);
					b5.setBackground(c1);
					b6.setForeground(c2);
					b6.setBackground(c1);

					// Menu Bar
					
			JMenuBar menubar = new JMenuBar();
	        ImageIcon iconNew = new ImageIcon("Change password.png");
	        
	        ImageIcon iconExit = new ImageIcon("exit.png");
	        ImageIcon iconNew1 = new ImageIcon("Log Out.png");

	        JMenu fileMenu = new JMenu("Option");

	        JMenuItem newMi = new JMenuItem("Change password", iconNew);
	        JMenuItem newMi1 = new JMenuItem("Log Out", iconNew1);
	        
	        fileMenu.setFont(new Font("Times New Roman",Font.BOLD,20));
	        newMi.setFont(new Font("Times New Roman",Font.BOLD,15));
	        newMi1.setFont(new Font("Times New Roman",Font.BOLD,15));
	        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
	        exitMi.setToolTipText("Exit application");

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

	        fileMenu.add(newMi);	       
	        fileMenu.addSeparator();
	        fileMenu.add(newMi1);
	        fileMenu.addSeparator();
	        fileMenu.add(exitMi);
	        menubar.add(fileMenu);
	        setJMenuBar(menubar);
	        
	        fileMenu.setForeground (Color.black);
	        newMi.setBackground (Color.blue);
	        newMi.setForeground (Color.white);
	        exitMi.setBackground (Color.red);
	        exitMi.setForeground (Color.white);
	        newMi1.setBackground (Color.blue);
	        newMi1.setForeground (Color.white);
	    }
	
	  
		public void actionPerformed(ActionEvent a)
		{
			
		  if(a.getSource()==b)
		  {	
			  new MyAdmin(u);
			this.setVisible(false);
		  }
		  else if(a.getSource()==b1)
		  {	
			 new Registations(u);
			 this.setVisible(false);
		  }
		  else if(a.getSource()==b2)
		  {	
			 new Registationf(u);
			 this.setVisible(false);
		  }
		  else if(a.getSource()==b3)
		  {	
			 new Registationa(u);
			 this.setVisible(false);
		  }
		  else if(a.getSource()==b4)
		  {	
			 new Delete(u);
			 this.setVisible(false);
		  }
		  else if(a.getSource()==b5)
		  {	
			 new Update(u);
			 this.setVisible(false);
		  }
		  
		  // view Profile
		  
		  if(a.getSource()==b6)
		  {
			  User m=new User();
			  
			  String s=new String(t.getText());
			  if(s.length()==5||s.length()==6){
			String j="select * from facultyInformation where userId='"+t.getText()+"'";

			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(j);
			
			if(rs.next())
			{ 
					
				m.setF(rs.getString("firstName"));
				m.setL(rs.getString(3));
				m.setU(rs.getString(1));
				m.setE(rs.getString(5));
				m.setC(rs.getString(7));
				m.setG(rs.getString(6));
				m.setB(rs.getString(8));			
				m.setD(rs.getString(9));
				m.setDp(rs.getString(10));
				m.setS(rs.getString(11));
				InformationForAdmin f=new InformationForAdmin(m,u); 
				 this.setVisible(false);
			 
				 }
				 else
				 {
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
				  
					String j="select * from adminInformation where userId='"+t.getText()+"'";

					try
					{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(j);
					
					if(rs.next())
					{
					 
						 
						    m.setF(rs.getString(2));
							m.setL(rs.getString(3));
							m.setU(rs.getString(1));
							m.setE(rs.getString(5));
							m.setC(rs.getString(7));
							m.setG(rs.getString(6));
							m.setB(rs.getString(8));			
							m.setD(rs.getString(9));
							m.setDp(rs.getString(10));

							InformationForAdmin n=new InformationForAdmin(m,u); 		
							 this.setVisible(false); 
						 }
						 else
						 {
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
				  
					String j="select * from studentInformation where userId='"+t.getText()+"'";

					try
					{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(j);
					
					if(rs.next())
					{
					
						 m.setF(rs.getString(2));
							m.setL(rs.getString(3));
							m.setU(rs.getString(1));
							m.setE(rs.getString(5));
							m.setC(rs.getString(7));
							m.setG(rs.getString(6));
							m.setB(rs.getString(8));			
							m.setD(rs.getString(9));
							m.setDp(rs.getString(10));
							m.setS(rs.getString(11));
	
							InformationForAdmin m2=new InformationForAdmin(m,u); 
							  this.setVisible(false);
						 }
						 else
						 {
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
	
