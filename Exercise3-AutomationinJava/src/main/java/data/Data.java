package data;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Data {
	
	String path = "/Users/hector.villa/git/Exercise3-AutomationinJava/Amazon_Data.json";
	
	public String getUrl() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String url = (String) oli.get("URL");
		return url;

	}
	
	public String getEmail() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String email = (String) oli.get("Email");		
		return email;

	}
	
	public String getPassword() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String password = (String) oli.get("Password");		
		return password;

	}
	
	public String getUserName() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String userName = (String) oli.get("UserName");		
		return userName;

	}
	
	public String getFirstProduct() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String firstProduct = (String) oli.get("First Product");		
		return firstProduct;

	}
	
	public String getSecondProduct() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject oli = (JSONObject) jsonObject.get("Data");
		String secondProduct = (String) oli.get("Second Product");		
		return secondProduct;

	}

}
