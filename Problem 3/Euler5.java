// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class Euler5 {
    public static void main(String[] args){
        long result = 1;

        for(int x=1; x<=20; x++){
            result = lcm(result, x);
        }

        System.out.println("result:" + result);

    }

    public static long gcd(long y, long z){
        while(z != 0){
            long temp = z;
            z = y % z;
            y = temp;
        }
        return y;
    }

    public static long lcm(long y, long z){
        return (y / gcd(y, z)) * z;
    }
}