Feature: A set of scenarios for testing the "PrestaShop" module
  Scenario Outline: Testing a case where a user changes their name
    Given User is not logged in and on homepage
    When User fills in login details "<Email>" and "<Password>"
    And User is logged in and on homepage
    And User is on user information
    And User changes his first name to "<newFirstName>" with password "<Password>"
    Then user scenario passes

    Examples:
      | firstName | lastName | Email            | Password  | newFirstName |
      | Tom       | Harel    | tomH@gmail.com   | Tt123456! | TomH         |

 Scenario Outline: Admin deactivates a user
    Given the Admin enters the login page
    When the Admin logs in with "<Email>" and "<Password>"
    And navigates to the customers page
    And deactivates the user with email "<UserEmail>"
    Then the user should be successfully deactivated

    Examples:
      | Email                 | Password        | UserEmail       |
      | demo@prestashop.com   | prestashop_demo | tomh@gmail.com  |
