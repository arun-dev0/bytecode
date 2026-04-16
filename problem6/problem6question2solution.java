package problem6;

import java.util.Arrays;
import java.util.Scanner;

public class problem6question2solution{ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String wordA = scanner.next();
        System.out.print("Enter another word: ");
        String wordB = scanner.next();
        isAnagram(wordA, wordB);
        scanner.close();
    }
    public static void isAnagram(String a, String b){
        char[] firstWord = a.toLowerCase().toCharArray();
        char[] secondWord = b.toLowerCase().toCharArray();
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);        
        System.out.println(Arrays.equals(firstWord, secondWord) ? "The words are anagrams" : "The words are not anagrams");
    }
}   