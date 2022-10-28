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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpSales extends JFrame {

	
	private JTextField InvIDtxt;
	private JTextField PrescriptIDtxt;
	private JTextField CustIDtxt;
	private JTextField CustNametxt;
	private JTextField textTSales;
	private JTextField textStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpSales up = new UpSales();
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
	public UpSales() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("UpdateSales");
		setBounds(0,0,1195, 768);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Connection con = con1();
				try {
					String query="select sum(total) from CustSales where cust_id='"+CustIDtxt.getText()+"'";
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						if(rs.next()) {
							String sum=rs.getString("sum(total)");
							textTSales.setText(sum);
						}
						
						rs.close();
						st.close();
						con.close();
						
						
					}catch (Exception e1) {
						System.out.println("error : "+e1);
					}
			}
		});
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(20, 25, 1151, 678);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdInvoice = new JLabel("Update Sales");
		lblAdInvoice.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		lblAdInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdInvoice.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblAdInvoice.setBounds(512, 10, 271, 48);
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
		
		JLabel lblTSales = new JLabel("Total:");
		lblTSales.setFont(new Font("Sylfaen", Font.BOLD, 22));
		lblTSales.setBounds(377, 330, 145, 35);
		panel.add(lblTSales);
		
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
				});

		InvIDtxt.setBounds(592, 90, 130, 35);
		panel.add(InvIDtxt);
		InvIDtxt.setColumns(10);
		
		PrescriptIDtxt = new JTextField();
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
		PrescriptIDtxt.setBounds(592, 150, 130, 35);
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
		CustIDtxt.setBounds(592, 210, 130, 35);
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
		
		textTSales = new JTextField();
		textTSales.setEditable(false);
		textTSales.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textTSales.setForeground(new Color(0, 0, 0));
		textTSales.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String phoneNumber = textTSales.getText();
				int length = phoneNumber.length();
		        char c = e.getKeyChar();
		        
		        if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
		            if(length<10){
		                
		                textTSales.setEditable(true);
		            }else{
		                textTSales.setEditable(false);
		            }
		        }else
		        {
		            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
		                textTSales.setEditable(true);
		                
		            }else{
		                textTSales.setEditable(false);
		            }
		                
		        }
			}
		});

		textTSales.setColumns(10);
		textTSales.setBounds(592, 330, 139, 35);
		panel.add(textTSales);
		
		JButton Addbtn = new JButton("Update");
		Addbtn.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		Addbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(PrescriptIDtxt.getText().isEmpty() || CustIDtxt.getText().isEmpty() || InvIDtxt.getText().isEmpty() || textTSales.getText().isEmpty()
							|| CustNametxt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null,"Please fill all details...!");
						}
				 else {
					 JOptionPane.showMessageDialog(null,"Sales Record Updated");
				 }
							
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						String query1="update SalesReport set Status=?  where inv_id=?";
						PreparedStatement pst1=con.prepareStatement(query1);
						pst1.setString(1,textStatus.getText());
						pst1.setString(2,InvIDtxt.getText());
						pst1.execute();
						
						String query2="update Invoice set Status=?  where inv_id=?";
						PreparedStatement pst2=con.prepareStatement(query2);
						pst2.setString(1,textStatus.getText());
						pst2.setString(2,InvIDtxt.getText());
						pst2.execute();
						
						 
						 
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
				if(InvIDtxt.getText().isEmpty() ) {
				 JOptionPane.showMessageDialog(null,"Please Enter Invoice ID...!");
					}
				
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
						 textStatus.setText(rs.getString("Status"));
					 }
					 else {
						 JOptionPane.showMessageDialog(null,"No Data Found...!");
						 InvIDtxt.setText("");
						 PrescriptIDtxt.setText("");
						 CustIDtxt.setText("");
						 CustNametxt.setText("");
						 textStatus.setText("");
						
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
		btnSearch.setBounds(793, 90, 152, 41);
		panel.add(btnSearch);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("Book Antiqua", Font.BOLD, 22));
		lblStatus.setBounds(377, 388, 145, 35);
		panel.add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setForeground(Color.BLACK);
		textStatus.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textStatus.setColumns(10);
		textStatus.setBounds(592, 388, 271, 35);
		panel.add(textStatus);
	}
	public void clearFields() {
		
	InvIDtxt.setText("");
	PrescriptIDtxt.setText("");
	CustIDtxt.setText("");
	CustNametxt.setText("");
	textTSales.setText("");
	textStatus.setText("");
	}
	static Connection con1() {
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/pms";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","Sum@iy@27");
			
		}catch (Exception e) {
			System.out.println("ConnectionFailed..!");
		}
		return null;
		
	}
}