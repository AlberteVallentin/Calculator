Feature: Calculator Operations
  As a user
  I want to perform basic mathematical operations
  So that I can solve arithmetic problems

  Scenario: Addition of two numbers
    Given I have entered first number 5
    And I have entered second number 7
    When I press add
    Then the result should be 12

  Scenario: Subtraction of two numbers
    Given I have entered first number 10
    And I have entered second number 4
    When I press subtract
    Then the result should be 6

  Scenario: Multiplication of two numbers
    Given I have entered first number 6
    And I have entered second number 8
    When I press multiply
    Then the result should be 48

  Scenario: Division of two numbers
    Given I have entered first number 15
    And I have entered second number 3
    When I press divide
    Then the result should be 5

  Scenario: Calculate percentage
    Given I have entered first number 50
    And I have entered second number 200
    When I calculate percentage
    Then the result should be 25

  Scenario: Calculate modulus
    Given I have entered first number 17
    And I have entered second number 5
    When I press modulus
    Then the result should be 2

  Scenario: Division by zero
    Given I have entered first number 10
    And I have entered second number 0
    When I press divide
    Then I should see error "Division by zero"
    And I should be able to perform new calculations