import java.util.HashMap;
import java.util.Scanner;

public class FrequancyWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        String cleaned = sentence.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = cleaned.split(" ");

        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nWord counts:");
        for (String word : counts.keySet()) {
            System.out.println("  " + word + " -> " + counts.get(word));
        }

        String topWord = "";
        int topCount = 0;
        for (String word : counts.keySet()) {
            if (counts.get(word) > topCount) {
                topCount = counts.get(word);
                topWord = word;
            }
        }

        System.out.println("\nMost frequent word: \"" + topWord + "\" (" + topCount + " times)");
    }
}
