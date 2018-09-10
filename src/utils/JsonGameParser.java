package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import beans.Game;

public class JsonGameParser extends JsonParser {

	public static List<Game> getGames(String json) throws ParseException, JSONException {
		json = formate(json);
		String[] tabJsonObject = getJsonObjects(json);
		List<Game> listGame = createGames(tabJsonObject);
		return listGame;
		
	}

	private static List<Game> createGames(String[] tabJsonObject) throws JSONException {
		List<Game> listGame = new ArrayList<Game>();
		for(int i = 0; i < tabJsonObject.length; ++i) {
			listGame.add(createGame(tabJsonObject[i]));
		}
		return listGame;
	}

	private static Game createGame(String jsonObjectString) throws JSONException {
		jsonObjectString = "{" + jsonObjectString + "}";
		JSONObject jsonObject = new JSONObject(jsonObjectString);
		String title = jsonObject.getString("title");
		Double price = jsonObject.getDouble("price");
		String console = jsonObject.getString("console");
		String description = jsonObject.getString("description");
		Game game = new Game(title, console, price, description);
		return game;
	}

}
