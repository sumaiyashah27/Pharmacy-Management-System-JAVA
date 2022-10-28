
	import javax.swing.JPanel;
	import java.awt.Font;
	import javax.swing.JButton;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;
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
	import javax.swing.border.MatteBorder;
	import java.awt.ScrollPane;
	import java.awt.SystemColor;
import javax.swing.SwingConstants;

	public class ManageStock extends JPanel {


		private JTable table;


		/**
		 * Create the panel.
		 */
		public ManageStock() {
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
			setVisible(true);
			
			JButton btnAdPharm = new JButton("Add");
			btnAdPharm.setBounds(177, 541, 162, 59);
			btnAdPharm.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Stock.png"));
			btnAdPharm.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	               MDashb md = new MDashb();
	               md.setVisible(false);
	               AdStock as=new AdStock();
	               as.setVisible(true);
	            }
	   });
			setLayout(null);
			btnAdPharm.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnAdPharm.setFocusable(false);
			add(btnAdPharm);
			
			
			JButton btnDeletePharm = new JButton("Delete");
			btnDeletePharm.setBounds(508, 541, 162, 59);
			btnDeletePharm.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
			btnDeletePharm.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	MDashb md = new MDashb();
	            	md.setVisible(false);
	            	DelStock ds=new DelStock();
	                     ds.setVisible(true);
	            }
	   });
			btnDeletePharm.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnDeletePharm.setFocusable(false);
			add(btnDeletePharm);
			
			JButton btnUpdatePharm = new JButton("Update");
			btnUpdatePharm.setBounds(840, 541, 162, 59);
			btnUpdatePharm.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\available-updates-32.png"));
			btnUpdatePharm.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	MDashb md = new MDashb();
	            	md.setVisible(false);
	            	UpStock us=new UpStock();
	                     us.setVisible(true);
	            }
	   });
			btnUpdatePharm.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnUpdatePharm.setFocusable(false);
			add(btnUpdatePharm);
			
			JLabel lblManagePharmacist = new JLabel("Manage Stock");
			lblManagePharmacist.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Stock.png"));
			lblManagePharmacist.setHorizontalAlignment(SwingConstants.CENTER);
			lblManagePharmacist.setBounds(428, 29, 329, 47);
			lblManagePharmacist.setForeground(new Color(0, 0, 0));
			lblManagePharmacist.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 35));
			add(lblManagePharmacist);
			
			
			JScrollPane scrollPanepharm = new JScrollPane();
			scrollPanepharm.setBounds(322, 94, 518, 382);
			add(scrollPanepharm);
			
			table = new JTable();
			table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			scrollPanepharm.setViewportView(table);
			
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
			model.addColumn("S_ID");
			model.addColumn("Med_ID");
			model.addColumn("Med_Name");
			model.addColumn("Unit");
			model.addColumn("Rate");
			try {
				String query="select *from medStock";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString("st_id"),
							rs.getString("m_id"),
							rs.getString("med_name"),
							rs.getString("unit"),
							rs.getString("rate"),
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
				
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				
				table.getColumnModel().getColumn(2).setPreferredWidth(180);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				
				table.getColumnModel().getColumn(3).setPreferredWidth(80);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				
				table.getColumnModel().getColumn(4).setPreferredWidth(80);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				
			}catch (Exception e) {
				System.out.println("error : "+e);
			}
			
		}
	}