Feature: A set of scenarios for testing the "example" module

  Scenario Outline: Student tries to change choice, enters choice change screen, can change choice successfully
    Given User is on Home page
    # And the choice titled "<Choice_Title>" is allowed to be updated
    When Student is logged in with "<Username>" and "<Password>"
    And the student navigates to the "<Course_Name>" course page
    And the student clicks on the choice titled "<Choice_Title>"
    And the student clicks on the choice option titled "<Choice_Option2>"
    Then the student should be able to change his choice to "<Choice_Option1>"
    And the student should be able to save the choice

    Examples:
      | Username   | Password  | Course_Name | Choice_Title | Choice_Option1 | Choice_Option2 |
      | moodleuser | Password1! | course1     | choice1      | choice_1      | choice_2       |

