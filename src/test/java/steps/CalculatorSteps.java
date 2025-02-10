package steps;

import dat.calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private final Calculator calculator = new Calculator();
    private double firstNumber;
    private double secondNumber;
    private double result;

    @Given("I have entered first number {double}")
    public void i_have_entered_first_number(Double number) {
        this.firstNumber = number;
    }

    @Given("I have entered second number {double}")
    public void i_have_entered_second_number(Double number) {
        this.secondNumber = number;
    }

    @When("I press add")
    public void i_press_add() {
        this.result = calculator.add(firstNumber, secondNumber);
    }

    @When("I press subtract")
    public void i_press_subtract() {
        this.result = calculator.subtract(firstNumber, secondNumber);
    }

    @When("I press multiply")
    public void i_press_multiply() {
        this.result = calculator.multiply(firstNumber, secondNumber);
    }

    @When("I press divide")
    public void i_press_divide() {
        this.result = calculator.divide(firstNumber, secondNumber);
    }

    @When("I calculate percentage")
    public void i_calculate_percentage() {
        this.result = calculator.percentage(firstNumber, secondNumber);
    }

    @When("I press modulus")
    public void i_press_modulus() {
        this.result = calculator.modulus(firstNumber, secondNumber);
    }

    @Then("the result should be {double}")
    public void the_result_should_be(Double expected) {
        assertEquals(expected, result, 0.001);
    }
}