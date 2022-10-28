	import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JRadioButton;
	import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
	import javax.swing.SwingConstants;
import java.awt.Toolkit;

	public class AdPharmacist extends JFrame {

		private JTextField textId;
		private JTextField textFname;
		private JTextField textPcode;
		private JTextField textEmail;
		private JPasswordField passwordField;
		private JTextField textUname;
		private JTextField textCno;
		private JTextField textLname;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		private JTextField textGender;


		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdPharmacist ap = new AdPharmacist();
						ap.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public AdPharmacist() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("RegisterPage");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(34, 32, 1117, 713);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel RegFormlabel = new JLabel("Registration Form");
			RegFormlabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-user-3-32.png"));
			RegFormlabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			RegFormlabel.setBounds(468, 10, 296, 49);
			panel.add(RegFormlabel);
			
			JLabel IDlabel = new JLabel("Pharmacist Id :");
			IDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			IDlabel.setBounds(324, 76, 179, 31);
			panel.add(IDlabel);
			
			textId = new JTextField();
			textId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textId.setEditable(true);
			        }
			        else
			        {
			        	textId.setEditable(false);
			        }
				}
				@Override
				public void keyReleased(KeyEvent e) {
					String id=textId.getText();
					int Id=Integer.parseInt(id);
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
							
							String sql2="select * from pharmacist where ph_id="+Id+"";
							
							Statement stmt=con.createStatement();
							 ResultSet rs=stmt.executeQuery(sql2);

							 if(rs.next()) {
								 JOptionPane.showMessageDialog(null,"Duplicate  Id");
								 clearFields();
							 }
							 
							 
							con.close();
						}catch(Exception e2) {
							System.out.println("error : "+e2);
							
						}
				}
			});
			textId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textId.setColumns(10);
			textId.setBounds(518, 76, 139, 50);
			panel.add(textId);
			
			textFname = new JTextField();
			textFname.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textFname.setEditable(true);
			        }
			        else
			        {
			        	textFname.setEditable(false);
			        }
				}
			});
			textFname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textFname.setColumns(10);
			textFname.setBounds(186, 190, 285, 50);
			panel.add(textFname);
			
			JLabel FNlabel = new JLabel("First Name :");
			FNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			FNlabel.setBounds(34, 190, 139, 31);
			panel.add(FNlabel);
			
			JLabel Genderlabel = new JLabel("Gender : ");
			Genderlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			Genderlabel.setBounds(34, 255, 139, 31);
			panel.add(Genderlabel);
			
			textPcode = new JTextField();
			textPcode.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textPcode.setEditable(true);
			        }
			        else
			        {
			        	textPcode.setEditable(false);
			        }
				}
			});
			textPcode.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textPcode.setColumns(10);
			textPcode.setBounds(186, 315, 285, 50);
			panel.add(textPcode);
			
			JLabel PClabel = new JLabel("Postal Code : ");
			PClabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			PClabel.setBounds(34, 315, 139, 31);
			panel.add(PClabel);
			
			JLabel EIDlabel = new JLabel("Email ID : ");
			EIDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			EIDlabel.setBounds(34, 380, 139, 31);
			panel.add(EIDlabel);
			
			textEmail = new JTextField();
			textEmail.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textEmail.setColumns(10);
			textEmail.setBounds(186, 380, 285, 50);
			panel.add(textEmail);
			
			JLabel LNlabel = new JLabel("Last Name :");
			LNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			LNlabel.setBounds(638, 190, 139, 31);
			panel.add(LNlabel);
			
			JLabel CNlabel = new JLabel("Contact No : ");
			CNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			CNlabel.setBounds(638, 250, 139, 31);
			panel.add(CNlabel);
			
			JLabel UNlabel = new JLabel("Username : ");
			UNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			UNlabel.setBounds(640, 315, 139, 31);
			panel.add(UNlabel);
			
			JLabel passlabel = new JLabel("Password : ");
			passlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			passlabel.setBounds(638, 380, 139, 31);
			panel.add(passlabel);
			
			passwordField = new JPasswordField();
			passwordField.setEchoChar('*');
			passwordField.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			passwordField.setBounds(792, 380, 285, 50);
			panel.add(passwordField);
			
			JCheckBox checkbox = new JCheckBox("Show Password");
			checkbox.setFont(new Font("Book Antiqua", Font.BOLD, 16));
			checkbox.setBounds(802, 437, 146, 21);
			panel.add(checkbox);
			checkbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkbox.isSelected()) {
						passwordField.setEchoChar((char)0);
					}
					else
					{
						passwordField.setEchoChar(('*'));
					}
						
				}
			});
			checkbox.setBackground(new Color(255, 240, 245));
			
			textUname = new JTextField();
			textUname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textUname.setColumns(10);
			textUname.setBounds(792, 315, 285, 50);
			panel.add(textUname);
			
			textCno = new JTextField();
			textCno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					String phoneNumber = textCno.getText();
					int length = phoneNumber.length();
			        char c = e.getKeyChar();
			        
			        if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
			            if(length<10){
			                
			            	textCno.setEditable(true);
			            }else{
			            	textCno.setEditable(false);
			            }
			        }else
			        {
			            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
			            	textCno.setEditable(true);
			                
			            }else{
			            	textCno.setEditable(false);
			            }
			                
			        }
				}
			});
			textCno.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textCno.setColumns(10);
			textCno.setBounds(792, 250, 285, 50);
			panel.add(textCno);
			
			textLname = new JTextField();
			textLname.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textLname.setEditable(true);
			        }
			        else
			        {
			        	textLname.setEditable(false);
			        }
				}
			});
			textLname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textLname.setColumns(10);
			textLname.setBounds(792, 190, 285, 50);
			panel.add(textLname);
			
			JButton Regbtn = new JButton("Register");
			Regbtn.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-user-3-32.png"));
			Regbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(textFname.getText().trim().isEmpty() || textLname.getText().trim().isEmpty() || textPcode.getText().trim().isEmpty() || textCno.getText().trim().isEmpty() || textEmail.getText().trim().isEmpty() || textUname.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || textId.getText().trim().isEmpty() )
						{
							JOptionPane.showMessageDialog(null,"Please fil all fields...");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Added Successfully");
							
							AdManager aa = new AdManager();
							aa.setVisible(false);
						}
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");

							String sql="insert into pharmacist (ph_id,fname,lname,phone_no,gender,email,postal_add,uname,pswd)values(?,?,?,?,?,?,?,?,?)";
							
							 PreparedStatement pst=con.prepareStatement(sql);
							 pst.setString(1,textId.getText());
							 pst.setString(2,textFname.getText());
							 pst.setString(3,textLname.getText());
							 pst.setString(4,textCno.getText());
							 pst.setString(5,textGender.getText());
							 pst.setString(6,textEmail.getText());
							 pst.setString(7,textPcode.getText());
							 pst.setString(8,textUname.getText());
							 pst.setString(9,passwordField.getText());
							 
						 
							 pst.execute();
							 clearFields();
							con.close();
						}catch (Exception e1){
							System.out.println("error : "+e1);
						}

						clearFields();
					}
				});
			Regbtn.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			Regbtn.setFocusable(false);
			Regbtn.setBounds(490, 592, 186, 49);
			panel.add(Regbtn);
			
			textGender = new JTextField();
			textGender.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textGender.setEditable(true);
			        }
			        else
			        {
			        	textGender.setEditable(false);
			        }
				}
			});
			textGender.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textGender.setColumns(10);
			textGender.setBounds(186, 250, 285, 50);
			panel.add(textGender);
			
		}
		private void clearFields() {
			textId.setText(null);
			textFname.setText(null);
			textPcode.setText(null);
			textEmail.setText(null);
			passwordField.setText(null);
			textUname.setText(null);
			textCno.setText(null);
			textLname.setText(null);
			textGender.setText(null);
	}
	}