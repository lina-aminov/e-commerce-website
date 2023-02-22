Feature: Sort By functionality (UI)

  Background: I'm on the home page
    Given I'm on the home Page
    And I click on the link to women's section


  Scenario: Sort products by A-Z functionality

    When I capture the product values.
    And I select Name, low to high from the drop down.
    Then the items are sorted in low to high order:
