@manual
Feature: RMS_Media Functional Manual Test Cases

  Background:
    Given a GET request is made to the API endpoint

  Scenario: Verify that content-Type is application/json in response header
    Then the "Content-Type" in the response header should be "application/json"

  Scenario: Verify that all Id values are unique and not null
    Then each "Id" value should be unique and not null

  Scenario: Verify that all the URI field in “Uris” in the response are unique and not duplicated.
    Then each "uri" value in "uris" should be unique and not duplicated

  Scenario: Verify that the start and end dates in the offset field of the music track are not null and valid integers.
    Then each music track should have a non-null and valid integer value for "start" and "end" dates in the "Offset" field