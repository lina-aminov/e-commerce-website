Feature: Checkout Page

  Scenario: Checkout Page
    Given I am on the Checkout Page
    When I enter my personal details
    And I enter my address
    And I click on Shipping method
    And I enter payment details by BANK WIRE
    Then I click on Order to Pay