Feature: Maps API

  @AddPlace @Regression
  Scenario Outline: Validate if a place is successfully added to the map using AddPlace API
		Given I have the "<accuracy>", "<name>", "<phone number>", "<address>", "<website>" and "<language>"
		And I have the "AddPlaceAPI" request body
		When I call "AddPlaceAPI" with "POST" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"
		And I should get "scope" as "APP"
		
		Examples:
		|accuracy	|name						|phone number		|address									|website							|language		|
		|50				|Frontline House|+91-9838933937	|41, Side Layout, Cohen 9	|http://www.google.com|Spanish-ES	|


  @DeletePlace @Regression
  Scenario: Validate if a place is successfully deleted from the map using DeletePlace API
		Given I have the "DeletePlaceAPI" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"