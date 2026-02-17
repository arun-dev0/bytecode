package problem1;

public class problem1solution {
    public static void main(String[] args) {
        solution1();
        solution2( 3, 5);
    }
    public static void solution1(){
        long start = System.nanoTime();
        int num = 0; // final answer variable decleration
        for (int i = 0; i < 1000 ; i++){ // checks every number between 0 and 1000
            if (i % 3 == 0 || i % 5 == 0){ // checks if the number is divisible by 3 or 5 
                num += i; // if the number is divisible by 3 or 5, it gets added to the total value
            }
        }
        System.out.println("The output is: " + num); // prints the final value
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli); // finds execution time

    }
    public static void solution2(int multiple1, int multiple2){
        long start = System.nanoTime();
        int num = 0; // final answer variable decleration
        for (int i = multiple1; i % multiple1 == 0 && i < 1000; i += multiple1){ // finds all multiples of the first number that are less than 1000
            num += i; // adds multiples to the total
        }
        for (int j = multiple2; j % multiple2 == 0 && j < 1000; j += multiple2){ // finds all multiples of the second number that are less that 1000
            if ( j % multiple1 != 0){ // makes sure that multiples have not already been added
                num += j; // adds multiples to the total
            }
        }
        System.out.println("The answer is: " + num); // prints final value
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli); // finde execution time
    }
}
// Answer: 233168