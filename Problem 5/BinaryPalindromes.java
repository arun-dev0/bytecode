public class BinaryPalindromes {
    public static void main(String[] args) {
        int count = 0;

        for (int n = 1; n <= 100; n++) {
            String binary = Integer.toBinaryString(n);

            if (isPalindrome(binary)) {
                System.out.println(n + " → " + binary);
                count++;
            }
        }

        System.out.println("Total: " + count);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}