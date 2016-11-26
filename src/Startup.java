package src;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

/**
 * 
 */

/**
 * @author ruanbotha
 *
 */
public class Startup {

	

	private JFrame frame;
	private String p1Name;
	private String p2Name;
	private JTextField txtP1;
	private JTextField txtP2;
	private JCheckBox checkComp;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Startup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLifeOfAn = new JLabel("Life of an Entrepreneur");
		lblLifeOfAn.setBounds(265, 60, 149, 16);
		frame.getContentPane().add(lblLifeOfAn);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardGUI gui = new BoardGUI();
				
				setP1Name(txtP1.getText());			
				if(checkComp.isSelected())
					setP2Name("Computer");
				else
					setP2Name(txtP2.getText());
				
				frame.dispose();
			}
		});
		btnStart.setBounds(90, 468, 117, 29);
		frame.getContentPane().add(btnStart);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(466, 468, 117, 29);
		frame.getContentPane().add(btnClose);
		
		JLabel label = new JLabel("Player 1");
		label.setBounds(321, 148, 61, 16);
		frame.getContentPane().add(label);
		
		txtP1 = new JTextField();
		txtP1.setText("Player 1");
		txtP1.setColumns(10);
		txtP1.setBounds(284, 176, 130, 26);
		frame.getContentPane().add(txtP1);
		
		JLabel label_1 = new JLabel("Player 2");
		label_1.setBounds(321, 259, 61, 16);
		frame.getContentPane().add(label_1);
		
		txtP2 = new JTextField();
		txtP2.setText("Player 2");
		txtP2.setColumns(10);
		txtP2.setBounds(284, 304, 130, 26);
		frame.getContentPane().add(txtP2);
		
		checkComp = new JCheckBox("Computer");
		checkComp.setBounds(286, 367, 128, 23);
		frame.getContentPane().add(checkComp);
		
		
		frame.setVisible(true);
	}
	
	public String getP2Name() {
		return p2Name;
	}

	public void setP2Name(String p2Name) {
		this.p2Name = p2Name;
	}

	public void setP1Name(String p1Name) {
		this.p1Name = p1Name;
	}

	public String getP1Name() {
		return p1Name;
	}


}
