public class Problem1Solution {
    public static void main(String[] args){

        int number = 0; // numbers to go through

        for (int i = 1; i < 1000; i++) { // keep counting up to 1000
            if (i % 3 == 0 || i % 5 == 0){ //is it a multiple of 3 and 5
                number += i; //number it is currently on plus i (multiple of 3 and 5)
            }
        }
        System.out.println("Sum:" + number);
    } 
}

/*
Algorithm

Step 1: Start out with 0
Step 2: Count up to 1000
Step 3: Check each number if it is a multiple of 3 and or 5
Step 4: If the number is a multiple, add it to "number" (Variable)
Step 5: Print the final number
 */

