import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class GenPrescription extends JFrame {

	JTextField textCustId;
	 JTextField textCustName;
	private JLabel lblCustid;
	private JLabel lblCustname;
	private JPanel panelJtbl;
	private JTextField textMId;
	private JTextField textRate;
	private JTextField textQuantity;
	private JButton btnAdd;
			JComboBox comboBox;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JLabel lblOvTotal;
	private JTextField textOverallTotal;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenPrescription gp = new GenPrescription();
					gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GenPrescription() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("GeneratePrescription");
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		setBounds(0,0,1195, 815);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
			}
		});
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(47, 32, 1086, 715);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textCustId = new JTextField();
		textCustId.setEditable(false);
		textCustId.setHorizontalAlignment(SwingConstants.CENTER);
		textCustId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCustId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenPrescription gp = new GenPrescription();
				gp.setVisible(true);
			}
		});
		textCustId.setBounds(283, 23, 158, 31);
		panel.add(textCustId);
		textCustId.setColumns(10);
		
		textCustName = new JTextField();
		textCustName.setEditable(false);
		textCustName.setHorizontalAlignment(SwingConstants.CENTER);
		textCustName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCustName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenPrescription gp = new GenPrescription();
				gp.setVisible(true);
			}
		});
		textCustName.setColumns(10);
		textCustName.setBounds(807, 23, 158, 31);
		panel.add(textCustName);
		
		lblCustid = new JLabel("Cust_ID :");
		lblCustid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustid.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustid.setBounds(132, 23, 179, 31);
		panel.add(lblCustid);
		
		lblCustname = new JLabel("Cust_Name :");
		lblCustname.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustname.setBounds(601, 19, 179, 38);
		panel.add(lblCustname);
		
		panelJtbl = new JPanel();
		panelJtbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
				ShowData2();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Connection con = con1();
				try {
					String query="select sum(total) from CustSales where cust_id='"+textCustId.getText()+"'";
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						if(rs.next()) {
							String sum=rs.getString("sum(total)");
							textOverallTotal.setText(sum);
						}
						
						rs.close();
						st.close();
						con.close();
						
						
					}catch (Exception e1) {
						System.out.println("error : "+e1);
					}
			}
		});
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(106, 78, 918, 589);
		panel.add(panelJtbl);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					PreparedStatement pst;
					pst=con.prepareStatement("select * from MedData where m_name=?");
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();

					while(rs.next()) {
						textMId.setText(rs.getString("m_id"));
					}
					pst.close();
					
				}catch (Exception e1) {
					System.out.println("error : "+e1);
				}
				
			}
		});
		comboBox.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		comboBox.setBounds(218, 17, 180, 28);
		panelJtbl.add(comboBox);
		
		JLabel lblMedName = new JLabel("Medicine name :");
		lblMedName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMedName.setBounds(10, 10, 179, 37);
		panelJtbl.add(lblMedName);
		
		JLabel lblMedicineId = new JLabel("Medicine  Id :");
		lblMedicineId.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicineId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMedicineId.setBounds(463, 17, 179, 37);
		panelJtbl.add(lblMedicineId);
		
		textMId = new JTextField();
		textMId.setEditable(false);
		textMId.setHorizontalAlignment(SwingConstants.CENTER);
		textMId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textMId.setColumns(10);
		textMId.setBounds(682, 20, 169, 31);
		panelJtbl.add(textMId);
		
		JLabel lblRate = new JLabel("Rate :");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblRate.setBounds(20, 64, 179, 37);
		panelJtbl.add(lblRate);
		
		textRate = new JTextField();
		
		textRate.setEditable(false);
		textRate.setHorizontalAlignment(SwingConstants.CENTER);
		textRate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textRate.setColumns(10);
		textRate.setBounds(218, 67, 180, 31);
		panelJtbl.add(textRate);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblQuantity.setBounds(473, 67, 179, 37);
		panelJtbl.add(lblQuantity);
		
		textQuantity = new JTextField();
		textQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = con1();
				try {
					String query="select med_unit from MedData where m_id='"+textMId.getText()+"'";
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						if(rs.next()) {
							String qty=rs.getString("med_unit");
							textQuantity.setText(qty);
						}
						
						rs.close();
						st.close();
						con.close();
						
						
					}catch (Exception e1) {
						System.out.println("error : "+e1);
					}
			}
		});
		textQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int c = e.getKeyChar();
		        if(Character.isDigit(c)|| Character.isISOControl(c))
		        {
		        	textQuantity.setEditable(true);
		        }
		        else
		        {
		        	textQuantity.setEditable(false);
		        }
			}
		});
		textQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		textQuantity.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textQuantity.setColumns(10);
		textQuantity.setBounds(682, 67, 171, 31);
		panelJtbl.add(textQuantity);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");

					String sql="insert into CustSales(cust_id,cust_name,med_id,med_name,rate,quantity,total)values(?,?,?,?,?,?,?)";
					
					 PreparedStatement pst=con.prepareStatement(sql);
					 pst.setString(1,textCustId.getText());
					 pst.setString(2,textCustName.getText());
					 pst.setString(3,textMId.getText());
					 pst.setString(4,comboBox.getSelectedItem().toString());
					 pst.setString(5,textRate.getText());
					 pst.setString(6,textQuantity.getText());
					 pst.setString(7,textTotal.getText());
					 pst.execute();
					 
					 String sql2="update MedData as m inner join CustSales as c on m.m_id=c.med_id set m.med_unit=m.med_unit-c.quantity;";
					 PreparedStatement pst2=con.prepareStatement(sql2);
					 pst2.execute();
					 
					 String sql3="update MedData set status='OutStock' where med_unit<=0 and status='Instock'";
					 PreparedStatement pst3=con.prepareStatement(sql3);
					 pst3.execute();
					 
					 String sql4="update MedData set med_unit=0 where med_unit<=0 and status='Outstock'";
					 PreparedStatement pst4=con.prepareStatement(sql4);
					 pst4.execute();
					
					 String sql5="update MedData set status='InStock' where med_unit>0 and status='OutStock'";
					 PreparedStatement pst5=con.prepareStatement(sql5);
					 pst5.execute();
					 
					 String sql6="update medStock as m inner join MedData as md on m.m_id=md.m_id set m.unit=md.med_unit;";
					 PreparedStatement pst6=con.prepareStatement(sql6);
					 pst6.execute();
					 
					 	JOptionPane.showMessageDialog(null,"Medicine Record Inserted");
					con.close();
					
				}catch (Exception e1){
					System.out.println("error : "+e1);
				}
			}
		});
		btnAdd.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		btnAdd.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdd.setFocusable(false);
		btnAdd.setBounds(201, 199, 161, 37);
		panelJtbl.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
			}
		});
		scrollPane.setBounds(258, 323, 498, 139);
		panelJtbl.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		
		lblTotal = new JLabel("Total :");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblTotal.setBounds(276, 126, 179, 37);
		panelJtbl.add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double v1,v2;
				v1=Double.valueOf(textRate.getText());
				v2=Double.valueOf(textQuantity.getText());
				double mul;
				mul=v1*v2;
				textTotal.setText(""+mul);
			}
		});
		textTotal.setEditable(false);
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textTotal.setColumns(10);
		textTotal.setBounds(419, 132, 161, 31);
		panelJtbl.add(textTotal);
		
		lblOvTotal = new JLabel("Total :");
		lblOvTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblOvTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblOvTotal.setBounds(384, 498, 179, 37);
		panelJtbl.add(lblOvTotal);
		
		textOverallTotal = new JTextField();
		textOverallTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = con1();
				try {
					String query="select sum(total) from CustSales where cust_id='"+textCustId.getText()+"'";
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						if(rs.next()) {
							String sum=rs.getString("sum(total)");
							textOverallTotal.setText(sum);
						}
						
						rs.close();
						st.close();
						con.close();
						
						
					}catch (Exception e1) {
						System.out.println("error : "+e1);
					}
				
			}
		});
		textOverallTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textOverallTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textOverallTotal.setEditable(false);
		textOverallTotal.setColumns(10);
		textOverallTotal.setBounds(527, 504, 161, 31);
		panelJtbl.add(textOverallTotal);
		
		fillCombox();
		
	}
	
	public void fillCombox() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
			
			PreparedStatement pst;
			pst=con.prepareStatement("select * from MedData");
			ResultSet rs=pst.executeQuery();

			while(rs.next()) {
				comboBox.addItem(rs.getString("m_name"));
				
				textMId.setText(rs.getString("m_id"));
			}
			
			
		}catch (Exception e1) {
			System.out.println("error : "+e1);
		}
	
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
	
	
	private void ShowData() {
		Connection con = con1();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("M_ID");
		model.addColumn("Medicine Name");
		model.addColumn("Rate");
		model.addColumn("Quantity");
		model.addColumn("Total");
		try {
			String query="select * from CustSales where cust_id='"+textCustId.getText()+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("med_id"),
						rs.getString("med_name"),
						rs.getString("rate"),
						rs.getString("quantity"),
						rs.getString("total"),
						
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.setRowHeight(30);
			
			table.getTableHeader().setFont(new Font("Book Antiqua", Font.BOLD, 20));
			DefaultTableCellRenderer centerRenderer=new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(1).setPreferredWidth(180);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(4).setPreferredWidth(80);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
	private void ShowData2() {
		Connection con = con1();
		try {
			String query4="select rate from medStock where m_id='"+textMId.getText()+"'";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query4);
				while(rs.next()) {
					textRate.setText(rs.getString("rate"));
				}
				rs.close();
				st.close();
				con.close();
				
				
			}catch (Exception e1) {
				System.out.println("error : "+e1);
			}
		
		}
		
		
	
	
}
