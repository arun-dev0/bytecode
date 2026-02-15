public class first_problem{
    /* 
        what is the problem to solve: Find the sum of all the multiples of 3 or 5 below 1000.

    */
    public static void main(String[] args) throws Exception { 
        int sum = 0;
        /* The variable, sum, is set to 0 at the beggining of the program.  
        */
        for (int i = 1; i < 1000; i=i+1) {
        /*At the start of the equation i=1. This is a for loop, so it will keep adding one to
        i until it reaches a 1000. 
         */
            if (i % 3 == 0||i % 5 == 0) {
            /* It is checking if i is divisble by 3 or 5. It is seeing if there is 
            the reminder in 0, then it is a multiple of 3 or 5. ||-> this means or*/
        
                sum = sum + i;
                /*If it is true, then it will add the value of i to the sum
                */
        }
       
        }
   
        System.out.println("Output for the problem 1 is: " + sum);
    }
    // 
       /* It is now going to repeat this loop 468000 times and then it will print out the 
       sum here. 
       */
}