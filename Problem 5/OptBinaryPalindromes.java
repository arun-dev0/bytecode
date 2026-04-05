public class OptBinaryPalindromes {
    public static void main(String[] args) {
        
        for (int n = 1; n <= 100; n++) {
            String binary = Integer.toBinaryString(n);

            if (isPalindrome(binary)) {
                System.out.println(n + " → " + binary);
            }
        }
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