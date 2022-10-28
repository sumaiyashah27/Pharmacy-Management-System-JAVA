import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class AdPrescription extends JFrame {

	private JTextField prescriptIDtxt;
	private JTextField CustIDtxt;
	private JTextField CustNmtxt;
	private JTextField Agetxt;
	private JTextField PhnNotxt;
	private JTextField PCtxt;
	private JTextField textGender;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdPrescription ap = new AdPrescription();
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
	public AdPrescription() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("AddPrescription");
		setBounds(0,0,1195, 581);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(20, 25, 1151, 488);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblpresID = new JLabel("Prescription ID :");
		lblpresID.setBounds(48, 110, 179, 40);
		panel.add(lblpresID);
		lblpresID.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		
		JLabel lblcustID = new JLabel("Customer ID :");
		lblcustID.setBounds(48, 170, 196, 40);
		panel.add(lblcustID);
		lblcustID.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		
		prescriptIDtxt = new JTextField();
		prescriptIDtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int c = e.getKeyChar();
		        if(Character.isDigit(c)|| Character.isISOControl(c))
		        {
		        	prescriptIDtxt.setEditable(true);
		        }
		        else
		        {
		        	prescriptIDtxt.setEditable(false);
		        }
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String id=prescriptIDtxt.getText();
				int Id=Integer.parseInt(id);
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						String sql2="select * from prescription where p_id="+Id+"";
						
						Statement stmt=con.createStatement();
						 ResultSet rs=stmt.executeQuery(sql2);

						 if(rs.next()) {
							 JOptionPane.showMessageDialog(null,"Duplicate Prescription Id");
							 clearFields();
						 }
						 
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
					
				}
			});
			
		prescriptIDtxt.setBounds(237, 110, 296, 39);
		panel.add(prescriptIDtxt);
		prescriptIDtxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		prescriptIDtxt.setColumns(10);
		
		CustIDtxt = new JTextField();
		CustIDtxt.addKeyListener(new KeyAdapter() {
			@Override	
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				 if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	CustIDtxt.setEditable(true);
			        }
			        else
			        {
			        	CustIDtxt.setEditable(false);
			        }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String id=CustIDtxt.getText();
				int Id=Integer.parseInt(id);
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						String sql2="select * from prescription where cust_id="+Id+"";
						
						Statement stmt=con.createStatement();
						 ResultSet rs=stmt.executeQuery(sql2);

						 if(rs.next()) {
							 JOptionPane.showMessageDialog(null,"Duplicate Customer Id");
							 clearFields();
						 }
						 
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
			}
		});
		CustIDtxt.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		CustIDtxt.setColumns(10);
		CustIDtxt.setBounds(237, 172, 296, 40);
		panel.add(CustIDtxt);
		
		JButton btnAdddb = new JButton("Add");
		btnAdddb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
		btnAdddb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(prescriptIDtxt.getText().isEmpty() || CustIDtxt.getText().isEmpty() || PCtxt.getText().isEmpty() || PhnNotxt.getText().isEmpty()
					|| CustNmtxt.getText().isEmpty()	|| textGender.getText().isEmpty() || Agetxt.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null,"Please fill all details...!");
				}
		 else {
			 JOptionPane.showMessageDialog(null,"Prescription Record Inserted");
		 }
					
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");

					String sql="insert into prescription (p_id,cust_id,cust_name,phone_no,post_add,age,gender)values(?,?,?,?,?,?,?)";
					
					 PreparedStatement pst=con.prepareStatement(sql);
					 pst.setString(1,prescriptIDtxt.getText());
					 pst.setString(2,CustIDtxt.getText());
					 pst.setString(3,CustNmtxt.getText());
					 pst.setString(4,PhnNotxt.getText());
					 pst.setString(5,PCtxt.getText());
					 pst.setString(6,Agetxt.getText());
					 pst.setNString(7,textGender.getText());
				 
					 pst.execute();
					con.close();
					clearFields();
				}catch (Exception e1){
					System.out.println("error : "+e1);
				}
			}
		});
		btnAdddb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdddb.setBounds(474, 380, 196, 59);
		btnAdddb.setFocusable(false);
		panel.add(btnAdddb);
		
		JLabel lblprescript = new JLabel("Add Prescription");
		lblprescript.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
		lblprescript.setHorizontalAlignment(SwingConstants.CENTER);
		lblprescript.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		lblprescript.setBounds(203, 10, 676, 98);
		panel.add(lblprescript);
		
		JLabel lblCustname = new JLabel("Customer Name :");
		lblCustname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustname.setBounds(48, 230, 179, 40);
		panel.add(lblCustname);
		
		CustNmtxt = new JTextField();
		CustNmtxt.addKeyListener(new KeyAdapter() {
			@Override	
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
		        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
		        {
		        	CustNmtxt.setEditable(true);
		        }
		        else
		        {
		        	CustNmtxt.setEditable(false);
		        }
			}
		});
		CustNmtxt.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		CustNmtxt.setColumns(10);
		CustNmtxt.setBounds(237, 232, 296, 40);
		panel.add(CustNmtxt);
		
		JLabel lblPhnNo = new JLabel("Phone No:");
		lblPhnNo.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblPhnNo.setBounds(631, 110, 140, 40);
		panel.add(lblPhnNo);
		
		JLabel lblpostCd = new JLabel("Postal Code:");
		lblpostCd.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblpostCd.setBounds(631, 170, 140, 40);
		panel.add(lblpostCd);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblAge.setBounds(48, 290, 179, 40);
		panel.add(lblAge);
		
		Agetxt = new JTextField();
		Agetxt.addKeyListener(new KeyAdapter() {
			@Override	
			public void keyPressed(KeyEvent e) {
				int c = e.getKeyChar();
		        if(Character.isDigit(c)|| Character.isISOControl(c))
		        {
		        	Agetxt.setEditable(true);
		        }
		        else
		        {
		        	Agetxt.setEditable(false);
		        }
			}
		});
		Agetxt.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		Agetxt.setColumns(10);
		Agetxt.setBounds(237, 290, 296, 40);
		panel.add(Agetxt);
		
		PhnNotxt = new JTextField();
		PhnNotxt.setForeground(new Color(0, 0, 0));
		PhnNotxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String phoneNumber = PhnNotxt.getText();
				int length = phoneNumber.length();
		        char c = e.getKeyChar();
		        
		        if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
		            if(length<10){
		                
		                PhnNotxt.setEditable(true);
		            }else{
		                PhnNotxt.setEditable(false);
		            }
		        }else
		        {
		            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
		                PhnNotxt.setEditable(false);
		                
		            }else{
		                PhnNotxt.setEditable(true);
		            }
		                
		        }
			}
		});
		PhnNotxt.setForeground(new Color(0, 0, 0));
		PhnNotxt.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		PhnNotxt.setColumns(10);
		PhnNotxt.setBounds(793, 110, 296, 40);
		panel.add(PhnNotxt);
		
		PCtxt = new JTextField();
		PCtxt.setForeground(new Color(0, 0, 0));
		PCtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
		        if(Character.isDigit(c)|| Character.isWhitespace(c) )
		        {
		        	PCtxt.setEditable(true);
		        }
		        else
		        {
		        	PCtxt.setEditable(false);
		        }
			}
		});
		PCtxt.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		PCtxt.setColumns(10);
		PCtxt.setBounds(793, 172, 296, 40);
		panel.add(PCtxt);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblGender.setBounds(631, 230, 140, 40);
		panel.add(lblGender);
		
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
		textGender.setBounds(793, 231, 296, 40);
		panel.add(textGender);
		
		
	}
	private void clearFields() {
		prescriptIDtxt.setText("");
		 CustIDtxt.setText("");
		 CustNmtxt.setText("");
		 PhnNotxt.setText("");
		 PCtxt.setText("");
		 Agetxt.setText("");
		 textGender.setText("");
		 
	}
}