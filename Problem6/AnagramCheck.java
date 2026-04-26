import java.util.Scanner;
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input word 1: ");
        String wordA = scanner.next();
        System.out.println("Please input word 2: ");
        String wordA = scanner.next();
        String word1 = sortedWord(wordA);
        String word2 = sortedWord(wordB);
        System.out.println(word1);
        System.out.println(word2);


    scanner.close();
    }
}

public static String[] sortedWord(String word){
    String lower = word.toLowerCase();         // "hello world"
     // Remove spaces
    String noSpaces = lower.replace(" ", "");   // "HelloWorld"
    // Convert to array of characters
    char[] letters = word.toCharArray();
    Arrays.sort(letters);
    letters = new String(letters);
    return letters[];
}