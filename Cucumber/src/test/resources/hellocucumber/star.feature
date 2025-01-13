Feature: A student defined a course as starred

  Scenario: A student defined a course as starred
    Given the student is logged in to the system with "<Username>" and "<Password>"
    And the student is on My Courses page
    When the student defined the course "<Course>" as starred
    Then the course is starred

    Examples:
      | Username  | Password   | Course          |
      | student   | Sandbox24* | My first course |

  Scenario: A teacher deleted a course
     Given the teacher is logged in to the system with "<Username>" and "<Password>"
     And the teacher is on "<Course>" setting
     When the teacher deletes the course
     Then the course "<Course>" is hidden from students

     Examples:
       | Username  | Password   | Course          |
       | teacher   | Sandbox24* | My first course |