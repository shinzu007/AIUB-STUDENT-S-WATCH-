/* Delete class....
 * Can delete Faculty
 *  or Student or Admin
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Delete extends JFrame implements ActionListener{

	JLabel back =new JLabel(new ImageIcon("D:\\hd_desktop_blue-1920x1200.jpg"));	
	JButton b=new JButton("Back");	
	JButton b1=new JButton("Delete");
	JLabel l= new JLabel("User Id :");
	JLabel l2= new JLabel("Welcome to Elemination page");
	JTextField f=new JTextField();
	User u;
	
	public Delete(User u)
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
	
	l2.setBounds(300,80,500,35);
	l.setBounds(100,80+35+35,100,35);
	f.setBounds(100+100+10,150,150,35);
	
	b.setBounds(80,700,100,35);
	b1.setBounds(700,700,100,35);
	
	b.addActionListener(this);
	b1.addActionListener(this);
	
	f.setFont(new Font("Times New Roman",Font.BOLD,20));
	l2.setFont(new Font("Times New Roman",Font.BOLD,30));
	l.setFont(new Font("Times New Roman",Font.BOLD,20));
	b.setFont(new Font("Times New Roman",Font.BOLD,20));
	b1.setFont(new Font("Times New Roman",Font.BOLD,20));
	
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
			 
			  if(s.length()==5||s.length()==6){
			String i="DELETE FROM `facultyInformation` WHERE `facultyInformation`.`userId` = \'"+f.getText()+"\'";
			String j="DELETE FROM `image` WHERE `image`.`id` = \'"+f.getText()+"\'";
			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate(i);
			stmt.executeUpdate(j);
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
				  
					String i="DELETE FROM `adminInformation` WHERE `adminInformation`.`userId` = \'"+f.getText()+"\'";
					String j="DELETE FROM `image` WHERE `image`.`id` = \'"+f.getText()+"\'";
					try
					{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
					Statement stmt=con.createStatement();
					stmt.executeUpdate(i);
					stmt.executeUpdate(j);
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
				  
				  String i="DELETE FROM `studentinformation` WHERE `studentinformation`.`userId` = \'"+f.getText()+"\'";
				  String j="DELETE FROM `image` WHERE `image`.`id` = \'"+f.getText()+"\'";

					try
					{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
					Statement stmt=con.createStatement();
					stmt.executeUpdate(i);
					stmt.executeUpdate(j);
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
