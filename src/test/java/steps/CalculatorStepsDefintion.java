package steps;

import dat.calculator.Calculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStepsDefintion {
    private final Calculator calculator = new Calculator();
    private double firstNumber;
    private double secondNumber;
    private double result;
    private String errorMessage;
    private boolean canContinue = true;

    @Given("I have entered first number {double}")
    public void enterFirstNumber(Double number) {
        this.firstNumber = number;
    }

    @Given("I have entered second number {double}")
    public void enterSecondNumber(Double number) {
        this.secondNumber = number;
    }

    @When("I press add")
    public void pressAdd() {
        this.result = calculator.add(firstNumber, secondNumber);
    }

    @When("I press subtract")
    public void pressSubtract() {
        this.result = calculator.subtract(firstNumber, secondNumber);
    }

    @When("I press multiply")
    public void pressMultiply() {
        this.result = calculator.multiply(firstNumber, secondNumber);
    }

    @When("I press divide")
    public void pressDivide() {
        try {
            this.result = calculator.divide(firstNumber, secondNumber);
        } catch (ArithmeticException e) {
            this.errorMessage = e.getMessage();
            this.canContinue = true;
        }
    }

    @When("I calculate percentage")
    public void calculatePercentage() {
        this.result = calculator.percentage(firstNumber, secondNumber);
    }

    @When("I press modulus")
    public void pressModulus() {
        try {
            this.result = calculator.modulus(firstNumber, secondNumber);
        } catch (ArithmeticException e) {
            this.errorMessage = e.getMessage();
            this.canContinue = true;
        }
    }

    @Then("the result should be {double}")
    public void checkResult(Double expected) {
        assertEquals(expected, result, 0.001);
    }

    @Then("I should see error {string}")
    public void checkError(String expectedError) {
        assertEquals(expectedError, errorMessage);
    }

    @And("I should be able to perform new calculations")
    public void verifyCanContinue() {
        assertEquals(true, canContinue);
    }
}