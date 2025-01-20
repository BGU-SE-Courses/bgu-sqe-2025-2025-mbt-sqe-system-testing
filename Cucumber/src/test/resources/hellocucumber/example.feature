Feature: A set of scenarios for testing the "PrestaShop" module

  Scenario Outline: Testing how a case where a user adds a product to the cart
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes
    Examples:
      |  |


  Scenario Outline: Admin deactivates a user
    Given the Admin enters the login page
    When the Admin logs in with "<Email>" and "<Password>"
    And navigates to the customers page
    And deactivates the user with email "<UserEmail>"
    Then the user should be successfully deactivated
    Examples:
      | Email          | Password | UserEmail |
      | demo@prestashop.com | prestashop_demo | pub@prestashop.com|
