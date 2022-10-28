	import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JRadioButton;
	import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
	import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

	public class AdStock extends JFrame {

		private JTextField textId;
		private JTextField textMedId;
		private JTextField textUnit;
		private JTextField textRate;
		private JTextField textMedname;


		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdStock as = new AdStock();
						as.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public AdStock() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("AddStock");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(64, 51, 1058, 669);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel RegFormlabel = new JLabel("Add Stock");
			RegFormlabel.setHorizontalAlignment(SwingConstants.CENTER);
			RegFormlabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Stock.png"));
			RegFormlabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			RegFormlabel.setBounds(468, 10, 296, 49);
			panel.add(RegFormlabel);
			
			JLabel IDlabel = new JLabel("Stock Id :");
			IDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			IDlabel.setBounds(364, 105, 139, 31);
			panel.add(IDlabel);
			
			textId = new JTextField();
			textId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textId.setEditable(true);
			        }
			        else
			        {
			        	textId.setEditable(false);
			        }
				}
				@Override
				public void keyReleased(KeyEvent e) {
					String id=textId.getText();
					int Id=Integer.parseInt(id);
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
							
							String sql2="select * from medStock where st_id="+Id+"";
							
							Statement stmt=con.createStatement();
							 ResultSet rs=stmt.executeQuery(sql2);

							 if(rs.next()) {
								 JOptionPane.showMessageDialog(null,"Duplicate  Id");
								 clearFields();
							 }
							 
							 
							con.close();
						}catch(Exception e2) {
							System.out.println("error : "+e2);
							
						}
				}
			});
			textId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textId.setColumns(10);
			textId.setBounds(518, 105, 139, 42);
			panel.add(textId);
			
			textMedId = new JTextField();
			textMedId.setEditable(false);
			textMedId.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			        	textMedId.setEditable(true);
			        }
			        else
			        {
			        	textMedId.setEditable(false);
			        }
				}
			});
			textMedId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textMedId.setColumns(10);
			textMedId.setBounds(186, 220, 145, 42);
			panel.add(textMedId);
			
			JLabel FNlabel = new JLabel("Med_Id :");
			FNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			FNlabel.setBounds(34, 220, 139, 31);
			panel.add(FNlabel);
			
			JLabel Genderlabel = new JLabel("Med_Name : ");
			Genderlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			Genderlabel.setBounds(34, 285, 139, 31);
			panel.add(Genderlabel);
			
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
			textUnit.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textUnit.setColumns(10);
			textUnit.setBounds(739, 220, 165, 42);
			panel.add(textUnit);
			
			JLabel PClabel = new JLabel("Unit : ");
			PClabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			PClabel.setBounds(587, 220, 139, 31);
			panel.add(PClabel);
			
			JLabel EIDlabel = new JLabel("Rate : ");
			EIDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			EIDlabel.setBounds(587, 285, 139, 31);
			panel.add(EIDlabel);
			
			textRate = new JTextField();
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
			textRate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textRate.setColumns(10);
			textRate.setBounds(739, 285, 211, 42);
			panel.add(textRate);
			
			JButton Regbtn = new JButton("Add");
			Regbtn.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Stock.png"));
			Regbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(textMedId.getText().trim().isEmpty() || textUnit.getText().trim().isEmpty() || textRate.getText().trim().isEmpty()  || textId.getText().trim().isEmpty() )
						{
							JOptionPane.showMessageDialog(null,"Please fil all fields...");
							
						}
								
								try {
									
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");

									String sql="insert into medStock (st_id,med_name,unit,rate,m_id)values(?,?,?,?,?)";

									 PreparedStatement pst=con.prepareStatement(sql);
									 pst.setString(1,textId.getText());
									 pst.setString(2,textMedname.getText());
									 pst.setString(3,textUnit.getText());
									 pst.setString(4,textRate.getText());
									 pst.setString(5,textMedId.getText());
									 pst.execute();
									 
									 String query1="update MedData set MedData.med_unit=(select sum(unit) from medStock where MedData.m_id=medStock.m_id);";
									 PreparedStatement pst1=con.prepareStatement(query1);
									 pst1.execute();
									 
									 	JOptionPane.showMessageDialog(null,"Stock Record Added");
									 clearFields();
									con.close();
								}catch (Exception e1){
									System.out.println("error : "+e1);
								}

						clearFields();
					}
				});
			Regbtn.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			Regbtn.setFocusable(false);
			Regbtn.setBounds(518, 440, 145, 49);
			panel.add(Regbtn);
			
			textMedname = new JTextField();
			textMedname.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from MedData where m_name=?");
						String Med_name=textMedname.getText();
						
						pst.setString(1, Med_name);
						 ResultSet rs=pst.executeQuery();

						while(rs.next()) {
							 textMedId.setText(rs.getString("m_id"));
				

						 }						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
				}
	
			});
			textMedname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			textMedname.setColumns(10);
			textMedname.setBounds(186, 280, 285, 42);
			panel.add(textMedname);
			
		}
		private void clearFields() {
			textId.setText(null);
			textMedId.setText(null);
			textUnit.setText(null);
			textRate.setText(null);
			textMedname.setText(null);
	}
	}