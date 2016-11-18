import java.util.Random;
import java.util.Scanner;

public class Board {
	private final int finishLine = 30;
	
	public Board(){
		
	}
	/* Draws board in straight line from 0 to 30
	 * Player 1 denoted with 1, Player 2 as 2, F = End Tile
	 */
	public void draw(Players one, Players two){
		for (int i = 0; i < finishLine; i++){
			if (i == one.getSpace())
				System.out.print(1);
			if (i == two.getSpace())
				System.out.print(2);
			else
				System.out.print(0);
		}
		System.out.println("F\n");
	}
	/* If player is not stuck waiting, and player has not finished, player "Spins"
	 * Generates random number 1 though 5 to move player.
	 * If player passes Pay Day and/or Tax Day, player gets paid or pays taxes.
	 * If player finishes gets to finish line first, company goes public and 
	 * the company value is doubled.
	 * Otherwise starts switch case for spot landed on. 
	 */
	public void move(Players toMove, Players other){
		Board ckTiles = new Board();
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int oldSpace = toMove.getSpace();
		System.out.println(toMove.name+" push any key to spin");
		String entry = scan.nextLine();
		int move = rand.nextInt(5)+1;
		int newSpace = move+oldSpace;
		System.out.println(toMove.name+" spun a "+move+".");
		if (newSpace == other.getSpace()){
			newSpace +=1;
			System.out.println("Since "+(newSpace-1)+" is taken, "+toMove.name+" moves to space"+newSpace);
		}
		if ((oldSpace < 1 && newSpace >=1) || (oldSpace < 7 && newSpace >=7) || (oldSpace < 13 && newSpace >=13) || (oldSpace < 19 && newSpace >=19) || (oldSpace < 26 && newSpace >=26)){
			toMove.setPersonWorth(toMove.getSalary());
			System.out.println(toMove.name+" passed Pay Day and recieved his salary of "+toMove.getSalary());
		}
		if ((oldSpace < 2 && newSpace >=2) || (oldSpace < 8 && newSpace >=8) || (oldSpace < 14 && newSpace >=14) || (oldSpace < 20 && newSpace >=20) || (oldSpace < 27 && newSpace >=27)){
			toMove.setPersonWorth((-.3*toMove.getSalary()));
			System.out.println(toMove.name+" passed Tax Day and had to pay "+(.3*toMove.getSalary()));
		}
		if (newSpace >= 30 && other.getSpace() < 30){
			double newCompEval = (toMove.getCompEval()*2);
			toMove.setCompEval(newCompEval);
			toMove.setPersonWorth((newCompEval*toMove.getPercentOwned()));
			toMove.setSalary(toMove.getPercentOwned(),toMove.getCompEval());
			System.out.println(toMove.name+"'s company went public and the company is now worth $"+toMove.getCompEval());
		}
		ckTiles.landedOn(toMove, other, newSpace);
		toMove.setSpace(newSpace);
		toMove.print();		
	}
	/*
	 * Cases include: paying services (potentially to other player).
	 * Paying penalties.
	 * Increase or decrease in company evaluation.
	 * Some optional choices, like adding investors or selling company.
	 * Bankruptcy.
	 */
	 private void landedOn(Players toMove, Players other, int tile) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		switch(tile){
		case 1: 
			break;
		case 2:
			break;
		case 3:
			if (new String("Ride Sharing Company").equals(toMove.getCompType()))
				break;
			System.out.println(toMove.name+" has to pay Ride Sharing Company $15,000 from last convention.");
			toMove.setPersonWorth(-15000);
			if (new String("Ride Sharing Company").equals(other.getCompType()))
					other.setPersonWorth(15000);
			break;
		case 4:
			System.out.println(toMove.name+"'s company received a good review on a tech website.  Value of company has increased by 25%");
			double newEval = (.25*toMove.getCompEval()+toMove.getCompEval());
			toMove.setCompEval(newEval);
			toMove.setPersonWorth(.25*toMove.getCompEval());
			toMove.setSalary(toMove.getPercentOwned(), toMove.getCompEval());
			break;
		case 5:
			System.out.println(toMove.name+" settled a lawsuite by paying the plaintiff $100,000");
			toMove.setPersonWorth(-100000);
			break;
		case 6:
			System.out.println(toMove.name+" crowdfunding has increased your company's value by 15%");
			double newVal = (.15*toMove.getCompEval()+toMove.getCompEval());
			toMove.setCompEval(newVal);
			toMove.setPersonWorth(.15*toMove.getCompEval());
			toMove.setSalary(toMove.getPercentOwned(), toMove.getCompEval());
		case 7:
			break;
		case 8:
			break;
		case 9:
			System.out.println("Would you like to enter a contest for new businesses?\n"
					+"The entry is $20000.  The winner gets $100000 and 2nd gets $25000\n"
					+"Press y to enter or any other key to skip it");
			String entry = scan.nextLine();
			if (new String("Y").equals(entry) || new String("y").equals(entry)){
				toMove.setPersonWorth(-20000);
				System.out.println("If you spin a 3 you win 1st place, 4 or 5 wins second.  Press any key to spin.");
				String entry2 = scan.nextLine();
				int spin = rand.nextInt(5)+1;
				if (spin == 3){
					System.out.println(toMove+" won first place and $100000");
					toMove.setPersonWorth(100000);
				}
				if (spin == 4 || spin == 5){
					System.out.println(toMove.name+" won second place and $25000");
					toMove.setPersonWorth(25000);
				}
			}
			break;
		case 10:
			if (new String("IT company").equals(toMove.getCompType()))
				break;
			System.out.println(toMove.name+" has to pay IT Company $30,000.");
			toMove.setPersonWorth(-30000);
			if (new String("IT company").equals(other.getCompType()))
					other.setPersonWorth(30000);
			break;
		case 11:
			System.out.println("You had to hire another staff member at $40000");
			toMove.setPersonWorth(-40000);
			break;
		case 12:
			System.out.println("You're rich uncle gave you a gift of $30000 to help your company");
			toMove.setPersonWorth(30000);
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			System.out.println("An angel investor has offered to buy 30% of the shares, but he promises to increase the company value by 40%.\n"
					+"Press y to accept or any other key to decline");
			String enter15 = scan.nextLine();
			if (new String("Y").equals(enter15) || new String("y").equals(enter15)){
				double newPercent = (toMove.getPercentOwned()-.3);
				toMove.setPercentOwned(newPercent);
				double newCompVal = (.4*toMove.getCompEval()+toMove.getCompEval());
				toMove.setCompEval(newCompVal);
				toMove.setSalary(toMove.getPercentOwned(), toMove.getCompEval());
			}
			break;
		case 16:
			if (new String("Social Media Company").equals(toMove.getCompType()))
				break;
			System.out.println(toMove.name+" pays Social Media Company $25,000 for advertising.");
			toMove.setPersonWorth(-25000);
			if (new String("Social Media Company").equals(other.getCompType()))
					other.setPersonWorth(25000);
			break;
		case 17:
			break;
		case 18:
			if (new String("Compression Software Company").equals(toMove.getCompType()))
				break;
			System.out.println(toMove.name+" pays Compression Software Company $15,000 for work done.");
			toMove.setPersonWorth(-15000);
			if (new String("Compression Software Company").equals(other.getCompType()))
					other.setPersonWorth(15000);
			break;
		case 19:
			break;
		case 20:
			break;
		case 21:
			if (new String("Job Search company").equals(toMove.getCompType()))
				break;
			System.out.println(toMove.name+" pays Job Search company $20,000 for finding employees.");
			toMove.setPersonWorth(-20000);
			if (new String("Job Search company").equals(other.getCompType()))
					other.setPersonWorth(20000);
			break;
		case 22:
			break;
		case 23:
			System.out.println(toMove.name+"'s company had a bad review in a podcast.  Companies value drops 10%");
			double eval23 = (-.2*toMove.getCompEval()+toMove.getCompEval());
			toMove.setCompEval(eval23);
			toMove.setSalary(toMove.getPercentOwned(), toMove.getCompEval());
			break;
		case 24:
			System.out.println(toMove.name+" gets a raise of $10000");
			toMove.salary += 10000;
			break;
		case 25:
			double eval25 = 1.75*toMove.getCompEval();
			System.out.println(toMove.name+", would you like to sell your company for $"+eval25+"?");
			System.out.println("Press y to sell or any other key to decline.");
			String enter25 = scan.nextLine();
			if (new String("Y").equals(enter25) || new String("y").equals(enter25)){
				toMove.setPersonWorth(eval25);
				toMove.setPercentOwned(0);
				toMove.setSalary(toMove.getPercentOwned(), toMove.getCompEval());
				toMove.setSpace(36);
			}
			break;
		case 26:
			break;
		case 27:
			break;
		case 28:
			break;
		case 29:
			System.out.println(toMove.name+"'s company went bankrupt.  You are now worth nothing");
			toMove.setCompEval(0);
			toMove.salary = 0;
			toMove.setPersonWorth(0*toMove.getPersonWorth());
			break;
		case 30:
			break;
		case 31:
			break;
		case 32:
			break;
		case 33:
			break;
		case 34:
			break;
		case 35:
			break;				
		}
		
	}
	/*
	 * Main method initializes players with scanner input and screen output
	 * Originally planned on setting up Computer User, but won't finish that on this iteration.
	 * 2 player only.
	 */
	public static void main(String[] args) {
		 String playerString, p1Name, p2Name, p1Comp="", p2Comp="";
		 Integer players = 2;
		 int p2Type = 0;
		 double p1Value=0, p2Value=0, pOneOwn=1, pTwoOwn=1;
		 double p1Worth=50000, p2Worth=50000;
		 boolean p1Wait = false, p2Wait = false;
		 Random rand = new Random();
		 Scanner scan = new Scanner(System.in);
		 /*System.out.println("How many players?  1 or 2?");
		 playerString = scan.nextLine();
		 players = Integer.parseInt(playerString);
		 while (players != 1 && players != 2){ 
			 System.out.println("This is an invalid option.  Please enter 1 or 2 players.");
			 playerString = scan.nextLine();
			 players = Integer.parseInt(playerString);
		 }*/
		 System.out.println("Player one, your name is Player One.  If you would you like to change your name, type it here: ");
		 p1Name = scan.nextLine();
		 if (new String("").equals(p1Name)){
			 p1Name = "Player One";
		 }
		 if (players == 2){
			 System.out.println("Player two, your name is Player Two.  If you would you like to change your name, type it here: ");
			 p2Name = scan.nextLine();
			 if (new String("").equals(p2Name))
				 p2Name = "Player Two";
		 }
		 else{
			 p2Name = "Computer";
			 p2Type = 1;
		 }
		 int selection = rand.nextInt(5)+1;
		 System.out.println(p1Name+" enter any key to spin the wheel to see what type of company you are starting.");
		 String check = scan.nextLine();
		 if (selection == 1){
			 p1Comp = "Ride Sharing Company";
			 p1Value = 175000;
			 System.out.println(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
		 }
		 if (selection == 2){
			 p1Comp = "IT company";
			 p1Value = 135000;
			 System.out.println(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
		 }
		 if (selection == 3){
			 p1Comp = "Social Media Company";
			 p1Value = 125000;
			 System.out.println(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
		 }
		 if (selection == 4){
			 p1Comp = "Compression Software Company";
			 p1Value = 185000;
			 System.out.println(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
		 }
		 if (selection == 5){
			 p1Comp = "Job Search company";
			 p1Value = 150000;
			 System.out.println(p1Name+" started a "+p1Comp+ "that is valued at $"+p1Value);
		 }
		 System.out.println("Would you like to allow an investor to buy 50% of your company, which will double the value of your company?"
					+ "\nIf so, you will have to wait one turn to move while you find an investor."
					+ "\nOtherwise, you can invest $50,000, which is half of your current worth, and keep the entire company."
			 		+ "\nPress Y for yes or any other key for no.");
		 String partner = scan.nextLine();
		 if (new String("Y").equals(partner) || new String("y").equals(partner)){
			 p1Value = (2*p1Value);
			 p1Worth = 2*p1Worth;
			 pOneOwn = .5;
			 p1Wait = true;
		 }
		 Players pOne = new Players(p1Name, p1Comp, p1Value, pOneOwn, p1Worth, 0, p1Wait);
		 pOne.print();
		 int selection2 = rand.nextInt(5)+1;
		 while (selection2 == selection)
			 selection2 = rand.nextInt(5)+1;
		 if (players == 2){
			 System.out.println(p2Name+" enter any key to spin the wheel to see what type of company you are starting.");
		 	 String check2 = scan.nextLine();
		 }
		 if (selection2 == 1){
			 p2Comp = "Ride Sharing Company";
			 p2Value = 175000;
			 System.out.println(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
		 }
		 if (selection2 == 2){
			 p2Comp = "IT company";
			 p2Value = 135000;
			 System.out.println(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
		 }
		 if (selection2 == 3){
			 p2Comp = "Social Media Company";
			 p2Value = 125000;
			 System.out.println(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
		 }
		 if (selection2 == 4){
			 p2Comp = "Compression Software Company";
			 p2Value = 185000;
			 System.out.println(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
		 }
		 if (selection2 == 5){
			 p2Comp = "Job Search company";
			 p2Value = 150000;
			 System.out.println(p2Name+" started a "+p2Comp+ "that is valued at $"+p2Value);
		 }
		 if (players == 2){
			 System.out.println("Would you like to allow an investor to buy 50% of your company, which will double the value of your company?"
					+ "\nIf so, you will have to wait one turn to move while you find an investor."
					+ "\nOtherwise, you can invest $50,000, which is half of your current worth, and keep the entire company."
			 		+ "\nPress Y for yes or any other key for no.");
			 String partner2 = scan.nextLine();
			 if (new String("Y").equals(partner2) || new String("y").equals(partner2)){
				 p2Value = (2*p2Value);
				 p2Worth = p2Worth*2;
				 pTwoOwn = .5; 
				 p2Wait = true;
			 }
		 }
		 Players pTwo = new Players(p2Name, p2Comp, p2Value, pTwoOwn, p2Worth, p2Type, p2Wait);
		 pTwo.print();
		 Board game = new Board();
		 while (pOne.getSpace() < 30 || pTwo.getSpace() < 30){
			 if (pOne.getSpace() < 30){
				 if (pOne.isWait() == false){
					 game.move(pOne,pTwo);
					 game.draw(pOne,pTwo);
				 }
				 else{
					 pOne.setWait(false);
					 System.out.println(pOne.name+" has to wait this round.  Press any key to continue to "+pTwo.name+"'s turn");
					 String entry = scan.nextLine();
				 }
			}
			else{
				System.out.println(pOne.name+" has already finished. Press any key to continue to "+pTwo.name+"'s turn.");
				String entry = scan.nextLine();
			}
			if (pTwo.getSpace() < 30){
				 if (pTwo.isWait() == false){
					 game.move(pTwo, pOne);
					 game.draw(pOne, pTwo);
				 }
				 else{
					 pTwo.setWait(false);
					 String entry = scan.nextLine();
				 }
			}
			else{
				System.out.println(pTwo.name+" has already finished. Press any key to continue to "+pOne.name+"'s turn.");
				String entry = scan.nextLine();
			}
		 }
		 if (pOne.getPersonWorth() > pTwo.getPersonWorth())
			 System.out.println(pOne.name+" Wins!");
		 if (pOne.getPersonWorth() < pTwo.getPersonWorth())
			 System.out.println(pTwo.name+" Wins!");
		 if (pOne.getPersonWorth() == pTwo.getPersonWorth())
			 System.out.println("It's a Tie!");		
		 }		 
}
