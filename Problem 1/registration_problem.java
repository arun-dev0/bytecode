public class registration_problem {
    /* 
        what is the problem to solve: Among the first 468000 square numbers, what is the sum of 
        all the odd squares?
    */
    public static void main(String[] args) throws Exception { 
        long sum = 0;
        /*  The variable sum is equal to 0 at the start of the problem. We need to use long
        to show what variable it is instead of integer because the variable will have a value
        over 2.1 billion. Which integer will not support 
        */
        for (int i = 1; i <= 468000; i=i+2) {
        /*At the start of the equation i=1. To make sure the problem only addes odd square
        we need to at plus to. This is going to make a loop because we used a for loop. It 
        will continue to loop until it repeats this 468000 times. 
         */
            long i_square = (long) i*i;
        /*Now after we got the odd numbers, we are going to multiply it by it self to get a square
        number. i_square is equal to variable i^2. 
        */
            sum = sum + i_square;
        /* Now we are saying that sum is equal to the initial sum, plus the square of the odd number,
        which is i_square. 
         */
        }
        System.out.println("Output for registration problem is: " + sum);
       /* It is now going to repeat this loop 468000 times and then it will print out the 
       sum here. 
       */
    }
}
