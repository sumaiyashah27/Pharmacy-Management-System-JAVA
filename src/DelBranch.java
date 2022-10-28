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

	public class DelBranch extends JFrame {
		private JTextField textBrId;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DelBranch db = new DelBranch();
						db.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public DelBranch() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
			setTitle("DeleteBranch");
			setBounds(0,0,1195, 815);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBackground(new Color(255, 182, 193));
			panel.setBounds(162, 148, 871, 486);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblBrId = new JLabel("Branch ID :");
			lblBrId.setBounds(149, 142, 179, 59);
			panel.add(lblBrId);
			lblBrId.setHorizontalAlignment(SwingConstants.CENTER);
			lblBrId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			
			textBrId = new JTextField();
			textBrId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			        	textBrId.setEditable(true);
			        }
			        else
			        {
			        	textBrId.setEditable(false);
			        }
				}
			});
			textBrId.setBounds(318, 143, 315, 59);
			panel.add(textBrId);
			textBrId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
			textBrId.setColumns(10);
			
			JButton btnDeldb = new JButton("Delete");
			btnDeldb.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
			btnDeldb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=textBrId.getText();
					
					int Id=Integer.parseInt(id);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						Statement stmt=con.createStatement();
						String query="delete from branch where br_id='"+textBrId.getText()+"' ";
						
						stmt.executeUpdate(query);
						
							JOptionPane.showMessageDialog(null,"Branch Record Deleted");
						con.close();
						clearFields();
						
					}catch (Exception e1){
						System.out.println("ConnectionFailed..!");
					}
				}
			});
			btnDeldb.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			btnDeldb.setBounds(356, 305, 196, 59);
			btnDeldb.setFocusable(false);
			panel.add(btnDeldb);
			
			JLabel lblRgstr = new JLabel("Delete Branch");
			lblRgstr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\delete-32.png"));
			lblRgstr.setHorizontalAlignment(SwingConstants.CENTER);
			lblRgstr.setFont(new Font("Book Antiqua", Font.BOLD, 35));
			lblRgstr.setBounds(220, 10, 483, 78);
			panel.add(lblRgstr);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
						
						PreparedStatement pst;
						pst=con.prepareStatement("select * from branch where br_id=?");
						int Id=Integer.parseInt(textBrId.getText());
						
						pst.setInt(1, Id);
						 ResultSet rs=pst.executeQuery();

						 if(rs.next()) {
							 JOptionPane.showMessageDialog(null,"Branch Record Found");
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Branch Record Not Found");
							 textBrId.setText("");
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
			btnSearch.setBounds(683, 151, 152, 41);
			panel.add(btnSearch);
			

		}
		private void clearFields() {
			textBrId.setText(null);
		}
	}
