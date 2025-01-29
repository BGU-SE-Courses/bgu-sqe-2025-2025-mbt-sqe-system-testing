Feature: Change assignment submission type

  As a teacher
  I want to change the assignment submission type
  So that students submit individually instead of in groups

  Scenario: Successfully change to individual submission
    Given I am logged in as a teacher
    When I am logged in with "admin" and "I#X^M8rDZu"
    And I create a new course named "New Course"
    And I create a new assignment named "Assignment 1" with submission type set to group
    And I navigate to the assignment settings page
    When I select individual submission in the submission type dropdown making sure to save
    Then the system should confirm the submission type is set to individual


#  Scenario: Fail to change submission type without permissions
#    Given I am logged in as a teacher without editing permissions
#    When I am logged in with "admin" and "I#X^M8rDZu"
#    When I attempt to change the submission type to "Individual"s
#    Then I should see an error message stating "Permission denied"
#
#  Scenario: Backend failure during submission type update
#    Given I am logged in as a teacher
#    When I am logged in with "admin" and "I#X^M8rDZu"
#    And I navigate to the assignment settings page
#    When I select "Individual submission" in the submission type dropdown
#    And the backend service fails
#    Then I should see an error message stating "Update failed"

