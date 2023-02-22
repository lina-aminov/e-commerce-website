Feature: Product Quantity (UI)

  Background: add item to cart
    Given I'm on the home Page
    When I click on a product

  Scenario: Change product quantity before adding to cart
    When I click 10 times on change quantity button
    Then I see the changed 11 items product quantity