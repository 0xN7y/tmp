import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base and exponent
        System.out.print("Enter the base: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the exponent: ");
        int exponent = scanner.nextInt();

        // Calculate the power using Math.pow() function
        double result = Math.pow(base, exponent);

        // Output the result
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);

        scanner.close();
    }
}
