
Feature: US_002 Verifying Headings on the Homepage

  Background:
    Given The user navigates to the home page
    Then The homepage should load successfully

  @UI @headless
  Scenario: TC_01 Verify headings are displayed
    Given The user should see the headings below at the top of the homepage
      | Leistungen         |
      | Mehrwerte          |
      | Unternehmen        |
      | Karriere           |
      | Demo anfragen      |

  Scenario: TC_02 Verify Page Layout and Visual Appearance
    Then The user should see the headings below at the top of the homepage
      | Leistungen         |
      | Mehrwerte          |
      | Unternehmen        |
      | Karriere           |
      | Demo anfragen      |
    Then The general appearance of the page should be visually appealing without layout issues