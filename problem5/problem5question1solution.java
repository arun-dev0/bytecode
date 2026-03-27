package problem5;

import java.util.Scanner; // import to get the value from the user

public class problem5question1solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // initializing input device
        System.out.print("Enter a number from 0 to 255: "); // prompts for a number from the user
        int number = scanner.nextInt(); // takes input
        while (number > 255){ // tells user to re-enter number if it is greater than 255
            System.out.print("The number needs to be at most 255. Enter a valid number: ");
            number = scanner.nextInt();
            continue;
        }
        popcount(number); // fuction to get popcount
        scanner.close(); // closes scanner
    }

    public static void popcount(int number){ // function to get popcount
        int quotient = number; // sets up to find binary and popcount
        int remainder;
        int popCount = 0;
        String output = new String();
        while (quotient != 0){ // loop to find binary
            remainder = quotient % 2; // finds the digit
            if (remainder == 1 && quotient == number) output = remainder + output; // stores the first value only if the digit is 1
            else output = remainder + output; // else just stores the digit
            if (remainder == 1) popCount++; // adds to popcount for every 1 in the number
            quotient = (quotient-remainder) / 2; // sets up for next runthrough of the loop
        }
        System.out.println("DECIMAL: " + number + "\nBINARY: " + output + "\nPOPCOUNT: " + popCount); // prints final values
    }
}
