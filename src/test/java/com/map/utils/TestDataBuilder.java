package com.map.utils;

import java.util.ArrayList;
import com.map.pojoClasses.AddPlaceRequest;
import com.map.pojoClasses.Location;

public class TestDataBuilder
{
	public AddPlaceRequest createAddPlaceRequestBody()
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

		return addPlaceRequestBody;
	}

	public String createDeletePlaceRequestBody(String placeID)
	{
		return "{\r\n"
				+ " \"place_id\":\""+placeID+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
}