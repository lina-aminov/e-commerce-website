Feature: Add To Cart

  Scenario: Go to Home Page
    Given I'm on the home Page
    When I click on a product
    And I add a product to Cart
    And I click proceed to checkout
    Then Confirm i am on the Checkout page
