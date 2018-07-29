/* Update class....
 * Can Update Faculty
 *  or Student or Admin's
 *  email,ContractNo,Dept
 */
package demo1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Update extends JFrame implements ActionListener{
	
		JLabel back =new JLabel(new ImageIcon("D:\\hd_desktop_blue-1920x1200.jpg"));	
		JButton b=new JButton("Back");	
		JButton b1=new JButton("Update");	
		JLabel l= new JLabel("User Id :");	
		JLabel l3= new JLabel("** Select Your Desire field and fill that correctly");
		JLabel l2= new JLabel("Welcome to Upgration page");
		
		JTextField f=new JTextField();
		JLabel l4= new JLabel("Update :");
		JLabel l5= new JLabel("Field :");
		JTextField f1=new JTextField();
		
		    JRadioButton rb1= new JRadioButton("Email");
			JRadioButton rb2= new JRadioButton("Contract No");
			JRadioButton rb3= new JRadioButton("Department");
			
			
			ButtonGroup bg1 = new ButtonGroup();
			User u;
		
		public Update(User u)
		{
			this.u=u;
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1000,1000);
		setVisible(true);
		setLayout(null);
		setTitle("Delete Page");
		setContentPane(back);
		
		add(b);
		add(b1);
		add(l);
		add(f);
		add(l2);
		add(l3);
		add(f1);
		add(l4);
		add(l5);
		
		l2.setBounds(300,80,500,35);
		l.setBounds(100,80+35+35,100,35);
		f.setBounds(100+100+10,150,150,35);
		l3.setBounds(100,80+70+45,450,35);
		l4.setBounds(100,80+70+45+35+10,100,35);
		
		b.setBounds(80,700,100,35);
		b1.setBounds(700,700,100,35);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		
		f.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setFont(new Font("Times New Roman",Font.BOLD,30));
		l.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l3.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		f1.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		rb1.setBounds(100+100+10,80+70+45+35+10,150,35);
		rb2.setBounds(100+100+10,80+70+45+35+10+45,150,35);
		rb3.setBounds(100+100+10,80+70+45+35+10+45+45,150,35);
		
		l5.setBounds(100,80+70+45+35+10+35+10+10+45+45,100,35);
		f1.setBounds(100+100+10,80+70+45+35+10+35+10+10+45+45,300,30);

		
		add(rb1);
		add(rb2);
		add(rb3);
	
		
		rb1.setFont(new Font("Times New Roman",Font.BOLD,16));
		rb2.setFont(new Font("Times New Roman",Font.BOLD,16));
		rb3.setFont(new Font("Times New Roman",Font.BOLD,16));
		
		
		
		bg1.add(rb1);
		bg1.add(rb2);
		bg1.add(rb3);
		
		 	Color c2= Color.white;
			Color c1= Color.gray;
			b1.setForeground(c2);
			b1.setBackground(c1);
			b.setForeground(c2);
			b.setBackground(c1);  
		}
		
		public void actionPerformed(ActionEvent a){
					
			if(a.getSource()==b)
			{
				new Admin(u);
				this.setVisible(false);
			}
			
			else if(a.getSource()==b1){
				
				 String s=new String(f.getText());
				 String p=new String();
				 
				 if(rb1.isSelected()){
					 p="email";
				 }else if(rb2.isSelected()){
					 p="contractNo";
				 }else if(rb3.isSelected()){
					 p="department"; 
				 }
				 
				  if(s.length()==5||s.length()==6){
				
				String i ="UPDATE `facultyinformation` SET `"+p+"` = '"+f1.getText()+"' WHERE `facultyinformation`.`userId` = '"+f.getText()+"';";
				try
				{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate(i);
				}
				catch(SQLException g)
				{
					JOptionPane.showMessageDialog(this,"Error");
				}
				catch(Exception eq){
					JOptionPane.showMessageDialog(this,"Error");
				}
				
				new Admin(u);
				this.setVisible(false);
				
				
				  }
				  
				  else if(s.length()<=4){
					  
					  String i ="UPDATE `adminInformation` SET `"+p+"` = '"+f1.getText()+"' WHERE `adminInformation`.`userId` = '"+f.getText()+"';";
						try
						{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
						Statement stmt=con.createStatement();
						stmt.executeUpdate(i);
						}
						catch(SQLException g)
						{
							JOptionPane.showMessageDialog(this,"Error");
						}
						catch(Exception eq){
							JOptionPane.showMessageDialog(this,"Error");
						}
						
						new Admin(u);
						this.setVisible(false);
				  }
				  
				  else if(s.length()>=8){
					  
					  String i ="UPDATE `studentinformation` SET `"+p+"` = '"+f1.getText()+"' WHERE `studentinformation`.`userId` = '"+f.getText()+"';";

						try
						{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
						Statement stmt=con.createStatement();
						stmt.executeUpdate(i);
						}
						
						catch(SQLException g)
						{
							JOptionPane.showMessageDialog(this,"This Id is not there !!");
						}
						catch(Exception eq){
							JOptionPane.showMessageDialog(this,"Error");
						}
						
						new Admin(u);
						this.setVisible(false);
						
				  }
			}
		}
		
		

		
	}


