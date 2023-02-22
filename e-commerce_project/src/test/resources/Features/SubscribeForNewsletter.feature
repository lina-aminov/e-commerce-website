Feature: Newsletter subscription

  Background:
    Given I'm on the home Page

  Scenario: Subscribe to the newsletter
    When I subscribe to the newsletter with the email address "UNIQUE_EMAIL"
    Then The message: "You have successfully subscribed to this newsletter." is visible


  Scenario: Subscribe to the newsletter with email that already subscribed for newsletters
    When I attempt to resubscribe to the newsletter with the email address "AlreadySubscribed@email.com"
    Then The message: "This email address is already registered." is shown instead

  Scenario: Leaving the email subscription field empty
    When I attempt to subscribe to the newsletter without entering an email
    Then The error message: "Invalid email address." is shown