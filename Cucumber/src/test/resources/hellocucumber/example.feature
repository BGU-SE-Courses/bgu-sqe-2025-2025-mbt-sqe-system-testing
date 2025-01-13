Feature: A set of scenarios for testing the "PrestaShop" application

  Scenario Outline: User buys an item from the store
    Given a user is logged into the PrestaShop store with "<Email>" and "<Password>"
    And the user adds an item to their shopping cart
    When the user buy the item
    Then the product purchase successfully confirmed
    #And the item is marked as "sold" in the store's inventory

    Examples:
      | Email           | Password  |
      | tomas@gmail.com | TomasNano123  |
#      | gor@gmail.com | 123456kk  |

  Scenario Outline: admin deletes an item from the store and user can't buy it
    Given an admin is logged in with <Email_admin> and <Password_admin>
    And a user is logged in with <Email_user> and <Password_user>
    And the user has added an item to their shopping cart
    When the admin deletes the item from the store
    Then the user should not be able to purchase the item

    Examples:
      | Email_user           | Password_user  | Email_admin | Password_admin |
      | tomas@gmail.com | TomasNano123  | nitzan861999@gmail.com | 123456kk  |

