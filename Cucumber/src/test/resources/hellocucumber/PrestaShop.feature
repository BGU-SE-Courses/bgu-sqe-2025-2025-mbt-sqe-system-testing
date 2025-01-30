Feature: PastaShop Cart Management

  Scenario: User adds a product to the cart twice
    Given User is already in PastaShop home page
    When User adds a product to cart Twice
    Then the cart contains 2 identical products

  Scenario: Admin changes the quantity of a product to one
    Given Admin is already logged in to the system
    And the cart contains 2 identical products on the admin page
    When Admin updates the product quantity to 1
    Then the product quantity in the cart is updated to 1