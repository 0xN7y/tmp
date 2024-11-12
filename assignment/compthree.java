import java.util.InputMismatchException;
import java.util.Scanner;

public class compthree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            System.out.print("Enter the third number: ");
            int num3 = scanner.nextInt();


            if (num1 == num2 && num2 == num3) {
                System.out.println("All three numbers are equal.");
            } else {
                int largest = num1;


                if (num2 > largest) {
                    largest = num2;
                }
                if (num3 > largest) {
                    largest = num3;
                }

                System.out.println("The largest number is: " + largest);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integer values only.");
        } finally {
            scanner.close();
        }
    }
}
