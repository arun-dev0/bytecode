package problem7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class problem7question1 {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String cleaned = sentence.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = cleaned.split(" ");
        for (String word : words) {
            if (wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        Object[] counts = new Object[wordCount.size()];
        counts = wordCount.values().toArray();
        Arrays.sort(counts);
        String mostCommonWord = "";
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == counts[counts.length - 1]){
                mostCommonWord = word;
                break;
            }
        }
        System.out.println("\"" + mostCommonWord + "\"" + " is the most common word, appearing " + wordCount.get(mostCommonWord) + " times in the sentence.");
        scanner.close();
    }
}
