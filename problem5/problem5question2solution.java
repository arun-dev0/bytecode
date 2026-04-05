package problem5;

public class problem5question2solution {
    public static void main(String[] args) {  
        for (int number = 1; number <= 100; number += 2){ // check all odd numbers from 1-100 (evens can't be palindromes)
            int quotient = number; // sets up to find binary and popcount
            int remainder;
            String output = new String();
            while (quotient != 0){ // loop to find binary
                remainder = quotient % 2; // finds the digit
                output = remainder + output; // else just stores the digit
                quotient = (quotient-remainder) / 2; // sets up for next runthrough of the loop
            }
            String reverseOutput = new StringBuilder(output).reverse().toString(); // reverses the string
            if (reverseOutput.equals(output)) { // sees if the srting can be read both ways
                System.out.println(number + " is " + output); // prints binary if it is a palindrome
            }
        }
    }
}
