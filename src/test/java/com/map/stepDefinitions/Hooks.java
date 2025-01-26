package com.map.stepDefinitions;

import java.io.IOException;
import io.cucumber.java.Before;

public class Hooks
{

	@Before("@DeletePlace")
	public void beforeDeletePlace() throws IOException
	{
		AddPlace addPlace = new AddPlace();
		if(AddPlace.placeID==null) //placeID is static variable & it will be null only if add Place request hasn't been run already
		{
			addPlace.i_have_the_and("50","Frontline house", "+91-9838933937", "29, side layout, cohen 09", "http://www.google.com", "French-IN");
			addPlace.i_have_the_request_body("AddPlaceAPI");
			addPlace.i_call_api_with_http_request("AddPlaceAPI", "POST");
			addPlace.i_should_get_as("status", "OK");
		}
	}
}