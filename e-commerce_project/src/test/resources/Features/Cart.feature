Feature: Remove products from cart (UI)

  Background: add item to cart
    Given I have an item in the cart
#    And I'm on cart page


  Scenario: Remove product from cart

    When I click bin button next to an item
    Then the item disappears and "There are no more items in your cart" message displays
