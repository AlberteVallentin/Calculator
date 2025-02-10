Feature: Calculator Menu Interface
  As a user of the calculator
  I want to have a clear and usable menu interface
  So that I can easily select the operations I need

  Scenario: View calculator menu
    When I view the menu
    Then I should see all operation options
    And the menu should be clearly formatted

  Scenario: Menu navigation for addition
    When I start the calculator with input "1" and numbers "5" and "3"
    Then I should be prompted for first number
    And I should be prompted for second number

  Scenario: Invalid number input handling
    When I start the calculator with operation "1" and invalid input "abc"
    Then I should see an invalid input error message
    And I should be prompted to enter the number again

  Scenario: Program exit
    When I start the calculator with exit command "7"
    Then the program should display exit message
    And the program should terminate cleanly