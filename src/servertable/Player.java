package servertable;

public class Player {
	private int id;
	private int stash = 1000;
	
	public Player(int id) {
		this.id = id; 
	}
	
	public int getId() {
		return this.id;
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
