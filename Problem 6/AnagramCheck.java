import java.util.Scanner;
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input word 1: ");
        String wordA = scanner.next();
        System.out.println("Please input word 2: ");
        String wordB = scanner.next();
        String word1 = sortedWord(wordA);
        String word2 = sortedWord(wordB);
        System.out.println(word1.equals(word2) ? "Anagram!" : "Not an anagram.");
        scanner.close();
    }

    public static String sortedWord(String word) {
        String noSpaces = word.toLowerCase().replace(" ", "");
        char[] letters = noSpaces.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}