Feature: Cancel coupon

  Scenario Outline: Admin cancel coupon
    Given User is on log in page
    When Admin is logged in with "<Username>" and "<Password>"
    And Admin click on marketing button
    And Admin navigates to Coupon button
    #And Admin watch Coupon page
    And Admin click on edit button
    And Admin scroll down
    And Admin click on status button
    And Admin scroll up
    And Admin click on the save button
    Then the Coupon is disable

    Examples:
      | Username | Password|
      | admin    | 1234|


  Scenario Outline: Customer applies a coupon at checkout
    Given User is on home page
    When User logs in with "<Email>" and "<Password>"
    And User clicks on the homepage
    And User scrolls down to see a product
    And User clicks on add to cart for the product
    And User scrolls up
    And User clicks on shopping cart
    And User scrolls down
    And User clicks on use a coupon
    And User enters the coupon code "<CouponCode>"
    And User clicks apply coupon
    Then The discount is applied to the total price

    Examples:
      | Email            | Password | CouponCode |
      | fun@gmail.com    | 1234     | itsfree  |
