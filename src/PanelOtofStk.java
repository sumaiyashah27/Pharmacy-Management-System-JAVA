import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelOtofStk extends JPanel {

	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelOtofStk() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
			}
			
		});
		setBackground(new Color(204, 255, 204));
		setBounds(0,0,1195, 815);
		setLayout(null);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(266, 121, 705, 555);
		add(panelJtbl);
		
		JScrollPane scrollPaneMedTbl = new JScrollPane();
		scrollPaneMedTbl.setBounds(82, 85, 552, 382);
		panelJtbl.add(scrollPaneMedTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneMedTbl.setViewportView(table);
		
		JLabel lblManagePrescription = new JLabel("Out of Stock");
		lblManagePrescription.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-out-of-stock-32.png"));
		lblManagePrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagePrescription.setForeground(Color.BLACK);
		lblManagePrescription.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblManagePrescription.setBounds(342, 30, 443, 47);
		add(lblManagePrescription);
		
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
		model.addColumn("M_ID");
		model.addColumn("Medicine Name");
		model.addColumn("Description");
		model.addColumn("Status");
		
		try {
			String query="select * from MedData where status='OutStock'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("m_id"),
						rs.getString("m_name"),
						rs.getString("description"),
						rs.getString("status"),
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
			
			table.getColumnModel().getColumn(1).setPreferredWidth(190);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(180);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}

}
