Feature: Maps API

  @Regression @ValidPlace
  Scenario: Validate if a place is successfully deleted from the map using DeletePlace API
		Given I have the "DeletePlace" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"

	@Regression @ValidPlace
  Scenario: Validate if a place is successfully deleted from the map using DeletePlace API
		Given I have the "DeletePlace" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a successful response with 200 status code
		And I should get "status" as "OK"