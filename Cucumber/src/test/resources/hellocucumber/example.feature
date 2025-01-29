Feature: Downgrade User Permissions

  Scenario: Downgrade TA to Student and verify content restriction
    Given a user with TA permissions exists
    When the teacher downgrades the user's permissions to Student
    Then the user role in the course is student


  Scenario: the previous TA Tries to edit but no edit option
    Given logging in with the user after making him student
    When going to course and try but no edit option
    Then no edit option
