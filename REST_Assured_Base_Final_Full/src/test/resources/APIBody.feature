Feature: Testing content of API response body

  Scenario: Validate Request body data
    Given I send a request to the server
    When I should get a sucessful response
    Then I should verify data