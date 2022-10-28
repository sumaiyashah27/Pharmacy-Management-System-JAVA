

	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;
	import javax.swing.border.LineBorder;
	import java.awt.event.FocusAdapter;
	import java.awt.event.FocusEvent;
import java.awt.Toolkit;

	public class UpPrescription extends JFrame {

		private JTextField prescriptIDtxt;
		private JTextField CustIDtxt;
		private JTextField CustNmtxt;
		private JTextField Agetxt;
		private JTextField PhnNotxt;
		private JTextField PCtxt;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpPrescription up = new UpPrescription();
						up.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public UpPrescription() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("UpdatePrescription");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(20, 25, 1151, 683);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblpresID = new JLabel("Prescription ID :");
			lblpresID.setBounds(323, 138, 179, 40);
			panel.add(lblpresID);
			lblpresID.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			JLabel lblcustID = new JLabel("Customer ID :");
			lblcustID.setBounds(323, 198, 196, 40);
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
				
				});
				
			prescriptIDtxt.setBounds(512, 138, 296, 39);
			panel.add(prescriptIDtxt);
			prescriptIDtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			prescriptIDtxt.setColumns(10);
			
			CustIDtxt = new JTextField();
			CustIDtxt.setEditable(false);
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
			});
			CustIDtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			CustIDtxt.setColumns(10);
			CustIDtxt.setBounds(512, 200, 296, 40);
			panel.add(CustIDtxt);
			
			JButton btnAdddb = new JButton("Update");
			btnAdddb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			btnAdddb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(prescriptIDtxt.getText().isEmpty() || CustIDtxt.getText().isEmpty()) {
				 JOptionPane.showMessageDialog(null,"Please enter ID...!");
					}
			 else {
				 JOptionPane.showMessageDialog(null,"Prescription Record Updated...");
			 }
						
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					Statement stmt=con.createStatement();
					String query1="Update prescription set phone_no='"+PhnNotxt.getText()+"' ,post_add='"+PCtxt.getText()+"' where p_id='"+prescriptIDtxt.getText()+"'";
					
					stmt.executeUpdate(query1);
					con.close();
					clearFields();
				}catch (Exception e1){
					System.out.println("ConnectionFailed..!");
				}
				}
			});
			btnAdddb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnAdddb.setBounds(457, 538, 196, 59);
			btnAdddb.setFocusable(false);
			panel.add(btnAdddb);
			
			JLabel lblprescript = new JLabel("Update Prescription");
			lblprescript.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			lblprescript.setHorizontalAlignment(SwingConstants.CENTER);
			lblprescript.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			lblprescript.setBounds(203, 10, 676, 79);
			panel.add(lblprescript);
			
			JLabel lblCustname = new JLabel("Customer Name :");
			lblCustname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblCustname.setBounds(323, 258, 179, 40);
			panel.add(lblCustname);
			
			CustNmtxt = new JTextField();
			CustNmtxt.setEditable(false);
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
			CustNmtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			CustNmtxt.setColumns(10);
			CustNmtxt.setBounds(512, 260, 296, 40);
			panel.add(CustNmtxt);
			
			JLabel lblPhnNo = new JLabel("Phone No:");
			lblPhnNo.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblPhnNo.setBounds(323, 318, 140, 40);
			panel.add(lblPhnNo);
			
			JLabel lblpostCd = new JLabel("Postal Code:");
			lblpostCd.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblpostCd.setBounds(319, 438, 140, 40);
			panel.add(lblpostCd);
			
			JLabel lblAge = new JLabel("Age:");
			lblAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblAge.setBounds(319, 378, 179, 40);
			panel.add(lblAge);
			
			Agetxt = new JTextField();
			Agetxt.setEditable(false);
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
			Agetxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			Agetxt.setColumns(10);
			Agetxt.setBounds(512, 380, 296, 40);
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
			                PhnNotxt.setEditable(true);
			                
			            }else{
			                PhnNotxt.setEditable(false);
			            }
			                
			        }
				}
			});
			PhnNotxt.setForeground(new Color(0, 0, 0));
			PhnNotxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			PhnNotxt.setColumns(10);
			PhnNotxt.setBounds(512, 318, 296, 40);
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
			PCtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			PCtxt.setColumns(10);
			PCtxt.setBounds(512, 440, 296, 40);
			panel.add(PCtxt);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\search-9-32.png"));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from prescription where p_id=?");
						int Id=Integer.parseInt(prescriptIDtxt.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 CustIDtxt.setText(rs.getString("cust_id"));
							 CustNmtxt.setText(rs.getString("cust_name"));
							 Agetxt.setText(rs.getString("age"));
							 PhnNotxt.setText(rs.getString("phone_no"));
							 PCtxt.setText(rs.getString("post_add"));

						 }
						 else {
							 JOptionPane.showMessageDialog(null,"No Data Found...!");
							 
							 CustIDtxt.setText("");
							 CustNmtxt.setText("");
							 Agetxt.setText("");
							 PhnNotxt.setText("");
							 PCtxt.setText("");
						 }
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
				}
			});
			btnSearch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnSearch.setFocusable(false);
			btnSearch.setBounds(885, 127, 152, 41);
			panel.add(btnSearch);
			
			
		}
		private void clearFields() {
			prescriptIDtxt.setText("");
			 CustIDtxt.setText("");
			 CustNmtxt.setText("");
			 PhnNotxt.setText("");
			 PCtxt.setText("");
			 Agetxt.setText("");
			 
		}
	}