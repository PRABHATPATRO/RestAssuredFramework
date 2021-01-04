import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class NewMethodPost {
	@Test
	public void postMethod()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Prabhat","Leader");
		map.put("Patro","Master");
		System.out.println(map);
		
		JSONObject req = new JSONObject();
		System.out.println(req.toJSONString());
		
		//Instead of creating a map and passing it as argument
		//we can directly put key-value in json req
		
		req.put("Prabhat1", "TeamLead");
		req.put("Prabhat2", "Manager");
		System.out.println(req.toJSONString());
		
		
		//The way we write entire scenario
		given()
			.header("Content-Type","application/JSON")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
	}

}
