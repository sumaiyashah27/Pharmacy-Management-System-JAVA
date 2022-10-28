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

public class AdBranch extends JFrame {
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
					AdBranch ab = new AdBranch();
					ab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdBranch() {
		setFont(new Font("Book Antiqua", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("RegisterPage");
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
			@Override
			public void keyReleased(KeyEvent e) {
				String id=textBrId.getText();
				int Id=Integer.parseInt(id);
				
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						String sql2="select * from branch where br_id="+Id+"";
						
						Statement stmt=con.createStatement();
						 ResultSet rs=stmt.executeQuery(sql2);

						 if(rs.next()) {
							 JOptionPane.showMessageDialog(null,"Duplicate Medicine Id");
							 clearFields();
						 }
						 
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
			}
		});
		textBrId.setBounds(411, 140, 315, 59);
		panel.add(textBrId);
		textBrId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textBrId.setColumns(10);
		
		textBrNm = new JTextField();
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
				String padd = textPsAd.getText();
				int length = padd.length();
		        char c = e.getKeyChar();
		        
		        if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
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
		
		JButton btnRgstrdb = new JButton("Register");
		btnRgstrdb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-32.png"));
		btnRgstrdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textBrId.getText();
				String name=textBrNm.getText();
				String add=textPsAd.getText();
				
				int Id=Integer.parseInt(id);
				int PAdd=Integer.parseInt(add);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					Statement stmt=con.createStatement();
					String sql="insert into branch values("+Id+",'"+name+"',"+PAdd+")";
					
					stmt.executeUpdate(sql);
				 
					JOptionPane.showMessageDialog(null,"Branch Record Inserted");
					
					con.close();
					clearFields();
				}catch (Exception e1){
					System.out.println("ConnectionFailed..!");
				}
			}
		});
		btnRgstrdb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnRgstrdb.setBounds(483, 538, 196, 59);
		btnRgstrdb.setFocusable(false);
		panel.add(btnRgstrdb);
		
		JLabel lblRgstr = new JLabel("Register Branch");
		lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-32.png"));
		lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
		lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblRgstr.setBounds(290, 10, 519, 64);
		panel.add(lblRgstr);

	}
	private void clearFields() {
		textBrId.setText(null);
		textBrNm.setText(null);
		textPsAd.setText(null);
	}
}
