import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

public class PanelPhDash extends JPanel {
	private JTextField textTltMed;
	private JTextField textTltprcs;
	private JTextField textOtOfStk;
	private JTextField texExpMedicine;

	/**
	 * Create the panel.
	 */
	public PanelPhDash() {
		setBounds(0,0,1195, 815);
		setBackground(new Color(204, 255, 204));
		setLayout(null);
		
		JLabel lblTitle = new JLabel(" DASHBOARD");
		lblTitle.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblTitle.setBounds(326, 21, 676, 68);
		add(lblTitle);
		
		JPanel paneTtlMedicines = new JPanel();
		paneTtlMedicines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlMedicines.setBackground(new Color(176, 224, 230));
				textTltMed.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from MedData";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textTltMed.setText(count);
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
				paneTtlMedicines.setBackground(new Color(176, 224, 230));
				textTltMed.setVisible(false);
			}
		});
		paneTtlMedicines.setLayout(null);
		paneTtlMedicines.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlMedicines.setBackground(new Color(176, 224, 230));
		paneTtlMedicines.setBounds(117, 241, 245, 143);
		add(paneTtlMedicines);
		
		JLabel lblmedicines = new JLabel("Medicine's");
		lblmedicines.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pill-2-24.png"));
		lblmedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblmedicines.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblmedicines.setBounds(50, 56, 152, 42);
		paneTtlMedicines.add(lblmedicines);
		
		textTltMed = new JTextField();
		textTltMed.setHorizontalAlignment(SwingConstants.CENTER);
		textTltMed.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textTltMed.setEditable(false);
		textTltMed.setDropMode(DropMode.INSERT);
		textTltMed.setColumns(10);
		textTltMed.setBackground(new Color(176, 224, 230));
		textTltMed.setBounds(157, 10, 78, 48);
		paneTtlMedicines.add(textTltMed);
		
		JPanel paneTtlprescript = new JPanel();
		paneTtlprescript.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTtlprescript.setBackground(new Color(176, 224, 230));
				textTltprcs.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from prescription";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textTltprcs.setText(count);
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
				paneTtlprescript.setBackground(new Color(176, 224, 230));
				textTltprcs.setVisible(false);
			}
		});
		paneTtlprescript.setLayout(null);
		paneTtlprescript.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTtlprescript.setBackground(new Color(176, 224, 230));
		paneTtlprescript.setBounds(863, 227, 245, 143);
		add(paneTtlprescript);
		
		JLabel lblprescript = new JLabel("Prescriptions");
		lblprescript.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
		lblprescript.setHorizontalAlignment(SwingConstants.CENTER);
		lblprescript.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblprescript.setBounds(51, 57, 152, 42);
		paneTtlprescript.add(lblprescript);
		
		textTltprcs = new JTextField();
		textTltprcs.setHorizontalAlignment(SwingConstants.CENTER);
		textTltprcs.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textTltprcs.setEditable(false);
		textTltprcs.setDropMode(DropMode.INSERT);
		textTltprcs.setColumns(10);
		textTltprcs.setBackground(new Color(176, 224, 230));
		textTltprcs.setBounds(157, 10, 78, 48);
		paneTtlprescript.add(textTltprcs);
		
		JPanel paneTltOtOfStock = new JPanel();
		paneTltOtOfStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneTltOtOfStock.setBackground(new Color(176, 224, 230));
				textOtOfStk.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from MedData where status='OutStock'";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						textOtOfStk.setText(count);
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
				paneTltOtOfStock.setBackground(new Color(176, 224, 230));
				textOtOfStk.setVisible(false);
			}
		});
		paneTltOtOfStock.setLayout(null);
		paneTltOtOfStock.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneTltOtOfStock.setBackground(new Color(176, 224, 230));
		paneTltOtOfStock.setBounds(117, 533, 245, 143);
		add(paneTltOtOfStock);
		
		JLabel lblOutOfStock = new JLabel("Out Of Stock");
		lblOutOfStock.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-out-of-stock-32.png"));
		lblOutOfStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutOfStock.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblOutOfStock.setBounds(28, 62, 174, 38);
		paneTltOtOfStock.add(lblOutOfStock);
		
		textOtOfStk = new JTextField();
		textOtOfStk.setHorizontalAlignment(SwingConstants.CENTER);
		textOtOfStk.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textOtOfStk.setEditable(false);
		textOtOfStk.setDropMode(DropMode.INSERT);
		textOtOfStk.setColumns(10);
		textOtOfStk.setBackground(new Color(176, 224, 230));
		textOtOfStk.setBounds(157, 10, 78, 48);
		paneTltOtOfStock.add(textOtOfStk);
		
		JPanel paneExpiredmed = new JPanel();
		paneExpiredmed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneExpiredmed.setBackground(new Color(176, 224, 230));
				texExpMedicine.setVisible(true);
				Connection con = con1();
				try {
					String query="select count(*) from MedData where DATE(exp_date)<DATE(NOW())";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						String count=rs.getString("count(*)");
						texExpMedicine.setText(count);
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
				paneTltOtOfStock.setBackground(new Color(176, 224, 230));
				texExpMedicine.setVisible(false);
			}
		});
		paneExpiredmed.setLayout(null);
		paneExpiredmed.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		paneExpiredmed.setBackground(new Color(176, 224, 230));
		paneExpiredmed.setBounds(863, 533, 245, 143);
		add(paneExpiredmed);
		
		JLabel lblExpiredMedicines = new JLabel("Expired Medicines");
		lblExpiredMedicines.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-expired-32.png"));
		lblExpiredMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpiredMedicines.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblExpiredMedicines.setBounds(10, 64, 225, 32);
		paneExpiredmed.add(lblExpiredMedicines);
		
		texExpMedicine = new JTextField();
		texExpMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		texExpMedicine.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		texExpMedicine.setEditable(false);
		texExpMedicine.setDropMode(DropMode.INSERT);
		texExpMedicine.setColumns(10);
		texExpMedicine.setBackground(new Color(176, 224, 230));
		texExpMedicine.setBounds(157, 10, 78, 48);
		paneExpiredmed.add(texExpMedicine);
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
