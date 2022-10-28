import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class MDashb extends JFrame {
	private PanelMngDash panelMngDash;
	private MngPharmacist panelmngPharmacist;
	private MangCashier panelmngCashier;
	private ManageStock panelmngStock;
	private SalesReport panelviewSales;
	

    JLabel background;
	private JPanel contentPane;
	private static Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDashb md = new MDashb();
					md.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		showWindow();
	}

	/**
	 * Create the frame.
	 */
	public MDashb() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1650,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panelMngDash = new PanelMngDash();
		 panelmngPharmacist = new MngPharmacist();
		 panelmngCashier = new MangCashier();
		 panelmngStock = new ManageStock();
		 panelviewSales = new SalesReport();
		
		 JPanel panelMenu = new JPanel();
		 panelMenu.setBackground(new Color(51, 51, 102));
		 panelMenu.setBounds(10, 10, 315, 835);
		 contentPane.add(panelMenu);
		 panelMenu.setLayout(null);
		 JLabel background=new JLabel(new ImageIcon("D:\\EJ\\PMS\\img\\Manager.png"));
	     background.setBounds(10, 10, 293, 237);
	     panelMenu.add(background);
		
	     JPanel Dashboard = new JPanel();
	     Dashboard.addMouseListener(new PanelButtonMouseAdapter(Dashboard) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelMngDash);
	     		}
	     	});
	        Dashboard.setBackground(new Color(255, 255, 255));
	        Dashboard.setBounds(10, 279, 293, 64);
	        panelMenu.add(Dashboard);
	        Dashboard.setLayout(null);
	        
	        JLabel DashLabel = new JLabel("Dashboard");
	        DashLabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
	        DashLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        DashLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	        DashLabel.setBounds(100, 10, 183, 44);
	        Dashboard.add(DashLabel);
		 
	        JPanel MngPharmcst = new JPanel();
	     	MngPharmcst.addMouseListener(new PanelButtonMouseAdapter(MngPharmcst) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelmngPharmacist);
	     		}
	     	});
	        MngPharmcst.setBackground(new Color(255, 255, 255));
	        MngPharmcst.setBounds(10, 353, 293, 64);
	        panelMenu.add(MngPharmcst);
	        MngPharmcst.setLayout(null);
	        
	        JLabel ManagePharmacist = new JLabel("Manage Pharmacist");
	        ManagePharmacist.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\manager-32.png"));
	        ManagePharmacist.setHorizontalAlignment(SwingConstants.TRAILING);
	        ManagePharmacist.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        ManagePharmacist.setBounds(60, 10, 223, 44);
	        MngPharmcst.add(ManagePharmacist);
	        
	        JPanel paneManageCashier = new JPanel();
	        paneManageCashier.addMouseListener(new PanelButtonMouseAdapter(paneManageCashier) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelmngCashier);
	     		}
	     	});
	        paneManageCashier.setBackground(new Color(255, 255, 255));
	        paneManageCashier.setBounds(10, 427, 293, 64);
	        panelMenu.add(paneManageCashier);
	        paneManageCashier.setLayout(null);
	        
	        JLabel MngCashier = new JLabel("Manage Cashier");
	        MngCashier.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\manager-32.png"));
	        MngCashier.setHorizontalAlignment(SwingConstants.TRAILING);
	        MngCashier.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        MngCashier.setBounds(60, 10, 223, 44);
	        paneManageCashier.add(MngCashier);
	        
	        JPanel panemngStock = new JPanel();
	        panemngStock.addMouseListener(new PanelButtonMouseAdapter(panemngStock) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelmngStock);
	     		}
	     	});
	        panemngStock.setBackground(new Color(255, 255, 255));
	        panemngStock.setBounds(10, 501, 293, 64);
	        panelMenu.add(panemngStock);
	        panemngStock.setLayout(null);
	        
	        
	        JLabel mngStock = new JLabel("Manage Stock");
	        mngStock.setBounds(60, 10, 223, 44);
	        panemngStock.add(mngStock);
	        mngStock.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Stock.png"));
	        mngStock.setHorizontalAlignment(SwingConstants.TRAILING);
	        mngStock.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        
	        JPanel SalesReport = new JPanel();
	        SalesReport.addMouseListener(new PanelButtonMouseAdapter(SalesReport) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelviewSales);
	     		}
	     	});
	        SalesReport.setBackground(new Color(255, 255, 255));
	        SalesReport.setBounds(10, 575, 293, 64);
	        panelMenu.add(SalesReport);
	        SalesReport.setLayout(null);
	        
	        
	        JLabel ViewSales = new JLabel("View Sales Report");
	        ViewSales.setBounds(60, 10, 223, 44);
	        SalesReport.add(ViewSales);
	        ViewSales.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Sales.png"));
	        ViewSales.setHorizontalAlignment(SwingConstants.TRAILING);
	        ViewSales.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        
	        JPanel paneLogout = new JPanel();
	        paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout) {
				@Override
	     		public void mouseClicked(MouseEvent e) {
	        		if(JOptionPane.showConfirmDialog(null,"Are You Sure You Want To LogOUT ? ")==0){
	        			MDashb md = new MDashb();
						md.setVisible(false);
						ManagerLP mp=new ManagerLP();
	                    mp.showWindow();
	          
	            	}
	        	}
	        });
	        paneLogout.setBackground(new Color(255, 255, 255));
	        paneLogout.setBounds(10, 649, 293, 64);
	        panelMenu.add(paneLogout);
	        paneLogout.setLayout(null);
	        
	        JLabel LogOut = new JLabel("Log Out");
	        LogOut.setBounds(47, 10, 236, 44);
	        paneLogout.add(LogOut);
	        LogOut.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\logout-32.png"));
	        LogOut.setHorizontalAlignment(SwingConstants.TRAILING);
	        LogOut.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        
	        JPanel panelMainContent = new JPanel();
	        panelMainContent.setBounds(335, 10, 1195, 825);
	        contentPane.add(panelMainContent);
	        panelMainContent.setLayout(null);
	        
	        
	        panelMainContent.add(panelviewSales);
	        panelMainContent.add(panelmngStock);
	        panelMainContent.add(panelmngCashier);
	        panelMainContent.add(panelmngPharmacist);
	        panelMainContent.add(panelMngDash);
	        
	        menuClicked(panelMngDash);
	        
	}
	
	public void menuClicked(JPanel panel) {
		panelMngDash.setVisible(true);
		panelmngPharmacist.setVisible(false);
		panelmngCashier.setVisible(false);
		panelmngStock.setVisible(false);
		panelviewSales.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	private class PanelButtonMouseAdapter extends  MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
	}
	
	

	public static void showWindow() {
		MDashb md = new MDashb();
		md.setVisible(true);
	}
}
