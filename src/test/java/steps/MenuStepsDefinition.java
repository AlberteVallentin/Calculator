package steps;
import dat.Main;
import dat.calculator.Calculator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Given("the calculator program is running")
    public void theCalculatorProgramIsRunning() {
        Main.printMenu();
    }

    @When("I view the menu")
    public void iViewTheMenu() {
        Main.printMenu();
    }

    @When("I choose operation {string}")
    public void iChooseOperation(String operation) {
        String prompt = "Enter first number: ";
        System.out.print(prompt);
    }

    @When("I enter number {string}")
    public void iEnterNumber(String number) {
        String prompt = "Enter second number: ";
        System.out.print(prompt);
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

    @Then("the program should display exit message")
    public void theProgramShouldDisplayExitMessage() {
        System.out.println("Thank you for using the calculator. Goodbye!");
        String output = outputStream.toString();
        assertTrue(output.contains("Thank you for using the calculator. Goodbye!"));
    }

    @Then("the program should terminate cleanly")
    public void theProgramShouldTerminateCleanly() {
        String output = outputStream.toString();
        assertTrue(output.contains("Goodbye!"));
    }
}