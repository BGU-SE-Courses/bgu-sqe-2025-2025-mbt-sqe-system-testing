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
