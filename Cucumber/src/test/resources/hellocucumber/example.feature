Feature: User writes a comment on a product and the admin deletes the product

  Scenario Outline: A user writes a comment on a product
    Given A product "<product_name>" exists in the store
    And The user "<user_username>" is logged in with the password "<user_password>"
    When The user navigates to the product "<product_name>" page
    And The user writes a comment with title "<comment_title>" and body "<comment_body>"
    Then The comment with title "<comment_title>" and body "<comment_body>" is visible under the product "<product_name>"

    Examples:
      | product_name         | user_username             | user_password | comment_title     | comment_body                    |
      | Hummingbird Printed T-shirt  | amittry@example.com  | aa11ss22dd33    | Great Shirt    | I love this product!        |
      | Hummingbird Printed T-shirt  | customer@example.com     | customer123   | Nice Quality  | I love this product!         |
      | Mug The adventure begins   | testuser@example.com     | testpass      | Amazing Mug    | Highly recommend this mug!   |


  Scenario: Admin deletes a product
    Given The admin "<admin_username>" is logged into the PrestaShop admin panel with the password "<admin_password>"
    And The product "<product_name>" exists in the store
    When The admin selects the product "<product_name>"
    And The admin clicks the "Delete" button
    And Confirms the deletion
    Then The product "<product_name>" should no longer appear in the product list

    Examples:
      | product_name         | admin_username             | admin_password | 
      | Hummingbird Printed T-shirt  | amithass@post.bgu.ac.il  | 1256359027    |