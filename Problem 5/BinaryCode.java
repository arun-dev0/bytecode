import java.util.Scanner;

public class BinaryCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // defines scanner

        // Read input
        System.out.print("Enter a number (0–255): "); // before asking for scanner it prints out prompt
        int N = scanner.nextInt(); //asks for number

        // Convert to binary
        String binary = Integer.toBinaryString(N); // converts number to binary string

        // Count number of 1s
        int count = 0; // popcount
        for (char c : binary.toCharArray()) { // sets c to each value and keeps on doing that everytime it runs
            if (c == '1') { // if the character ends up as one
                count++;//add 1 to count
            }
        }
        

        // Output results
        System.out.println("Binary representation: " + binary); //Prints out binary string of number
        System.out.println("Popcount (number of 1s): " + count); // prints out popcount

        scanner.close(); //terminates scanner
    }
}