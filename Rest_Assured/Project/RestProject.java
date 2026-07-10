import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestProject {
	
	RequestSpecification reqSpec;
	String sshKey = "";
	static int id;
	String token = "";
	Map<String,String> hmap = new HashMap<>();
	
	@BeforeClass
	public void setUp() {
		reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer "+token)
				.setBaseUri("https://api.github.com")
				.build();
		
		hmap.put("title", "TestAPIKey");
		hmap.put("key",sshKey);
	}
	
	@Test(priority=1)
	public void addSSHKey() {
		
		Response response = given().spec(reqSpec)
				            .body(hmap)
				            .when()
				            .post("/user/keys");
		response.then().statusCode(201);
		
		id = response.then().extract().path("id");
		
		response.prettyPrint();
		
	}
	
	@Test(priority=2)
	public void getSSHKey() {
		
		Response response = given().spec(reqSpec)
				            .pathParam("keyId", id)
				            .when()
				            .get("/user/keys/{keyId}");
		
		response.prettyPrint();
		
		response.then().statusCode(200);
			
	}
	
	@Test(priority=3)
	public void deleteSSHKey() {
		Response response = given().spec(reqSpec)
				            .pathParam("keyId", id)
				            .when()
				            .delete("/user/keys/{keyId}");
		
		response.prettyPrint();
		
		response.then().statusCode(204);
	}

}
