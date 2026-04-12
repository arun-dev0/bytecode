public class solution2 {
    public static void main(String[] args) {
        //max limit for Fibonacci numbers
        long limit = 4_000_000;
        // restarts to at 0 even fibbonacci numbers
        long sum = 0;
        long even1 = 2;
        long even2 = 8;
        // first two even Fibonacci numbers are 2 and 8 we start with those
        // add the first even fibb. num
        sum += even1;
        while (even2 < limit) { //keep doing this until limit
            // add the current fibb. to the sum
            sum += even2;   
            long nextEven = 4 * even2 + even1;//generate the next num
            //use ^ that because every 3rd num is even (as shown by the question.md)
            even1 = even2;
            even2 = nextEven;
        }
        System.out.println("sum of even Fibonacci numbers: " + sum);
    }
}