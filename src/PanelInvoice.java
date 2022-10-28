import java.awt.Color;
import java.awt.Font;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInvoice extends JPanel {

	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelInvoice() {
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
		
		JLabel lblTitle = new JLabel(" Manage Invoice ");
		lblTitle.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\invoice-24.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblTitle.setBounds(327, 51, 676, 78);
		add(lblTitle);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(292, 167, 711, 485);
		add(panelJtbl);
		
		JScrollPane scrollPaneBrTbl = new JScrollPane();
		scrollPaneBrTbl.setBounds(95, 93, 539, 294);
		panelJtbl.add(scrollPaneBrTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneBrTbl.setViewportView(table);
		
		JButton btnAdBranch = new JButton("Add ");
		btnAdBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDashb cd = new CDashb();
            	cd.setVisible(false);
                     AdInvoice ai=new AdInvoice();
                     ai.setVisible(true);
			}
		});
		btnAdBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\invoice-24.png"));
		btnAdBranch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdBranch.setFocusable(false);
		btnAdBranch.setBounds(243, 705, 162, 73);
		add(btnAdBranch);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDashb cd = new CDashb();
            	cd.setVisible(false);
            	InvPdf ip=new InvPdf();
            	ip.setVisible(true);
			}
		});
		btnPrint.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\printer-4-32.gif"));
		btnPrint.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnPrint.setFocusable(false);
		btnPrint.setBounds(875, 705, 162, 73);
		add(btnPrint);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDashb cd = new CDashb();
            	cd.setVisible(false);
                     UpInvoice ui=new UpInvoice();
                     ui.setVisible(true);
			}
		});
		btnUpdate.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(566, 705, 162, 73);
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
		model.addColumn("Inv_Id");
		model.addColumn("P_Id");
		model.addColumn("Cust_Id");
		model.addColumn("Cust_Name");
		model.addColumn("MobileNo");



		try {
			String query="select * from Invoice";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("inv_id"),
						rs.getString("p_id"),
						rs.getString("cust_id"),
						rs.getString("cust_name"),
						rs.getString("phoneno"),
						

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
			
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(180);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
}
