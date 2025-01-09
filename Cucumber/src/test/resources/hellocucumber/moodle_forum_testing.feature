Feature: Testing Moodle Forum Module

  Scenario Outline: Student searches for a comment in the forum and selects the result
    Given The user is logged in with "<Username>" and "<Password>"
    And The student is enrolled in the course "<CourseName>"
    When The student searches for the comment "<CommentText>" in the forum
    Then The comment "<CommentText>" should appear in the search results
    And The student can navigate to the comment

    Examples:
      | Username            | Password   | CourseName | CommentText             |
      | s1                  | 123456Aaa- | course1    | hey1                    |
      | s1                  | 123456Aaa- | course1    | hey2                    |

  Scenario Outline: Teacher deletes their comment from the forum
    Given The user is logged in with "<Username>" and "<Password>"
    And The teacher has posted the comment "<CommentText>" in the course "<CourseName>"
    When The teacher deletes their comment
    Then The comment "<CommentText>" should no longer appear in the forum

    Examples:
      | Username            | Password   | CourseName | CommentText            |
      | t1                  | 123456Aaa- | course1    | hey1                   |
      | t1                  | 123456Aaa- | course1    | hey2                   |

