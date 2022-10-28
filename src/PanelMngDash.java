import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

public class PanelMngDash extends JPanel {
	private JTextField textPharmacist;
	private JTextField textCash;
	private JTextField textStock;

	/**
	 * Create the panel.
	 */
	public PanelMngDash() {
		setBackground(new Color(204, 255, 204));
		setBounds(0,0,1195, 815);
		setLayout(null);
		
		JLabel lblmngDash = new JLabel("DashBoard");
		lblmngDash.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
		lblmngDash.setHorizontalAlignment(SwingConstants.CENTER);
		lblmngDash.setForeground(Color.BLACK);
		lblmngDash.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblmngDash.setBounds(429, 77, 315, 54);
		add(lblmngDash);
		
		JPanel paneTtlPharmacist = new JPanel();
		paneTtlPharmacist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlPharmacist.setBackground(new Color(176, 224, 230));
				textPharmacist.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from pharmacist";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textPharmacist.setText(count);
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
				paneTtlPharmacist.setBackground(new Color(176, 224, 230));
				textPharmacist.setVisible(false);
			}
		});
		paneTtlPharmacist.setLayout(null);
		paneTtlPharmacist.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlPharmacist.setBackground(new Color(176, 224, 230));
		paneTtlPharmacist.setBounds(166, 234, 245, 143);
		add(paneTtlPharmacist);
		
		JLabel lblPharmacist = new JLabel("Pharmacist");
		lblPharmacist.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharmacist.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblPharmacist.setBounds(50, 33, 152, 77);
		paneTtlPharmacist.add(lblPharmacist);
		
		textPharmacist = new JTextField();
		textPharmacist.setHorizontalAlignment(SwingConstants.CENTER);
		textPharmacist.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textPharmacist.setEditable(false);
		textPharmacist.setDropMode(DropMode.INSERT);
		textPharmacist.setColumns(10);
		textPharmacist.setBackground(new Color(176, 224, 230));
		textPharmacist.setBounds(157, 10, 78, 48);
		paneTtlPharmacist.add(textPharmacist);
		
		JPanel paneTtlCash = new JPanel();
		paneTtlCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlCash.setBackground(new Color(176, 224, 230));
				textCash.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from cashier";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textCash.setText(count);
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
				paneTtlCash.setBackground(new Color(176, 224, 230));
				textCash.setVisible(false);
			}
		});
		paneTtlCash.setLayout(null);
		paneTtlCash.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlCash.setBackground(new Color(176, 224, 230));
		paneTtlCash.setBounds(719, 234, 245, 143);
		add(paneTtlCash);
		
		JLabel lblCashier = new JLabel("Cashier");
		lblCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashier.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCashier.setBounds(50, 33, 152, 77);
		paneTtlCash.add(lblCashier);
		
		textCash = new JTextField();
		textCash.setHorizontalAlignment(SwingConstants.CENTER);
		textCash.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textCash.setEditable(false);
		textCash.setDropMode(DropMode.INSERT);
		textCash.setColumns(10);
		textCash.setBackground(new Color(176, 224, 230));
		textCash.setBounds(157, 10, 78, 48);
		paneTtlCash.add(textCash);
		
		JPanel paneTtlStock = new JPanel();
		paneTtlStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlStock.setBackground(new Color(176, 224, 230));
				textStock.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from medStock";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textStock.setText(count);
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
				paneTtlStock.setBackground(new Color(176, 224, 230));
				textStock.setVisible(false);
			}
		});
		paneTtlStock.setLayout(null);
		paneTtlStock.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlStock.setBackground(new Color(176, 224, 230));
		paneTtlStock.setBounds(455, 484, 245, 143);
		add(paneTtlStock);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblStock.setBounds(50, 33, 152, 77);
		paneTtlStock.add(lblStock);
		
		textStock = new JTextField();
		textStock.setHorizontalAlignment(SwingConstants.CENTER);
		textStock.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textStock.setEditable(false);
		textStock.setDropMode(DropMode.INSERT);
		textStock.setColumns(10);
		textStock.setBackground(new Color(176, 224, 230));
		textStock.setBounds(157, 10, 78, 48);
		paneTtlStock.add(textStock);

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