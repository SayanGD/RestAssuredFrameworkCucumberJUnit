Feature: Delete API in Maps

	@DeletePlace @ValidPlaceID @Regression
  Scenario: Validate if a place is successfully deleted from the map using DeletePlace API
		Given I have the "DeletePlaceAPI" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a response with 200 status code
		And I should get "status" as "OK"


	@DeletePlace @InvalidPlaceID @Regression
  Scenario Outline: Validate if DeletePlace API returns error message when a non-existent place is attempted to be deleted
  	Given I have the "<place_id>"
		And I have the "DeletePlaceAPI" request body
		When I call "DeletePlaceAPI" with "DELETE" HTTP request
		Then I should get a response with 404 status code
		And I should get "msg" as "Delete operation failed, looks like the data doesn't exists"

	Examples:
		|place_id													|
		|dd86dc59ae9f8578091498d87628c104	|