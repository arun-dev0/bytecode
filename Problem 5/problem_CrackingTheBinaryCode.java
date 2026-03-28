import java.util.Scanner;

public class problem_CrackingTheBinaryCode {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // it will take in the info I type

int n; // n is the variable that stores the number in as
int count = 0; // count is the variable to count the number of 1s. starting number is 0
String binary = ""; // stores binary as text

System.out.println("Enter a number please:"); // asks the person running code to type a number
n = input.nextInt(); // takes the number and saves it as n

while (n > 0) { // while loop
    int digit = n % 2; // finds the remainder, which is either 1 or 2

    if (digit == 1){ // if the digit has a remainder of 1
        count ++; // add it
    }

    binary = digit + binary; // formula to find the binary
    n = n / 2; // divides the number the person typed in by 2

}

        System.out.println("Binary: " + binary); // print out answer
        System.out.println("Popcount: " + count); // print out answer

        input.close();
    
    }
}