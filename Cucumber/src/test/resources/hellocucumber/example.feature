Feature: User writes a comment on a product and the admin deletes the product

  Scenario Outline: A user writes a comment on a product
    Given A product "<product_name>" exists in the store
    And The user "<user_username>" is logged in with the password "<user_password>"
    When The user navigates to the product "<product_name>" page
    And The user writes a comment "<comment_text>"
    Then The comment "<comment_text>" is visible under the product "<product_name>"

    Examples:
      | product_name         | user_username      | user_password | comment_text                  |
      | Hummingbird T-shirt  | customer@example.com | customer123  | "I love this product!"       |
      | Printed Mug          | testuser@example.com | testpass     | "Highly recommend this mug!" |

  Scenario Outline: Admin deletes the product after the user commented
    Given A product "<product_name>" exists in the store with a comment "<comment_text>"
    And The admin is logged in with username "<admin_username>" and password "<admin_password>"
    When The admin deletes the product "<product_name>"
    And The user logs in with username "<user_username>" and password "<user_password>"
    Then The product "<product_name>" and the comment "<comment_text>" are no longer visible

    Examples:
      | product_name         | user_username      | user_password | comment_text               | admin_username     | admin_password |
      | Hummingbird T-shirt  | customer@example.com | customer123  | "I love this product!"    | admin@example.com  | admin123       |
      | Printed Mug          | testuser@example.com | testpass     | "Highly recommend this mug!" | admin@example.com  | admin123       |
