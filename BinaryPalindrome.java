public class BinaryPalindrome {
    public static void main(String[] args) {
        // Loop through numbers from 1 to 100
        for (int num = 1; num <= 100; num++) {
            // Convert the current number to its binary representation as a string
            String binary = Integer.toBinaryString(num);

            // Check if the binary string is a palindrome
            if (isPalindrome(binary)) {
                // Print the number and its binary representation if it's a palindrome
                System.out.println(num + " in binary and it is a palindrome: " + binary);
            }
        }
    }

    /**
     * Method to check if a given string is a palindrome
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // Initialize two pointers: one at the start, one at the end
        int left = 0;
        int right = str.length() - 1;

        // Compare characters from both ends moving towards the center
        while (left < right) {
            // If characters at the two pointers don't match, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            // Move the left pointer forward
            left++;
            // Move the right pointer backward
            right--;
        }

        // If all characters matched, it's a palindrome
        return true;
    }
}