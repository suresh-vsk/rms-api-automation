Feature: RMS API Response Headers Validation
  As a QA Engineer
  I want to validate the response headers
  So that I can ensure proper API metadata is returned

  Scenario: Validate response headers contain Date field
    Given I make a GET request to the RMS API endpoint
    When I receive the response
    Then the response headers should contain "Date" field
    And the "Date" header should have a valid date format