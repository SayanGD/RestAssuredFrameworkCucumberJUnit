Feature: Add a place to Maps API

	@AddPlace @GetPlace @Regression
	Scenario Outline: Validate if a place is successfully added to the map using AddPlace API
		Given I have the "<accuracy>", "<name>", "<phone number>", "<address>", "<website>" and "<language>"
		And I have the "AddPlaceAPI" request body
		When I call "AddPlaceAPI" with "POST" HTTP request
		Then I should get a response with 200 status code
		And I should get "status" as "OK"
		And I should get "scope" as "APP"
		And I should get a placeID created
		When I have the "GetPlaceAPI" request body
		And I call "GetPlaceAPI" with "GET" HTTP request
		Then I should get a response with 200 status code
		And I should get "name" as "<name>"

	Examples:
		|accuracy	|name					|phone number		|address									|website							|language		|
		|4141			|Backline Home|+91-9838933937	|41, Side Street, Cohen 9	|http://www.yahoo.com	|Spanish-ES	|