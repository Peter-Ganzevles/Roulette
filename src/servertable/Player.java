package servertable;

public class Player {
	private String name;
	private int stash = 1000;
	
	public Player(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return this.name;
	}

	public int getStash() {
		return this.stash;
	}
	
	public void addToStash(int profit) {
		this.stash += profit;
	}
	
	public void removeFromStash(int betvalue) {
		this.stash -= betvalue;
	}
}
