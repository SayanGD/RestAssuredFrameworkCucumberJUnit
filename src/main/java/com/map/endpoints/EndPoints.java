package com.map.endpoints;

public enum EndPoints
{
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI(""),
	UpdatePlaceAPI(""),
	DeletePlaceAPI(""),;

	private String path;

	EndPoints(String path)
	{
		this.path=path;
	}

	public String getPath()
	{
		return path;
	}
}