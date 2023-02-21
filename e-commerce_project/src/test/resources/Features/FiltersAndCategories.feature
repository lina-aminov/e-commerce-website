Feature: Searching by filters and categories

  Background: Go to all products page
    Given I'm on the home Page
    When I go to All Products Page

  Scenario Outline: Search by color
    When I chose color "<color>" as filer
    Then All appropriate filters are displayed
    Examples:
      | color  |
      | Beige  |
      | White  |
      | Black  |
      | Orange |
      | Blue   |
      | Green  |
      | Yellow |
      | Pink   |