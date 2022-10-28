	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Toolkit;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.LineBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import javax.swing.ImageIcon;
	import java.awt.SystemColor;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class UpInvoice extends JFrame {

		
		private JTextField InvIDtxt;
		private JTextField PrescriptIDtxt;
		private JTextField CustIDtxt;
		private JTextField CustNametxt;
		private JTextField PhnNotxt;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpInvoice ui = new UpInvoice();
						ui.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public UpInvoice() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("UpdateInvoices");
			setBounds(0,0,1195, 768);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(20, 68, 1151, 573);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblAdInvoice = new JLabel("Update Invoices");
			lblAdInvoice.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			lblAdInvoice.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdInvoice.setFont(new Font("Sylfaen", Font.BOLD, 30));
			lblAdInvoice.setBounds(454, 10, 271, 48);
			panel.add(lblAdInvoice);
			
			JLabel lblInvID = new JLabel("Invoice ID:");
			lblInvID.setFont(new Font("Sylfaen", Font.BOLD, 22));
			lblInvID.setBounds(377, 90, 145, 35);
			panel.add(lblInvID);
			
			JLabel lblPrescriptionId = new JLabel("Prescription ID:");
			lblPrescriptionId.setFont(new Font("Sylfaen", Font.BOLD, 22));
			lblPrescriptionId.setBounds(377, 150, 161, 35);
			panel.add(lblPrescriptionId);
			
			JLabel lblCustomerId = new JLabel("Customer ID:");
			lblCustomerId.setFont(new Font("Sylfaen", Font.BOLD, 22));
			lblCustomerId.setBounds(377, 210, 145, 35);
			panel.add(lblCustomerId);
			
			JLabel lblCustomerName = new JLabel("Customer Name:");
			lblCustomerName.setFont(new Font("Sylfaen", Font.BOLD, 22));
			lblCustomerName.setBounds(377, 270, 178, 35);
			panel.add(lblCustomerName);
			
			JLabel lblPhoneNo = new JLabel("Phone No:");
			lblPhoneNo.setFont(new Font("Sylfaen", Font.BOLD, 22));
			lblPhoneNo.setBounds(377, 330, 145, 35);
			panel.add(lblPhoneNo);
			
			InvIDtxt = new JTextField();
			InvIDtxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			InvIDtxt.setForeground(new Color(0, 0, 0));
			InvIDtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c) )
			        {
			        	InvIDtxt.setEditable(true);
			        }
			        else
			        {
			        	InvIDtxt.setEditable(false);
			        }
				}
					@Override
					public void keyReleased(KeyEvent e) {
						String inv_id=InvIDtxt.getText();
						int Id=Integer.parseInt(inv_id);
							try {
								
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
								
								String sql2="select * from Invoices where inv_id="+Id+"";
								
								Statement stmt=con.createStatement();
								 ResultSet rs=stmt.executeQuery(sql2);

								 if(rs.next()) {
									 JOptionPane.showMessageDialog(null,"Duplicate Id");
									 clearFields();
								 }
								 
								 
								con.close();
							}catch(Exception e2) {
								System.out.println("error : "+e2);
								
							}
							
						}
					});

			InvIDtxt.setBounds(592, 90, 271, 35);
			panel.add(InvIDtxt);
			InvIDtxt.setColumns(10);
			
			PrescriptIDtxt = new JTextField();
			PrescriptIDtxt.setEditable(false);
			PrescriptIDtxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			PrescriptIDtxt.setForeground(new Color(0, 0, 0));
			PrescriptIDtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c) )
			        {
			        	PrescriptIDtxt.setEditable(true);
			        }
			        else
			        {
			        	PrescriptIDtxt.setEditable(false);
			        }
				}
			});
			PrescriptIDtxt.setColumns(10);
			PrescriptIDtxt.setBounds(592, 150, 271, 35);
			panel.add(PrescriptIDtxt);
			
			CustIDtxt = new JTextField();
			CustIDtxt.setEditable(false);
			CustIDtxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			CustIDtxt.setForeground(new Color(0, 0, 0));
			CustIDtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c) )
			        {
			        	CustIDtxt.setEditable(true);
			        }
			        else
			        {
			        	CustIDtxt.setEditable(false);
			        }
				}
			});
			CustIDtxt.setColumns(10);
			CustIDtxt.setBounds(592, 210, 271, 35);
			panel.add(CustIDtxt);
			
			CustNametxt = new JTextField();
			CustNametxt.setEditable(false);
			CustNametxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			CustNametxt.setForeground(new Color(0, 0, 0));
			CustNametxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) )
			        {
			        	CustNametxt.setEditable(true);
			        }
			        else
			        {
			        	CustNametxt.setEditable(false);
			        }
				}
			});
			CustNametxt.setColumns(10);
			CustNametxt.setBounds(592, 270, 271, 35);
			panel.add(CustNametxt);
			
			PhnNotxt = new JTextField();
			PhnNotxt.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
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

			PhnNotxt.setColumns(10);
			PhnNotxt.setBounds(592, 330, 271, 35);
			panel.add(PhnNotxt);
			
			JButton Addbtn = new JButton("Update");
			Addbtn.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			Addbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(PrescriptIDtxt.getText().isEmpty() || CustIDtxt.getText().isEmpty() || InvIDtxt.getText().isEmpty() || PhnNotxt.getText().isEmpty()
								|| CustNametxt.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null,"Please fill all details...!");
							}
					 else {
						 JOptionPane.showMessageDialog(null,"Invoice Record Updated");
					 }
								
							try {
								
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
								
								String query1="update Invoice set phoneno=?  where inv_id=?";
								PreparedStatement pst1=con.prepareStatement(query1);
								pst1.setString(1,PhnNotxt.getText());
								pst1.setString(2,InvIDtxt.getText());
								pst1.execute();
								 
								 
								 clearFields();
								con.close();
								
							}catch (Exception e1){
								System.out.println("error : "+e1);
							}
						}
			});
			Addbtn.setVerticalAlignment(SwingConstants.BOTTOM);
			Addbtn.setFont(new Font("Sylfaen", Font.BOLD, 22));
			Addbtn.setBounds(564, 447, 161, 48);
			Addbtn.setFocusable(false);
			panel.add(Addbtn);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from Invoice where inv_id=?");
						int Id=Integer.parseInt(InvIDtxt.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 PrescriptIDtxt.setText(rs.getString("p_id"));
							 CustIDtxt.setText(rs.getString("cust_id"));
							 CustNametxt.setText(rs.getString("cust_name"));
							 PhnNotxt.setText(rs.getString("phoneno"));
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"No Data Found...!");
							 PrescriptIDtxt.setText("");
							 CustIDtxt.setText("");
							 CustNametxt.setText("");
							 PhnNotxt.setText("");
						 }
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
				}
			});
			btnSearch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\search-9-32.png"));
			btnSearch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnSearch.setFocusable(false);
			btnSearch.setBounds(920, 144, 152, 41);
			panel.add(btnSearch);
		}
		public void clearFields() {
			
		InvIDtxt.setText("");
		PrescriptIDtxt.setText("");
		CustIDtxt.setText("");
		CustNametxt.setText("");
		PhnNotxt.setText("");
		}
	}