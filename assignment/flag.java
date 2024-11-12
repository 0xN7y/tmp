public class flag {
    public static void main(String[] args) {
        // Define constants for the flag
        int flagHeight = 15;     // Total height of the flag
        int starSectionHeight = 9; // Height of the stars section
        int starRowLength = 12;   // Width of the stars section
        int flagRowLength = 74;   // Total width of the flag

        for (int i = 0; i < flagHeight; i++) {
            // Stars and stripes section
            if (i < starSectionHeight) {
                for (int j = 0; j < flagRowLength; j++) {
                    if (j < starRowLength) {
                        // Print stars in an alternating pattern
                        if ((i % 2 == 0 && j % 4 == 0) || (i % 2 != 0 && j % 4 == 2)) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print("="); // Right side stripes
                    }
                }
            } else {
                // Full stripe section for rows below the stars
                for (int j = 0; j < flagRowLength; j++) {
                    System.out.print("=");
                }
            }
            System.out.println(); // New line after each row
        }
    }
}
