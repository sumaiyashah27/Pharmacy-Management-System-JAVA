	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.sql.*;
	import javax.swing.SwingConstants;
	import javax.swing.JTextField;
	import javax.swing.JPanel;
	import java.awt.Color;
	import javax.swing.border.LineBorder;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

	public class UpBranch extends JFrame {
		private JTextField textBrId;
		private JTextField textBrNm;
		private JTextField textPsAd;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpBranch ub = new UpBranch();
						ub.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public UpBranch() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("UpdateBranch");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(47, 43, 1086, 686);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblBrId = new JLabel("Branch ID :");
			lblBrId.setBounds(242, 139, 179, 59);
			panel.add(lblBrId);
			lblBrId.setHorizontalAlignment(SwingConstants.CENTER);
			lblBrId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			JLabel lblPostalAddr = new JLabel("Postal Addr :");
			lblPostalAddr.setBounds(242, 352, 179, 59);
			panel.add(lblPostalAddr);
			lblPostalAddr.setHorizontalAlignment(SwingConstants.CENTER);
			lblPostalAddr.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			JLabel lblBrName = new JLabel("Branch Name :");
			lblBrName.setBounds(242, 248, 179, 59);
			panel.add(lblBrName);
			lblBrName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBrName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			textBrId = new JTextField();
			textBrId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textBrId.setEditable(true);
			        }
			        else
			        {
			        	textBrId.setEditable(false);
			        }
				}
			});
			textBrId.setBounds(411, 140, 315, 59);
			panel.add(textBrId);
			textBrId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			textBrId.setColumns(10);
			
			textBrNm = new JTextField();
			textBrNm.setEditable(false);
			textBrNm.addKeyListener(new KeyAdapter() {
				@Override	
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textBrNm.setEditable(true);
			        }
			        else
			        {
			        	textBrNm.setEditable(false);
			        }
				}
			});
			textBrNm.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textBrNm.setColumns(10);
			textBrNm.setBounds(411, 248, 315, 59);
			panel.add(textBrNm);
			
			textPsAd = new JTextField();
			textPsAd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					String phoneNumber = textPsAd.getText();
					int length = phoneNumber.length();
			        char c = e.getKeyChar();
			        
			        if(e.getKeyChar()>='0' && e.getKeyChar()<='6'){
			            if(length<7){
			                
			            	textPsAd.setEditable(true);
			            }else{
			            	textPsAd.setEditable(false);
			            }
			        }else
			        {
			            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
			            	textPsAd.setEditable(true);
			                
			            }else{
			            	textPsAd.setEditable(false);
			            }
			                
			        }
				}
			});
			textPsAd.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textPsAd.setColumns(10);
			textPsAd.setBounds(411, 353, 315, 59);
			panel.add(textPsAd);
			
			JButton btnRgstrdb = new JButton("Update");
			btnRgstrdb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			btnRgstrdb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String id=textBrId.getText();
						String name=textBrNm.getText();
						String add=textPsAd.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						Statement stmt=con.createStatement();
						String query1="Update branch set br_id='"+textBrId.getText()+"' ,br_name='"+textBrNm.getText()+"' ,postal_add='"+textPsAd.getText()+"' where br_id='"+textBrId.getText()+"'";
						
						stmt.executeUpdate(query1);
						
						if(id.equals("") && name.equals("") && add.equals("")){
	                		JOptionPane.showMessageDialog(null,"Enter Branch Details..!");
						}
						else {
							JOptionPane.showMessageDialog(null,"Branch Record Updated");
							
						}
						con.close();
						clearFields();
					}catch (Exception e1){
						System.out.println("ConnectionFailed..!");
					}
				}
			});
			btnRgstrdb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnRgstrdb.setBounds(463, 528, 196, 59);
			btnRgstrdb.setFocusable(false);
			panel.add(btnRgstrdb);
			
			JLabel lblRgstr = new JLabel("Update Branch");
			lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
			lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lblRgstr.setBounds(211, 10, 676, 76);
			panel.add(lblRgstr);
	
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from branch where br_id=?");
						int Id=Integer.parseInt(textBrId.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 textBrNm.setText(rs.getString("br_name"));
							 textPsAd.setText(rs.getString("postal_add"));
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"No Data Found...!");
							 textBrNm.setText("");
							 textPsAd.setText("");
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
			btnSearch.setBounds(812, 148, 152, 41);
			panel.add(btnSearch);
			

		}
		private void clearFields() {
			textBrId.setText(null);
			textBrNm.setText(null);
			textPsAd.setText(null);
		}
	}
