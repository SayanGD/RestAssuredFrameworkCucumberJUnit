package com.map.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import com.map.pojoClasses.AddPlaceRequest;
import com.map.pojoClasses.Location;
import utilities.SpecificationBuilder;

public class AddPlace
{

	@Given("I have the AddPlace request body")
	public void i_have_the_add_place_request_body() throws IOException
	{
		Location location=new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		ArrayList<String> types=new ArrayList<>();
		types.add("shoe park");
		types.add("shop");

		AddPlaceRequest addPlaceRequestBody=new AddPlaceRequest();
		addPlaceRequestBody.setLocation(location);
		addPlaceRequestBody.setAccuracy(50);
		addPlaceRequestBody.setName("Frontline house");
		addPlaceRequestBody.setPhone_number("+91-9838933937");
		addPlaceRequestBody.setAddress("29, side layout, cohen 09");
		addPlaceRequestBody.setTypes(types);
		addPlaceRequestBody.setWebsite("http://www.google.com");
		addPlaceRequestBody.setLanguage("French-IN");

		SpecificationBuilder spec=new SpecificationBuilder();
		RequestSpecification requestSpecification=spec.getRequestSpecification();

		String response = given().spec(requestSpecification).log().all().body(addPlaceRequestBody)
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

	@When("I call AddPlace API with POST HTTP request")
	public void i_call_add_place_api_with_post_http_request()
	{
	   
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