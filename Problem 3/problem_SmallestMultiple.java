public class problem_SmallestMultiple {
    public static void main(String[] args) {
        long result = 1;// 1 because anything is divisble by 1

        for (int i = 2; i <= 20; i++) { //for loop to check if everything is divisble from 2-20
            result = lcm(result, i);// uses lcm to find the result
        }

        System.out.println("Answer: " + result);// print out the result
    }

    public static long gcd(long a, long b) { // uses gcd
        while (b != 0) { // keep repeating while b is not 0
            long temp = b; // saves the old value of b
            b = a % b; // it checks if it's divisble
            a = temp; // it switches value of b into a
        }
        return a; // it switches the a back to being divided
    }

    public static long lcm(long a, long b) {
        long answer = (a * b) / gcd(a, b);// it's the equation
        return answer; // sends the a back as an answer
    }
}