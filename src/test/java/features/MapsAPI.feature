Feature: Maps API

  @AddPlace @Regression
  Scenario: Validate if a place is successfully added to the map using AddPlace API
    Given I have the AddPlace request body
    When I call "AddPlaceAPI" with "POST" HTTP request 
    Then I should get a successful response with 200 status code
    And I should get "status" as "OK"
    And I should get "scope" as "AAP"