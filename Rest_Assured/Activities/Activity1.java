package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Activity1 {

	static Map<String, Object> hmap;

	@Test(priority = 0)
	public void createPet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		hmap = new HashMap<>();
		hmap.put("id", 77232);
		hmap.put("name", "Riley");
		hmap.put("status", "alive");

		Response response = given().header("Content-Type", "application/json").body(hmap).when().post("/pet");

		String jsonResponse = response.then().extract().asString();

		JsonPath js = new JsonPath(jsonResponse);
		Assert.assertEquals(hmap.get("id"), Integer.parseInt(js.getString("id")));
		Assert.assertEquals(hmap.get("name"), js.getString("name"));
		Assert.assertEquals(hmap.get("status"), js.getString("status"));
	}

	@Test(priority = 1)
	public void getPet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response response = given().header("Content-Type", "application/json").pathParams("petId", 77232).when()
				.get("/pet/{petId}");

		String jsonResponse = response.then().extract().asString();

		JsonPath js = new JsonPath(jsonResponse);
		Assert.assertEquals(hmap.get("id"), Integer.parseInt(js.getString("id")));
		Assert.assertEquals(hmap.get("name"), js.getString("name"));
		Assert.assertEquals(hmap.get("status"), js.getString("status"));
	}
	
	@Test(priority=2)
	public void deletePet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
				            .pathParam("petId", hmap.get("id"))
				            .when()
				            .delete("/pet/{petId}");
		
		response.then().statusCode(200);
		response.then().body("message",equalTo("77232"));
		response.prettyPrint();
	}

}
