	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import javax.swing.ImageIcon;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.SwingConstants;
	import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
	import javax.swing.JTextField;

	public class PanelSalseReport extends JPanel {

		private JTable table;
		private JTextField textTSales;

		/**
		 * Create the panel.
		 */
		public PanelSalseReport() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					ShowData();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					ShowData();
				}
			});
			setBackground(new Color(204, 255, 204));
			setBounds(0,0,1195, 815);
			setLayout(null);
			
			
			JPanel panelJtbl = new JPanel();
			panelJtbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Connection con = con1();
					try {
						String query="select sum(total) from CustSales";
							Statement st=con.createStatement();
							ResultSet rs=st.executeQuery(query);
							if(rs.next()) {
								String sum=rs.getString("sum(total)");
								textTSales.setText(sum);
							}
							
							rs.close();
							st.close();
							con.close();
							
							
						}catch (Exception e1) {
							System.out.println("error : "+e1);
						}
				}
			});
			panelJtbl.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panelJtbl.setBackground(new Color(255, 218, 185));
			panelJtbl.setBounds(350, 150, 661, 507);
			add(panelJtbl);
			panelJtbl.setLayout(null);
			
			JScrollPane scrollPaneBrTbl = new JScrollPane();
			scrollPaneBrTbl.setBounds(129, 72, 422, 336);
			panelJtbl.add(scrollPaneBrTbl);
			
			table = new JTable();
			table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			scrollPaneBrTbl.setViewportView(table);
			
			JLabel lblTotalSales = new JLabel("Total Sales :");
			lblTotalSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotalSales.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			lblTotalSales.setBounds(151, 436, 179, 50);
			panelJtbl.add(lblTotalSales);
			
			textTSales = new JTextField();
			textTSales.setHorizontalAlignment(SwingConstants.CENTER);
			textTSales.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			textTSales.setEditable(false);
			textTSales.setColumns(10);
			textTSales.setBounds(331, 438, 161, 47);
			panelJtbl.add(textTSales);
			
			JLabel lblManageBranch = new JLabel("Sales Report");
			lblManageBranch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Sales.png"));
			lblManageBranch.setHorizontalAlignment(SwingConstants.CENTER);
			lblManageBranch.setForeground(new Color(0, 0, 0));
			lblManageBranch.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lblManageBranch.setBounds(423, 25, 470, 47);
			add(lblManageBranch);
			
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
			model.addColumn("Med_ID");
			model.addColumn("Med_Name");
			model.addColumn("Rate");
			model.addColumn("Unit");
			try {
				String query="select *from CustSales";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString("med_id"),
							rs.getString("med_name"),
							rs.getString("rate"),
							rs.getString("quantity"),
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
				
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				
				table.getColumnModel().getColumn(3).setPreferredWidth(80);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				
				
			}catch (Exception e) {
				System.out.println("error : "+e);
			}
			
		}
	}
