Feature: RMS API Schedule Data Validation
  As a QA Engineer
  I want to validate the schedule data structure and content
  So that I can ensure data integrity and consistency

  Background:
    Given I make a GET request to the RMS API endpoint
    And I receive a successful response

  Scenario: Validate schedule elements have required fields
    Then all schedule elements should have non-null and non-empty "id" fields
    And all episodes should have "type" field as "episode"

  Scenario: Validate episode titles are present
    Then all episodes should have non-null and non-empty "title" fields

  Scenario: Validate live episode count
    Then only one episode should have "live" field as true

  Scenario: Validate transmission time ordering
    Then all schedule items should have "transmission_start" before "transmission_end"