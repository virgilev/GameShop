package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import beans.Client;

public class JsonClientParser extends JsonParser {

	public static List<Client> getClients(String json) throws ParseException, JSONException {
		json = formate(json);
		String[] tabJsonObject = getJsonObjects(json);
		List<Client> listClient = createClients(tabJsonObject);
		return listClient;
		
	}

	private static List<Client> createClients(String[] tabJsonObject) throws JSONException {
		List<Client> listClient = new ArrayList<Client>();
		for(int i = 0; i < tabJsonObject.length; ++i) {
			listClient.add(createClient(tabJsonObject[i]));
		}
		return listClient;
	}

	private static Client createClient(String jsonObjectString) throws JSONException {
		jsonObjectString = "{" + jsonObjectString + "}";
		JSONObject jsonObject = new JSONObject(jsonObjectString);
		String email = jsonObject.getString("email");
		String lastName = jsonObject.getString("lastName");
		String firstName = jsonObject.getString("firstName");
		String password = jsonObject.getString("password");
		String birthDate = jsonObject.getString("birthDate");
		Client Client = new Client(email, lastName, firstName, password, birthDate);
		return Client;
	}

}
