package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import pojoClasses.AddPlaceRequest;
import pojoClasses.Location;

public class MapsAPI
{

	public static void main(String[] args)
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

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123").body(addPlaceRequestBody)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js=new JsonPath(response);
		String placeID=js.getString("place_id");

		String deletePlaceRequestBody="{\r\n"
				+ "    \"place_id\":\""+placeID+"\"\r\n"
				+ "}\r\n"
				+ "";

		given().log().all().contentType(ContentType.JSON).queryParam("key", "qaclick123").body(deletePlaceRequestBody)
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);
	}
}