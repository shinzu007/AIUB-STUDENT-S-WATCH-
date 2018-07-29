/* By this student choose their 
 * faculty whose profile he want to
 * watch
 * 
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
class Cse extends JFrame implements ActionListener
{
	 JButton b= new JButton("Cancel");
	 JLabel l= new JLabel("Faculty Name's:");
	 String[] name= new String[]{};
     JComboBox<String>fa = new JComboBox<>(name); 
	 JPanel p=new JPanel();
	
     JLabel back =new JLabel(new ImageIcon("D:\\me.jpg"));
      User u;
      
	public Cse()
	{
		// adding all faculty name from database in combo box
		
		String sql="select * from facultyInformation";

		try
		{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
	    while (rs.next())
	    {       

	    	String pat = rs.getString("fullName");
	    
            fa.addItem(pat);
            fa.setEditable(false);

	    }
	    
	} catch(Exception sqe) {
	    System.out.println("SQl error");
	}
		
		
   setResizable(false);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1000,1000);
	setVisible(true);
	setLayout(null);
	setTitle("Choose Faculty");
	setContentPane(back);
	add(fa);
    fa.setBounds(400,200,350,45);
	add(b);
	b.setBounds(50,700,100,30);
	add(l);
	l.setBounds(150,200,300,45);
	l.setFont(new Font("Times New Roman",Font.BOLD,30));
	fa.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.addActionListener(this);
		fa.addActionListener(this);
		
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
	     
        Color c2= Color.white;
    	Color c1= Color.gray;
    	b.setForeground(c2);
    	b.setBackground(c1);
	
	}
	
	public Cse(User u){
		this();
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent a)
	{
		
		if(a.getSource()==b)
	    {
			Student c=new Student(u);
		    this.setVisible(false);
	    }
		else if(a.getSource()==fa){
			
			User m=new User();
			
			String item=(String)fa.getSelectedItem();
			
			String j="select * from facultyInformation where fullName='"+item+"'";
			try
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(j);
			
			while(rs.next())
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
				
				
				Information n1=new Information(m,u);
			    this.setVisible(false); 
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
	
