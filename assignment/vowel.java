import java.util.Scanner;

public class vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a character
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        // Using if statement to check if it's a vowel or consonant
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            System.out.println(ch + " is a vowel (using if statement).");
        } else {
            System.out.println(ch + " is a consonant (using if statement).");
        }

        // Using switch statement to check if it's a vowel or consonant
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println(ch + " is a vowel (using switch statement).");
                break;
            default:
                System.out.println(ch + " is a consonant (using switch statement).");
                break;
        }

        scanner.close();
    }
}
