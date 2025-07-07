Feature: RMS API Basic Validation
  As a QA Engineer
  I want to validate the basic functionality of the RMS API
  So that I can ensure the API meets the expected requirements

  Scenario: Validate API response status and performance
    Given I make a GET request to the RMS API endpoint
    When I receive the response
    Then the HTTP status code should be 200
    And the response time should be below 1000 milliseconds

  Scenario: Validate API error handling
    Given I make a GET request to the RMS API endpoint with invalid path "/2023-09-11"
    When I receive the response
    Then the HTTP status code should be 404
    And the error object should have properties "details" and "http_response_code"