import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author ruanbotha
 *
 */
public class Startup {

	private JFrame frame;

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
		frame.setBounds(100, 100, 679, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLifeOfAn = new JLabel("Life of an Entrepreneur");
		lblLifeOfAn.setBounds(265, 60, 149, 16);
		frame.getContentPane().add(lblLifeOfAn);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerName name = new PlayerName();
				frame.dispose();
			}
		});
		btnStart.setBounds(63, 202, 117, 29);
		frame.getContentPane().add(btnStart);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(439, 202, 117, 29);
		frame.getContentPane().add(btnClose);
		
		
		frame.setVisible(true);
	}
}
