package dat;

import dat.calculator.Calculator;

import java.util.Scanner;

public class Main {
    private static final Calculator calculator = new Calculator();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result = 0;
            try {
                switch (choice) {
                    case 1 -> result = calculator.add(a, b);
                    case 2 -> result = calculator.subtract(a, b);
                    case 3 -> result = calculator.multiply(a, b);
                    case 4 -> result = calculator.divide(a, b);
                    case 5 -> result = calculator.percentage(a, b);
                    case 6 -> result = calculator.modulus(a, b);
                    default -> {
                        System.out.println("Invalid choice");
                        continue;
                    }
                }
                System.out.printf("Result: %.2f%n", result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nCalculator Menu:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Percentage");
        System.out.println("6. Modulus");
        System.out.println("7. Exit");
        System.out.print("Choose operation: ");
    }
}