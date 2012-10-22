package servertable;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Bet")
public class Servie {
	@GET
	@Path("{name}/{table}/{square}/{bet}")
	public String makeBet(@PathParam("name") String name,
			@PathParam("table") int table, @PathParam("square") int square,
			@PathParam("bet") int bet) {
//		int found = Game.getTable(table).hasPlayer(name);
//		if (found > -1) {
		System.out.println(name);
		System.out.println(table);
		System.out.println(square);
		System.out.println(bet);
			ArrayList<Square> betsquare = new ArrayList<Square>();
			Squares squares = new Squares();
			if (square == squares.getColorRed()) {
				for (int i = 0; i < squares.getRed().length; i++) {
					int number = squares.getNextRed(i);
					betsquare.add(new Square(number, squares.getColorRed()));
				}
			} else if (square == squares.getColorBlack()) {
				for (int i = 0; i < squares.getBlack().length; i++) {
					int number = squares.getNextBlack(i);
					betsquare.add(new Square(number, squares.getColorBlack()));
				}
			} else if (square == squares.getCEven()) {
				for (int i = 0; i < squares.getEven().length; i++) {
					int number = squares.getNextEven(i);
					betsquare.add(new Square(number, squares
							.getColorForNumber(number)));
				}
			} else if (square == squares.getCOdd()) {
				for (int i = 0; i < squares.getOdd().length; i++) {
					int number = squares.getNextOdd(i);
					betsquare.add(new Square(number, squares
							.getColorForNumber(number)));
				}
			} else {
				betsquare.add(new Square(square, squares
						.getColorForNumber(square)));
			}
//			Game.getTable(table).placeBet(
//					new Bet(betsquare, bet, Game.getTable(table).getPlayer(
//							found)));
			
//		}
		String s = ("a "+bet+" dollar bet on table "+table+" on square "+square+" has been made by "+name+".");
		System.out.println(s);
		return s;
	}
}
