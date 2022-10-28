import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLP 
{
	static JLabel AIcon;
	private static JTextField EnterUsername;
	private static JPasswordField EnterPassword;
	public static void main(String[] args) 
	{
            showWindow();
	}

	public static void showWindow() {
		
		JFrame frmLoginpage=new JFrame("Admin LogIn");
		frmLoginpage.setTitle("LogInPage");
		frmLoginpage.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		AIcon=new JLabel(new ImageIcon("D:\\EJ\\PMS\\img\\admin.png"),JLabel.CENTER);
		AIcon.setBounds(590,135,313,237);
        frmLoginpage.getContentPane().add(AIcon);
		frmLoginpage.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
        frmLoginpage.setSize(1650,1080);
        frmLoginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginpage.getContentPane().setLayout(null);
        
        
        
        //Back Button
        JButton Exit=new JButton("Exit");
        Exit.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\backarr.png"));
        Exit.setFont(new Font("Book Antiqua", Font.BOLD, 25));
        Exit.setBackground(Color.WHITE);
        Exit.setBounds(629, 685, 142, 44);
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
        Username.setFont(new Font("Book Antiqua", Font.BOLD, 25));
        Username.setBounds(568, 415, 171, 32);
        frmLoginpage.getContentPane().add(Username);
        
        //For Password Label
        JLabel Password = new JLabel("Password ");
        Password.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pass.png"));
        Password.setFont(new Font("Book Antiqua", Font.BOLD, 25));
        Password.setBounds(568, 509, 174, 32);
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
        EnterPassword.setBounds(761, 506, 244, 44);
        frmLoginpage.getContentPane().add(EnterPassword);
        
        JCheckBox checkbox = new JCheckBox("Show Password");
		checkbox.setBounds(771, 556, 149, 29);
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
        Login.setFont(new Font("Book Antiqua", Font.BOLD, 25));
        Login.setBounds(796, 684, 149, 44);
        Login.setFocusable(false);
        frmLoginpage.getContentPane().add(Login);
        
        JLabel lblAdminLogin = new JLabel("Admin LogIn");
        lblAdminLogin.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-admin-32.png"));
        lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdminLogin.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 35));
        lblAdminLogin.setBackground(new Color(255, 228, 225));
        lblAdminLogin.setBounds(576, 22, 394, 67);
        frmLoginpage.getContentPane().add(lblAdminLogin);
        
      //Admin LogIn Page
        Login.addActionListener(new ActionListener(){
            @SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0)
            {
            	String un=EnterUsername.getText();
            	String ps=EnterPassword.getText();
            	
            	if(un.equals("admin") && ps.equals("123")) {
            		JOptionPane.showMessageDialog(null,"LogIn Succesfull..!");
            		
            		frmLoginpage.setVisible(false);
                    ADashb ad=new ADashb();
                    ad.showWindow();
          
            	}
            	else if(un.equals("") && ps.equals("")){
                		JOptionPane.showMessageDialog(null,"Enter Username Or Password..!");
                		
                		frmLoginpage.setVisible(false);
                        AdminLP ap=new AdminLP();
                        ap.showWindow();
                }
            	else {
            		JOptionPane.showMessageDialog(null,"Invalid Username Or Password..!");
            		
            		frmLoginpage.setVisible(false);
                    AdminLP ap=new AdminLP();
                    ap.showWindow();
            	}
                     
            }
   });    
        
         frmLoginpage.setVisible(true);
	}

}

