package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity2 {
	
	@Test(priority=1)
	public void createuser() throws IOException {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\userInfo.json";
		
		// Import JSON file
		FileInputStream inputJSON = new FileInputStream(filePath);
		
		Response response = given()
				            .header("Content-Type", "application/json")
				            .body(inputJSON)
				            .when().post("/user");
		
		inputJSON.close();
		 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("9186"));
				            
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		// Import JSON file to write to
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
 
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.pathParam("username", "restassuredTest") // Pass request body from file
			.when().get("/{username}"); // Send POST request
		
		// Get response body
		String resBody = response.getBody().asPrettyString();
 
		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		// Assertion
		response.then().body("id", equalTo(9186));
		response.then().body("username", equalTo("restassuredTest"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.pathParam("username", "restassuredTest") // Add path parameter
			.when().delete("/{username}"); // Send POST request
 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("restassuredTest"));
	}

}
