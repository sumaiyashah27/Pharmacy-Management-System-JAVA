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
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelMngBranch extends JPanel {
	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelMngBranch() {
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
		
		JButton btnAdBranch = new JButton("Add ");
		btnAdBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-32.png"));
		btnAdBranch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
                     AdBranch ab=new AdBranch();
                     ab.setVisible(true);
            }
   });
		btnAdBranch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdBranch.setBounds(215, 688, 162, 73);
		btnAdBranch.setFocusable(false);
		add(btnAdBranch);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(323, 150, 607, 485);
		add(panelJtbl);
		panelJtbl.setLayout(null);
		
		JScrollPane scrollPaneBrTbl = new JScrollPane();
		scrollPaneBrTbl.setBounds(121, 72, 379, 341);
		panelJtbl.add(scrollPaneBrTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneBrTbl.setViewportView(table);
		
		JButton btnDeleteBranch = new JButton("Delete ");
		btnDeleteBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
		btnDeleteBranch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
            	DelBranch db=new DelBranch();
                     db.setVisible(true);
            }
   });
		btnDeleteBranch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnDeleteBranch.setFocusable(false);
		btnDeleteBranch.setBounds(549, 688, 162, 73);
		add(btnDeleteBranch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	ADashb ad = new ADashb();
            	ad.setVisible(false);
            	UpBranch ub=new UpBranch();
                     ub.setVisible(true);
            }
   });
		btnUpdate.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(849, 688, 162, 73);
		add(btnUpdate);
		
		JLabel lblManageBranch = new JLabel("Manage Branch");
		lblManageBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\branch-32.png"));
		lblManageBranch.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageBranch.setForeground(new Color(0, 0, 0));
		lblManageBranch.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblManageBranch.setBounds(423, 25, 329, 47);
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
		model.addColumn("B_ID");
		model.addColumn("Branch Name");
		model.addColumn("Post_Add");
		try {
			String query="select *from branch";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("br_id"),
						rs.getString("br_name"),
						rs.getString("postal_add"),
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
			
			table.getColumnModel().getColumn(1).setPreferredWidth(180);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
}
