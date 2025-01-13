Feature: A set of scenarios for testing the "PrestaShop" application

  Scenario: Admin deletes an item from the store
    Given an admin is logged into the PrestaShop admin panel
    And the admin navigates to the product catalog
    When the admin deletes an item from the store
    Then the item is no longer visible in the product catalog
    And the item is no longer available in the store for users

  Scenario Outline: User buys an item from the store
    Given a user is logged into the PrestaShop store with "<Email>" and "<Password>"
    And the user adds an item to their shopping cart
    When the user buy the item
    Then the product successfully bought
    #And the item is marked as "sold" in the store's inventory

    Examples:
      | Email           | Password  |
      | nitzan861999@gmail.com | 123456kk  |
#      | gor@gmail.com | 123456kk  |