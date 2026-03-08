public class Problem_2 {
    /* 
        What is the problem to solve: 
        Find the sum of all even Fibonacci numbers below 4,000,000.
    */
    public static void main(String[] args) throws Exception { 
        int sum = 0;
        int first = 1; 
        int second = 2;

      

        // Loop until the second Fibonacci number does not go over 4,000,000
        while (second <= 4000000) {
        

            //Check if the current Fibonacci number is even
            if (second % 2 == 0) {
                // If it is even, add it to the sum
                sum = sum + second;
            }

            // Create the   next Fibonacci number
            int next = first + second; //the next variable is ewual to the first and second 
            first = second;  // move the sequence forward
            second = next;   // move the sequence forward
        }

        // Print the final sum
        System.out.println("Output for the problem 2 is: " + sum);
        /* 
           After looping through all Fibonacci numbers below 4,000,000,
           the program prints the sum of all even Fibonacci numbers.
        */
    }
}