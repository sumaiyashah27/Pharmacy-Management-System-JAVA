import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PanelGenPrescpt extends JPanel {
	private JTextField textPid;
	 JTextField textCustId;
	private JTextField textPAdd;
	private JTextField textMobNo;
	JTextField textCustName;
	

	/**
	 * Create the panel.
	 */
	public PanelGenPrescpt() {
		setBackground(new Color(204, 255, 204));
		setBounds(0,0,1195, 815);
		setLayout(null);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(170, 111, 888, 635);
		add(panelJtbl);
		
		JLabel lblPrescriptionId = new JLabel("Prescription  ID :");
		lblPrescriptionId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrescriptionId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblPrescriptionId.setBounds(70, 97, 179, 59);
		panelJtbl.add(lblPrescriptionId);
		
		textPid = new JTextField();
		textPid.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textPid.setColumns(10);
		textPid.setBounds(292, 97, 166, 47);
		panelJtbl.add(textPid);
		
		JLabel lblCustomerId = new JLabel("Customer  ID :");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustomerId.setBounds(70, 185, 179, 59);
		panelJtbl.add(lblCustomerId);
		
		textCustId = new JTextField();
		textCustId.setEditable(false);
		textCustId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textCustId.setColumns(10);
		textCustId.setBounds(292, 185, 166, 47);
		panelJtbl.add(textCustId);
		
		JLabel lblPostalAdd = new JLabel("Postal Add. :");
		lblPostalAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostalAdd.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblPostalAdd.setBounds(70, 362, 179, 59);
		panelJtbl.add(lblPostalAdd);
		
		textPAdd = new JTextField();
		textPAdd.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textPAdd.setColumns(10);
		textPAdd.setBounds(292, 348, 217, 47);
		panelJtbl.add(textPAdd);
		
		JLabel lblMobileNo = new JLabel("Mobile No. :");
		lblMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNo.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMobileNo.setBounds(76, 447, 179, 59);
		panelJtbl.add(lblMobileNo);
		
		textMobNo = new JTextField();
		textMobNo.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textMobNo.setColumns(10);
		textMobNo.setBounds(298, 447, 217, 47);
		panelJtbl.add(textMobNo);
		
		JButton btnGenPrescript = new JButton("Generate Prescription");
		btnGenPrescript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPid.getText().isEmpty() && textPAdd.getText().isEmpty() && textMobNo.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null,"Field is Empty..!");
				}else {
					PhDashb phd = new PhDashb();
	            	phd.setVisible(false);
	            	
	            	String inputText=textCustId.getText();
	            	String inputText2=textCustName.getText();
	            	GenPrescription gp = new GenPrescription();
	            	gp.textCustId.setText(inputText);
	            	gp.textCustName.setText(inputText2);
					gp.setVisible(true);
				}
		            	
			}
		});
		btnGenPrescript.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\cart-70-32.png"));
		btnGenPrescript.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnGenPrescript.setFocusable(false);
		btnGenPrescript.setBounds(216, 542, 455, 64);
		panelJtbl.add(btnGenPrescript);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					PreparedStatement pst;
					pst=con.prepareStatement("select * from prescription where p_id=?");
					int Id=Integer.parseInt(textPid.getText());
					
					pst.setInt(1, Id);
					 ResultSet rs=pst.executeQuery();

					 if(rs.next()) {
						 textCustId.setText(rs.getString("cust_id"));
						 textCustName.setText(rs.getString("cust_name"));
						 textPAdd.setText(rs.getString("post_add"));
						 textMobNo.setText(rs.getString("phone_no"));

					 }
					 else {
						 JOptionPane.showMessageDialog(null,"No Data Found...!");
						 textCustId.setText("");
						 textCustName.setText("");
						 textMobNo.setText("");
						 textPAdd.setText("");
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
		btnSearch.setBounds(532, 99, 152, 41);
		panelJtbl.add(btnSearch);
		
		JLabel lblCustomerName = new JLabel("Customer  Name :");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustomerName.setBounds(70, 267, 179, 59);
		panelJtbl.add(lblCustomerName);
		
		textCustName = new JTextField();
		textCustName.setEditable(false);
		textCustName.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textCustName.setColumns(10);
		textCustName.setBounds(292, 267, 217, 47);
		panelJtbl.add(textCustName);
		
		JLabel lblGenprescpt = new JLabel("Generate Prescription");
		lblGenprescpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\cart-70-32.png"));
		lblGenprescpt.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenprescpt.setForeground(Color.BLACK);
		lblGenprescpt.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 35));
		lblGenprescpt.setBounds(420, 33, 443, 47);
		add(lblGenprescpt);
		
		
		
		setVisible(true);
	}

}
