import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelMedSrch extends JPanel {
	private JTextField textSearch;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelMedSrch() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(textSearch.getText().equals("Search Medicines")) {
					textSearch.setText("");
					textSearch.setForeground(new Color(153,153,153));
			}
		}
		});
		setBackground(new Color(204, 255, 204));
		setBounds(0,0,1195, 815);
		setLayout(null);
		
		JLabel lblSearchMedicines = new JLabel("Search Medicines");
		lblSearchMedicines.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\search-9-32.png"));
		lblSearchMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMedicines.setForeground(Color.BLACK);
		lblSearchMedicines.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 35));
		lblSearchMedicines.setBounds(385, 29, 329, 47);
		add(lblSearchMedicines);
		
		JPanel panelJtbl = new JPanel();
		panelJtbl.setLayout(null);
		panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelJtbl.setBackground(new Color(255, 218, 185));
		panelJtbl.setBounds(155, 111, 888, 571);
		add(panelJtbl);
		
		textSearch = new JTextField();
		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Connection con = con1();
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("M_ID");
				model.addColumn("Medicine Name");
				model.addColumn("Description");
				model.addColumn("MFG.Date");
				model.addColumn("Exp.Date");
				model.addColumn("Status");
				try {
					String query="select *from MedData where m_name=?";
					PreparedStatement pst =con.prepareStatement(query);
					pst.setString(1,textSearch.getText());
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()) {
						model.addRow(new Object[] {
								rs.getString("m_id"),
								rs.getString("m_name"),
								rs.getString("description"),
								rs.getString("mfg_date"),
								rs.getString("exp_date"),
								rs.getString("status"),
						});
						
					}
					rs.close();
					pst.close();
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
					
					table.getColumnModel().getColumn(5).setPreferredWidth(100);
					table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
					
					
				}catch (Exception e1) {
					System.out.println("error : "+e1);
				}
			}
		});
		textSearch.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textSearch.setColumns(10);
		textSearch.setBounds(244, 47, 315, 49);
		panelJtbl.add(textSearch);
		
		JScrollPane scrollPaneBrTbl = new JScrollPane();
		scrollPaneBrTbl.setEnabled(false);
		scrollPaneBrTbl.setBounds(86, 142, 728, 345);
		panelJtbl.add(scrollPaneBrTbl);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPaneBrTbl.setViewportView(table);
		
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
