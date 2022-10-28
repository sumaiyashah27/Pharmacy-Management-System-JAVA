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

public class PhDashb extends JFrame {
	
	private PanelPhDash panelPhDash;
	private PanelMed panelMedcn;
	private PanelPrscp panelPrscp;
	private PanelMedSrch panelMedSrch;
	private PanelGenPrescpt panelGenPrescpt;
	private PanelOtofStk panelOtofStk;
	private PanelExpSoon panelExpSoon;

	

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
					PhDashb phd = new PhDashb();
					phd.setVisible(true);
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
	public PhDashb() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1650,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPhDash=new PanelPhDash();
		panelMedcn=new PanelMed();
		panelPrscp=new PanelPrscp();
		panelMedSrch=new PanelMedSrch();
		panelGenPrescpt=new PanelGenPrescpt();
		panelOtofStk=new PanelOtofStk();
		panelExpSoon=new PanelExpSoon();
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(51, 51, 102));
		panelMenu.setBounds(10, 10, 315, 835);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		 background=new JLabel(new ImageIcon("D:\\EJ\\PMS\\img\\Pharamacist.png"),JLabel.CENTER);
	     background.setBounds(10, 10, 281, 206);
	     panelMenu.add(background);
		
	     	JPanel paneDash = new JPanel();
	     	paneDash.addMouseListener(new PanelButtonMouseAdapter(paneDash) {
	     		@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelPhDash);
	     		}
	     	});
	        paneDash.setBackground(new Color(255, 255, 255));
	        paneDash.setBounds(12, 267, 293, 53);
	        panelMenu.add(paneDash);
	        paneDash.setLayout(null);
	        
	        JLabel NameDash = new JLabel("Dashboard");
	        NameDash.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\dashboard-5-32.png"));
	        NameDash.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameDash.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameDash.setBounds(100, 10, 183, 33);
	        paneDash.add(NameDash);
		 
	        JPanel paneMngBrnch = new JPanel();
	        paneMngBrnch.addMouseListener(new PanelButtonMouseAdapter(paneMngBrnch) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelMedcn);
	     		}
	        });
	        paneMngBrnch.setBackground(new Color(255, 255, 255));
	        paneMngBrnch.setBounds(12, 330, 293, 53);
	        panelMenu.add(paneMngBrnch);
	        paneMngBrnch.setLayout(null);
	        
	        JLabel NameMngBrnch = new JLabel("Manage Medicine");
	        NameMngBrnch.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\pill-2-24.png"));
	        NameMngBrnch.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameMngBrnch.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameMngBrnch.setBounds(60, 10, 223, 33);
	        paneMngBrnch.add(NameMngBrnch);
	        
	        JPanel paneMngPrescpt = new JPanel();
	        paneMngPrescpt.addMouseListener(new PanelButtonMouseAdapter(paneMngPrescpt) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelPrscp);
	     		}
	        });
	        paneMngPrescpt.setBackground(new Color(255, 255, 255));
	        paneMngPrescpt.setBounds(12, 456, 293, 53);
	        panelMenu.add(paneMngPrescpt);
	        paneMngPrescpt.setLayout(null);
	        
	        JLabel NameMngPrescpt = new JLabel("Manage Prescription");
	        NameMngPrescpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\paper-24.png"));
	        NameMngPrescpt.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameMngPrescpt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameMngPrescpt.setBounds(60, 10, 223, 33);
	        paneMngPrescpt.add(NameMngPrescpt);
	        
	        JPanel paneLgOt = new JPanel();
	        paneLgOt.addMouseListener(new PanelButtonMouseAdapter(paneLgOt) {
	        	@SuppressWarnings("static-access")
				@Override
	     		public void mouseClicked(MouseEvent e) {
	        		if(JOptionPane.showConfirmDialog(null,"Are You Sure You Want To LogOUT ? ")==0){
	        			PhDashb phd = new PhDashb();
						phd.setVisible(false);
						PharmacistLP php=new PharmacistLP();
	                    php.showWindow();
	          
	            	}
	        	}
	        });
	        paneLgOt.setBackground(new Color(255, 255, 255));
	        paneLgOt.setBounds(10, 708, 293, 53);
	        panelMenu.add(paneLgOt);
	        paneLgOt.setLayout(null);
	        
	        JLabel LogOut = new JLabel("Log Out");
	        LogOut.setBounds(47, 10, 236, 33);
	        paneLgOt.add(LogOut);
	        LogOut.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\logout.png"));
	        LogOut.setHorizontalAlignment(SwingConstants.TRAILING);
	        LogOut.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        
	        JPanel paneSearchMed = new JPanel();
	        paneSearchMed.addMouseListener(new PanelButtonMouseAdapter(paneSearchMed) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelMedSrch);
	     		}
	        });
	        paneSearchMed.setLayout(null);
	        paneSearchMed.setBackground(Color.WHITE);
	        paneSearchMed.setBounds(12, 393, 293, 53);
	        panelMenu.add(paneSearchMed);
	        
	        JLabel lblSearchMedicine = new JLabel("Search Medicine");
	        lblSearchMedicine.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\search-9-32.png"));
	        lblSearchMedicine.setHorizontalAlignment(SwingConstants.TRAILING);
	        lblSearchMedicine.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        lblSearchMedicine.setBounds(60, 10, 223, 33);
	        paneSearchMed.add(lblSearchMedicine);
	        
	        JPanel paneOtOfStk = new JPanel();
	        paneOtOfStk.addMouseListener(new PanelButtonMouseAdapter(paneOtOfStk) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelOtofStk);
	     		}
	        });
	        paneOtOfStk.setLayout(null);
	        paneOtOfStk.setBackground(Color.WHITE);
	        paneOtOfStk.setBounds(12, 582, 293, 53);
	        panelMenu.add(paneOtOfStk);
	        
	        JLabel NameOutStk = new JLabel("Out of Stock");
	        NameOutStk.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-out-of-stock-32.png"));
	        NameOutStk.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameOutStk.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameOutStk.setBounds(60, 10, 223, 33);
	        paneOtOfStk.add(NameOutStk);
	        
	        JPanel paneExpSoon = new JPanel();
	        paneExpSoon.addMouseListener(new PanelButtonMouseAdapter(paneExpSoon) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelExpSoon);
	     		}
	        });
	        paneExpSoon.setLayout(null);
	        paneExpSoon.setBackground(Color.WHITE);
	        paneExpSoon.setBounds(10, 645, 293, 53);
	        panelMenu.add(paneExpSoon);
	        
	        JLabel NameExpSoon = new JLabel("Expired ");
	        NameExpSoon.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-expired-32.png"));
	        NameExpSoon.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameExpSoon.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameExpSoon.setBounds(60, 10, 223, 33);
	        paneExpSoon.add(NameExpSoon);
	        
	        JPanel paneGenPriscript = new JPanel();
	        paneGenPriscript.setBounds(12, 519, 293, 53);
	        panelMenu.add(paneGenPriscript);
	        paneGenPriscript.addMouseListener(new PanelButtonMouseAdapter(paneGenPriscript) {
	        	@Override
	     		public void mouseClicked(MouseEvent e) {
	     			menuClicked(panelGenPrescpt);
	     		}
	        });
	        paneGenPriscript.setLayout(null);
	        paneGenPriscript.setBackground(Color.WHITE);
	        
	        JLabel NameGenPrescrpt = new JLabel("Generate Prescription");
	        NameGenPrescrpt.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\cart-70-32.png"));
	        NameGenPrescrpt.setHorizontalAlignment(SwingConstants.TRAILING);
	        NameGenPrescrpt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	        NameGenPrescrpt.setBounds(26, 10, 257, 33);
	        paneGenPriscript.add(NameGenPrescrpt);
	       
	        JPanel panelMainContent = new JPanel();
	        panelMainContent.setBounds(335, 20, 1195, 815);
	        contentPane.add(panelMainContent);
	        panelMainContent.setLayout(null);
	        
	        panelMainContent.add(panelPhDash);
	        panelMainContent.add(panelMedcn);
	        panelMainContent.add(panelPrscp);
	        panelMainContent.add(panelMedSrch);
	        panelMainContent.add(panelGenPrescpt);
	        panelMainContent.add(panelOtofStk);
	        panelMainContent.add(panelExpSoon);
	        
	        menuClicked(panelPhDash);
	}
	
	public void menuClicked(JPanel panel) {
		panelPhDash.setVisible(false);
		panelMedcn.setVisible(false);
		panelPrscp.setVisible(false);
		panelMedSrch.setVisible(false);
		panelGenPrescpt.setVisible(false);
		panelOtofStk.setVisible(false);
		panelExpSoon.setVisible(false);
		
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
		PhDashb phd = new PhDashb();
		phd.setVisible(true);
	}
}
