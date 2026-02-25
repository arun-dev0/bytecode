public class problem2 {
    public static void main(String[] args) {
        int limit = 4000000;

        int first = 1;
        int second = 2;
        int sum = 0;

        while (first <= limit) {
            // Check if the number is event
            if (first % 2 == 0) {
                sum += first;
            }

            // Generate next Fibonacci number
            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println("Sum of even Fibonacci numbers up to 4,000,000: " + sum);
    }
}