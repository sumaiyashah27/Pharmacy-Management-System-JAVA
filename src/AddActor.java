
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.text.BadLocationException;
	import javax.swing.text.DocumentFilter;
	import javax.swing.text.PlainDocument;

	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;

	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JRadioButton;
	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.ImageIcon;
	import java.awt.SystemColor;
import javax.swing.SwingConstants;

	public class AddActor extends JFrame {

		private JPanel contentPane;
		private JTextField FNtxt;
		private JTextField PCtxt;
		private JTextField UNtxt;
		private JTextField EIDtxt;
		private JTextField LNtxt;
		private JTextField CNtxt;
		private JTextField IDtxt;
		private JPasswordField passtxt;
		private final ButtonGroup buttonGroup = new ButtonGroup();

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AddActor aa = new AddActor();
						aa.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public AddActor() {
			setTitle("User Registration Form");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1261, 645);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 182, 193));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel RegFormlabel = new JLabel("Registration Form");
			RegFormlabel.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-user-3-32.png"));
			RegFormlabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
			RegFormlabel.setBounds(489, 33, 296, 49);
			contentPane.add(RegFormlabel);
			
			JLabel FNlabel = new JLabel("First Name :");
			FNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			FNlabel.setBounds(21, 213, 139, 31);
			contentPane.add(FNlabel);
			
			JLabel Genderlabel = new JLabel("Gender : ");
			Genderlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			Genderlabel.setBounds(21, 278, 139, 31);
			contentPane.add(Genderlabel);
			
			JLabel PClabel = new JLabel("Postal Code : ");
			PClabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			PClabel.setBounds(21, 338, 139, 31);
			contentPane.add(PClabel);
			
			JLabel UNlabel = new JLabel("Username : ");
			UNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			UNlabel.setBounds(661, 338, 139, 31);
			contentPane.add(UNlabel);
			
			JLabel LNlabel = new JLabel("Last Name :");
			LNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			LNlabel.setBounds(659, 213, 139, 31);
			contentPane.add(LNlabel);
			
			JLabel CNlabel = new JLabel("Contact No : ");
			CNlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			CNlabel.setBounds(659, 273, 139, 31);
			contentPane.add(CNlabel);
			
			JLabel EIDlabel = new JLabel("Email ID : ");
			EIDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			EIDlabel.setBounds(21, 403, 139, 31);
			contentPane.add(EIDlabel);
			
			JLabel passlabel = new JLabel("Password : ");
			passlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			passlabel.setBounds(659, 403, 139, 31);
			contentPane.add(passlabel);
			
			JLabel IDlabel = new JLabel("Manager Id :");
			IDlabel.setFont(new Font("Book Antiqua", Font.BOLD, 22));
			IDlabel.setBounds(385, 99, 139, 31);
			contentPane.add(IDlabel);
			
			FNtxt = new JTextField();
			FNtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			FNtxt.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			            FNtxt.setEditable(true);
			        }
			        else
			        {
			            FNtxt.setEditable(false);
			        }
				}
			});
			FNtxt.setBounds(173, 213, 285, 50);
			contentPane.add(FNtxt);
			FNtxt.setColumns(10);
			
			PCtxt = new JTextField();
			PCtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			PCtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			            PCtxt.setEditable(true);
			        }
			        else
			        {
			            PCtxt.setEditable(false);
			        }
				}
			});
			PCtxt.setColumns(10);
			PCtxt.setBounds(173, 338, 285, 50);
			contentPane.add(PCtxt);
			
			UNtxt = new JTextField();
			UNtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			UNtxt.setColumns(10);
			UNtxt.setBounds(813, 338, 285, 50);
			contentPane.add(UNtxt);
			
			EIDtxt = new JTextField();
			EIDtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			EIDtxt.setColumns(10);
			EIDtxt.setBounds(173, 403, 285, 50);
			contentPane.add(EIDtxt);
			
			LNtxt = new JTextField();
			LNtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			LNtxt.addKeyListener(new KeyAdapter() {
				@Override
				
				public void keyPressed(KeyEvent e) {
					char c = e.getKeyChar();
			        if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
			        {
			            LNtxt.setEditable(true);
			        }
			        else
			        {
			            LNtxt.setEditable(false);
			        }
				}
			});
			LNtxt.setColumns(10);
			LNtxt.setBounds(813, 213, 285, 50);
			contentPane.add(LNtxt);
			
			CNtxt = new JTextField();
			CNtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			CNtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					String phoneNumber = CNtxt.getText();
					int length = phoneNumber.length();
			        char c = e.getKeyChar();
			        
			        if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
			            if(length<10){
			                
			                CNtxt.setEditable(true);
			            }else{
			                CNtxt.setEditable(false);
			            }
			        }else
			        {
			            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
			                CNtxt.setEditable(true);
			                
			            }else{
			                CNtxt.setEditable(false);
			            }
			                
			        }
				}
			});
			CNtxt.setColumns(10);
			CNtxt.setBounds(813, 273, 285, 50);
			contentPane.add(CNtxt);
			
			IDtxt = new JTextField();
			IDtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			IDtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int c = e.getKeyChar();
			        if(Character.isDigit(c)|| Character.isISOControl(c))
			        {
			            IDtxt.setEditable(true);
			        }
			        else
			        {
			            IDtxt.setEditable(false);
			        }
				}
			});
			IDtxt.setColumns(10);
			IDtxt.setBounds(539, 99, 139, 50);
			contentPane.add(IDtxt);
			
			passtxt = new JPasswordField();
			passtxt.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			PlainDocument document = (PlainDocument) passtxt.getDocument();
		      document.setDocumentFilter(new DocumentFilter() {
		         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
		            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		               if (string.length() <= 7) {
		                  super.replace(fb, offset, length, text, attrs);
		               }
		         }
		      });
			passtxt.setBounds(813, 403, 285, 50);
			contentPane.add(passtxt);
			
			JRadioButton radiomale = new JRadioButton("Male");
			radiomale.setHorizontalAlignment(SwingConstants.CENTER);
			radiomale.setBackground(new Color(255, 240, 245));
			radiomale.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			buttonGroup.add(radiomale);
			radiomale.setBounds(173, 278, 103, 50);
			contentPane.add(radiomale);
			
			JRadioButton radiofemale = new JRadioButton("Female");
			radiofemale.setHorizontalAlignment(SwingConstants.CENTER);
			radiofemale.setBackground(new Color(255, 240, 245));
			radiofemale.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			buttonGroup.add(radiofemale);
			radiofemale.setBounds(326, 278, 132, 50);
			contentPane.add(radiofemale);
			
			JButton Regbtn = new JButton("Register");
			Regbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(FNtxt.getText().trim().isEmpty() || LNtxt.getText().trim().isEmpty() || PCtxt.getText().trim().isEmpty() || CNtxt.getText().trim().isEmpty() || IDtxt.getText().trim().isEmpty() || UNtxt.getText().trim().isEmpty() || passtxt.getText().trim().isEmpty() || EIDtxt.getText().trim().isEmpty() )
						{
							JOptionPane.showMessageDialog(null,"Please fil all fields...");
							MDashb md = new MDashb();
							md.setVisible(false);
							AddActor aa = new AddActor();
							aa.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Added Successfully");
							MDashb md = new MDashb();
							md.setVisible(false);
							AddActor aa = new AddActor();
							aa.setVisible(false);
						}
						clearFields();
					}
				});
			Regbtn.setFont(new Font("Book Antiqua", Font.BOLD, 20));
			Regbtn.setIcon(new ImageIcon("D:\\EJ\\PMS\\img\\add-user-3-32.png"));
			Regbtn.setFocusable(false);
			Regbtn.setBounds(492, 513, 186, 49);
			contentPane.add(Regbtn);
		}
		
		private void clearFields() {
			FNtxt.setText(null);
			LNtxt.setText(null);
			PCtxt.setText(null);
			CNtxt.setText(null);
			IDtxt.setText(null);
			EIDtxt.setText(null);
			passtxt.setText("");
			UNtxt.setText(null);
			buttonGroup.clearSelection();
	}
}
