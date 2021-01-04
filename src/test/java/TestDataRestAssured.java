import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class TestDataRestAssured extends dataDrivenTestClass{
	
//	@Test(dataProvider = "datadriven")
//	public void datadriven(String firstName,String lastName, int subjectId)
//	{
//	baseURI = "http://localhost:3000/";
//	
//	JSONObject req = new JSONObject();
//	req.put("firstName", firstName);
//	req.put("lastName", lastName);
//	req.put("subjectId", subjectId);
//	
//	given()
//		.header("ContentType","application/JSON")
//		.contentType(ContentType.JSON)
//		.accept(ContentType.JSON)
//		.body(req.toJSONString())
//	.when()
//		.post("/users")
//	.then()
//		.statusCode(201);
//	}
//
//	@DataProvider(name = "datadriven")
//	public Object[][] dataForTest()
//	{
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 1;		
//		
//		data[1][0] = "Thomas";
//		data[1][1] = "Edison";
//		data[1][2] = 2;	
//				
//		return data;
//	}
	
	@Test(dataProvider = "dataToDeleteUsers")
	public void deleteData(int userid)
	{
		baseURI = "http://localhost:3000/";
		
		given()
			.delete("users/"+ userid)
		.then()
			.statusCode(200);
	}
}
