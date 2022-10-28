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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class AdMedicine extends JFrame {

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
					AdMedicine am = new AdMedicine();
					am.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdMedicine() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("AddMedicine");
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
		lblMedName.setBounds(226, 173, 196, 41);
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
			
			@Override
			public void keyReleased(KeyEvent e) {
				String id=textMedId.getText();
				int Id=Integer.parseInt(id);
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						String sql2="select * from MedData where m_id="+Id+"";
						
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
			
		textMedId.setBounds(412, 105, 240, 41);
		panel.add(textMedId);
		textMedId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textMedId.setColumns(10);
		
		textMedNm = new JTextField();
		textMedNm.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		textMedNm.setColumns(10);
		textMedNm.setBounds(412, 173, 315, 41);
		panel.add(textMedNm);
		
		JButton btnAdddb = new JButton("Add");
		btnAdddb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		btnAdddb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(textMedId.getText().isEmpty() && textMedNm.getText().isEmpty() && txtMedDescp.getText().isEmpty() && textFieldMFG.getText().isEmpty()
					&& textFieldEXP.getText().isEmpty()	&& textFieldStats.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null,"Field is Empty..!");
				}
			else if(textMedId.getText().isEmpty()) {
				
						JOptionPane.showMessageDialog(null,"Enter id...");
						clearFields();
				}
		 else {
			 JOptionPane.showMessageDialog(null,"Medicine Record Inserted");
		 }
					
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");

					String sql="insert into MedData (m_id,m_name,description,mfg_date,exp_date,status,med_unit)values(?,?,?,?,?,?,?)";
					
					 PreparedStatement pst=con.prepareStatement(sql);
					 pst.setString(1,textMedId.getText());
					 pst.setString(2,textMedNm.getText());
					 pst.setString(3,txtMedDescp.getText());
					 pst.setString(4,textFieldMFG.getText());
					 pst.setString(5,textFieldEXP.getText());
					 pst.setString(6,textFieldStats.getText());
					 pst.setString(7,textUnit.getText());
				 
					 pst.execute();
					 clearFields();
					con.close();
				}catch (Exception e1){
					System.out.println("error : "+e1);
				}
			}
		});
		btnAdddb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdddb.setBounds(496, 600, 196, 59);
		btnAdddb.setFocusable(false);
		panel.add(btnAdddb);
		
		JLabel lblRgstr = new JLabel("Add Medicine");
		lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
		lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblRgstr.setBounds(202, 10, 676, 74);
		panel.add(lblRgstr);
		
		JLabel lblMedDescp = new JLabel("Description  :");
		lblMedDescp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedDescp.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMedDescp.setBounds(243, 242, 179, 41);
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
		txtMedDescp.setBounds(412, 242, 315, 41);
		panel.add(txtMedDescp);
		
		JLabel lblMFGdate = new JLabel("MFG Date :");
		lblMFGdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblMFGdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMFGdate.setBounds(243, 315, 179, 37);
		panel.add(lblMFGdate);
		
		JLabel lblEXPdate = new JLabel("EXP Date :");
		lblEXPdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEXPdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblEXPdate.setBounds(243, 375, 179, 41);
		panel.add(lblEXPdate);
		
		JLabel lblMedStatus = new JLabel("Status :");
		lblMedStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedStatus.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMedStatus.setBounds(226, 437, 196, 42);
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
		textFieldStats.setBounds(412, 439, 315, 41);
		panel.add(textFieldStats);
		
		textFieldMFG = new JTextField();
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
		textFieldMFG.setBounds(412, 311, 315, 41);
		panel.add(textFieldMFG);
		
		textFieldEXP = new JTextField();
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
		textFieldEXP.setBounds(412, 375, 315, 41);
		panel.add(textFieldEXP);
		
		JLabel lblUnit = new JLabel("Unit :");
		lblUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblUnit.setBounds(226, 494, 196, 42);
		panel.add(lblUnit);
		
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
		textUnit.setBounds(412, 496, 240, 41);
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
