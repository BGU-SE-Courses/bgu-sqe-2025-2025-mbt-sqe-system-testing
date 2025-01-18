# Feature: A set of scenarios for testing the "example" module

#   Scenario: Testing how a case where a user adds a product to the cart
#     Given an example scenario
#     When all step definitions are implemented
#     Then the scenario passes

Feature: Student subscribes to a forum discussion, Teacher deletes this discussion

  Scenario: Student subscribes to a forum discussion
    Given Student is on Home page
    And Student is logged in with "<username>" and "<password>"
    And Studnt has a course
    And Course has a forum discussion
    When Student subscribes to a forum discussion
    Then The student succcessfully subscribed to the discussion

    Examples:
      | username          | password         |
      | student           | Student123!      |

