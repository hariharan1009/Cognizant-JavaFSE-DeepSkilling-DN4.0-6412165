import java.util.Arrays;
import java.util.Scanner;

public class FinancialForecastIterative {
    // Iterative method to calculate future value
    public static double calculateFutureValueIterative(double initialValue, double[] growthRates) {
        double value = initialValue;
        for (double rate : growthRates) {
            value *= (1 + rate);
        }
        return value;
    }

    public static void main(String[] args) {
        // Use try-with-resources to automatically close Scanner
        try (Scanner sc = new Scanner(System.in)) {
            // Input present value
            double presentValue;
            while (true) {
                System.out.print("Enter the present value: ");
                try {
                    presentValue = sc.nextDouble();
                    if (presentValue < 0) {
                        throw new IllegalArgumentException("Present value cannot be negative.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input for present value. Please enter a valid number.");
                    sc.nextLine(); // Clear invalid input
                }
            }

            // Input number of years
            int years;
            while (true) {
                System.out.print("Enter the number of years: ");
                try {
                    years = sc.nextInt();
                    if (years < 0) {
                        throw new IllegalArgumentException("Years cannot be negative.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input for years. Please enter a valid non-negative integer.");
                    sc.nextLine(); // Clear invalid input
                }
            }

            // Input growth rates
            double[] growthRates = new double[years];
            System.out.println("Enter the growth rate for each year (as a decimal, e.g., 0.05 for 5%):");
            for (int i = 0; i < years; i++) {
                while (true) {
                    System.out.print("Year " + (i + 1) + ": ");
                    try {
                        growthRates[i] = sc.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input for growth rate. Please enter a valid number.");
                        sc.nextLine(); // Clear invalid input
                    }
                }
            }

            // Test iterative method
            System.out.println("\nTesting Iterative Forecast:");
            double result = calculateFutureValueIterative(presentValue, growthRates);
            System.out.printf("Initial Value: ₹%.2f, Future Value after %d years: ₹%.2f%n", 
                              presentValue, years, result);

            // Display growth rates
            System.out.println("\nGrowth Rates Used: " + Arrays.toString(growthRates));
        }
    }
}