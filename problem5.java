// Language: Java
import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a positive integer up to 255
        System.out.print("Enter a positive integer (0-255): ");
        int n = scanner.nextInt();

        // Validate input
        if (n < 0 || n > 255) {
            System.out.println("Invalid input! Please enter a number between 0 and 255.");
            return;
        }

        // Convert integer to binary string
        String binaryString = Integer.toBinaryString(n);
        
        // Ensure 8-bit representation by padding with leading zeros if necessary
        binaryString = String.format("%8s", binaryString).replace(' ', '0');

        System.out.println("Binary: " + binaryString);

        // Example: Perform a simple bitwise operation (bitwise NOT)
        int bitwiseNot = ~n & 0xFF; // limit to 8 bits
        String bitwiseNotBinary = String.format("%8s", Integer.toBinaryString(bitwiseNot)).replace(' ', '0');

        // Example: Count number of 1s
        int countOnes = Integer.bitCount(n);
        System.out.println("Number of 1s in binary representation: " + countOnes);
    }
}