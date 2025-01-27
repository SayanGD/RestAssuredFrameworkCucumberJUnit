package com.map.stepDefinitions;

import java.io.IOException;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.map.endpoints.EndPoints;
import com.map.pojoClasses.AddPlaceRequest;
import com.map.utils.SpecificationBuilder;
import com.map.utils.TestDataBuilder;

public class MapsStepDefinitions extends SpecificationBuilder
{

	TestDataBuilder testDataBuilder=new TestDataBuilder();
	RequestSpecification requestSpecification;
	Response response;
	static String placeID; //making it static so that multiple tests share the same value of the variable
	JsonPath js;
	int accuracy;
	String name;
	String phoneNumber;
	String address;
	String website;
	String language;

	@Given("I have the {string}")
	public void i_have_the_place_id(String placeID)
	{
		MapsStepDefinitions.placeID=placeID;
	}

	@Given("I have the {string}, {string}, {string}, {string}, {string} and {string}")
	public void i_have_the_and(String accuracy, String name, String phoneNumber, String address, String website, String language)
	{
	    this.accuracy=Integer.parseInt(accuracy);
		this.name=name;
	    this.phoneNumber=phoneNumber;
	    this.address=address;
	    this.website=website;
	    this.language=language;
	}

	@Given("I have the {string} request body")
	public void i_have_the_request_body(String APIName) throws IOException
	{
		switch(APIName)
		{
			case "AddPlaceAPI":
					AddPlaceRequest addPlaceRequestBody=testDataBuilder.createAddPlaceRequestBody(name, phoneNumber, address, website, language);
					requestSpecification=given().spec(getRequestSpecification()).body(addPlaceRequestBody);
					//getRequestSpecification() method is from parent SpecificationBuilder class created by me, so no object creation is needed to call it
					break;
			case "DeletePlaceAPI":
					if(placeID==null) //placeID is static variable & it will be null only if add Place request hasn't been run already
					{
						i_have_the_and("50","Frontline house", "+91-9838933937", "29, side layout, cohen 09", "http://www.google.com", "French-IN");
						i_have_the_request_body("AddPlaceAPI");
						i_call_api_with_http_request("AddPlaceAPI", "POST");
						i_should_get_as("status", "OK");
					}
					String deletePlaceRequestBody=testDataBuilder.createDeletePlaceRequestBody(placeID);
					requestSpecification=given().spec(getRequestSpecification()).body(deletePlaceRequestBody);
					break;
		}		
	}

	@When("I call {string} with {string} HTTP request")
	public void i_call_api_with_http_request(String APIName, String HTTPMethod)
	{
		String endPoint=EndPoints.valueOf(APIName).getPath(); //getting the relevant end-point from the Enum where all the end-points are kept

		switch(HTTPMethod)
		{
			case "POST": response=requestSpecification.when().post(endPoint); //building the response
						break;
			case "GET": response=requestSpecification.when().get(endPoint); //building the response
						break;
			case "PUT": response=requestSpecification.when().put(endPoint); //building the response
						break;
			case "DELETE": response=requestSpecification.when().delete(endPoint); //building the response
						break;			
		}
	}

	@Then("I should get a response with {int} status code")
	public void i_should_get_a_response_with_status_code(int expectedResponseCode)
	{
		response=response.then().log().all().extract().response(); //updating the response
		int actualResponseCode=response.getStatusCode();
		Assert.assertEquals(expectedResponseCode, actualResponseCode);
	}

	@Then("I should get {string} as {string}")
	public void i_should_get_as(String attribute, String expectedAttributeValue)
	{
		js=new JsonPath(response.asString());
		String actualAttributeValue=js.getString(attribute);
		Assert.assertEquals(expectedAttributeValue, actualAttributeValue);

		placeID=js.getString("place_id");
	}

	@Then("I should be able to retrieve the {string}, {string}, {string}, {string}, {string} and {string} using created placeID")
	public void i_should_be_able_to_retrieve_the_and_using_created_place_id(String string, String string2, String string3, String string4, String string5, String string6)
	{
	    
	}
}