package servertable;

import java.util.ArrayList;

public class Bet {
	private ArrayList<Square> betSquares = new ArrayList<Square>();
	private static final int multiplication = 36;
	private int value;
	private Player player;
	
	public Bet(ArrayList<Square> betSquares, int value, Player player) {
		this.betSquares = betSquares;
		this.value = value;
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public boolean containsSquare(Square square) {
		boolean found = false;
		for(Square s : betSquares) {
			if(s.equals(square));
			found = true;
		}
		return found;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getReward() {
		return((multiplication / betSquares.size())*value);
	}
}
