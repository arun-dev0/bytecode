package problem6;

import java.util.Arrays;
import java.util.Scanner;

public class problem6question2solution{ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // initializes scanner to take in words
        System.out.print("Enter a word: "); // asks user for a word
        String wordA = scanner.nextLine(); // stores that word
        System.out.print("Enter another word: "); // asks for another word
        String wordB = scanner.nextLine(); // stores the second word
        isAnagram(wordA, wordB); // sees if the words are anagrams
        scanner.close(); // closes the scanner
    }
    public static void isAnagram(String a, String b){ // method to determine if two words are anagrams or not
        char[] firstWord = a.replaceAll(" ", "").toLowerCase().toCharArray(); // turns the first word into an array and ignores case and spaces
        char[] secondWord = b.replaceAll(" ", "").toLowerCase().toCharArray(); // turns the second word into an array and ignores case and spaces
        Arrays.sort(firstWord); // sorts the first word
        Arrays.sort(secondWord); // sorts the second word 
        System.out.println(Arrays.equals(firstWord, secondWord) ? "The words are anagrams" : "The words are not anagrams"); // decides if the words are anagrams or not
    }
}   