import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AutomationProject.setupFiles.TestSetup;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class dataDrivenTestClass extends TestSetup {

	@Test
	public void getCustomers()

	{
		Response res = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "").get(configProp.getCustomerDetails());
		res.prettyPrint();
		System.out.print(res.getStatusCode());
	}
}
