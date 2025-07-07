Feature:
  As a broadcasting system
  I want to ensure
  Programme Duration and Schedule Logic Validation
  Episode ID Format and Metadata Consistency
  Timestamp Format and Timezone Consistency

  Scenario: Validate programme durations are within acceptable ranges
    Given I retrieve the schedule data from the RMS API
    When I calculate each programme duration
    Then the programme durations should be:
      | Programme              | Expected Duration | Min Duration | Max Duration |
      | BBC Breakfast          | 3h 15min          | 2h 30min     | 4h           |
      | Morning Live           | 1h 30min          | 1h           | 2h           |
      | Homes Under the Hammer | 1h                | 45min        | 1h 15min     |
      | Bargain Hunt           | 15min             | 30min        | 1h           |
      | BBC News at One        | 1h                | 30min        | 1h 30min     |
    And no programme should be shorter than 15 minutes
    And no programme should be longer than 4 hours
    And I should flag "Bargain Hunt" as potentially too short for this show type

  Scenario: Verify schedule covers appropriate time period
    Given I have the complete schedule data
    When I analyze the total time coverage
    Then the schedule should span exactly 7 hours (06:00 to 13:00)
    And the schedule should cover the morning/early afternoon period
    And there should be no time gaps between consecutive programmes
    And the schedule should not extend beyond reasonable broadcasting hours

  Scenario: Validate episode ID format consistency
    Given I retrieve all episodes from the schedule
    When I examine each episode ID
    Then all episode IDs should follow the pattern:
      | Episode ID | Expected Format | Length | Character Set |
      | m001cy4k   | m + 7 chars     | 8      | alphanumeric  |
      | m001d4ws   | m + 7 chars     | 8      | alphanumeric  |
      | m001d7r3   | m + 7 chars     | 8      | alphanumeric  |
      | m001dcf6   | m + 7 chars     | 8      | alphanumeric  |
      | m001dcjl   | m + 7 chars     | 8      | alphanumeric  |
    And all episode IDs should start with "m"
    And all episode IDs should be exactly 8 characters long
    And all episode IDs should be unique within the schedule
    And episode IDs should contain only lowercase letters and numbers

  Scenario: Validate episode metadata consistency
    Given I have all episode data
    When I check episode properties
    Then all episodes should have type "episode"
    And all episodes should have non-empty titles
    And all episodes should have boolean "live" values
    And episode titles should not contain special characters that could break systems
    And episode titles should be appropriate length (not too long or too short)

  Scenario: Validate ISO 8601 timestamp format compliance
    Given I retrieve transmission times from all programmes
    When I examine the timestamp format
    Then all transmission_start times should match pattern "YYYY-MM-DDTHH:mm:ss.sssZ"
    And all transmission_end times should match pattern "YYYY-MM-DDTHH:mm:ss.sssZ"
    And all timestamps should use UTC timezone (indicated by 'Z')
    And all timestamps should include milliseconds (.000)
    And the date component should be "2023-07-12" for all programmes
    And time components should use 24-hour format
    And no timestamps should have invalid values:
      | Invalid Example          | Reason       |
      | 2023-07-12T25:00:00.000Z | Hour > 23    |
      | 2023-07-12T12:60:00.000Z | Minutes > 59 |
      | 2023-07-12T12:00:60.000Z | Seconds > 59 |
      | 2023-13-12T12:00:00.000Z | Month > 12   |

  Scenario: Validate date logic and weekday appropriateness
    Given the schedule date is "2023-07-12"
    When I verify the date logic
    Then "2023-07-12" should be a valid calendar date
    And "2023-07-12" should be a Wednesday
    And the programme lineup should be appropriate for a weekday:
      | Programme Type     | Weekday Appropriate |
      | BBC Breakfast      | Yes                 |
      | Morning Live       | Yes (weekday show)  |
      | Homes Under Hammer | Yes (weekday show)  |
      | Bargain Hunt       | Yes (weekday show)  |
      | BBC News at One    | Yes (daily news)    |
    And no weekend-specific programmes should be present
    And the schedule should reflect typical weekday BBC One programming