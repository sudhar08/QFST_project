package Activity;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class firstClass {
	
	@Test
	public void postRequestTest() {
		
		Map<String, Object> reqBody = Map.of(
				"name", "Donut",
				"species", "CAT",
				"breed", "Orange",
				"ageMonths", "8",
				"price", "999999",
				"currency", "ISC",
				"status", "ADOPTED"
				);
	RestAssured
				.given()
				.baseUri("POST https://api.petstoreapi.com/v1/pets")
				.header("Authorization", "Bearer sudharsananibm")
				.header("X-Tenant-Id", "550e48400-e29b-41d4-a716-446655448912")
				.header("Content-Type","application/json")
				.body(reqBody).when().post()
				.then().statusCode(201).body("status", Matchers.equalTo("ADOPTED"));
	}
}


