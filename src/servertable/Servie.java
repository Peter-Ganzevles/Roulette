package servertable;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/makeBet")
public class Servie {
	private static Game game;
	public static final void main(String[] args) {
		game = new Game();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String makeBet(String b) {
		JSONObject jobj;
		int playerid = -1;
		int table = -1;
		int bet = -1;
		int square = -1;
		try {
			jobj = new JSONObject(b);
			playerid = jobj.getInt("name");
			table = jobj.getInt("table");
			bet = jobj.getInt("bet");
			square = jobj.getInt("square");
		} catch (JSONException e) {
			
		}
		int temp = bet + square + table;
		System.out.println("test"+playerid+temp);
		
		game.getTable(table).placeBet(new Bet(square, temp, playerid));
		
		
		return "fiets";
	}
}
