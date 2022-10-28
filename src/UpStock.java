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
import java.awt.Toolkit;

	public class UpStock extends JFrame {

		private JTextField textMedId;
		private JTextField textMedNm;
		private JTextField txtUnit;
		private JTextField textStId;
		private JTextField textRate;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpStock us = new UpStock();
						us.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public UpStock() {
			setTitle("UpdateStock");
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(47, 43, 1086, 675);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblMedId = new JLabel("Medicine ID :");
			lblMedId.setBounds(371, 118, 179, 42);
			panel.add(lblMedId);
			lblMedId.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			JLabel lblMedName = new JLabel("Medicine Name :");
			lblMedName.setBounds(10, 356, 196, 42);
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
				
			textMedId.setBounds(540, 119, 129, 41);
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
			textMedNm.setBounds(196, 356, 280, 42);
			panel.add(textMedNm);
			
			JButton btnUpdatedb = new JButton("Update");
			btnUpdatedb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			btnUpdatedb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String Med_id=textMedId.getText();
						String Med_name=textMedNm.getText();
						String Unit=txtUnit.getText();
						String Rate=textRate.getText();
						String St_id=textStId.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						Statement stmt=con.createStatement();
						String query1="Update medStock set unit='"+txtUnit.getText()+"' ,rate='"+textRate.getText()+"' where m_id='"+textMedId.getText()+"'";
						stmt.executeUpdate(query1);
						
						Statement stmt2=con.createStatement();
						String query2="update MedData set MedData.med_unit=(select sum(unit) from medStock where MedData.m_id=medStock.m_id);";
						stmt2.executeUpdate(query2);

						
						Statement stmt3=con.createStatement();
						String query3="update MedData as md inner join medStock as ms on md.m_id=ms.m_id set md.med_unit=ms.unit;";
						stmt3.executeUpdate(query3);
							JOptionPane.showMessageDialog(null,"Stock Record Updated");
							
						con.close();
						clearFields();
					}catch (Exception e1){
						System.out.println("ConnectionFailed..!");
					}
				}
			});
			btnUpdatedb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnUpdatedb.setBounds(510, 519, 196, 59);
			btnUpdatedb.setFocusable(false);
			panel.add(btnUpdatedb);
			
			JLabel lblRgstr = new JLabel("Update Stock");
			lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
			lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lblRgstr.setBounds(328, 10, 550, 66);
			panel.add(lblRgstr);
			
			JLabel lblMedDescp = new JLabel("Unit  :");
			lblMedDescp.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedDescp.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMedDescp.setBounds(527, 295, 179, 42);
			panel.add(lblMedDescp);
			
			txtUnit = new JTextField();
			txtUnit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	txtUnit.setEditable(true);
			        }
			        else
			        {
			        	txtUnit.setEditable(false);
			        }
				}
				
			});
			txtUnit.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			txtUnit.setColumns(10);
			txtUnit.setBounds(696, 295, 166, 42);
			panel.add(txtUnit);
			
			JLabel lblMFGdate = new JLabel("Rate:");
			lblMFGdate.setHorizontalAlignment(SwingConstants.CENTER);
			lblMFGdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMFGdate.setBounds(527, 361, 179, 37);
			panel.add(lblMFGdate);
			
			JLabel lblMedStatus = new JLabel("Stock Id :");
			lblMedStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblMedStatus.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			lblMedStatus.setBounds(10, 295, 196, 42);
			panel.add(lblMedStatus);
			
			textStId = new JTextField();
			textStId.setEditable(false);
			textStId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textStId.setEditable(true);
			        }
			        else
			        {
			        	textStId.setEditable(false);
			        }
				}
				
			});
			textStId.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textStId.setColumns(10);
			textStId.setBounds(196, 295, 113, 42);
			panel.add(textStId);
			
			textRate = new JTextField();
			textRate.setForeground(new Color(0, 0, 0));
			textRate.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) )
			        {
			        	textRate.setEditable(false);
			        }
			        else
			        {
			        	textRate.setEditable(true);
			        }
				}
			});
			textRate.setForeground(new Color(0, 0, 0));
			textRate.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			textRate.setColumns(10);
			textRate.setBounds(696, 357, 166, 41);
			panel.add(textRate);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textMedId.getText().equals("")){
						 JOptionPane.showMessageDialog(null,"Enter Medicine ID");
					 }
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from medStock where m_id=?");
						int Id=Integer.parseInt(textMedId.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 textStId.setText(rs.getString("st_id"));
							 textMedNm.setText(rs.getString("med_name"));
							 txtUnit.setText(rs.getString("unit"));
							 textRate.setText(rs.getString("rate"));
						 }
						 
						 else {
							 JOptionPane.showMessageDialog(null,"No Data Found...!");
							 textMedId.setText("");
							 textMedNm.setText("");
							 textRate.setText("");
							 txtUnit.setText("");
							 textStId.setText("");
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
			btnSearch.setBounds(747, 119, 152, 41);
			panel.add(btnSearch);
			
			
		}
		private void clearFields() {
			textMedId.setText("");
			 textMedNm.setText("");
			 txtUnit.setText("");
			 textRate.setText("");
			 textStId.setText("");
			 
		}
		
	}
