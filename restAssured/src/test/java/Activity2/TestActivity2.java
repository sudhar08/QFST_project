package Activity2;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

class TestActivity2 {
	
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	String petID;
	
	
	@BeforeClass
    public void setup(){
		requestspec = new RequestSpecBuilder().
				setBaseUri("https://api.petstoreapi.com/v1/pets").
				addHeader("Content-Type", "application/json").
				addHeader("Authorization", "Bearer sudharsananibm").
				addHeader("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655445674").build();
		
		responsespec =  new ResponseSpecBuilder()
				.expectBody("status",Matchers.equalTo("AVAILABLE")).
				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).build();
		
    }
	
	@Test
	public void postrequest() {
		File inputjson = new File("src/test/resources/body.json");
		petID = RestAssured.given().relaxedHTTPSValidation()
				.spec(requestspec)
				.body(inputjson).when().post().then().log().all().spec(responsespec).statusCode(201).extract().path("id");
		
		System.out.println(petID);
	}
	
	@Test(dependsOnMethods = "postrequest")
	public void deleteRequest() {
		
		RestAssured.given().relaxedHTTPSValidation().spec(requestspec).
		pathParam("id", petID)
		.when().delete("/{id}").then().log().all()
		.statusCode(204);
		
		
		
		
		
		
	}
}