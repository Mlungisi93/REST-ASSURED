Feature: Get correct weather details of city

  Scenario: Get weather of city by city name
    Given I send the URI
    When I send city name to the request
    Then Response should contain name of city