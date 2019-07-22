Feature: Get correct weather data of a city

  Scenario: Get weather of data by the city name
    Given I send the URIs
    When I send cities name to the request
    Then the Response should contain the cities name