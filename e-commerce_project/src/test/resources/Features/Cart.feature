Feature: Cart functionality (UI)

  Background: add item to cart
    Given I navigate to cart with an item in it


  Scenario: Remove product from cart

    When I click bin button next to an item
    Then the item disappears and "There are no more items in your cart" message displays