Feature: Retrieve country name by ISO code

  As a tour agent
  I want to be able to lookup a country name by ISO code
  so that I can use ISO codes for country searches in bookings

  Scenario: Get country name from 2 character ISO code

    Given I am using valid two character ISO codes
    When I submit a valid ISO code
    Then I recieve the correct country