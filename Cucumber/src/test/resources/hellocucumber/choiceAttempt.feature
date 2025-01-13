Feature: A set of scenarios for testing the "example" module

  Scenario Outline: Student tries to change choice, enters choice change screen, can change choice successfully
    Given "<Actor>" is on home page
    When "<Actor>" is logged in with "<Student_Username>" and "<Password>"
    And the "<Actor>" navigates to the "<Course_Name>" course page
    And the "<Actor>" clicks on the choice test titled "<Test_Title>"
    And the "<Actor>" clicks on the choice option titled "<Choice_Option2>"
    Then the "<Actor>" should be able to change his choice to "<Choice_Option1>"
    And the "<Actor>" should be able to save the choice

    Examples:
      | Actor   | Student_Username | Password   | Course_Name | Test_Title | Choice_Option1 | Choice_Option2 |
      | student | moodleuser       | Password1! | course1     | choice1    | choice_1       | choice_2       |


  Scenario Outline: Student tries to change choice after the teacher disables updates
    Given "<Student_Actor>" is on home page
    When "<Student_Actor>" is logged in with "<Student_Username>" and "<Password>"
    And the "<Student_Actor>" navigates to the "<Course_Name>" course page
    And the "<Student_Actor>" clicks on the choice test titled "<Test_Title>"
    And the "<Student_Actor>" should be able to change his choice to "<Choice_Option1>"
    And the "<Student_Actor>" should be able to save the choice
    And "<Teacher_Actor>" is on home page
    And "<Teacher_Actor>" is logged in with "<Teacher_Username>" and "<Password>"
    And the "<Teacher_Actor>" navigates to the "<Course_Name>" course page
    And the "<Teacher_Actor>" clicks on the choice test titled "<Test_Title>"
    And the "<Teacher_Actor>" disables updates for the choice test
    Then the "<Student_Actor>" navigates to the "<Course_Name>" course page
    And the "<Student_Actor>" clicks on the choice test titled "<Test_Title>"
    And the "<Student_Actor>" should not be able to change his choice to "<Choice_Option2>"
    # The last step is to allow the test to run multiple times
    # without manually setting it back to the original state
    And the "<Teacher_Actor>" enables updates for the choice test "<Test_Title>"

    Examples:
    | Student_Actor | Teacher_Actor  | Student_Username | Teacher_Username | Password   | Course_Name | Test_Title | Choice_Option1 | Choice_Option2 |
    | student       | teacher        | moodleuser       | teacher          | Password1! | course1     | choice2    | choice_1       | choice_2       |
