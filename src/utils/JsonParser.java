package utils;

public class JsonParser {
	
	public static String[] getJsonObjects(String json) {
		return json.split("\\}, \\{");
	}

	public static String formate(String json) {
		String result = json.substring(4);
		result = result.substring(0, result.length() - 3);
		return result;
	}
	
}
