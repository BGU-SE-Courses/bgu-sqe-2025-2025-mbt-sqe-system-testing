Feature: The forum module

  Scenario: Testing student posts comment
    Given Forum is opened
    And Student is logged in
    When User posts a discussion with subject "<subject>" and body "<body>" on forum
    Then The discussion was posted successfully

    Examples:
      | subject | body  |
      | subject | body  |
  
  Scenario: Testing teacher deletes the forum
    Given The forum Exists
    When The teacher deletes the forum
    Then The forum is deleted successfully