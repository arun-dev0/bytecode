import java.util.HashMap;
import java.util.Scanner;

public class wordcount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word: words) {
            //System.out.println(word);
            word = word.toLowerCase();
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
            }
            else {
                wordCounter.put(word, 1);
            }
        }
        //for (String word : wordCounter.keySet()) {
        //System.out.println(word + ": " + wordCounter.get(word));
        //}
        String topWord = "";
        int topCount = 0;
        for (String word : wordCounter.keySet()) {
            if (wordCounter.get(word) > topCount) {
                topCount = wordCounter.get(word);
                topWord = word;
            }
        }   
        System.out.println("The most used word is: " + topWord);
    }
}