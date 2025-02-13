package dat.calculator;


public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public double percentage(double value, double total) {
        if (total == 0) {
            throw new ArithmeticException("Cannot calculate percentage of zero");
        }
        return (value / total) * 100;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero");
        }
        return a % b;
    }
}

