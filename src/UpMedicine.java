

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

	public class UpMedicine extends JFrame {

		private JTextField textMedId;
		private JTextField textMedNm;
		private JTextField txtMedDescp;
		private JTextField textFieldStats;
		private JTextField textFieldMFG;
		private JTextField textFieldEXP;
		private JTextField textUnit;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpMedicine um = new UpMedicine();
						um.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public UpMedicine() {
			setTitle("UpdateMedicine");
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(47, 43, 1086, 686);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblMedId = new JLabel("Medicine ID :");
			lblMedId.setBounds(243, 104, 179, 42);
			panel.add(lblMedId);
			lblMedId.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			JLabel lblMedName = new JLabel("Medicine Name :");
			lblMedName.setBounds(226, 166, 196, 42);
			panel.add(lblMedName);
			lblMedName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			textMedId = new JTextField();
			textMedId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textMedId.setEditable(true);
			        }
			        else
			        {
			        	textMedId.setEditable(false);
			        }
				}
				
			});
				
			textMedId.setBounds(412, 105, 152, 41);
			panel.add(textMedId);
			textMedId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			textMedId.setColumns(10);
			
			textMedNm = new JTextField();
			textMedNm.setEditable(false);
			textMedNm.addKeyListener(new KeyAdapter() {
				@Override	
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textMedNm.setEditable(true);
			        }
			        else
			        {
			        	textMedNm.setEditable(false);
			        }
				}
			});
			textMedNm.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textMedNm.setColumns(10);
			textMedNm.setBounds(412, 166, 315, 42);
			panel.add(textMedNm);
			
			JButton btnUpdatedb = new JButton("Update");
			btnUpdatedb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			btnUpdatedb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String M_id=textMedId.getText();
						String M_name=textMedNm.getText();
						String M_Descp=txtMedDescp.getText();
						String M_Mfg=textFieldMFG.getText();
						String M_Exp=textFieldEXP.getText();
						String M_Status=textFieldStats.getText();
						String M_Unit=textUnit.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						Statement stmt=con.createStatement();
						String query1="Update MedData set m_name='"+textMedNm.getText()+"' ,description='"+txtMedDescp.getText()+"',status='"+textFieldStats.getText()+"',med_unit='"+textUnit.getText()+"' where m_id='"+textMedId.getText()+"'";
						
						stmt.executeUpdate(query1);

							JOptionPane.showMessageDialog(null,"Medicine Record Updated");
							
						con.close();
						clearFields();
					}catch (Exception e1){
						System.out.println("ConnectionFailed..!");
					}
				}
			});
			btnUpdatedb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnUpdatedb.setBounds(496, 600, 196, 59);
			btnUpdatedb.setFocusable(false);
			panel.add(btnUpdatedb);
			
			JLabel lblRgstr = new JLabel("Update Medicine");
			lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
			lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lblRgstr.setBounds(202, 10, 676, 66);
			panel.add(lblRgstr);
			
			JLabel lblMedDescp = new JLabel("Description  :");
			lblMedDescp.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedDescp.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMedDescp.setBounds(243, 230, 179, 42);
			panel.add(lblMedDescp);
			
			txtMedDescp = new JTextField();
			txtMedDescp.addKeyListener(new KeyAdapter() {
				@Override	
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	txtMedDescp.setEditable(true);
			        }
			        else
			        {
			        	txtMedDescp.setEditable(false);
			        }
				}
			});
			txtMedDescp.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			txtMedDescp.setColumns(10);
			txtMedDescp.setBounds(412, 230, 315, 42);
			panel.add(txtMedDescp);
			
			JLabel lblMFGdate = new JLabel("MFG Date :");
			lblMFGdate.setHorizontalAlignment(SwingConstants.CENTER);
			lblMFGdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMFGdate.setBounds(243, 296, 179, 37);
			panel.add(lblMFGdate);
			
			JLabel lblEXPdate = new JLabel("EXP Date :");
			lblEXPdate.setHorizontalAlignment(SwingConstants.CENTER);
			lblEXPdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblEXPdate.setBounds(243, 355, 179, 41);
			panel.add(lblEXPdate);
			
			JLabel lblMedStatus = new JLabel("Status :");
			lblMedStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedStatus.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMedStatus.setBounds(226, 417, 196, 42);
			panel.add(lblMedStatus);
			
			textFieldStats = new JTextField();
			textFieldStats.addKeyListener(new KeyAdapter() {
				@Override	
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textFieldStats.setEditable(true);
			        }
			        else
			        {
			        	textFieldStats.setEditable(false);
			        }
				}
			});
			textFieldStats.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textFieldStats.setColumns(10);
			textFieldStats.setBounds(412, 417, 315, 42);
			panel.add(textFieldStats);
			
			textFieldMFG = new JTextField();
			textFieldMFG.setEditable(false);
			textFieldMFG.setForeground(new Color(0, 0, 0));
			textFieldMFG.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) )
			        {
			        	textFieldMFG.setEditable(false);
			        }
			        else
			        {
			        	textFieldMFG.setEditable(true);
			        }
				}
			});
			textFieldMFG.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldMFG.setForeground(new Color(0, 0, 0));
			textFieldMFG.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(textFieldMFG.getText().equals("yy-MMM-dd")) {
						textFieldMFG.setText("");
						textFieldMFG.setForeground(new Color(153,153,153));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textFieldMFG.getText().equals("")) {
						textFieldMFG.setText("yy-MMM-dd");
						textFieldMFG.setForeground(new Color(153,153,153));
						
					}
				}
			});
			textFieldMFG.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textFieldMFG.setColumns(10);
			textFieldMFG.setBounds(412, 292, 315, 41);
			panel.add(textFieldMFG);
			
			textFieldEXP = new JTextField();
			textFieldEXP.setEditable(false);
			textFieldEXP.setForeground(new Color(0, 0, 0));
			textFieldEXP.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) )
			        {
			        	textFieldEXP.setEditable(false);
			        }
			        else
			        {
			        	textFieldEXP.setEditable(true);
			        }
				}
			});
			textFieldEXP.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(textFieldEXP.getText().equals("yy-MMM-dd")) {
						textFieldEXP.setText("");
						textFieldEXP.setForeground(new Color(153,153,153));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textFieldEXP.getText().equals("")) {
						textFieldEXP.setText("yy-MMM-dd");
						textFieldEXP.setForeground(new Color(153,153,153));
						
					}
				}
			});
			textFieldEXP.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldEXP.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textFieldEXP.setColumns(10);
			textFieldEXP.setBounds(412, 355, 315, 41);
			panel.add(textFieldEXP);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from MedData where m_id=?");
						int Id=Integer.parseInt(textMedId.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 textMedNm.setText(rs.getString("m_name"));
							 txtMedDescp.setText(rs.getString("description"));
							 textFieldMFG.setText(rs.getString("mfg_date"));
							 textFieldEXP.setText(rs.getString("exp_date"));
							 textFieldStats.setText(rs.getString("status"));
							 textUnit.setText(rs.getString("med_unit"));

						 }
						 else {
							 JOptionPane.showMessageDialog(null,"No Data Found...!");
							 textMedNm.setText("");
							 txtMedDescp.setText("");
							 textFieldMFG.setText("");
							 textFieldEXP.setText("");
							 textFieldStats.setText("");
							 textUnit.setText("");
							 textMedId.requestFocus();
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
			btnSearch.setBounds(750, 105, 152, 41);
			panel.add(btnSearch);
			
			JLabel lblRate = new JLabel("Unit :");
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblRate.setBounds(216, 481, 196, 42);
			panel.add(lblRate);
			
			textUnit = new JTextField();
			textUnit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textUnit.setEditable(true);
			        }
			        else
			        {
			        	textUnit.setEditable(false);
			        }
				}
				
			});
			textUnit.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			textUnit.setColumns(10);
			textUnit.setBounds(412, 483, 152, 41);
			panel.add(textUnit);
			
			
		}
		private void clearFields() {
			textMedId.setText("");
			 textMedNm.setText("");
			 txtMedDescp.setText("");
			 textFieldMFG.setText("");
			 textFieldEXP.setText("");
			 textFieldStats.setText("");
			 textUnit.setText("");
			 
		}
		
	}
