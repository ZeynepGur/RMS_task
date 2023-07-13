@media
Feature: RMS_Media API Testing

  Background:
    When a GET request is made to the API endpoint

  Scenario: Verify the response status code and response time
    Then the response status code should be 200
    And the response time should be below "100" milliseconds

  Scenario: Verify the "id" field is never null or empty for all items
    Then the "id" field should not be null or empty for all items

  Scenario: Verify the "segment_type" field is always "music" for every track
    Then the "segment_type" field should be "music" for every track

  Scenario: Verify the "primary" field in "title_list" is never null or empty for any track
    Then the "primary" field in "title_list" should not be null or empty for any track

  Scenario: Verify only one track has "now_playing" field in "offset" as true
    Then only one track should have "now_playing" field in "offset" as true

  Scenario: Verify the "Date" value in the response headers
    Then the response headers should contain a valid "Date" value