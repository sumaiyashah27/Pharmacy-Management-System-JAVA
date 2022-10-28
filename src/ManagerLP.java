import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class ManagerLP {
	
		static JLabel MIcon;
		static JTextField EnterUsername;
		static JPasswordField EnterPassword;
		public static void main(String[] args) 
		{
	            showWindow();
		}
		

	public static void showWindow() {
		JFrame frmLoginpage=new JFrame("Manager LogIn");
		frmLoginpage.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		frmLoginpage.setTitle("LoginPage");
		MIcon=new JLabel(new ImageIcon("D:\\EJ\\PMS\\img\\Manager.png"),JLabel.CENTER);
		MIcon.setBounds(617,135,313,237);
        frmLoginpage.getContentPane().add(MIcon);
		frmLoginpage.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
        frmLoginpage.setSize(1650,1080);
        frmLoginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginpage.getContentPane().setLayout(null);
        
        
        
        //Back Button
        JButton Exit=new JButton("Exit");
        Exit.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\backarr.png"));
        Exit.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        Exit.setBackground(Color.WHITE);
        Exit.setBounds(626, 636, 142, 44);
        Exit.setFocusable(false);
        frmLoginpage.getContentPane().add(Exit);
     
        //Action For Back to  HomePage
        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                     frmLoginpage.setVisible(false);
                     PMSHomePage hp=new PMSHomePage();
                     hp.showWindow();
            }
   });
        
        //For Username Label
        JLabel Username = new JLabel("Username ");
        Username.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\User.png"));
        Username.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        Username.setBounds(590, 415, 149, 56);
        frmLoginpage.getContentPane().add(Username);
        
        //For Password Label
        JLabel Password = new JLabel("Password ");
        Password.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pass.png"));
        Password.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        Password.setBounds(597, 523, 142, 44);
        frmLoginpage.getContentPane().add(Password);
        
        EnterUsername = new JTextField();
        EnterUsername.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        EnterUsername.setBounds(761, 421, 244, 44);
        frmLoginpage.getContentPane().add(EnterUsername);
        EnterUsername.setColumns(10);
        
        EnterPassword = new JPasswordField();
        EnterPassword.setEchoChar('*');
        EnterPassword.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        EnterPassword.setToolTipText("");
        EnterPassword.setBounds(761, 523, 244, 44);
        frmLoginpage.getContentPane().add(EnterPassword);
        
        JCheckBox checkbox = new JCheckBox("Show Password");
		checkbox.setBounds(761, 568, 149, 29);
		frmLoginpage.getContentPane().add(checkbox);
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbox.isSelected()) {
					EnterPassword.setEchoChar((char)0);
				}
				else
				{
					EnterPassword.setEchoChar(('*'));
				}
					
			}
		});
		checkbox.setFont(new Font("Book Antiqua", Font.BOLD, 16));
        
        JButton Login = new JButton("LogIn");
        Login.setBackground(Color.WHITE);
        Login.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\login-32.png"));
        Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Login.setBounds(793, 635, 130, 44);
        Login.setFocusable(false);
        frmLoginpage.getContentPane().add(Login);
        
        JLabel lblNewLabel = new JLabel("Manager LogIn");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 35));
        lblNewLabel.setBounds(491, 22, 559, 67);
        frmLoginpage.getContentPane().add(lblNewLabel);
        
      //Admin LogIn Page
        Login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
            {
            	String un=EnterUsername.getText();
            	String ps=EnterPassword.getText();
            	
            	try {
            		 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					PreparedStatement pst;
					pst=con.prepareStatement("select uname,pswd from manager where uname=? and pswd=?");
					pst.setString(1,un);
					pst.setString(2,ps);
					
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"LogIn Succesfull..!");
	            		frmLoginpage.setVisible(false);
	                    MDashb md=new MDashb();
	                    md.showWindow();
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid Username Or Password..!");
						frmLoginpage.setVisible(false);
						ManagerLP mp=new ManagerLP();
	                    mp.showWindow();
					}
            	}
            	catch(Exception e) {
            		
            		System.out.println("error : "+e);
            	}
            }
   });    
        
         frmLoginpage.setVisible(true);
	}
}
