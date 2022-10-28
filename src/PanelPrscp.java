import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelPrscp extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelPrscp() {
		setBackground(new Color(204, 255, 204));
		setBounds(0,0,1195, 815);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ShowData();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ShowData();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ShowData();
			}
		});
		setLayout(null);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(215, 120, 735, 538);
		add(panelJtbl);
		
		JScrollPane scrollPaneMedTbl = new JScrollPane();
		scrollPaneMedTbl.setBounds(102, 72, 543, 382);
		panelJtbl.add(scrollPaneMedTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneMedTbl.setViewportView(table);
		
		JLabel lblManagePrescription = new JLabel("Manage Prescription");
		lblManagePrescription.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
		lblManagePrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagePrescription.setForeground(Color.BLACK);
		lblManagePrescription.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblManagePrescription.setBounds(342, 30, 443, 47);
		add(lblManagePrescription);
		
		JButton btnAdPrescrpt = new JButton("Add ");
		btnAdPrescrpt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	PhDashb phd = new PhDashb();
            	phd.setVisible(false);
            	AdPrescription ap = new AdPrescription();
				ap.setVisible(true);
            }
   });
		btnAdPrescrpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
		btnAdPrescrpt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdPrescrpt.setFocusable(false);
		btnAdPrescrpt.setBounds(215, 690, 162, 73);
		add(btnAdPrescrpt);
		
		JButton btnDelPrescrpt = new JButton("Delete ");
		btnDelPrescrpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhDashb phd = new PhDashb();
            	phd.setVisible(false);
            	DelPrescription dp = new DelPrescription();
				dp.setVisible(true);
			}
		});
		btnDelPrescrpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
		btnDelPrescrpt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnDelPrescrpt.setFocusable(false);
		btnDelPrescrpt.setBounds(517, 690, 162, 73);
		add(btnDelPrescrpt);
		
		JButton btnUpdatePrescrpt = new JButton("Update");
		btnUpdatePrescrpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhDashb phd = new PhDashb();
            	phd.setVisible(false);
            	UpPrescription up = new UpPrescription();
				up.setVisible(true);
			}
		});
		btnUpdatePrescrpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdatePrescrpt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdatePrescrpt.setFocusable(false);
		btnUpdatePrescrpt.setBounds(788, 690, 162, 73);
		add(btnUpdatePrescrpt);
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
	
	
	private void ShowData() {
		Connection con = con1();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("P_ID");
		model.addColumn("Cust_ID");
		model.addColumn("Cust_Name");
		model.addColumn("Mobile No");
		model.addColumn("Post_Add");
		try {
			String query="select *from prescription";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("p_id"),
						rs.getString("cust_id"),
						rs.getString("cust_name"),
						rs.getString("phone_no"),
						rs.getString("post_add"),
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
			
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}

}
