package problem6;

import java.util.Scanner;

public class problem6question1solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // initialize scanner to take in a message
        System.out.print("Would you like to encode or decode a message? Type e for encoding and d for decoding: "); // asks if user wants to encode or decode a message
        String encodeOrDecode = scanner.nextLine(); // takes the user's answer
        System.out.print("Enter the message: "); // asks for a message to encode/decode
        String message = scanner.nextLine(); // stores the message
        switch (encodeOrDecode.toLowerCase().toCharArray()[0]) { // decides if encoding or decoding
            case 'e': // if user enters 'e'...
                encode(message); // ...encode the message
                break;
            case 'd': // if user enters 'd'...
                decode(message); // ...decode the message
                break;
        }
        scanner.close(); // closes scanner
    }
    public static void encode(String message){ // method to encode
        for (char letter : message.toCharArray()) { // takes each letter in the string
            char codedLetter; // declares a char variable to hold the coded letter
            int code = (int) letter; // finds the code for the letter
            if (code > 96){ // sees if the letter is lowercase
                code -= 96; // finds the position in the alphabet
                code += 3; // shifts by 3
                code = code % 26; // wraps around if needed
                code += 96; // reverts to proper code for the letters
                codedLetter = (char) code; // turns code back into letter
            }
            else if (code > 64) { // sees if the letter is uppercase
                code -= 64; // finds the position in the alphabet
                code += 3; // shifts by 3
                code = code % 26; // wraps around if needed
                code += 64; // reverts to proper code for the letters
                codedLetter = (char) code; // turns code back into letter
            }
            else { // sees if the character is not a letter
                codedLetter = letter; // keeps it the same
            }
            System.out.print(codedLetter); // prints the coded letter
        }
        System.out.println(); // prints a blank line at the end of the message
    }
    public static void decode(String message){ // method to decode 
        for (char codedLetter : message.toCharArray()) { // takes each letter in the string
            char letter; // declares a char variable to hold the letter
            int code = (int) codedLetter; // finds the code for the letter
            if (code > 96){ // sees if the letter is lowercase
                code -= 96; // finds the position in the alphabet
                code -= 3; // shifts by 3
                if (code <=0) code += 26; // wraps around if needed
                code += 96; // reverts to proper code for the letters
                letter = (char) code; // turns code back into letter
            }
            else if (code > 64){ // sees if the letter is uppercase
                code -= 67; // finds the position in the alphabet
                code -= 3; // shifts by 3
                if (code <=0) code += 26; // wraps around if needed
                code += 67; // reverts to proper code for the letters
                letter = (char) code; // turns code back into letter
            }
            else { // sees if the character is not a letter
                letter = codedLetter; // keeps ot the same
            }
            System.out.print(letter); // prints the decoded letter
        }
        System.out.println(); // prints a blank line at the end of the message
    }
}
