package src;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * 
 */

/**
 * @author ruanbotha
 *
 */
public class BoardGUI {

	private JFrame frame;
	private Board board;
	private Players p1;
	private Players p2;
	static Startup start;
	boolean firstSpin = true;
	JTextPane lblOutput;
	JTextPane txtHistory;
	Players pTwo = null,pOne = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	public BoardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(21, -22, 1079, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 6, 103, 100);
		label.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(128, 6, 100, 100);
		label_1.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(233, 6, 100, 100);
		label_2.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(338, 6, 100, 100);
		label_3.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(443, 6, 100, 100);
		label_4.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(548, 6, 100, 100);
		label_5.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_5);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(20, 111, 103, 100);
		label_17.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_17);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(548, 111, 100, 100);
		label_6.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_6);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(20, 216, 103, 100);
		label_16.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_16);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(548, 216, 100, 100);
		label_7.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		frame.getContentPane().add(label_7);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(20, 321, 103, 100);
		label_15.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_15);
		
		
		/*
		 * This is where every time spin gets pressed something happens.
		 */
		
		
		JButton btnSpin = new JButton("Spin");
		btnSpin.setBounds(298, 356, 75, 29);
		btnSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(firstSpin){
					
					System.out.println("First Spin");
				 String playerString = "", p1Name = start.getP1Name(), p2Name = start.getP2Name(), p1Comp="", p2Comp="";
				
				 Random rand = new Random();
				 int selection = rand.nextInt(5)+1;
				 
				 Integer players = 2;
				 int p2Type = 0;
				 double p1Value=0, p2Value=0, pOneOwn=1, pTwoOwn=1;
				 double p1Worth=50000, p2Worth=50000;
				 boolean p1Wait = false, p2Wait = false;
				
				 
				 if (selection == 1){
					 p1Comp = "Ride Sharing Company\n";
					 p1Value = 175000;
					 lblOutput.setText(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
				 }
				 if (selection == 2){
					 p1Comp = "IT company\n";
					 p1Value = 135000;
					 lblOutput.setText(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
				 }
				 if (selection == 3){
					 p1Comp = "Social Media Company\n";
					 p1Value = 125000;
					 lblOutput.setText(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
				 }
				 if (selection == 4){
					 p1Comp = "Compression Software Company\n";
					 p1Value = 185000;
					 lblOutput.setText(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
				 }
				 if (selection == 5){
					 p1Comp = "Job Search company\n";
					 p1Value = 150000;
					 lblOutput.setText(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
				 }
				 int dialogResult = JOptionPane.showConfirmDialog(null,"Would you like to allow an investor to buy 50% of your company, which will double the value of your company?"
							+ "\nIf so, you will have to wait one turn to move while you find an investor."
							+ "\nOtherwise, you can invest $50,000, which is half of your current worth, and keep the entire company.","Choose a route",JOptionPane.YES_NO_OPTION);
				 
				 if (dialogResult == JOptionPane.YES_OPTION){
					 p1Value = (2*p1Value);
					 p1Worth = 2*p1Worth;
					 pOneOwn = .5;
					 p1Wait = true;
				 }
				 pOne = new Players(p1Name, p1Comp, p1Value, pOneOwn, p1Worth, 0, p1Wait);
				 lblOutput.setText(pOne.toString());
				 txtHistory.setText("\n" + txtHistory.getText() + pOne.toString()+"\n\n");
				 
				 
				 int selection2 = rand.nextInt(5)+1;
				 while (selection2 == selection)
					 selection2 = rand.nextInt(5)+1;

				 if (selection2 == 1){
					 p2Comp = "Ride Sharing Company";
					 p2Value = 175000;
					 lblOutput.setText(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
				 }
				 if (selection2 == 2){
					 p2Comp = "IT company";
					 p2Value = 135000;
					 lblOutput.setText(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
				 }
				 if (selection2 == 3){
					 p2Comp = "Social Media Company";
					 p2Value = 125000;
					 lblOutput.setText(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
				 }
				 if (selection2 == 4){
					 p2Comp = "Compression Software Company";
					 p2Value = 185000;
					 lblOutput.setText(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
				 }
				 if (selection2 == 5){
					 p2Comp = "Job Search company";
					 p2Value = 150000;
					 lblOutput.setText(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
				 }
				 int dialogResult2 = JOptionPane.showConfirmDialog(null,"Would you like to allow an investor to buy 50% of your company, which will double the value of your company?"
							+ "\nIf so, you will have to wait one turn to move while you find an investor."
							+ "\nOtherwise, you can invest $50,000, which is half of your current worth, and keep the entire company.","Choose a route",JOptionPane.YES_NO_OPTION);
				 
				 if (dialogResult2 == JOptionPane.YES_OPTION){
						 p2Value = (2*p2Value);
						 p2Worth = p2Worth*2;
						 pTwoOwn = .5; 
						 p2Wait = true;
					 }
				 pTwo = new Players(p2Name, p2Comp, p2Value, pTwoOwn, p2Worth, p2Type, p2Wait);
				 lblOutput.setText(pTwo.toString());
				 txtHistory.setText("\n" + txtHistory.getText() + pTwo.toString()+"\n\n");
				 
				 
				 
				 firstSpin = false;
				}
	/*			
	 * This bit needs to be edited and rewritten to fit our board but it is pretty good so far.
	 */			else{
		 	//this else means it is not the initial spin.
				Board game = new Board();
				 if (pOne.getSpace() < 18 || pTwo.getSpace() < 18){
					 if (pOne.getSpace() < 18){
						 if (pOne.isWait() == false){
							 game.move(pOne,pTwo, lblOutput, txtHistory);
							 game.draw(pOne,pTwo);
						 }
						 else{
							 pOne.setWait(false);
							 lblOutput.setText(pOne.name+" has to wait this round.");
							 txtHistory.setText("\n" + txtHistory.getText() + pOne.name+" has to wait this round."+"\n\n");
						 }
					}
					else{
						lblOutput.setText(pOne.name+" has already finished.");
						 txtHistory.setText("\n" + txtHistory.getText() + pOne.name+" has already finished."+"\n\n");
					}
					if (pTwo.getSpace() < 18){
						 if (pTwo.isWait() == false){
							 game.move(pTwo, pOne, lblOutput, txtHistory);
							 game.draw(pOne, pTwo);
						 }
						 else{
							 pTwo.setWait(false);
						 }
					}
					else{
						lblOutput.setText(pTwo.name+" has already finished.");
						txtHistory.setText("\n" + txtHistory.getText() + pTwo.name+" has already finished."+"\n\n");
					}
				 }else{
				 if (pOne.getPersonWorth() > pTwo.getPersonWorth()){
					 lblOutput.setText(pOne.name+" Wins!");
					 txtHistory.setText("\n" + txtHistory.getText() + pOne.name+" Wins!"+"\n\n");
				 }
				 if (pOne.getPersonWorth() < pTwo.getPersonWorth()){
					 lblOutput.setText(pTwo.name+" Wins!");
					 txtHistory.setText("\n" + txtHistory.getText() + pTwo.name+" Wins!" + "\n\n");
				 }
				 if (pOne.getPersonWorth() == pTwo.getPersonWorth())
					 lblOutput.setText("It's a Tie!");	
				 	txtHistory.setText("\n" + txtHistory.getText() + "It's a Tie!" + "\n\n");
				 }
	 			}
			}
		});
		frame.getContentPane().add(btnSpin);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(548, 321, 100, 100);
		label_8.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_8);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(20, 426, 103, 100);
		label_14.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/TilesEvent.png")));
		frame.getContentPane().add(label_14);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(128, 426, 100, 100);
		label_13.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_13);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(233, 426, 100, 100);
		label_12.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_12);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(338, 426, 100, 100);
		label_11.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_11);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(443, 426, 100, 100);
		label_10.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_10);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(548, 426, 100, 100);
		label_9.setIcon(new ImageIcon(BoardGUI.class.getResource("/Resources/Tile.png")));
		frame.getContentPane().add(label_9);
		
		lblOutput = new JTextPane();
		lblOutput.setEditable(false);
		lblOutput.setBackground(SystemColor.window);
		lblOutput.setBounds(138, 118, 404, 198);
		frame.getContentPane().add(lblOutput);
		
		txtHistory = new JTextPane();
		txtHistory.setEditable(false);
		txtHistory.setBounds(1070, 6, -393, 520);
		frame.getContentPane().add(txtHistory);
		
		JScrollPane scrollBar = new JScrollPane(txtHistory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollBar.setBounds(660, 6, 413, 520);
		frame.getContentPane().add(scrollBar);
		frame.setVisible(true);
		
		
		
		board = new Board();
		//setP1(new Players(name1, compType, compEval, percentOwned, capital, playerType, wait));
		//setP2(new Players(name2, compType, compEval, percentOwned, capital, playerType, wait))
		
	}

	public static void main(String[] args) {
		start = new Startup();
		
	}
	
	public Players getP1() {
		return p1;
	}

	public void setP1(Players p1) {
		this.p1 = p1;
	}

	public Players getP2() {
		return p2;
	}

	public void setP2(Players p2) {
		this.p2 = p2;
	}
}
