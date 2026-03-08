public class problem3 {        

    // the way to find the gcd(greatest common divisor)
    private static long gcd(long a, long b) {  
        while (b != 0) {                 // loops until b becomes 0
            long temp = b;               // stores b temporarily
            b = a % b;                   // replace b with the remainder of a divided by b
            a = temp;                    // Replace a with the old value of b
        }
        return a;                        // When b is 0, a is the GCD
    }

    // the way to find lcm (lowest common multiple)
    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));      // formula: LCM(a, b) = a × (b / GCD(a, b)) The smallest number that both a and b divide evenly into
        //It does that by multiplying a by the part of b that isn’t already included in a.
    }

    public static void main(String[] args) {  
        long result = 1;                 // Start with 1 because LCM calculations begin from 1

        for (int i = 1; i <= 20; i++) {  // Loop through numbers 1 to 20
            result = lcm(result, i);     // Update result by computing LCM of current result and i
        }

        // Print the final answer
        System.out.println("The smallest positive number divisible by all numbers from 1 to 20 is: " + result);
    }
}
