
public class Players {
	public String name;
	public String compType;
	private double compEval;
	private double percentOwned;
	private double personWorth;
	public double salary;
	private int space;
	private int playerType;
	private boolean wait;
	
	public Players(String name, String compType, double compEval, double percentOwned, double capital, int playerType, boolean wait){
		this.name = name;
		this.compType = compType;
		this.compEval = compEval;
		this.percentOwned = percentOwned;
		personWorth = capital+percentOwned*compEval;
		salary = percentOwned*compEval*.32;
		space = 0;
		this.playerType = playerType;
		this.wait = wait;
	}

	public double getPercentOwned() {
		return percentOwned;
	}

	public void setPercentOwned(double percentOwned) {
		this.percentOwned = percentOwned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCompEval() {
		return compEval;
	}

	public void setCompEval(double compEval) {
		this.compEval = compEval;
	}
	
	public double getPersonWorth() {
		return personWorth;
	}

	public void setPersonWorth(double change) {
		personWorth = personWorth+change;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double percentOwned, double compEval) {
		salary = percentOwned*compEval*.32;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public int getPlayerType() {
		return playerType;
	}

	public void setPlayerType(int playerType) {
		this.playerType = playerType;
	}

	public boolean isWait() {
		return wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public void print() {
		System.out.println(getName()+" UPDATE *************************************");
		System.out.println("Owns "+(percentOwned*100)+"% of a(n) "+compType+"\nValued at $"+getCompEval()
				+"\nPersonal Worth $ "+getPersonWorth()+" with a salary of $"+getSalary()
				+"\nCurrently at tile "+getSpace()+ " of 30 spaces.");
		System.out.println("*******************************************************");
	}
}
