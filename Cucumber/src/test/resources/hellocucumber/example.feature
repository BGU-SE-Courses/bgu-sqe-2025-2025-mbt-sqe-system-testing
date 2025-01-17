Feature: A set of scenarios for testing the "example" module

  Scenario: Testing student posts comment
    Given Forum is opened
    And Student is logged in
    When User posts a discussion with subject "<subject>" and body "<body>" on forum
    Then The discussion was posted successfully

    Examples:
      | subject | body  |
      | subject | body  |