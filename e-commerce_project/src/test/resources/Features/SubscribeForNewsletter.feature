Feature: Newsletter subscription

  Background:
    Given I'm on the home Page

  Scenario: Subscribe to the newsletter
    When I subscribe to the newsletter with the email address "UNIQUE_EMAIL"
    Then The message: "You have successfully subscribed to this newsletter." is visible
