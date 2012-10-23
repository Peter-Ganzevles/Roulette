package servertable;


public class Bet {
	private int[] betSquares;
	private static final int multiplication = 36;
	private int value;
	private int playerid;
	
	public Bet(int betsquares, int value, int playerid) {
		if(betsquares == Squares.getCEven()) {
			betSquares = Squares.getEven();
		} else if (betsquares == Squares.getCOdd()) {
			betSquares = Squares.getOdd();
		} else if (betsquares == Squares.getColorRed()) {
			betSquares = Squares.getRed();
		} else if (betsquares == Squares.getColorBlack()) {
			betSquares = Squares.getBlack();
		}
		this.value = value;
		this.playerid = playerid;
	}
		
	public int getPlayerId() {
		return this.playerid;
	}
	
	public boolean containsSquare(int square) {
		boolean found = false;
		for(int s : betSquares) {
			if(s == square);
			found = true;
		}
		return found;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getReward() {
		return((multiplication / betSquares.length)*value);
	}
}
