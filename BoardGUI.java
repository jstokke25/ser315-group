import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;

/**
 * 
 */

/**
 * @author ruanbotha
 *
 */
public class BoardGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public BoardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		frame.getContentPane().add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		frame.getContentPane().add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 0;
		frame.getContentPane().add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 6;
		gbc_label_4.gridy = 0;
		frame.getContentPane().add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 7;
		gbc_label_5.gridy = 0;
		frame.getContentPane().add(label_5, gbc_label_5);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 2;
		gbc_label_17.gridy = 1;
		frame.getContentPane().add(label_17, gbc_label_17);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 1;
		frame.getContentPane().add(label_6, gbc_label_6);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 2;
		gbc_label_16.gridy = 2;
		frame.getContentPane().add(label_16, gbc_label_16);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 7;
		gbc_label_7.gridy = 2;
		frame.getContentPane().add(label_7, gbc_label_7);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 2;
		gbc_label_15.gridy = 3;
		frame.getContentPane().add(label_15, gbc_label_15);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_8.gridx = 7;
		gbc_label_8.gridy = 3;
		frame.getContentPane().add(label_8, gbc_label_8);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridx = 2;
		gbc_label_14.gridy = 4;
		frame.getContentPane().add(label_14, gbc_label_14);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 0, 5);
		gbc_label_13.gridx = 3;
		gbc_label_13.gridy = 4;
		frame.getContentPane().add(label_13, gbc_label_13);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 4;
		gbc_label_12.gridy = 4;
		frame.getContentPane().add(label_12, gbc_label_12);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 5;
		gbc_label_11.gridy = 4;
		frame.getContentPane().add(label_11, gbc_label_11);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 0, 5);
		gbc_label_10.gridx = 6;
		gbc_label_10.gridy = 4;
		frame.getContentPane().add(label_10, gbc_label_10);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.gridx = 7;
		gbc_label_9.gridy = 4;
		frame.getContentPane().add(label_9, gbc_label_9);
		frame.setVisible(true);
		
	}

}
