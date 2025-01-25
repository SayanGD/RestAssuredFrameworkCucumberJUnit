package com.map.endpoints;

public enum EndPoints
{
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	UpdatePlaceAPI("/maps/api/place/update/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),;

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