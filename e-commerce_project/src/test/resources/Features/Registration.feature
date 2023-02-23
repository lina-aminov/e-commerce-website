Feature: Registration

  Background:
    Given I'm on the home Page

  Scenario: Sign Up
    When I click Sign In button
    And I click the sign up link
    When I fill in the account details with the following:
      | Social title | Mr           |
      | First Name   | bruce        |
      | Last Name    | wayne        |
      | Email        | UNIQUE_EMAIL |
      | Password     | 69420        |

    And click the Save button
    Then I am redirected to the home page with the name: "bruce wayne" visible

  Scenario: Invalid account name details
    When I click Sign In button
    And I click the sign up link
    When I fill in the account details with the following:
      | Social title | Mr           |
      | First Name   | 69           |
      | Last Name    | 420          |
      | Email        | UNIQUE_EMAIL |
      | Password     | 69420        |
    And click the Save button
    Then I am see the error message "Invalid name"

  Scenario: Invalid account email details
    When I click Sign In button
    And I click the sign up link
    When I fill in the account details with the following:
      | Social title | Mr                     |
      | First Name   | Bruce                  |
      | Last Name    | Wayne                  |
      | Email        | SUUUUUUUIIIIIIIIII@sui |
      | Password     | 69420                  |
    And click the Save button
    Then the error message "Invalid format." is visible

  Scenario: Already registered email
    When I click Sign In button
    And I click the sign up link
    When I fill in the account details with the following:
      | Social title | Mr                      |
      | First Name   | Bruce                   |
      | Last Name    | Wayne                   |
      | Email        | LENNY@LENNY.LENNY.LENNY |
      | Password     | 69420                   |
    And click the Save button
    Then the error message "The email \"LENNY@LENNY.LENNY.LENNY\" is already used, please choose another one or sign in" becomes visible