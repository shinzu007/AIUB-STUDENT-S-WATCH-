/* Student Registration Page.....
 * Adding new Student by this 
 */
package demo1;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalIconFactory;

class Registations extends JFrame implements ActionListener {


	    Icon warnIcon = MetalIconFactory.getTreeComputerIcon();
	    JLabel label = new JLabel(warnIcon);
	    JButton button2 = new JButton("Browse");
	    String s;  
	    Border border = LineBorder.createGrayLineBorder();	
	    JLabel l[]=new JLabel[18];
	    JLabel back =new JLabel(new ImageIcon("D:\\me.jpg"));
	    Color c2=Color.RED;
	
	String[] a=new String[]{"CSE","CSSE","BBA","ENG","EEE","ARCH","CS"};
	JComboBox<String> dep = new JComboBox<>(a);
	String[] c=new String[]{"O+","O-","A+","A-","B+","B-","AB+","AB-"};
	JComboBox<String> grp = new JComboBox<>(c);
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	
	JPasswordField t4=new JPasswordField();
	JPasswordField t5=new JPasswordField();
	JRadioButton rb1= new JRadioButton("Male");
	JRadioButton rb2= new JRadioButton("Female");
	ButtonGroup bg1 = new ButtonGroup();
	String[] year= new String[]{"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983","1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970","1969","1968","1967"};
	String[] mon= new String[]{"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
	String[] date=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox<String> yearList = new JComboBox<>(year);
	JComboBox<String> monList= new JComboBox<>(mon);
	JComboBox<String> dateList= new JComboBox<>(date);
	
	JTextField t6=new JTextField();
	JTextField t7=new JTextField("N/A");
	JTextField t8=new JTextField();
	JTextField t9=new JTextField();
	JTextField t13=new JTextField("Can Donate this month");
	JRadioButton rb3= new JRadioButton("Faculty");
	JRadioButton rb4= new JRadioButton("Student");
	JRadioButton rb5= new JRadioButton("Admin");
	ButtonGroup bg2 = new ButtonGroup();
	
	JButton b1=new JButton("Cancle");
	JButton b2=new JButton("Submit");
	User m;
	
	public Registations(User m){
		
		this.m=m;
		setTitle("Student Registation Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(1200,1000);
		setLayout(null);
		
		b2.setForeground(c2);
		setContentPane(back);
		l[0]=new JLabel("First Name");
		l[1]=new JLabel("Last Name");
		l[2]=new JLabel("UserId");
		l[3]=new JLabel("Password");
		l[4]=new JLabel("Confirm Password");
		l[5] = new JLabel("Gender");
		l[6] = new JLabel("Date of Birth");
		l[7]=new JLabel("Email");
		l[8]=new JLabel("Contact No");
		l[9]= new JLabel("Blood Group");
		l[10]= new JLabel("Welcome to Student Registation Page");
		l[12]= new JLabel("Department");
		l[13]= new JLabel("Blood Status");
	    l[11]= new JLabel("**( ID must be 8-12 Characters )");
		
		l[0].setBounds(210,100,150,35);
		l[1].setBounds(210,150,150,35);
		l[2].setBounds(210,200,150,35);
		l[3].setBounds(210,250+35,150,35);
		l[4].setBounds(210,300+35,170,35);
		l[5].setBounds(210,350+35,150,35);
		rb1.setBounds(210+150+20+37,350+35,100,35);
		rb2.setBounds(210+150+20+100+20+37,350+35,95,35);
		l[6].setBounds(210,400+35,150,35);
		yearList.setBounds(210+150+30+30,400+35,60,35);
		monList.setBounds(210+150+30+60+30,400+35,60,35);
		dateList.setBounds(210+150+30+60+60+30,400+35,60,35);
		bg1.add(rb1);
		bg1.add(rb2);
		l[7].setBounds(210,450+35,150,35);
		l[8].setBounds(210,500+35,150,35);
		l[9].setBounds(210,550+35,150,35);
		l[10].setBounds(250,30,600,35);
		l[11].setBounds(210+150+30+10,200+30,300,35);
		l[12].setBounds(210,600+35,150,35);
		l[13].setBounds(210,650+35,150,35);
		
		for(int i=0;i<=10;i++){
		  
			add(l[i]);
		}
		
	    add(l[11]);
	    add(l[12]);
	    add(l[13]);
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
		add(rb5);
		add(yearList);
		add(dateList);
		add(monList);
		t1.setBounds(210+150+30+30,100,200,28);
		t2.setBounds(210+150+30+30,150,200,28);
		t3.setBounds(210+150+30+30,200,200,28);
		t4.setBounds(210+150+30+30,250+35,200,28);
		t5.setBounds(210+150+30+30,300+35,200,28);
		t6.setBounds(210+150+30+30,450+35,200,28);
		t7.setBounds(210+150+30+30,500+35,200,28);
		grp.setBounds(210+150+30+30,550+35,200,28);
		dep.setBounds(210+150+30+30,600+35,200,28);
		t13.setBounds(210+150+30+30,650+35,200,28);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(grp);
		add(dep);
		add(t13);
		b1.setBounds(125+40,800,100,35);
		b2.setBounds(350+450+50,800,130,35);
		add(b1);
		add(b2);
		
		t1.setFont(new Font("Times New Roman",Font.BOLD,15));
		t2.setFont(new Font("Times New Roman",Font.BOLD,15));
		t3.setFont(new Font("Times New Roman",Font.BOLD,15));
		t4.setFont(new Font("Times New Roman",Font.BOLD,15));
		t5.setFont(new Font("Times New Roman",Font.BOLD,15));
		t6.setFont(new Font("Times New Roman",Font.BOLD,15));
		t7.setFont(new Font("Times New Roman",Font.BOLD,15));
		grp.setFont(new Font("Times New Roman",Font.BOLD,15));
		dep.setFont(new Font("Times New Roman",Font.BOLD,15));
		t13.setFont(new Font("Times New Roman",Font.BOLD,15));
		for(int i=0;i<=9;i++){
			  
			l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
		}
		
		rb1.setFont(new Font("Times New Roman",Font.BOLD,20));
		rb2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l[10].setFont(new Font("Times New Roman",Font.BOLD,30));
	    l[11].setFont(new Font("Times New Roman",Font.BOLD,15));
	    l[12].setFont(new Font("Times New Roman",Font.BOLD,20));
	    l[13].setFont(new Font("Times New Roman",Font.BOLD,20));
		b1.addActionListener(this);
		b2.addActionListener(this);
		grp.setForeground(Color.red);
	    label.setBorder(border);  	    
		button2.setBounds(350+450+50,340,130,30);   
	    add(button2);	  
	    add(label);
	    label.setBounds(800,50,250,250); 
		  
		    Color c2= Color.white;
			Color c1= Color.GRAY;
			b1.setForeground(c2);
			b1.setBackground(c1);
			button2.setForeground(c2);
			button2.setBackground(c1);  
			b2.setForeground(c2);
			b2.setBackground(c1);
			
		    //button to browse the image into label
			
		    button2.addActionListener(new ActionListener(){
		        @Override
		     public void actionPerformed(ActionEvent e){
		         JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             label.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
		     }
		    });
		
	}
	
// Method To Resize The ImageIcon
	
	  public ImageIcon ResizeImage(String imgPath){
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }
	
	
	
	public void actionPerformed(ActionEvent a){
		String p1=new String(t4.getPassword());
		String p2=new String(t5.getPassword());
		String ui=t3.getText();
		String bl=" ";
		String item=(String)dep.getSelectedItem();
		String item2=(String)grp.getSelectedItem();
		if(a.getSource()==b2){
			if(t1.getText().isEmpty()||t2.getText().isEmpty()||t6.getText().isEmpty()||t7.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"All Fields Must Be Filled");}
			else
			{
			if(ui.length()==9||ui.length()==10||ui.length()==11||ui.length()==12||ui.length()==8){
			if(p1.equals(p2)){
				
				User u= new User();
				u.setF(t1.getText());
				u.setL(t2.getText());
				u.setU(t3.getText());
				u.setP(new String(t4.getPassword()));
				u.setE(t6.getText());
				u.setC(t7.getText());
				if(rb1.isSelected()){
					u.setG(rb1.getText());
				}else{
					u.setG(rb2.getText());	
				}
				u.setB(item2);
				u.setDp(item);
				u.setS(t13.getText());
				u.setD(yearList.getSelectedItem().toString(),monList.getSelectedItem().toString(),dateList.getSelectedItem().toString());
				
				String dsql="INSERT INTO `studentinformation` (`userId`, `firstName`, `lastName`, `password`, `email`, `gender`, `contractNo`,`bloodGroup`, `dateOfBirth`,`department`,`bloodstatus`) VALUES ('"+u.getU()+"', '"+u.getF()+"', '"+u.getL()+"', '"+u.getP()+"', '"+u.getE()+"', '"+u.getG()+"', '"+u.getC()+"', '"+u.getB()+"', '"+u.getD()+"', '"+u.getDp()+"', '"+u.getS()+"')";
				try{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
					Statement stmt=con.createStatement();
					stmt.executeUpdate(dsql);
					
				}
				catch(SQLException g){
					JOptionPane.showMessageDialog(this,"Id Is not available Change the Id");
					
				}
				catch(Exception eq){
					JOptionPane.showMessageDialog(this,"Error");
				
				}
				try{
		        	   Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
		               PreparedStatement ps = con.prepareStatement("insert into image(id,name,image) values(?,?,?)");
		               InputStream is = new FileInputStream(new File(s));
		               ps.setString(1,t3.getText());
		               ps.setString(2, t1.getText()+" "+t2.getText());
		               ps.setBlob(3,is);
		               ps.executeUpdate();
		               JOptionPane.showMessageDialog(null, "Data Inserted");
		           }catch(Exception ex){
		               JOptionPane.showMessageDialog(null, "Error");
		           }
				
				this.setVisible(false);
				Login log= new Login();
				
			}else{
				JOptionPane.showMessageDialog(this,"Passwords Didn't Match");
			}
			}
			
			else{
				JOptionPane.showMessageDialog(this,"Faculty Id must be 9-12 characters");
			}
			}	
		}
		else{
			setVisible(false);
			new Admin(m);
		}
	
	}
}