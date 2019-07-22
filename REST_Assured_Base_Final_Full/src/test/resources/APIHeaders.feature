Feature: Test functionality of api response Headers

  Scenario: Testing request headers
    Given I send a request to the api
    When the response is returned succesfully
    Then verify the status line