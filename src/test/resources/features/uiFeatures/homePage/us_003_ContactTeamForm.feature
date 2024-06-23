
Feature: US_003 Verifying Headings on the Homepage

  Background:
    Given The user navigates to the home page
    Then The homepage should load successfully

  Scenario: TC_01 Verify "Contact the Crew" form accessibility
    Given Check if the form is visible

  Scenario: TC_02 Filling out and submitting the "Contact the Crew" form
    Given Check if the form is visible
    Then Fill in and submit the form

  Scenario: TC_03 Verify filling out and submitting the "Contact the Crew" form
    Given Check if the form is visible
    Then Fill in and submit the form
    Then Verify that the form is submitted