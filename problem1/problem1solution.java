package problem1;

public class problem1solution {
    public static void main(String[] args) {
        solution1();
        solution2();
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
        System.out.println("Execution time: " + durationMilli);

    }
    public static void solution2(){
        long start = System.nanoTime();
        int num = 0;
        for (int i = 3; i % 3 == 0 && i < 1000; i += 3){
            num += i;
        }
        for (int j = 5; j % 5 == 0 && j < 1000; j += 5){
            if ( j % 3 != 0){
                num += j;
            }
        }
        System.out.println("The answer is: " + num);
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli);
    }
}
// Answer: 233168