import java.util.Scanner; // for reading user input
public class solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create scanner to read input
        System.out.print("Enter a positive integer (1-255): ");
        int N = scanner.nextInt(); // read the integer
        if(N < 1 || N > 255){ // check valid range
            System.out.println("Number must be between 1 and 255!");
            return; // stop program if invalid
        }
        String binary = ""; // will store binary digits
        int popcount = 0;   // counts number of 1s
        int number = N;     // copy N, so we can modify number without losing N
        // repeat until number becomes 0
        while(number > 0){
            int digit = number % 2;       // get remainder (0 or 1)
            binary = digit + binary;      // prepend digit to binary string
            if(digit == 1){               // if digit is 1
                popcount++;               // increase count
            }
            number = number / 2;          // divide by 2 to move to next bit
        }
        System.out.println("Binary: " + binary);           // print binary form
        System.out.println("Popcount (number of 1s): " + popcount); // print 1s count
    }
}