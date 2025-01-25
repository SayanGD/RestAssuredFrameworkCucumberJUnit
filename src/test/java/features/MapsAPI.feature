Feature: Maps API

  @AddPlace @Regression
  Scenario: Validate if a place is successfully added to the map using AddPlace API
		Given I have the "AddPlace" request body
		When I call "AddPlaceAPI" with "POST" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"
		And I should get "scope" as "APP"

  @DeletePlace @Regression
  Scenario: Validate if a place is successfully deleted from the map using DeletePlace API
		Given I have the "DeletePlace" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"