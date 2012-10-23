package servertable;

import java.util.ArrayList;

public class Table {
	private ArrayList<Player> players;
	private ArrayList<Bet> bets;
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

	public int hasPlayer(int id) {
		int found = -1;
		if(players.size() != 0) {
			for(int i = 0; i < players.size(); i++) {
				if(players.get(i).getId() == id) {
					found = i;
				}
			}
		}
		return found;
	}
	
	public Player getPlayer(int position) {
		return (players.get(position));
	}
	
	public boolean placeBet(Bet bet) {
		boolean succes = false;
		for (Player p : players) {
			if(p.getId() == bet.getPlayerId()) {
				if ((p.getStash() - bet.getValue()) >= 0
						&& bet.getValue() >= minBet && bet.getValue() <= maxBet) {
					bets.add(bet);
					p.removeFromStash(bet.getValue());
					succes = true;
				}
			}
		}
		return succes;
	}

	public void clearBets() {
		bets.clear();
	}

	public Square roll() {
		int number = (int) (Math.random() * nrOfSquares);
		return new Square(number, Squares.getColorForNumber(number));
	}

	public ArrayList<Bet> getWinningBets(int square) {
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
			for(Player p : players) {
				if(p.getId() == b.getPlayerId()) {
					p.addToStash(b.getReward());
				}
			}
		}
	}

	public ArrayList<Bet> getBets() {
		return this.bets;
	}
}
