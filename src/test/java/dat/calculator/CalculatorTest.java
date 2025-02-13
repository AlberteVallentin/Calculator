package dat.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(12, calculator.add(5, 7), "5 + 7 should be 12");
        assertEquals(0, calculator.add(0, 0), "0 + 0 should be 0");
    }

    @Test
    void testSubtract() {
        assertEquals(6, calculator.subtract(10, 4), "10 - 4 should be 6");
        assertEquals(0, calculator.subtract(5, 5), "5 - 5 should be 0");
    }

    @Test
    void testMultiply() {
        assertEquals(48, calculator.multiply(6, 8), "6 * 8 should be 48");
        assertEquals(0, calculator.multiply(0, 5), "0 * 5 should be 0");
    }

    @Test
    void testDivide() {
        assertEquals(5, calculator.divide(15, 3), "15 / 3 should be 5");
        assertThrows(ArithmeticException.class,
            () -> calculator.divide(10, 0),
            "Should throw ArithmeticException when dividing by zero"
        );
    }

    @Test
    void testPercentage() {
        assertEquals(25, calculator.percentage(50, 200), "50 is 25% of 200");
        assertThrows(ArithmeticException.class,
            () -> calculator.percentage(50, 0),
            "Should throw ArithmeticException when total is zero"
        );
    }

    @Test
    void testModulus() {
        assertEquals(2, calculator.modulus(17, 5), "17 % 5 should be 2");
        assertThrows(ArithmeticException.class,
            () -> calculator.modulus(10, 0),
            "Should throw ArithmeticException when modulus by zero"
        );
    }
}