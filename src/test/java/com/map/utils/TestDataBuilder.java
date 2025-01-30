package com.map.utils;

import java.util.ArrayList;
import com.map.pojoClasses.AddPlaceRequest;
import com.map.pojoClasses.Location;

public class TestDataBuilder
{
	public AddPlaceRequest createAddPlaceRequestBody(int accuracy, String name, String phoneNumber, String address, String website, String language)
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
		addPlaceRequestBody.setName(name);
		addPlaceRequestBody.setPhone_number(phoneNumber);
		addPlaceRequestBody.setAddress(address);
		addPlaceRequestBody.setTypes(types);
		addPlaceRequestBody.setWebsite(website);
		addPlaceRequestBody.setLanguage(language);

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