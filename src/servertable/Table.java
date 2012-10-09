package servertable;

import java.util.ArrayList;

public class Table {
	private ArrayList<Player> players;
	private ArrayList<Bet> bets;
	private Squares squares;
	private int minBet;
	private int maxBet;
	private int maxPlayers;
	private static final int nrOfSquares = 37;

	public Table() {
		players = new ArrayList<Player>();
		minBet = 1;
		maxBet = 2000;
		maxPlayers = 10;
	}

	public boolean tryJoinTable(Player player) {
		boolean placed = false;
		if (this.players.size() < maxPlayers) {
			players.add(player);
			placed = true;
		}
		return placed;
	}

	public void leaveTable(Player player) {
		for (Player e : players) {
			if (e.getId() == player.getId()) {
				players.remove(e);
			}
		}
	}

	public void placeBet(Bet bet) {
		if ((bet.getPlayer().getStash() - bet.getValue()) >= 0
				&& bet.getValue() >= minBet && bet.getValue() <= maxBet) {
			bets.add(bet);
			bet.getPlayer().removeFromStash(bet.getValue());
		}
	}

	public void clearBets() {
		bets.clear();
	}

	public Square roll() {
		int number = (int) (Math.random() * nrOfSquares);
		return new Square(number, squares.getColorForNumber(number));
	}

	public ArrayList<Bet> getWinningBets(Square square) {
		ArrayList<Bet> winningBets = new ArrayList<Bet>();
		for (Bet b : bets) {
			if (b.containsSquare(square)) {
				winningBets.add(b);
			}
		}
		return winningBets;
	}

	public void payOut(ArrayList<Bet> payOutBets) {
		for (Bet b : payOutBets) {
			b.getPlayer().addToStash(b.getReward());
		}
	}

	public ArrayList<Bet> getBets() {
		return this.bets;
	}
}
