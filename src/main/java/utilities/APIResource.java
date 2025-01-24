package utilities;

public enum APIResource
{
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI(""),
	updatePlaceAPI(""),
	deletePlaceAPI(""),;

	private String resource;

	APIResource(String string)
	{
		this.resource=string;
	}

	public String getResource()
	{
		return resource;
	}
}