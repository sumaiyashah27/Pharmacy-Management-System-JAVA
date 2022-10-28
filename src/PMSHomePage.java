import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
public class PMSHomePage{
	static JLabel background;
         public static void main(String args[])
         {
                  showWindow();
               
         }
                  
         public static void showWindow()
         {
                  JFrame frmHomepage=new JFrame("HomePage PMS");
                  frmHomepage.setTitle("HomePage ");
                  frmHomepage.setForeground(new Color(0, 0, 0));
                  frmHomepage.setFont(new Font("Book Antiqua", Font.BOLD, 25));
                  frmHomepage.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EJ\\PMS\\img\\Logo_64.png"));
                  frmHomepage.getContentPane().setBackground(new Color(255, 204, 255));
                  frmHomepage.setSize(1650,1080);
                  frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  frmHomepage.getContentPane().setLayout(null);
                  
                  JButton Admin = new JButton("Admin");
                  Admin.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-admin-32.png"));
                  Admin.setBounds(750, 376, 211, 54);
                  frmHomepage.getContentPane().add(Admin);
                  Admin.setFont(new Font("Book Antiqua", Font.BOLD, 25));
                  Admin.setBackground(new Color(255, 182, 193));
                  Admin.setFocusable(false);
                  
                  JButton Manager = new JButton("Manager");
                  Manager.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-manager-32.png"));
                  Manager.setBounds(859, 440, 211, 54);
                  frmHomepage.getContentPane().add(Manager);
                  Manager.setFont(new Font("Book Antiqua", Font.BOLD, 25));
                  Manager.setBackground(new Color(255, 182, 193));
                  Manager.setFocusable(false);
                  
                  JButton Pharmacist = new JButton("Pharmacist");
                  Pharmacist.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-pharmacist-32.png"));
                  Pharmacist.setBounds(962, 504, 211, 54);
                  frmHomepage.getContentPane().add(Pharmacist);
                  Pharmacist.setFont(new Font("Book Antiqua", Font.BOLD, 25));
                  Pharmacist.setBackground(new Color(255, 182, 193));
                  Pharmacist.setFocusable(false);
                  
                  JButton Cashier = new JButton("Cashier");
                  Cashier.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\icons8-cashier-32.png"));
                  Cashier.setBounds(1067, 568, 211, 54);
                  frmHomepage.getContentPane().add(Cashier);
                  Cashier.setFont(new Font("Book Antiqua", Font.BOLD, 25));
                  Cashier.setBackground(new Color(255, 182, 193));
                  Cashier.setFocusable(false);
                  
                  JLabel lblNewLabel = new JLabel("Pharmacy Management System");
                  lblNewLabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\Logo_64.png"));
                  lblNewLabel.setForeground(new Color(255, 255, 255));
                  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                  lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 45));
                  lblNewLabel.setBounds(425, 47, 776, 73);
                  frmHomepage.getContentPane().add(lblNewLabel);
                  
                  JLabel lblNewLabel_1 = new JLabel("");
                  lblNewLabel_1.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\PHBG.jpg"));
                  lblNewLabel_1.setBounds(10, 10, 1520, 825);
                  frmHomepage.getContentPane().add(lblNewLabel_1);
                  
                  
                  //Cashier LogIn Page
                  Cashier.addActionListener(new ActionListener(){
                      @SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent arg0)
                      {
                               frmHomepage.setVisible(false);
                               CashierLP cp=new CashierLP();
                               cp.showWindow();
                      }
             });
                  
                  //PharmacistLP LogIn Page
                  Pharmacist.addActionListener(new ActionListener(){
                      @SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent arg0)
                      {
                               frmHomepage.setVisible(false);
                               PharmacistLP php=new PharmacistLP();
                               php.showWindow();
                      }
             });
                  
                  //Manager LogIn Page
                  Manager.addActionListener(new ActionListener(){
                      @SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent arg0)
                      {
                               frmHomepage.setVisible(false);
                               ManagerLP mp=new ManagerLP();
                               mp.showWindow();
                      }
             });
                  
                  //Admin LogIn Page
                  Admin.addActionListener(new ActionListener(){
                      @SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent arg0)
                      {
                               frmHomepage.setVisible(false);
                               AdminLP ap=new AdminLP();
                               ap.showWindow();
                      }
             });
                  
                  
                  frmHomepage.setVisible(true);
                 
                  
         }
}