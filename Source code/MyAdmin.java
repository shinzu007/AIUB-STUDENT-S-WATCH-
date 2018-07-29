/* Admin profile class,this show details of a particular Admin
 */
package demo1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

class MyAdmin extends JFrame implements ActionListener {

		JButton b1=new JButton("Go to Admin Panel");
		JLabel []l=new JLabel[20];
	    User u;
	    JLabel  label = new JLabel();

	    
		public MyAdmin(User u){ 
			
			    this.u=u;
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setResizable(false);
		        setLayout(null);
		        setVisible(true);
			    setSize(1000,1000);
			    setTitle("Admin's Profile");
			
			l[0]=new JLabel("Welcome");
			l[1]=new JLabel("Id :");
			l[2]=new JLabel("Name :");
			l[3]=new JLabel("Email :");
			l[4]=new JLabel("Gender  :");
			l[5]=new JLabel("Contract No :");
			l[6]=new JLabel("Blood group :");
			l[7]=new JLabel("DOB  :");
			
			l[10]=new JLabel(u.getF()+" "+u.getL());
			l[11]=new JLabel(u.getU());
			l[12]=new JLabel(u.getF()+" "+u.getL());
			l[13]=new JLabel(u.getE());
			l[14]=new JLabel(u.getG());
			l[15]=new JLabel(u.getC());
			l[16]=new JLabel(u.getB());
			l[17]=new JLabel(u.getD());			

			for(int i=0;i<=7;i++){
				add(l[i]);
			}
			for(int i=10;i<=17;i++){
				add(l[i]);
			}
			
			
			for(int i=0;i<=7;i++){
				l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
			}
			
			for(int i=10;i<=17;i++){
				l[i].setFont(new Font("Times New Roman",Font.BOLD,20));
			}
				
				add(b1);
				b1.setBounds(700,700+100,200,40);
				b1.addActionListener(this);

				b1.setBackground(new java.awt.Color(128, 128, 128));
				b1.setForeground(new java.awt.Color(255, 255,255 ));
				b1.setFont(new Font("Times New Roman",Font.BOLD,15));
				
				l[1].setBounds(155+27,280+15+15+10,120,30);
				l[2].setBounds(150,280+30+10+15+15+10,120,30);
				l[3].setBounds(150,280+80+15+15+10,120,30);
				l[4].setBounds(127,280+120+15+15+10,120,30);
				l[5].setBounds(93,280+160+15+15+10,120,30);
				l[6].setBounds(93,280+200+15+15+10,120,30);
				l[7].setBounds(143,280+240+15+15+10,120,30);
							
				l[10].setBounds(300+80+10,280+15,200,30);
				l[11].setBounds(155+55+10,280+15+15+10,100,30);
				l[12].setBounds(150+60+10,280+30+10+15+15+10,200,30);
				l[13].setBounds(150+60+10,280+80+15+15+10,200,30);
				l[14].setBounds(127+83+10,280+120+15+15+10,100,30);
				l[15].setBounds(93+110+10,280+160+15+15+10,150,30);
				l[16].setBounds(93+110+10,280+200+15+15+10,100,30);
				l[17].setBounds(143+60+10,280+240+15+15+10,200,30);
				
				
				 label.setBounds(350,10,250,250);   
				 add(label);
				    
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
					b1.setForeground(c2);
					b1.setBackground(c1);
					
					// image displaying
					
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
				                	
				                    JOptionPane.showMessageDialog(null, "Image is not available or not inserted");
				                    
				                }
				                }
				        
				                 catch(Exception ex){
				            	JOptionPane.showMessageDialog(null, "Error");
				            	                    }
	    }
		
		public void actionPerformed(ActionEvent a){
		  
		  if(a.getSource()==b1)
		  {
			  new Admin(u);  
			  this.setVisible(false);
		  }
		  }
	}
	
