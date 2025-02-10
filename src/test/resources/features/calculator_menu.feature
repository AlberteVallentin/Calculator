Feature: Calculator Menu Interface
  As a user of the calculator
  I want to have a clear and usable menu interface
  So that I can easily select the operations I need

  Scenario: View calculator menu
    Given the calculator program is running
    When I view the menu
    Then I should see all operation options
    And the menu should be clearly formatted

  Scenario: Menu navigation
    Given the calculator program is running
    When I choose operation "1"
    Then I should be prompted for first number
    When I enter number "5"
    Then I should be prompted for second number

  Scenario: Program exit
    Given the calculator program is running
    When I choose operation "7"
    Then the program should display exit message
    And the program should terminate cleanly