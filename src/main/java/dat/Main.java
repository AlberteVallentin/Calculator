package dat;

import dat.calculator.Calculator;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private final Calculator calculator;
    private final Scanner scanner;
    private boolean running;

    public Main() {
        this(new Calculator(), new Scanner(System.in));
    }

    Main(Calculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
        this.running = true;
    }

    public void start() {
        while (running) {
            try {
                printMenu();
                int choice = getValidChoice();

                if (choice == 7) {
                    exit();
                    break;
                }

                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();

                double result = performCalculation(choice, a, b);
                System.out.printf("Result: %.2f%n", result);

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter valid numbers.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static void printMenu() {
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

    private int getValidChoice() {
        int choice = scanner.nextInt();
        if (choice < 1 || choice > 7) {
            throw new IllegalArgumentException("Invalid choice. Please select a number between 1 and 7.");
        }
        return choice;
    }

    private double performCalculation(int choice, double a, double b) {
        return switch (choice) {
            case 1 -> calculator.add(a, b);
            case 2 -> calculator.subtract(a, b);
            case 3 -> calculator.multiply(a, b);
            case 4 -> calculator.divide(a, b);
            case 5 -> calculator.percentage(a, b);
            case 6 -> calculator.modulus(a, b);
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }

    private void exit() {
        System.out.println("Thank you for using the calculator. Goodbye!");
        running = false;
    }

    public static void main(String[] args) {
        Main calculatorMain = new Main();
        calculatorMain.start();
    }
}