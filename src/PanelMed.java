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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelMed extends JPanel {

	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelMed() {
		setBounds(0,0,1195, 815);
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
		setLayout(null);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(187, 150, 861, 485);
		add(panelJtbl);
		panelJtbl.setLayout(null);
		
		JScrollPane scrollPaneMedTbl = new JScrollPane();
		scrollPaneMedTbl.setBounds(76, 56, 723, 373);
		panelJtbl.add(scrollPaneMedTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneMedTbl.setViewportView(table);
		
		JButton btnAdMed = new JButton("Add ");
		btnAdMed.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		btnAdMed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	PhDashb phd = new PhDashb();
            	phd.setVisible(false);
                     AdMedicine amed=new AdMedicine();
                     amed.setVisible(true);
            }
   });
		btnAdMed.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnAdMed.setFocusable(false);
		btnAdMed.setBounds(215, 658, 162, 73);
		add(btnAdMed);
		
		JButton btnDeleteMed = new JButton("Delete ");
		btnDeleteMed.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
		btnDeleteMed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	PhDashb phd = new PhDashb();
            	phd.setVisible(false);
            	DelMedicine dmed=new DelMedicine();
            	dmed.setVisible(true);
            }
   });
		btnDeleteMed.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnDeleteMed.setFocusable(false);
		btnDeleteMed.setBounds(549, 658, 162, 73);
		add(btnDeleteMed);
		
		JButton btnUpdateMed = new JButton("Update");
		btnUpdateMed.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
		btnUpdateMed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
            	PhDashb phd = new PhDashb();
            	phd.setVisible(false);
            	UpMedicine umed=new UpMedicine();
                     umed.setVisible(true);
            }
   });
		btnUpdateMed.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnUpdateMed.setFocusable(false);
		btnUpdateMed.setBounds(849, 658, 162, 73);
		add(btnUpdateMed);
		
		JLabel lblManageMedicines = new JLabel("Manage Medicines");
		lblManageMedicines.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		lblManageMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageMedicines.setForeground(Color.BLACK);
		lblManageMedicines.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		lblManageMedicines.setBounds(421, 40, 389, 47);
		add(lblManageMedicines);
		
		
		
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
		model.addColumn("MFG.Date");
		model.addColumn("Exp.Date");
		try {
			String query="select *from MedData";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("m_id"),
						rs.getString("m_name"),
						rs.getString("description"),
						rs.getString("mfg_date"),
						rs.getString("exp_date"),
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
			
			table.getColumnModel().getColumn(2).setPreferredWidth(190);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.getColumnModel().getColumn(4).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
	
}
