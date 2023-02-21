Feature: Searching by filters and categories

  Background: Go to all products page
    Given I'm on the home Page
    When I go to All Products Page

  Scenario: Search by filter
    When I choose filters I want to apply
    Then the filters are applied
      | Color | Blue            |
      | Price | $16.00 - $17.00 |
      | Size  | S               |

