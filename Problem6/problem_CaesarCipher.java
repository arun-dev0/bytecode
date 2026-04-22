import java.util.Scanner;

public class problem_CaesarCipher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // intakes the word user typed

        System.out.println("Type a word"); // asks user to type a word
        String encodeWord = scanner.nextLine(); // stores word the user writes as a variable

        System.out.println("You typed " + encodeWord); // prints the word the user wrote
        System.out.println("Type a number to shift by"); // asks user what amount to shift by
        int shift = scanner.nextInt(); // uses the number(int) the user typed as a variable to shift(shift)

       shift = ((shift % 26) + 26) % 26; // keeps the shift in the 0-25 range so negative and big numbers still wrap correctly
        String encodedWord = ""; // makes a place for the word after shifting

        for (int i = 0; i < encodeWord.length(); i++) { // checks each letter of the word the user typed once
            char c = encodeWord.charAt(i); // take one character from the encodeWord at i(number of letter in loop) and store it as c(variable)

            if (Character.isUpperCase(c)) { // if loop to start off the scenario of there being an upper case letter
                char shifted = (char) ('A' + (c - 'A' + shift) % 26); // formula to use old word to make encoded word(take c, and move it by the shift, if needed, wrap around by dividing by 26)
                encodedWord += shifted; // add new letter to encoded word
            } else if (Character.isLowerCase(c)) { // checks if the character is lowercase
                char shifted = (char) ('a' + (c - 'a' + shift) % 26); // formula for lowercase letters
                encodedWord += shifted; // add new letter to encoded word
            } else {
                encodedWord += c; // keeps spaces and punctuation the same
            }
        }

        System.out.println("Encoded word: " + encodedWord); // prints the encoded word

        String decodedWord = ""; // makes a place for the decoded word
        int decodeShift = 26 - shift; // uses the opposite shift to get back the original word

        for (int i = 0; i < encodedWord.length(); i++) { // checks each letter of the encoded word once
            char c = encodedWord.charAt(i); // take one character from the encodedWord at i and store it as c

            if (Character.isUpperCase(c)) { // checks if the character is uppercase
                char shifted = (char) ('A' + (c - 'A' + decodeShift) % 26); // shifts uppercase letter back
                decodedWord += shifted; // add new letter to decoded word
            } else if (Character.isLowerCase(c)) { // checks if the character is lowercase
                char shifted = (char) ('a' + (c - 'a' + decodeShift) % 26); // shifts lowercase letter back
                decodedWord += shifted; // add new letter to decoded word
            } else {
                decodedWord += c; // keeps spaces and punctuation the same
            }
        }

        System.out.println("Decoded word: " + decodedWord); // prints the decoded word

        scanner.close(); // closes scanner
    }
}