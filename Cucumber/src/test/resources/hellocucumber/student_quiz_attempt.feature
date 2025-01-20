Feature: A set of scenarios for testing the "Student Attempt A Quiz" module

  Scenario: Student successfully attempts a quiz
    Given User is inside the Moodle Home Page
    And Student is logged in with "<Username>" and "<Password>"
    When Student navigates to the "<CourseName>"
    And Student selects the quiz "<QuizName>"
    And Student clicks "Attempt Quiz Now"
    And Student answers the quiz questions
    And Student submits the quiz
    Then The quiz attempt is marked as "Finished"
    And The student sees the quiz results


  Scenario: Student attempts a quiz with a time limit
    Given User is inside the Moodle Home Page
    And Student is logged in with "<Username>" and "<Password>"
    When the student navigates to the "<CourseName>" course page
    And the student clicks on the quiz titled "<QuizTitle>"
    And the student clicks the "Start Attempt" button
    And the quiz has a time limit of "<TimeLimit>" minutes
    And the student answers some questions
    Then The student is notified when the time is about to expire
    And The student submits the quiz before the time runs out
    Then The student should see the time taken and the results


  Scenario: Student submits an incomplete quiz
    Given User is inside the Moodle Home Page
    And Student is logged in with "<Username>" and "<Password>"
    When the student navigates to the "<CourseName>" course page
    And the student clicks on the quiz titled "<QuizTitle>"
    And the student clicks the "Start Attempt" button
    And the student answers some questions but leaves some unanswered
    When The student clicks "Finish attempt" and submits the quiz
    Then The student should see a warning about unanswered questions
    And The student confirms to submit the quiz
    Then The student should see the results for the completed questions


  Scenario: Student tries to access the quiz after the deadline
    Given User is inside the Moodle Home Page
    And Student is logged in with "<Username>" and "<Password>"
    When the student navigates to the "<CourseName>" course page
    And the student clicks on the quiz titled "<QuizTitle>"
    Then The student should see a message indicating the quiz is closed
    And The student cannot start the quiz after the deadline


