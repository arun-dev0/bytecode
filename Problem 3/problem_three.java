public class problem_three {
    public static void main(String[] args) {
        long result = 1;

        for (int i = 2; i <= 20; i++) {
            result = lcm(result, i);
        }

        System.out.println("Answer: " + result);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        long answer = (a * b) / gcd(a, b);
        return answer;
    }
}