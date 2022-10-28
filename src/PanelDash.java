import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.DropMode;


public class PanelDash extends JPanel {
	private JTextField textCountBr;
	private JTextField textCountMr;
	private JTextField textCountSales;

	/**
	 * Create the panel.
	 */
	public PanelDash() {
		setBounds(0,0,1195, 815);
		setBackground(new Color(204, 255, 204));
		setLayout(null);
	
		JLabel lblTitle = new JLabel(" DASHBOARD");
		lblTitle.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblTitle.setBounds(221, 41, 676, 78);
		add(lblTitle);
		
		JPanel paneTtlBrch = new JPanel();
		paneTtlBrch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlBrch.setBackground(new Color(176, 224, 230));
				textCountBr.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from branch";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textCountBr.setText(count);
					}
					
					rs.close();
					st.close();
					con.close();
					
					
				}catch (Exception e1) {
					System.out.println("error : "+e1);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneTtlBrch.setBackground(new Color(176, 224, 230));
				textCountBr.setVisible(false);
			}
		});
		paneTtlBrch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlBrch.setBackground(new Color(176, 224, 230));
		paneTtlBrch.setBounds(145, 251, 245, 143);
		add(paneTtlBrch);
		paneTtlBrch.setLayout(null);
		
		JLabel lblbranchs = new JLabel("Branch's");
		lblbranchs.setBounds(50, 33, 152, 77);
		paneTtlBrch.add(lblbranchs);
		
		lblbranchs.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\branch-32.png"));
		lblbranchs.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblbranchs.setHorizontalAlignment(SwingConstants.CENTER);
		
		textCountBr = new JTextField();
		textCountBr.setBounds(157, 10, 78, 48);
		paneTtlBrch.add(textCountBr);
		textCountBr.setDropMode(DropMode.INSERT);
		textCountBr.setEditable(false);
		textCountBr.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCountBr.setBackground(new Color(176, 224, 230));
		textCountBr.setHorizontalAlignment(SwingConstants.CENTER);
		textCountBr.setColumns(10);
		
		JPanel paneTtlMngr = new JPanel();
		paneTtlMngr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlMngr.setBackground(new Color(176, 224, 230));
				textCountMr.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from manager";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textCountMr.setText(count);
					}
					
					rs.close();
					st.close();
					con.close();
					
					
				}catch (Exception e1) {
					System.out.println("error : "+e1);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneTtlBrch.setBackground(new Color(176, 224, 230));
				textCountMr.setVisible(false);
			}
		});
		paneTtlMngr.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlMngr.setLayout(null);
		paneTtlMngr.setBackground(new Color(176, 224, 230));
		paneTtlMngr.setBounds(784, 251, 245, 143);
		add(paneTtlMngr);
		
		JLabel lblManagers = new JLabel("Manager's");
		lblManagers.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\manager-32.png"));
		lblManagers.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagers.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblManagers.setBounds(46, 36, 160, 73);
		paneTtlMngr.add(lblManagers);
		
		textCountMr = new JTextField();
		textCountMr.setBounds(156, 10, 79, 48);
		paneTtlMngr.add(textCountMr);
		textCountMr.setDropMode(DropMode.INSERT);
		textCountMr.setEditable(false);
		textCountMr.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCountMr.setBackground(new Color(176, 224, 230));
		textCountMr.setHorizontalAlignment(SwingConstants.CENTER);
		textCountMr.setColumns(10);
		
		JPanel paneTtlSals = new JPanel();
		paneTtlSals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlSals.setBackground(new Color(176, 224, 230));
				textCountSales.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(med_id) from CustSales";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(med_id)");
						textCountSales.setText(count);
					}
					
					rs.close();
					st.close();
					con.close();
					
					
				}catch (Exception e1) {
					System.out.println("error : "+e1);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneTtlSals.setBackground(new Color(176, 224, 230));
				textCountSales.setVisible(false);
			}
		});
		paneTtlSals.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlSals.setLayout(null);
		paneTtlSals.setBackground(new Color(176, 224, 230));
		paneTtlSals.setBounds(444, 528, 245, 143);
		add(paneTtlSals);
		
		JLabel lblSalse = new JLabel("Sale's");
		lblSalse.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\report-32.png"));
		lblSalse.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalse.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblSalse.setBounds(46, 36, 160, 73);
		paneTtlSals.add(lblSalse);
		
		textCountSales = new JTextField();
		textCountSales.setHorizontalAlignment(SwingConstants.CENTER);
		textCountSales.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCountSales.setEditable(false);
		textCountSales.setDropMode(DropMode.INSERT);
		textCountSales.setColumns(10);
		textCountSales.setBackground(new Color(176, 224, 230));
		textCountSales.setBounds(156, 10, 79, 48);
		paneTtlSals.add(textCountSales);

		setVisible(true);
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
