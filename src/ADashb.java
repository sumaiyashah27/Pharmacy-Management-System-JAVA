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

public class ADashb extends JFrame {
	
	private PanelDash panelDash;
	private PanelMngBranch panelMngBrnch;
	private PanelMngManager panelMngMngr;
	private  PanelSalseReport panelSalseRprt;
	

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
					ADashb ad = new ADashb();
					ad.setVisible(true);
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
	public ADashb() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1650,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDash=new PanelDash();
		panelMngBrnch=new PanelMngBranch();
		panelMngMngr=new PanelMngManager();
		panelSalseRprt=new PanelSalseReport();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(51, 51, 102));
		panelMenu.setBounds(10, 10, 315, 835);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		 background=new JLabel(new ImageIcon("D:\\EJ\\PMS\\img\\admin.png"),JLabel.CENTER);
	     background.setBounds(10, 10, 295, 237);
	     panelMenu.add(background);
		
	     	JPanel paneDash = new JPanel();
	     	paneDash.addMouseListener(new PanelButtonMouseAdapter(paneDash) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelDash);
	     		}
	     	});
	        paneDash.setBackground(new Color(255, 255, 255));
	        paneDash.setBounds(10, 326, 293, 64);
	        panelMenu.add(paneDash);
	        paneDash.setLayout(null);
	        
	        JLabel NameDash = new JLabel("Dashboard");
	        NameDash.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
	        NameDash.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameDash.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameDash.setBounds(100, 10, 183, 44);
	        paneDash.add(NameDash);
		 
	        JPanel paneMngBrnch = new JPanel();
	        paneMngBrnch.addMouseListener(new PanelButtonMouseAdapter(paneMngBrnch) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelMngBrnch);
	     		}
	        });
	        paneMngBrnch.setBackground(new Color(255, 255, 255));
	        paneMngBrnch.setBounds(10, 400, 293, 64);
	        panelMenu.add(paneMngBrnch);
	        paneMngBrnch.setLayout(null);
	        
	        JLabel NameMngBrnch = new JLabel("Manage Branch");
	        NameMngBrnch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\branch-32.png"));
	        NameMngBrnch.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameMngBrnch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameMngBrnch.setBounds(60, 10, 223, 44);
	        paneMngBrnch.add(NameMngBrnch);
	        
	        JPanel paneMngManagr = new JPanel();
	        paneMngManagr.addMouseListener(new PanelButtonMouseAdapter(paneMngManagr) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelMngMngr);
	     		}
	        });
	        paneMngManagr.setBackground(new Color(255, 255, 255));
	        paneMngManagr.setBounds(10, 474, 293, 64);
	        panelMenu.add(paneMngManagr);
	        paneMngManagr.setLayout(null);
	        
	        JLabel NameMngMangr = new JLabel("Manage Manager");
	        NameMngMangr.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\mangemanager-32.png"));
	        NameMngMangr.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameMngMangr.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameMngMangr.setBounds(60, 10, 223, 44);
	        paneMngManagr.add(NameMngMangr);
	        
	        JPanel paneSaleReprt = new JPanel();
	        paneSaleReprt.addMouseListener(new PanelButtonMouseAdapter(paneSaleReprt) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelSalseRprt);
	     		}
	        });
	        paneSaleReprt.setBackground(new Color(255, 255, 255));
	        paneSaleReprt.setBounds(10, 548, 293, 64);
	        panelMenu.add(paneSaleReprt);
	        paneSaleReprt.setLayout(null);
	        
	        
	        JLabel SalsReprt = new JLabel("Sales Report");
	        SalsReprt.setBounds(60, 10, 223, 44);
	        paneSaleReprt.add(SalsReprt);
	        SalsReprt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\report-32.png"));
	        SalsReprt.setHorizontalAlignment(SwingConstants.TRAILING);
	        SalsReprt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        
	        JPanel paneLgOt = new JPanel();
	        paneLgOt.addMouseListener(new PanelButtonMouseAdapter(paneLgOt) {
				@Override
	     		public void mouseClicked(MouseEvent e) {
	        		if(JOptionPane.showConfirmDialog(null,"Are You Sure You Want To LogOUT ? ")==0){
	        			ADashb ad = new ADashb();
						ad.setVisible(false);
	                    AdminLP ap=new AdminLP();
	                    ap.showWindow();
	          
	            	}
	        	}
	        });
	        paneLgOt.setBackground(new Color(255, 255, 255));
	        paneLgOt.setBounds(10, 622, 293, 64);
	        panelMenu.add(paneLgOt);
	        paneLgOt.setLayout(null);
	        
	        JLabel LogOut = new JLabel("Log Out");
	        LogOut.setBounds(47, 10, 236, 44);
	        paneLgOt.add(LogOut);
	        LogOut.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\logout.png"));
	        LogOut.setHorizontalAlignment(SwingConstants.TRAILING);
	        LogOut.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	       
	        JPanel panelMainContent = new JPanel();
	        panelMainContent.setBounds(335, 20, 1195, 815);
	        contentPane.add(panelMainContent);
	        panelMainContent.setLayout(null);
	        
	        panelMainContent.add(panelDash);
	        panelMainContent.add(panelMngBrnch);
	        panelMainContent.add(panelMngMngr);
	        panelMainContent.add(panelSalseRprt);
	        
	        menuClicked(panelDash);
	}
	
	public void menuClicked(JPanel panel) {
		panelDash.setVisible(false);
		panelMngBrnch.setVisible(false);
		panelMngMngr.setVisible(false);
		panelSalseRprt.setVisible(false);
		
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
		ADashb ad = new ADashb();
		ad.setVisible(true);
	}
}
