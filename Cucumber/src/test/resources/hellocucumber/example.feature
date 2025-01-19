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

Feature: Group submits to an assignment

  As a student in a group
  I want to submit to a group assignment
  So that the submission is recorded for all group members

  Background:
    Given I am logged in as a teacher
    When I am logged in with "admin" and "I#X^M8rDZu"
    And I create a new course named "New Course"
    And I create a new assignment named "Assignment 1" with submission type set to group

  Scenario: Successfully submit as a group
    Given I am logged in as a student
    When I am logged in as a student with "student1" and "password123"
    And I navigate to the course "New Course"
    And I navigate to the assignment "Assignment 1"
    And I upload a file named "group_submission.docx"
    And I click the submit button
    Then the system should confirm the submission was successful
    And the submission should be visible for all group members of "Group A"

  Scenario: Group submission is unavailable after the teacher changes to individual submission
    Given I am logged in as a teacher
    And I change the submission type to individual in the assignment settings
    Then the system should confirm the submission type is set to individual
    When I log out and log in as "student1" with "password123"
    And I navigate to the course "New Course"
    And I navigate to the assignment "Assignment 1"
    Then the group submission option should no longer be available
    And the system should display an error or message indicating individual submission is required
