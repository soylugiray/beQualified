@UI @headless
Feature: US_001 Accessing the Homepage

  Scenario: TC_01 Verify homepage accessibility
    Given The user navigates to the home page
    Then The homepage should load successfully