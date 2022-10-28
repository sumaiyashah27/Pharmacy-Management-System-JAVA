import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelCDash extends JPanel {
	private JTextField textFieldInv;
	private JTextField textSales;

	/**
	 * Create the panel.
	 */
	public PanelCDash() {
		setBounds(0,0,1195, 815);
		setBackground(new Color(204, 255, 204));
		setLayout(null);
		
		JLabel lblTitle = new JLabel(" DASHBOARD");
		lblTitle.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblTitle.setBounds(327, 51, 676, 78);
		add(lblTitle);
		
		JPanel paneTtlBrch = new JPanel();
		paneTtlBrch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlBrch.setBackground(new Color(176, 224, 230));
				textFieldInv.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from Invoice";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textFieldInv.setText(count);
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
				textFieldInv.setVisible(false);
			}
		});
		paneTtlBrch.setLayout(null);
		paneTtlBrch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlBrch.setBackground(new Color(176, 224, 230));
		paneTtlBrch.setBounds(134, 375, 245, 143);
		add(paneTtlBrch);
		
		JLabel lblInvoices = new JLabel("Invoice's");
		lblInvoices.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\invoice-24.png"));
		lblInvoices.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoices.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblInvoices.setBounds(50, 33, 152, 77);
		paneTtlBrch.add(lblInvoices);
		
		textFieldInv = new JTextField();
		textFieldInv.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldInv.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textFieldInv.setEditable(false);
		textFieldInv.setDropMode(DropMode.INSERT);
		textFieldInv.setColumns(10);
		textFieldInv.setBackground(new Color(176, 224, 230));
		textFieldInv.setBounds(157, 10, 78, 48);
		paneTtlBrch.add(textFieldInv);
		
		JPanel paneTtlSales = new JPanel();
		paneTtlSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlBrch.setBackground(new Color(176, 224, 230));
				textSales.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from SalesReport";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textSales.setText(count);
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
				textSales.setVisible(false);
			}
		});
		paneTtlSales.setLayout(null);
		paneTtlSales.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlSales.setBackground(new Color(176, 224, 230));
		paneTtlSales.setBounds(845, 375, 245, 143);
		add(paneTtlSales);
		
		JLabel lblSales = new JLabel("Sale's");
		lblSales.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Sales.png"));
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSales.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblSales.setBounds(50, 33, 152, 77);
		paneTtlSales.add(lblSales);
		
		textSales = new JTextField();
		textSales.setHorizontalAlignment(SwingConstants.CENTER);
		textSales.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textSales.setEditable(false);
		textSales.setDropMode(DropMode.INSERT);
		textSales.setColumns(10);
		textSales.setBackground(new Color(176, 224, 230));
		textSales.setBounds(157, 10, 78, 48);
		paneTtlSales.add(textSales);
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
