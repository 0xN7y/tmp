public class Aflag {
    public static void main(String[] args) {
 
        int starRows = 9;       
        int stripeRows = 6;      
        int flagWidth = 46;      

        for (int i = 0; i < starRows; i++) {
            
            if (i % 2 == 0) {
                System.out.print("* * * * * * ");
            } else {
                System.out.print(" * * * * *  ");
            }
            
            for (int j = 0; j < flagWidth - 12; j++) { 
                System.out.print("=");
            }
            System.out.println(); 
        }

        
        for (int i = 0; i < stripeRows; i++) {
            for (int j = 0; j < flagWidth; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
