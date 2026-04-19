import java.util.Scanner;

public class problem_CaesarCipher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type a word"); // asks user to type a word
        String encodeWord = scanner.nextLine(); // stores word the user writes as a variable
        
        System.out.println("You typed" + encodeWord); // prints the word the user wrote

    }
}