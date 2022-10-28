import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelMngManager extends JPanel {
	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelMngManager() {
		setBackground(new Color(204, 255, 204));
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
		setBounds(0,0,1195, 815);
		setLayout(null);
		setVisible(true);
		
		JButton btnAdmanager = new JButton("Add ");
		btnAdmanager.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
                     AdManager am=new AdManager();
                     am.setVisible(true);
            }
   });
		btnAdmanager.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-user-3-32.png"));
		btnAdmanager.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdmanager.setBounds(215, 688, 162, 73);
		btnAdmanager.setFocusable(false);
		add(btnAdmanager);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(60, 150, 1097, 485);
		add(panelJtbl);
		panelJtbl.setLayout(null);
		
		JScrollPane scrollPaneBrTbl = new JScrollPane();
		scrollPaneBrTbl.setBounds(50, 53, 1005, 382);
		panelJtbl.add(scrollPaneBrTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneBrTbl.setViewportView(table);
		
		JButton btnDeleteManager = new JButton("Delete ");
		btnDeleteManager.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
            	DelManager dm=new DelManager();
                     dm.setVisible(true);
            }
   });
		btnDeleteManager.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
		btnDeleteManager.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnDeleteManager.setFocusable(false);
		btnDeleteManager.setBounds(549, 688, 162, 73);
		add(btnDeleteManager);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
            	UpManager um=new UpManager();
                     um.setVisible(true);
            }
   });
		btnUpdate.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(849, 688, 162, 73);
		add(btnUpdate);
		
		JLabel lblManageBranch = new JLabel("Manage Manager");
		lblManageBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\mangemanager-32.png"));
		lblManageBranch.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageBranch.setForeground(new Color(0, 0, 0));
		lblManageBranch.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblManageBranch.setBounds(475, 26, 329, 47);
		add(lblManageBranch);
		
		

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
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Mobile No.");
		model.addColumn("Gender");
		model.addColumn("Email Id");
		model.addColumn("Post_Add");
		model.addColumn("Username");
		model.addColumn("Password");
		try {
			String query="select *from manager";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("m_id"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getString("phone_no"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("postal_add"),
						rs.getString("uname"),
						rs.getString("pswd"),
						
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setRowHeight(30);
			table.setAutoResizeMode(0);
			
			table.getTableHeader().setFont(new Font("Book Antiqua", Font.BOLD, 20));
			DefaultTableCellRenderer centerRenderer=new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(4).setPreferredWidth(80);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(5).setPreferredWidth(200);
			table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(8).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
}
