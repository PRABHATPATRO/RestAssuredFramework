import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndDeleteUser {

	@Test
	public void getUser()
	{
		baseURI = "http://localhost:3000";
		
	Response res =	given()
			.header("Content-Type","application/JSON")
			.body("{" + 
					"    \"firstName\": \"AlbertTest\"," + 
					"    \"lastName\": \"EinsteinTest\"," + 
					"    \"subjectId\": 1" + 
					"}")
			.when()
				.post("/users")
			.then()
				.assertThat().statusCode(201).and()
				.contentType(ContentType.JSON)
				.body("subjectId",equalTo(1))
				.extract().response();
	System.out.println(res.asString());
	JsonPath Jpath = new JsonPath(res.asString());
	int ID = Jpath.get("id");
	
	given()
		.contentType(ContentType.JSON)
	.when()
		.delete("/users/" +ID)
	.then()
		.assertThat().statusCode(200);
	
	}
}
