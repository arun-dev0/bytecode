import java.util.Scanner;

public class ceasercipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word that you want to encode: ");
        String encodeWord = scanner.nextLine();

        System.out.print("How much do you wish to shift the letter by (enter a number): ");
        int shiftNumber = scanner.nextInt();

        String encodedResult = encode(encodeWord, shiftNumber);
        System.out.println("The encoded result is: "+encodedResult);

        String decodedResult = decode(encodedResult, shiftNumber);
        System.out.println("The decoded result is: "+decodedResult);
    }

    public static String encode(String encodeWord, int shiftNumber) {
        String result = "";
        for (int i=0; i<encodeWord.length() ; i++) {
            if (Character.isLetter(encodeWord.charAt(i))) {
            char base = Character.isLowerCase(encodeWord.charAt(i)) ? 'a' : 'A';    
            //Step 1
            int shifted = encodeWord.charAt(i)-base;
            //Step 2
            int newShift = shifted + shiftNumber;
            //Step 3 
            int step3 = (newShift % 26 + 26) % 26;
            //step 4
            char newCharacter = (char)(base + step3);
            result = result + newCharacter;
            }
            else {
                result = result + encodeWord.charAt(i);
            }
        }
        return result;
    }

    public static String decode(String encodeWord, int shiftNumber) {
        String result = "";
        for (int i=0; i<encodeWord.length(); i++) {
            if (Character.isLetter(encodeWord.charAt(i))) {
            char base = Character.isLowerCase(encodeWord.charAt(i)) ? 'a' : 'A';    
            //step 1
            int shifted = encodeWord.charAt(i)-base;
            //step 2
            int newShift = shifted - shiftNumber;
            //step 3
            int step3 = (newShift % 26 + 26) % 26;
            //step 4
            char newCharacter = (char)(base+step3);
            result = result + newCharacter;
            }
            else {
                result = result + encodeWord.charAt(i);
            }
        }
        return result;
    }
}
