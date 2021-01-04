import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
public class Test01_GET {
	
	@Test
	void Test01_GET() {

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("email", "prabhaattest@gmail.com");
		map.put("firstName", "Prabhaat");
		map.put("lastName", "patro");
		
		ArrayList<Integer> listOfPhoneNo = new ArrayList<Integer>();
		listOfPhoneNo.add(4334534);
		listOfPhoneNo.add(234343);
        map.put("MobileNo", listOfPhoneNo);
        
        HashMap<String,String> address = new HashMap<String,String>();
        address.put("HouseNo", "408");
        address.put("Street", "Sai colony");
        address.put("City", "Bangalore");
        
        map.put("address", address);
        
		ArrayList<String> primarySkills = new ArrayList<String>();
		primarySkills.add("c++");
		primarySkills.add("Java");
		primarySkills.add("Python");
		
		map.put("primarySkills", primarySkills);
		
		ArrayList<String> secondarySkills = new ArrayList<String>();
		secondarySkills.add("shellScripting");
		secondarySkills.add("AL");
		
		map.put("secondarySkills", secondarySkills);
		
		HashMap<String,String> course1 = new HashMap<String,String>();
		
		course1.put("course", "b.tech");
		course1.put("marks", "75");

		HashMap<String,String> course2 = new HashMap<String,String>();

		course2.put("course", "m.tech");
		course2.put("marks", "80");
		
		ArrayList<Object> courseList = new ArrayList<Object>();
		courseList.add(course1);
		courseList.add(course2);
		
		map.put("Education", courseList);
		
		
		Response response = given().contentType(ContentType.JSON)
				.body(map)
				.post("https://reqres.in/api/users");
		
		response.prettyPrint();
		
		
	}

}
