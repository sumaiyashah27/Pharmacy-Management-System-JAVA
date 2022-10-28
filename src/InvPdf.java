import java.awt.Color;
import java.awt.EventQueue;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class InvPdf extends JFrame {

	private JTable table;
	private JTextField textCustId;
	private JTextField textName;
	private JTextField textMobno;
	private JTextField textAge;
	private JTextField textPC;
	private JTextField textTAmnt;
	private JTextField textInvno;
	private JTextField textGst;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvPdf frame = new InvPdf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvPdf() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("GeneratePdf");
		setBounds(0,0,1250, 1080);
		getContentPane().setLayout(null);
		
		JPanel panelPrint = new JPanel();
		panelPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ShowData();
				ShowData2();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ShowData();
				ShowData2();
			}
		});
		panelPrint.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panelPrint.setBackground(new Color(245, 245, 245));
		panelPrint.setBounds(114, 62, 985, 695);
		getContentPane().add(panelPrint);
		panelPrint.setLayout(null);
		
		
		
		JScrollPane scrollPanepdf = new JScrollPane();
		scrollPanepdf.setBounds(239, 310, 524, 122);
		panelPrint.add(scrollPanepdf);
		
		table = new JTable();
		table.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		scrollPanepdf.setViewportView(table);
		
		JLabel lblCustname = new JLabel("Name :");
		lblCustname.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-name-32.png"));
		lblCustname.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustname.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblCustname.setBounds(23, 152, 179, 38);
		panelPrint.add(lblCustname);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(230, 156, 158, 31);
		panelPrint.add(textName);
		
		JLabel lblNewLabel = new JLabel("Pharmacy ");
        lblNewLabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Logo_64.png"));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(401, 10, 246, 64);
		panelPrint.add(lblNewLabel);
		
		JLabel lblMobile = new JLabel("Mobile No :");
		lblMobile.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\phone-62-32.png"));
		lblMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobile.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMobile.setBounds(425, 152, 179, 38);
		panelPrint.add(lblMobile);
		
		textMobno = new JTextField();
		textMobno.setHorizontalAlignment(SwingConstants.CENTER);
		textMobno.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textMobno.setEditable(false);
		textMobno.setColumns(10);
		textMobno.setBounds(632, 156, 158, 31);
		panelPrint.add(textMobno);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-age-32.png"));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblAge.setBounds(23, 202, 179, 38);
		panelPrint.add(lblAge);
		
		textAge = new JTextField();
		textAge.setHorizontalAlignment(SwingConstants.CENTER);
		textAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textAge.setEditable(false);
		textAge.setColumns(10);
		textAge.setBounds(230, 206, 78, 31);
		panelPrint.add(textAge);
		
		JLabel lblPinode = new JLabel("Pinode :");
		lblPinode.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-address-32.png"));
		lblPinode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinode.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblPinode.setBounds(425, 202, 179, 38);
		panelPrint.add(lblPinode);
		
		textPC = new JTextField();
		textPC.setHorizontalAlignment(SwingConstants.CENTER);
		textPC.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textPC.setEditable(false);
		textPC.setColumns(10);
		textPC.setBounds(632, 206, 158, 31);
		panelPrint.add(textPC);
		
		JLabel lblMedicine = new JLabel("Medicine Details");
		lblMedicine.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pills-32.png"));
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicine.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblMedicine.setBounds(229, 262, 521, 38);
		panelPrint.add(lblMedicine);
		
		JLabel lblNetAmt = new JLabel("Net Amount :");
		lblNetAmt.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetAmt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblNetAmt.setBounds(410, 442, 179, 38);
		panelPrint.add(lblNetAmt);
		
		textTAmnt = new JTextField();
		textTAmnt.setHorizontalAlignment(SwingConstants.CENTER);
		textTAmnt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textTAmnt.setEditable(false);
		textTAmnt.setColumns(10);
		textTAmnt.setBounds(605, 446, 158, 31);
		panelPrint.add(textTAmnt);
		
		JLabel lblInvoiceNo = new JLabel("Invoice No :");
		lblInvoiceNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceNo.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblInvoiceNo.setBounds(23, 104, 179, 38);
		panelPrint.add(lblInvoiceNo);
		
		textInvno = new JTextField();
		textInvno.setHorizontalAlignment(SwingConstants.CENTER);
		textInvno.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textInvno.setEditable(false);
		textInvno.setColumns(10);
		textInvno.setBounds(230, 108, 78, 31);
		panelPrint.add(textInvno);
		
		JLabel lblGst = new JLabel("GST 12% :");
		lblGst.setHorizontalAlignment(SwingConstants.CENTER);
		lblGst.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblGst.setBounds(410, 490, 179, 38);
		panelPrint.add(lblGst);
		
		textGst = new JTextField();
		textGst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double v1;
				v1=Double.valueOf(textTAmnt.getText());
				
				double gst;
				gst=Math.round(0.12*v1);
				textGst.setText(""+gst);
			}
		});
		
		textGst.setHorizontalAlignment(SwingConstants.CENTER);
		textGst.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textGst.setEditable(false);
		textGst.setColumns(10);
		textGst.setBounds(605, 494, 158, 31);
		panelPrint.add(textGst);
		
		JLabel lblTotalAmt = new JLabel("Total Amount :");
		lblTotalAmt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		lblTotalAmt.setBounds(410, 538, 179, 38);
		panelPrint.add(lblTotalAmt);
		
		textTotal = new JTextField();
		textTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double v1,v2;
				v1=Double.valueOf(textTAmnt.getText());
				v2=Double.valueOf(textGst.getText());
				double sum;
				sum=v1+v2;
				textTotal.setText(""+sum);
			}
		});
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		textTotal.setEditable(false);
		textTotal.setColumns(10);
		textTotal.setBounds(605, 542, 158, 31);
		panelPrint.add(textTotal);
		
		JLabel lblthankyouVisitAgain = new JLabel("**********Thank You ! Visit Again**********");
		lblthankyouVisitAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblthankyouVisitAgain.setForeground(Color.BLACK);
		lblthankyouVisitAgain.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 30));
		lblthankyouVisitAgain.setBounds(157, 624, 671, 64);
		panelPrint.add(lblthankyouVisitAgain);
		
		JLabel lblCustId = new JLabel("Cust ID :");
		lblCustId.setBounds(330, 10, 179, 42);
		getContentPane().add(lblCustId);
		lblCustId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		
		textCustId = new JTextField();
		textCustId.setBounds(499, 11, 108, 41);
		getContentPane().add(textCustId);
		textCustId.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		textCustId.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					PreparedStatement pst;
					pst=con.prepareStatement("select * from Invoice where cust_id=?");
					int Id=Integer.parseInt(textCustId.getText());
					
					pst.setInt(1, Id);
					 ResultSet rs=pst.executeQuery();

					 if(rs.next()) {
						 textInvno.setText(rs.getString("inv_id"));
						
						 }
					 else {
						 	JOptionPane.showMessageDialog(null,"No Data Found...!");
						 textInvno.setText("");
						 
					 }
					 
					con.close();
				}catch(Exception e2) {
					System.out.println("error : "+e2);
					
				}
			}
		});
		btnSearch.setBounds(662, 11, 152, 41);
		getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","Sum@iy@27");
					
					PreparedStatement pst;
					pst=con.prepareStatement("select * from prescription where cust_id=?");
					int Id=Integer.parseInt(textCustId.getText());
					
					pst.setInt(1, Id);
					 ResultSet rs=pst.executeQuery();

					 if(rs.next()) {
						 textName.setText(rs.getString("cust_name"));
						 textMobno.setText(rs.getString("phone_no"));
						 textAge.setText(rs.getString("age"));
						 textPC.setText(rs.getString("post_add"));
						
						 }
					 else {
						 JOptionPane.showMessageDialog(null,"No Data Found...!");
						 textInvno.setText("");
						 textCustId.setText("");
						 textName.setText("");
						 textMobno.setText("");
						 textAge.setText("");
						 textPC.setText("");
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
		
		JButton btnGeneratePdf = new JButton(" PDF/PRINT");
		btnGeneratePdf.setBounds(510, 767, 189, 48);
		getContentPane().add(btnGeneratePdf);
		btnGeneratePdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrinterJob job=PrinterJob.getPrinterJob();
				job.setJobName("Print Data");
				
				job.setPrintable(new Printable() {
					public int print(Graphics pg,PageFormat pf,int pageNum) {
						pf.setOrientation(PageFormat.PORTRAIT);
						if(pageNum>0) {
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D g2=(Graphics2D)pg;
						g2.translate(pf.getImageableX(),pf.getImageableY());
						g2.scale(0.47,0.47);
						panelPrint.print(g2);
						
						return Printable.PAGE_EXISTS;
					}
				});
				boolean ok=job.printDialog();
				if(ok) {
					try {
						job.print();
					}
					catch(PrinterException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnGeneratePdf.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnGeneratePdf.setFocusable(false);
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
		model.addColumn("Rate");
		model.addColumn("Quantity");
		model.addColumn("Total");
		try {
			String query="select * from CustSales where cust_id='"+textCustId.getText()+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("med_id"),
						rs.getString("med_name"),
						rs.getString("rate"),
						rs.getString("quantity"),
						rs.getString("total"),
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
			
			table.getColumnModel().getColumn(4).setPreferredWidth(80);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			
			
		}catch (Exception e) {
			System.out.println("error : "+e);
		}
		
	}
	private void ShowData2() {
		Connection con = con1();
		try {
			String query="select sum(total) from CustSales where cust_id='"+textCustId.getText()+"'";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				if(rs.next()) {
					String sum=rs.getString("sum(total)");
					textTAmnt.setText(sum);
				}
				
				rs.close();
				st.close();
				con.close();
				
				
			}catch (Exception e1) {
				System.out.println("error : "+e1);
			}
	}
}
