Feature: Checkout Page
Background:
  Given I'm on the home Page
  When I click on a product
  And I add a product to Cart
  And I click proceed to checkout
  And I click proceed to checkout again
  When I am on the Checkout Page
  Scenario: Checkout Page

    And I enter my personal details like firstname "John" lastname "Smith" email "hello@username.com"
    And I enter my address "123 Lane" city "New York" zipcode "12345"
    And I click on Shipping method
    And I enter payment details by BANK WIRE
    Then I click on Order to Pay

    Scenario: Enters incorrect zipcode format

      And I enter my personal details like firstname "Jim" lastname "Ronaldo" email "aol@aol.com"
      And I enter my address "123 Road" city "Delaware" zipcode "N1111"
