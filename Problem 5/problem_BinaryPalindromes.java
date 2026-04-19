public class problem_BinaryPalindromes {

    public static void main(String[] args) {

        int count = 0; // names the variable and starts at 0

        for (int number = 1; number <= 100; number++) { // for loop to go through number 1-100
            String binary = Integer.toBinaryString(number); // java function to convert number to binary

            if (isPalindrome(binary)) { // is the binary a palindrome
                System.out.println(number + " -> " + binary); // prints decimal and binary form
                count++; // if binary number is palindrome, add it to the count of numbers of how many palindrome binary numbers there are
            }
        }

        System.out.println("Total binary palindrome numbers found: " + count); // prints the final total
    }

    public static boolean isPalindrome(String str) { // checks if it's palindrome
        String reversed = new StringBuilder(str).reverse().toString(); // makes backwards version of text
        return str.equals(reversed); // checks if str and reversed are the same
    }
}