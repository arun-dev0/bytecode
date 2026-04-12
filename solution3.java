public class solution3 {

    // Find the Greatest Common Divisor
    public static long gcd(long a, long b) {
        while (b != 0) {     // keep looping until b becomes 0
            long temp = b;   // store b temporarily
            b = a % b;       // remainder of a divided by b
            a = temp;        // move previous b into a
        }
        return a;            // a is now the GCD
    }

    // Find the Least Common Multiple
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);   // LCM formula
    }

    public static void main(String[] args) {

        long start = System.nanoTime();   // start timer

        long result = 1;

        // loop from 1 to 20
        for (int i = 1; i <= 20; i++) {
            result = lcm(result, i);
        }

        long end = System.nanoTime();   // end timer

        System.out.println("Smallest number divisible by 1-20: " + result);

        System.out.println("Time taken: " + (end - start) + " nanoseconds");
    }
}