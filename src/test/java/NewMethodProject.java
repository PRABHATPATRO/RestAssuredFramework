import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NewMethodProject {
	@Test
	public void NewMethod()
	{
		baseURI = "http://localhost:3000";
		
		given()
			.param("name","Math")
			.get("/subjects")
		.then()
			.statusCode(200)
			.log().all();
	}

}
