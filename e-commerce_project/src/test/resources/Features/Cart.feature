Feature: Cart functionality (UI)

  Background: add item to cart
    Given I'm on the home Page
    When I click on a product
    And I add a product to Cart
    And I click proceed to checkout


  Scenario: Remove product from cart

    When I click bin button next to an item
    Then the item disappears and "There are no more items in your cart" message displays

  Scenario: Change the quantity from the cart
    When I am clicking 8 times on up button
    And I click 2 times on down button
    Then I see the changed 7 items quantity


  Scenario Outline: I am adding different quantity values in the input cart
    When I am adding manually <num> items into the cart
    Then I see the changed <num> items quantity
    Examples:
      | num |
      | 6   |
      | 2   |
      | 100 |
      | 9   |
      | 175 |

    #negative testing
  Scenario Outline: I am adding negative and max positive numbers in the input cart
    When I am adding negative <num1> items into the cart
    Then I should see as 248 max value
    Examples:
      | num1   |
      | -1     |
      | 177    |
      | 999999 |
      | 248    |
      | 249    |
      | -1     |






          