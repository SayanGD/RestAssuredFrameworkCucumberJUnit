package com.map.stepDefinitions;

import java.io.IOException;
import io.cucumber.java.After;

public class Hooks
{
	/*Delete the added place to avoid junk data collection after each run*/
	@After("@AddPlace")
	public void deletePlaceAfterAdding() throws IOException
	{
		MapsStepDefinitions stepDefinition = new MapsStepDefinitions();
		if(MapsStepDefinitions.placeID!=null)
		{
			stepDefinition.i_have_the_request_body("DeletePlaceAPI");
			stepDefinition.i_call_api_with_http_request("DeletePlaceAPI", "DELETE");
			stepDefinition.i_should_get_a_response_with_status_code(200);
		}
	}
}