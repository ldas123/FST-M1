package activities;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

public class Activity3 {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeMethod()
	public void setUp(){
		reqSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.build();
		
		resSpec = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200)
				.expectBody("status", equalTo("alive"))
				.build();
				
	}
	
	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider(){
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}
	
	@Test(priority=1,dataProvider="petInfo")
	public void createPet(int petId,String petName,String petStatus) {
		Map<String,Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(reqSpec)
		.body(reqBody)
		  .when()
		        .post()
		        .then().spec(resSpec)
		        .body("name",equalTo(petName));
		        
	}
	
	@Test(priority=2,dataProvider="petInfo")
	public void getPet(int petId, String petName, String petStatus) {
		given().spec(reqSpec)
		.pathParam("petId", petId)
		.log().all()
		.when()
		.get("/{petId}")
		.then().spec(resSpec)
		.body("name", equalTo(petName))
		.log().all();
	}
	
	@Test(priority=3, dataProvider = "petInfo")
	public void deletePet(int petId, String petName, String petStatus) {
		given().spec(reqSpec) // Use requestSpec
		.pathParam("petId", petId) // Add path parameter
	.when()
		.delete("/{petId}") // Send GET request
	.then()
		.body("code", equalTo(200))
		.body("message", equalTo(""+petId)); // Assertions using responseSpec
	}
	
}
