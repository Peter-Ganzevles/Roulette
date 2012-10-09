package servertable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/hello")
public class Servie {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String publishResult(Table table) {
		Square roll = table.roll();
		try {
			JSONObject jsonTable = new JSONObject().put("table", table);
			JSONObject jsonRoll = new JSONObject().put("roll", roll);
			JSONObject jsonWins = new JSONObject().put("wins", table.getWinningBets(roll));
			
			JSONArray array = new JSONArray();
			array.put(jsonTable);
			array.put(jsonRoll);
			array.put(jsonWins);
			
		} catch (JSONException e) {

		}
		return null;

	}
}
