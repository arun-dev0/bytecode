import java.util.Scanner;
import java.util.Arrays;
public class anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i<5 ; i++) {
        System.out.print("Enter the first word: ");
        String firstWord = scanner.nextLine();

        System.out.print("Enter the second word: ");
        String secondWord = scanner.nextLine();

        Boolean anagramChecker = isAnagram(firstWord, secondWord);
        System.out.println(anagramChecker);
        }
    }
    public static Boolean isAnagram(String firstWord, String secondWord) {
        Boolean result = false;
        String lower = firstWord.toLowerCase();
        String lower2 = secondWord.toLowerCase();  
        String noSpaces = lower.replace(" ","");
        String noSpaces2 = lower2.replace(" ", "");
        int length1 = noSpaces.length();
        int length2 = noSpaces2.length();
       // System.out.println(length1);
        //System.out.println(length2);
       // char[] letters = length1.toCharArray();
       if (length1 != length2) {
        result = false;
       }
       else {
        char[] letters = noSpaces.toCharArray(); 
        char[] letters2 = noSpaces2.toCharArray(); 
        //System.out.println(Arrays.toString(letters));
        //System.out.println(Arrays.toString(letters2));

        Arrays.sort(letters);
        //System.out.println(Arrays.toString(letters));
        Arrays.sort(letters2);
        //System.out.println(Arrays.toString(letters2));
        String sortedString = new String(letters);
        String sortedString2 = new String(letters2);
        if (sortedString.equals(sortedString2)) {
            result = true;
        }
        else {
            result = false;
        }
       }
        return result;
    }

}
