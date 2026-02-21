//A number is a perfect square, or a square number, if it is the square of a positive integer.
//For example, 25 is a square number because 5^2 = 5 x 5 = 25; it is also an odd square.
//The first 5 square numbers are: 1, 4, 6, 16, 25 and the sum of the odd squares is 1 + 9 + 25.
//Among the first 851 thousand square numbers, what is the sum of all the odd squares?

public class Euler0 {
    public static void main(String[] args){

        long x = 0; 

        for (long i = 0; i<851001 ;i++){
            if (i%2==1){
            x = x + (i*i);
            //System.out.println(i*i);
            }
        }
        System.out.println(x);

    }
}