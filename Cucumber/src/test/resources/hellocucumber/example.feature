Feature: User writes a comment on a product and the admin deletes the product

  Scenario Outline: A user writes a comment on a product
    Given A product "<product_name>" exists in the store
    And The user "<user_username>" is logged in with the password "<user_password>"
    When The user navigates to the product "<product_name>" page
    And The user writes a comment with title "<comment_title>" and body "<comment_body>"
    Then The comment with title "<comment_title>" and body "<comment_body>" is visible under the product "<product_name>"

    Examples:
      | product_name         | user_username             | user_password | comment_title     | comment_body                    |
      | Hummingbird Printed T-shirt  | volodavi@post.bgu.ac.il  | 56575453Ab    | Great Shirt    | I love this product!        |
      | Hummingbird Printed T-shirt  | customer@example.com     | customer123   | Nice Quality  | I love this product!         |
      | Mug The adventure begins   | testuser@example.com     | testpass      | Amazing Mug    | Highly recommend this mug!   |

  Scenario Outline: Admin deletes the product after the user commented
    Given A product "<product_name>" exists in the store with a comment with title "<comment_title>" and body "<comment_body>"
    And The admin is logged in with username "<admin_username>" and password "<admin_password>"
    When The admin deletes the product "<product_name>"
    And The user logs in with username "<user_username>" and password "<user_password>"
    Then The product "<product_name>" and the comment with title "<comment_title>" and body "<comment_body>" are no longer visible

    Examples:
      | product_name         | user_username      | user_password | comment_title     | comment_body                 | admin_username     | admin_password |
      | Hummingbird Printed T-shirt  | customer@example.com | customer123  | Nice Quality   | I love this product!      | admin@example.com  | admin123       |
      | Printed Mug          | testuser@example.com | testpass     | Amazing Mug   | Highly recommend this mug! | admin@example.com  | admin123       |
