Feature: Logging In

  Background:
    Given I'm on the home Page

  Scenario: Logging as a registered user
    When I click Sign In button
    And I fill in the account details with the following:
      | Email    | LENNY@LENNY.LENNY.LENNY |
      | Password | 123456                  |

    And click the Sign In button
    Then I am redirected to the home page with the name: ". ." visible

  Scenario: Log in with incorrect password
    When I click Sign In button
    And I fill in the account details with the following:
      | Email    | LENNY@LENNY.LENNY.LENNY |
      | Password | 69420                   |
    And click the Sign In button
    Then I am see the error message "Authentication failed."

  Scenario: log in with unregistered email
    When I click Sign In button
    And I fill in the account details with the following:
      | Email    | UNIQUE_EMAIL |
      | Password | 69420        |
    And click the Sign In button
    Then the error message "Authentication failed." is displayed
