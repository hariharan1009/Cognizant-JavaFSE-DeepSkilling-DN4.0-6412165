import java.util.Arrays;
import java.util.Scanner;

public class FinancialForecast {
    // Basic recursive method
    public static double calculateFutureValue(double initialValue, double[] growthRates, int years) {
        // Base case: no more years to forecast
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: apply current year's growth rate and recurse
        double currentValue = initialValue * (1 + growthRates[years - 1]);
        return calculateFutureValue(currentValue, growthRates, years - 1);
    }

    private static Double[] memo;
    public static double calculateFutureValueMemoized(double initialValue, double[] growthRates, int years) {
        if (memo == null || memo.length < years + 1) {
            memo = new Double[years + 1];
        }
        // Base case
        if (years == 0) {
            return initialValue;
        }
        // Check memoized result
        if (memo[years] != null) {
            return memo[years];
        }
        // Recursive case
        double currentValue = initialValue * (1 + growthRates[years - 1]);
        memo[years] = calculateFutureValueMemoized(currentValue, growthRates, years - 1);
        return memo[years];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
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


            System.out.println("\nTesting Basic Recursive Forecast:");
            double result = calculateFutureValue(presentValue, growthRates, years);
            System.out.printf("Initial Value: ₹%.2f, Future Value after %d years: ₹%.2f%n", 
            presentValue, years, result);

            // Test memoized recursive method
            System.out.println("\nTesting Memoized Recursive Forecast:");
            result = calculateFutureValueMemoized(presentValue, growthRates, years);
            System.out.printf("Initial Value: ₹%.2f, Future Value after %d years: ₹%.2f%n", 
                    presentValue, years, result);

            // Display growth rates
            System.out.println("\nGrowth Rates Used: " + Arrays.toString(growthRates));
        }
    }
}