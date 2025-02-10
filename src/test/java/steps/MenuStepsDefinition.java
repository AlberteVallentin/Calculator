package steps;
import dat.Main;
import dat.calculator.Calculator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.InputStream;

public class MenuStepsDefinition {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private InputStream originalIn;
    private Calculator calculator;

    @Before
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        originalIn = System.in;
        System.setOut(new PrintStream(outputStream));
        calculator = new Calculator();
    }

    @After
    public void cleanup() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        outputStream.reset();
    }

    private void runCalculatorWithInput(String... inputs) {
        String inputString = String.join("\n", inputs) + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        Main calculatorMain = new Main(calculator, new Scanner(inputStream));
        calculatorMain.start();
    }

    @When("I view the menu")
    public void iViewTheMenu() {
        Main.printMenu();
    }

    @When("I start the calculator with input {string} and numbers {string} and {string}")
    public void iStartCalculatorWithInput(String operation, String num1, String num2) {
        runCalculatorWithInput(operation, num1, num2, "7");
    }

    @When("I start the calculator with operation {string} and invalid input {string}")
    public void iStartCalculatorWithInvalidInput(String operation, String invalidInput) {
        // Efter det ugyldige input skal programmet bede om input igen, så vi giver et gyldigt input efter
        runCalculatorWithInput(operation, invalidInput, "5", "3", "7");
    }

    @When("I start the calculator with exit command {string}")
    public void iStartCalculatorWithExitCommand(String command) {
        runCalculatorWithInput(command);
    }

    @Then("I should see all operation options")
    public void iShouldSeeAllOperationOptions() {
        String output = outputStream.toString();
        assertTrue(output.contains("1. Add"));
        assertTrue(output.contains("2. Subtract"));
        assertTrue(output.contains("3. Multiply"));
        assertTrue(output.contains("4. Divide"));
        assertTrue(output.contains("5. Percentage"));
        assertTrue(output.contains("6. Modulus"));
        assertTrue(output.contains("7. Exit"));
    }

    @Then("the menu should be clearly formatted")
    public void theMenuShouldBeClearlyFormatted() {
        String output = outputStream.toString();
        assertTrue(output.contains("Calculator Menu:"));
    }

    @Then("I should be prompted for first number")
    public void iShouldBePromptedForFirstNumber() {
        String output = outputStream.toString();
        assertTrue(output.contains("Enter first number"),
            "Expected prompt 'Enter first number' not found in output: " + output);
    }

    @Then("I should be prompted for second number")
    public void iShouldBePromptedForSecondNumber() {
        String output = outputStream.toString();
        assertTrue(output.contains("Enter second number"),
            "Expected prompt 'Enter second number' not found in output: " + output);
    }

    @Then("I should see an invalid input error message")
    public void iShouldSeeInvalidInputError() {
        String output = outputStream.toString();
        assertTrue(output.contains("Error: Invalid input"),
            "Expected 'Error: Invalid input' message not found in output: " + output);
    }

    @Then("I should be prompted to enter the number again")
    public void iShouldBePromptedAgain() {
        String output = outputStream.toString();
        assertTrue(output.contains("Enter") && output.contains("number"),
            "Expected number prompt not found in output: " + output);
    }

    @Then("the program should display exit message")
    public void theProgramShouldDisplayExitMessage() {
        String output = outputStream.toString();
        assertTrue(output.contains("Thank you for using the calculator. Goodbye!"));
    }

    @Then("the program should terminate cleanly")
    public void theProgramShouldTerminateCleanly() {
        String output = outputStream.toString();
        assertTrue(output.contains("Goodbye!"));
    }
}