Feature: Cart functionality (UI)

  Background: add item to cart
    Given I'm on the home Page
    When I click on a product
    And I add a product to Cart
    And I click proceed to checkout


  Scenario: Remove product from cart

    When I click bin button next to an item
    Then the item disappears and "There are no more items in your cart" message displays