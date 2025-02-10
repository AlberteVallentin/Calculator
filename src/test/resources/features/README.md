# Calculator User Stories and Acceptance

## Core System Functionality

### US1: Menu Navigation

As a calculator user

I want to navigate a clear operation menu

So that I can select mathematical operations efficiently

**Dependencies:**

- None (This is a core starting functionality)

**Acceptance Criteria:**

- Given the calculator program starts
- When the menu displays
- Then each operation appears with a numeric identifier (1-7)
- Given the menu displays operation options
- When the user enters a number between 1 and 7
- Then the calculator executes the corresponding operation
- Given the menu is active
- When the user enters an invalid menu choice
- Then the calculator prompts for new menu selection

### US2: Input Validation

As a calculator user

I want immediate feedback on my numeric inputs

So that I can enter valid numbers for my calculations

**Dependencies:**

- Requires US1 (Menu Navigation) to be implemented first

**Acceptance Criteria:**

- Given the calculator prompts for numeric input
- When the user enters non-numeric characters
- Then the calculator displays "Invalid input" message
- Given the calculator displays an input error message
- When the error message appears
- Then the calculator prompts for new input
- Given the calculator receives numeric input
- When the input matches expected format
- Then the calculator proceeds with the calculation

### US3: Error Handling

As a calculator user

I want clear error messages

So that I can understand and correct any problems

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)

**Acceptance Criteria:**

- Given an operation encounters an error
- When the error is calculation-based
- Then the calculator displays a specific error message
- Given an error message displays
- When the error is non-fatal
- Then the calculator returns to operation menu
- Given the calculator shows an error
- When the error message appears
- Then the calculator preserves its operational state

### US4: Program State Management

As a calculator user

I want the calculator to maintain its state

So that I can perform multiple calculations without interruption

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US3 (Error Handling)

**Acceptance Criteria:**

- Given a calculation completes
- When the result displays
- Then the calculator remains active
- Given the calculator is running
- When multiple operations execute
- Then each operation starts with a clean state
- Given any calculator state
- When an operation completes
- Then the calculator returns to the menu

## Mathematical Operations

### US5: Addition

As a calculator user

I want to add two numbers together

So that I can find their combined sum

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US4 (Program State Management)

**Acceptance Criteria:**

- Given the calculator is in addition mode
- When two valid operands are entered
- Then the calculator displays their sum

### US6: Subtraction

As a calculator user

I want to subtract one number from another

So that I can find their difference

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US4 (Program State Management)

**Acceptance Criteria:**

- Given the calculator is in subtraction mode
- When two valid operands are entered
- Then the calculator displays their difference

### US7: Multiplication

As a calculator user

I want to multiply two numbers together

So that I can find their product

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US4 (Program State Management)

**Acceptance Criteria:**

- Given the calculator is in multiplication mode
- When two valid operands are entered
- Then the calculator displays their product

### US8: Division

As a calculator user

I want to divide one number by another

So that I can find their quotient

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US3 (Error Handling) for division by zero
- Requires US4 (Program State Management)

**Acceptance Criteria:**

- Given the calculator is in division mode
- When the divisor is not zero
- Then the calculator displays the quotient
- Given the calculator is in division mode
- When the divisor is zero
- Then the calculator displays "Division by zero" message

### US9: Percentage

As a calculator user

I want to calculate what percentage one number is of another

So that I can understand their relative proportion

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US3 (Error Handling) for zero denominator
- Requires US4 (Program State Management)
- Requires US8 (Division) functionality

**Acceptance Criteria:**

- Given the calculator is in percentage mode
- When two valid operands are entered
- Then the calculator displays the percentage result
- Given the calculator is in percentage mode
- When the second operand is zero
- Then the calculator displays "Cannot calculate percentage of zero" message

### US10: Modulus

As a calculator user

I want to find the remainder after division

So that I can calculate what remains after division

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US2 (Input Validation)
- Requires US3 (Error Handling) for zero divisor
- Requires US4 (Program State Management)
- Requires US8 (Division) functionality

**Acceptance Criteria:**

- Given the calculator is in modulus mode
- When two valid operands are entered
- Then the calculator displays the remainder
- Given the calculator is in modulus mode
- When the divisor is zero
- Then the calculator displays "Modulus by zero" message

### US11: Program Exit

As a calculator user

I want to close the calculator program

So that I can end my calculation session

**Dependencies:**

- Requires US1 (Menu Navigation)
- Requires US4 (Program State Management) for clean shutdown

**Acceptance Criteria:**

- Given the calculator displays the operation menu
- When the user selects exit option (7)
- Then the calculator displays "Goodbye" message
- Given any calculation state
- When the exit command executes
- Then the calculator terminates without error messages


# Calculator Project Glossary

## Core Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| Calculator | A tool that performs mathematical operations on numbers | Calculator | Main class that handles mathematical operations | Calculator | - | calculator | add(), subtract(), multiply(), divide(), percentage(), modulus() | Core mathematical operation methods |
| Operation | A specific mathematical calculation | Operation Choice | Selected menu option for mathematical operation | Main | choice | choice | performCalculation(), getValidChoice() | Methods handling operation selection and validation |
| Number | A mathematical value used in calculations | Operand | Input value for mathematical operations | Calculator | Parameters | a, b, value, total | getValidNumber() | Includes input validation |
| Result | The outcome of a mathematical operation | Result | The calculated value returned from an operation | Calculator, Main | result | result | performCalculation() | Includes error handling |
| Input Validation | Checking if user input is valid | Input Validation | Process of validating numeric input | Main | - | scanner | getValidNumber(), getValidChoice() | Handles invalid inputs |
| Program State | Current status of calculator | Running State | Boolean indicating if program should continue | Main | running | running | start(), exit() | Controls program lifecycle |
| Menu | List of available operations | Menu Interface | Command-line interface | Main | - | - | printMenu(), getValidChoice() | Displays options and handles selection |
| Error | Information about calculation or input problems | Exception | Runtime errors and invalid inputs | Main, Calculator | errorMessage | e.getMessage() | try-catch blocks | Handles both arithmetic and input errors |

## Mathematical Operation Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| Addition | Combining two numbers | Add Operation | Mathematical addition | Calculator | - | a, b | add() | Returns sum of two numbers |
| Subtraction | Finding difference between numbers | Subtract Operation | Mathematical subtraction | Calculator | - | a, b | subtract() | Returns difference between numbers |
| Multiplication | Product of two numbers | Multiply Operation | Mathematical multiplication | Calculator | - | a, b | multiply() | Returns product of numbers |
| Division | Splitting into equal parts | Divide Operation | Mathematical division | Calculator | - | a, b | divide() | Returns quotient, handles division by zero |
| Percentage | Relative proportion calculation | Percentage Operation | Calculating percentage value | Calculator | - | value, total | percentage() | Returns percentage value |
| Modulus | Remainder after division | Modulus Operation | Mathematical modulo | Calculator | - | a, b | modulus() | Returns remainder after division |

## Input/Output Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| User Input | Numbers entered by user | Scanner Input | Java Scanner class input | Main | scanner | scanner | getValidNumber() | Handles user number input |
| Menu Choice | User's operation selection | Menu Selection | Integer representing operation | Main | choice | choice | getValidChoice() | Validates menu selection |
| Display | Showing information to user | System Output | Console output stream | Main | - | System.out | printMenu(), printf() | Handles all user output |
| Prompt | Request for user input | Input Message | Text asking for input | Main | - | - | getValidNumber() | Guides user input |

## Test-Related Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| Test Scenario | Specific situation to test | Cucumber Scenario | BDD test case | CalculatorStepsDefinition | - | - | Step methods | Implements test steps |
| Menu Test | Testing menu functionality | Menu Steps | Menu interface testing | MenuStepsDefinition | outputStream | - | setup(), cleanup() | Tests menu interaction |
| Input Test | Testing input handling | Input Validation Test | Testing input validation | MenuStepsDefinition | - | - | iStartCalculatorWithInvalidInput() | Tests invalid inputs |
| Output Verification | Checking program output | Assert Methods | Output verification | MenuStepsDefinition | - | - | assertTrue() | Verifies program responses |
| Step | Individual test action | Step Definition | Method implementing a test step | CalculatorStepsDefinition | - | - | All @Given, @When, @Then methods | Individual test implementations |
| Test State | Test environment state | Test Setup/Teardown | Environment management | MenuStepsDefinition | - | originalOut, originalIn | setup(), cleanup() | Manages test environment |

## Error Handling Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| Input Error | Invalid user input | InputMismatchException | Exception for invalid input format | Main | - | e | getValidNumber(), getValidChoice() | Handles non-numeric input |
| Calculation Error | Mathematical operation error | ArithmeticException | Exception for invalid calculations | Calculator | - | e | divide(), modulus() | Handles division by zero |
| Error Message | User-friendly error description | Exception Message | String describing the error | Main, Calculator | - | errorMessage | try-catch blocks | Provides user feedback |
| Error Recovery | Returning to valid state | Error Handling | Process of handling errors | Main | - | - | try-catch blocks | Maintains program stability |

## State Management Terms

| Noun in business domain | Noun business explanation | Noun in code | Noun code explanation | Class | Attribute | Variable name(s) | Related Method(s) | Related Method(s) comment |
|------------------------|-------------------------|--------------|---------------------|--------|-----------|-----------------|-----------------|------------------------|
| Program Running | Calculator is active | Running State | Boolean running state | Main | running | running | start(), exit() | Controls program lifecycle |
| Clean State | Ready for new calculation | State Reset | Clearing previous operation | Main | - | - | performCalculation() | Prepares for next operation |
| Program Exit | Ending calculator session | Exit Operation | Termination process | Main | running | running | exit() | Handles clean shutdown |