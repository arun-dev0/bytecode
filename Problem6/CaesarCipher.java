import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    
    System.out.println(encrypt(n, "hello"));
    scanner.close();
    }

    public static String encrypt(int shift, String precrypt){
        char[] arrpc = precrypt.toCharArray();
        for(int n = 0; n < precrypt.length(); n++){
            int x = (int) arrpc[n];
            arrpc[n] = (char) (x + shift);
        }
        String encryption = new String(arrpc);
        return encryption;
    }
    
}