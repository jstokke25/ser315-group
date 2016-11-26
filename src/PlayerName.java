package src;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author ruanbotha
 *
 */
public class PlayerName {


	private JFrame frame;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerName window = new PlayerName();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(239, 22, 61, 16);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setBounds(239, 133, 61, 16);
		frame.getContentPane().add(lblPlayer_1);
		
		txtPlayer = new JTextField();
		txtPlayer.setText("Player 1");
		txtPlayer.setBounds(202, 50, 130, 26);
		frame.getContentPane().add(txtPlayer);
		txtPlayer.setColumns(10);
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setText("Player 2");
		txtPlayer_1.setBounds(202, 178, 130, 26);
		frame.getContentPane().add(txtPlayer_1);
		txtPlayer_1.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardGUI gui = new BoardGUI();
				frame.dispose();
			}
		});
		btnStart.setBounds(55, 340, 117, 29);
		frame.getContentPane().add(btnStart);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(329, 340, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JCheckBox chckbxComputer = new JCheckBox("Computer");
		chckbxComputer.setBounds(202, 253, 128, 23);
		frame.getContentPane().add(chckbxComputer);
		
		frame.setVisible(true);
	}
	
	
	public JTextField getTxtPlayer() {
		return txtPlayer;
	}

	public JTextField getTxtPlayer_1() {
		return txtPlayer_1;
	}
}
