import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSales extends JPanel {

	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelSales() {
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
		});
		setBounds(0,0,1195, 815);
		setBackground(new Color(204, 255, 204));
		setLayout(null);
		
		JLabel lblTitle = new JLabel(" Manage Salse");
		lblTitle.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Sales.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblTitle.setBounds(327, 51, 676, 78);
		add(lblTitle);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(392, 161, 621, 459);
		add(panelJtbl);
		
		JScrollPane scrollPaneBrTbl = new JScrollPane();
		scrollPaneBrTbl.setBounds(98, 87, 438, 283);
		panelJtbl.add(scrollPaneBrTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneBrTbl.setViewportView(table);
		
		JButton btnAdBranch = new JButton("Add ");
		btnAdBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDashb cd = new CDashb();
            	cd.setVisible(false);
                     AdSales as=new AdSales();
                     as.setVisible(true);
			}
		});
		btnAdBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Sales.png"));
		btnAdBranch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdBranch.setFocusable(false);
		btnAdBranch.setBounds(370, 671, 162, 63);
		add(btnAdBranch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDashb cd = new CDashb();
            	cd.setVisible(false);
                     UpSales up=new UpSales();
                     up.setVisible(true);
			}
		});
		btnUpdate.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(851, 671, 162, 63);
		add(btnUpdate);
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
		model.addColumn("InvID");
		model.addColumn("CustName");
		model.addColumn("Total");
		model.addColumn("Status");



		try {
			String query="select * from SalesReport";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("inv_id"),
						rs.getString("cust_name"),
						rs.getString("total"),
						rs.getString("Status"),


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
			
			table.getColumnModel().getColumn(1).setPreferredWidth(180);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			
		
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}

}
