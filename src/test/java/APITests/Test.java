package APITests;

import java.io.IOException;
import java.nio.file.*;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test {
	
	public static void main(String[] args) throws IOException
	{
	byte[] jsonData = Files.readAllBytes(Paths.get("\\Users\\prabhatkumarpatro\\Documents\\seleniumProjects\\RestAssuredProject\\personFile.json"));
	
	ObjectMapper objectmapper = new ObjectMapper();
	
	Person person = objectmapper.readValue(jsonData, Person.class);
	
	System.out.print(person.getEmail());
	System.out.print(person.getFirstName());
	
	JSONObject json = new JSONObject();
	json.put("Name","Prabhat");
	json.put("email", "prabhat123@gmail");
	json.put("roll", "55");
	
	JSONObject address = new JSONObject();
	address.put("apartment", "sri krishna ventures");
	address.put("laneno.", "1st line marathalli");
	
	json.put("address", address);
	
	Response res = given().contentType(ContentType.JSON)
			.body(json.toString()).log().all()
	.when().put("https://reqres.in/api/users");
	
	res.prettyPrint();
	
	}

}
