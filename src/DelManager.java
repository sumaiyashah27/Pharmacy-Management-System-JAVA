	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.sql.*;
	import javax.swing.SwingConstants;
	import javax.swing.JTextField;
	import javax.swing.JPanel;
	import java.awt.Color;
	import javax.swing.border.LineBorder;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

	public class DelManager extends JFrame {
		private JTextField textMngrId;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DelManager dm = new DelManager();
						dm.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public DelManager() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("DeleteManager");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(162, 148, 871, 486);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblMngrId = new JLabel("Manager ID :");
			lblMngrId.setBounds(141, 142, 179, 59);
			panel.add(lblMngrId);
			lblMngrId.setHorizontalAlignment(SwingConstants.CENTER);
			lblMngrId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			textMngrId = new JTextField();
			textMngrId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textMngrId.setEditable(true);
			        }
			        else
			        {
			        	textMngrId.setEditable(false);
			        }
				}
			});
			textMngrId.setBounds(310, 143, 315, 59);
			panel.add(textMngrId);
			textMngrId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			textMngrId.setColumns(10);
			
			JButton btnDeldb = new JButton("Delete");
			btnDeldb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
			btnDeldb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=textMngrId.getText();
					
					int Id=Integer.parseInt(id);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						Statement stmt=con.createStatement();
						String query="delete from manager where m_id='"+textMngrId.getText()+"' ";
						
						stmt.executeUpdate(query);
						
							JOptionPane.showMessageDialog(null,"Manager Record Deleted");
						con.close();
						clearFields();
						
					}catch (Exception e1){
						System.out.println("ConnectionFailed..!");
					}
				}
			});
			btnDeldb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnDeldb.setBounds(415, 305, 196, 59);
			btnDeldb.setFocusable(false);
			panel.add(btnDeldb);
			
			JLabel lbldelstr = new JLabel("Delete Manager");
			lbldelstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
			lbldelstr.setHorizontalAlignment(SwingConstants.CENTER);
			lbldelstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lbldelstr.setBounds(220, 10, 483, 98);
			panel.add(lbldelstr);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from manager where m_id=?");
						int Id=Integer.parseInt(textMngrId.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 JOptionPane.showMessageDialog(null,"Manager Record Found");
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Manager Record Not Found");
							 textMngrId.setText("");
						 }
						 
						con.close();
					}catch(Exception e2) {
						System.out.println("error : "+e2);
						
					}
				}
			});
			btnSearch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\search-9-32.png"));
			btnSearch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnSearch.setFocusable(false);
			btnSearch.setBounds(665, 149, 152, 41);
			panel.add(btnSearch);

		}
		private void clearFields() {
			textMngrId.setText(null);
		}
	}
