public class triangles {
    public static void main(String[] args) {
        int rows = 5; // Number of rows for the triangle
        
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces (direct calculation)
            System.out.print(" ".repeat(rows - i));
            
            // Print stars with space in between
            System.out.print("* ".repeat(i).trim());
            
            // Move to the next line after each row
            System.out.println();
        }
	 // Number of rows for the triangle
       System.out.println("\n\n\n") ;
        // Loop through each row (starting from the largest row)
        for (int i = rows; i >= 1; i--) {
            // Print leading spaces (direct calculation)
            System.out.print(" ".repeat(rows - i));
            
            // Print stars with space in between
            System.out.print("* ".repeat(i).trim());
            
            // Move to the next line after each row
            System.out.println();
        }

	System.out.println("\n\n\n");

	for (int i = rows; i >= 1; i--) {
            // Print stars with space in between
            System.out.print("* ".repeat(i).trim());
            
            // Move to the next line after each row
            System.out.println();
        }


	System.out.println("\n\n\n\n\n");

	for (int i = 0; i < rows; i++) {
            // Print leading spaces (increases as i increases)
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            
            // Print numbers from 1 to rows - i
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(j + " ");
            }
            
            // Move to the next line after each row
            System.out.println();
        }


	

	}
}
