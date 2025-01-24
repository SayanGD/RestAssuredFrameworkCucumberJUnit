package com.map.stepDefinitions;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import com.map.pojoClasses.AddPlaceRequest;
import com.map.utils.SpecificationBuilder;
import com.map.utils.TestDataBuilder;

public class AddPlace extends SpecificationBuilder
{

	RequestSpecification requestSpecification;

	@Given("I have the AddPlace request body")
	public void i_have_the_add_place_request_body() throws IOException
	{
		TestDataBuilder testDataBuilder=new TestDataBuilder();
		AddPlaceRequest addPlaceRequestBody=testDataBuilder.createAddPlaceRequestBody();

		requestSpecification=given().spec(getRequestSpecification()).body(addPlaceRequestBody);
		//getRequestSpecification() method is from parent SpecificationBuilder class created by me, so no object creation is needed to call it
	}

	@When("I call AddPlace API with POST HTTP request")
	public void i_call_add_place_api_with_post_http_request()
	{
		String response = given().spec(requestSpecification)
				.when().post("/maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK")).body("scope", equalTo("APP")).extract().response().asString();

		JsonPath js=new JsonPath(response);
		String placeID=js.getString("place_id");

		String deletePlaceRequestBody="{\r\n"
					+ "    \"place_id\":\""+placeID+"\"\r\n"
					+ "}\r\n"
					+ "";

		given().spec(requestSpecification).log().all().body(deletePlaceRequestBody)
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);
	}

	@Then("I should get a successful response with {int} status code")
	public void i_should_get_a_successful_response_with_status_code(int responseCode)
	{
	    
	}

	@Then("I should get {string} as {string}")
	public void i_should_get_as(String string, String string2)
	{
	    
	}
}