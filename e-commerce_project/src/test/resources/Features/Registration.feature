Feature: Registration

  Background:
    Given I'm on the home Page

  Scenario: Sign Up
    When I click Sign In button
    And I click the sign up link
    When I fill in the account details with the following:
      | Social title | Mr                             |
      | First Name   | bruce                          |
      | Last Name    | wayne                          |
      | Email        | BATMANNAMTAB@NOTBRUCEWAYNE.COM |
      | Password     | New York City                  |

    And click the Save button
    Then I am redirected to the home page with the name: "bruce wayne" visible
