Feature: A set of scenarios for testing the "Student Attempt A Quiz" and "Teacher Hide a Quiz" 

  Scenario: Student successfully attempts a quiz
    Given User is inside the Moodle Home Page
    And Student is logged in with "<Username>" and "<Password>"
    When Student navigates to the "<CourseName>"
    And Student selects the quiz "<QuizName>"
    And Student clicks "start attemp"
    And Student answers the quiz questions
    And Student finish attemp
    Then The quiz attempt is marked as "Finished"
    And The student sees the quiz results

 Examples:
    | Username | Password     | CourseName | QuizName   |
    | student  | Qq123456!    | test       | quiz-test  |


  Scenario: Teacher hides a quiz and student is unable to see it
    Given Teacher is on Home page
    And Teacher is logged in with "<TeacherUsername>" and "<TeacherPassword>"
    And Teacher navigate to course page "<CourseName>"
    And a quiz titled "<QuizName>" is available
    And Teacher hide quiz
    And quiz should be with hidden status 
    And Teacher logged out
    When Student log in with "<StudentUsername>" and "<StudentPassword>"
    And Student navigate to course page "<CourseName>"
    Then Student try to access quiz and fail "<QuizName>" 

Examples:
  | TeacherUsername | TeacherPassword | CourseName | QuizName   | StudentUsername | StudentPassword |
  | teacher        | Qq123456!       | test       | quiz-test  | student        | Qq123456!       |


  Scenario: Student tries to access the quiz after the deadline
      Given Anon is inside the Moodle Home Page
      And Student is log in with "<Username>" and "<Password>"
      When the student navigates to the "<CourseName>" course page
      And the student clicks on the quiz titled "<QuizName>"
      Then The student should not see "start attemp" button

Examples:
    | Username | Password   | CourseName | QuizName              |
    | student  | Qq123456!  | test       | after deadline quiz   |

