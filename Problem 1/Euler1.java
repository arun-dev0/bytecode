//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6, and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.

public class Euler1 {
    public static void main(String[] args) {
        //Base value
        int x = 0;
        /*
        Params:
        1.make an int variable i = 0 
        2.i will never = 1000 or exceed 1000 
        3.run the function, add 1 to i, and then redo
        */
        for (int i = 0; i < 1000; i++) {
            //If the remainder when the number is /5 or /3 = 0
            if (i % 3==0 || i % 5 == 0){
            //It will add i to x
            x = x + i;
            }
        }
        //Print final x value
        System.out.println(x);
    }
}