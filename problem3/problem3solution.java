package problem3;

public class problem3solution {
    public static void main(String[] args) {
        beginnerSolution();
        intermediateSolution();
    }
    public static void beginnerSolution(){ // "Smart Brute Force" way
        long start = System.nanoTime();
        long multiple = 21; // multiple to check
        boolean divisibleBy1_20 = false; // helps to tell when to exit the loop
        while (!divisibleBy1_20){ // goes until the multiple is divisible by all numbers from 11-20
            multiple ++; // to cycle through every number until it is divisible by all numbers from 11-20
            if (multiple % 11 == 0 && multiple % 12 == 0 && multiple % 13 == 0 && multiple % 14 == 0 && multiple % 15 == 0 && multiple % 14 == 0 && multiple % 15 == 0 && multiple % 16 == 0 && multiple % 17 == 0 && multiple % 18 == 0 && multiple % 19 == 0 && multiple % 20 == 0) { // checks if divisible by numbers 11-20
                divisibleBy1_20 = true; // exits loop after running through the entire thing
            } else {
                divisibleBy1_20 = false; // go again
            }
        }
        System.out.println(multiple); // prints final value
        long stop = System.nanoTime();
        double executionNanos = stop - start;
        double executionMillis = executionNanos / 1_000_000;
        System.out.println("Execution Time: " + executionMillis); // finds execution time
    }
    public static void intermediateSolution(){ // LCM formula way
        long start = System.nanoTime();
        long lcm = 1; // final value declaration
        int num = 2; // number to check for divisibility
        
        while (num <= 20){ // goes through until checks all numbers from 2 - 20 (every number is divisible by one)
            lcm = lcm(lcm, num); // finds the LCM of the previous lcm and the current number to check for divisibility
            num ++; // to go through all numbers from 2-20
        }
        System.out.println(lcm); // prints final value
        long stop = System.nanoTime();
        double executionNanos = stop - start;
        double executionMillis = executionNanos / 1_000_000;
        System.out.println("Execution Time: " + executionMillis); // finds execution time 
    }

    // ----------------- HELPER FUNCTIONS -----------------


    public static long lcm(long a, int b){ // finds LCM based on the fact that the LCM of a and b is always a*b divided by the GCD of a and b 

        long lcm = (a*b)/gcd(a, b);
        return lcm;

    }
    public static int gcd(long a, int b) { // finds GCD of two numbers
        
        while (b != 0) {
            int temp = b;
            b = (int) a % b;
            a = temp;
        }
        return (int) a;
    }
}
// Solution : 232792560
// Solution 1 Execution Time : 107 milliseconds
// Solution 2 Execution Time : 0.01 milliseconds (WAY faster)