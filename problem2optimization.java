public class problem2optimization {

    public static void main(String[] args) {

        // maximum fibonacci cang go
        int limit = 4000000;

        // fist even num
        int even1 = 2;

        // second even num
        int even2 = 8;

        // start the series with the first even num
        int sum = even1;

        // keep looping as long as the current even fibonacci number is less than or equal to max
        while (even2 <= limit) {

            // add current even fibonacci number to the total sum
            sum += even2;

            // calculate next even fibonacci number
            // calculaataion: next even = 4 × current even + previous even
            int nextEven = 4 * even2 + even1;

            // move forward in sequence:
            // current even becomes the previous even
            even1 = even2;

            // the newly calculated number becomes the current even
            even2 = nextEven;
        }

        //PRINT SUM!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:DDDDDD:))))
        System.out.println("Sum of even Fibonacci numbers up to 4,000,000: " + sum);
        
    }
}