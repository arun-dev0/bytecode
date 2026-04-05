public class Problem_5 {
    public static void main(String[] args) {

        for (int i = 1; i < 100; i++) {

            int quotient = i;
            String binary_representation = "";

            while (quotient > 0) {
                int remainder = quotient % 2;
                binary_representation = remainder + binary_representation;
                quotient = quotient / 2;
            }

            System.out.println(i + " = " + binary_representation);

            String reversed = new StringBuilder(binary_representation)
                    .reverse()
                    .toString();

            if (binary_representation.equals(reversed)) {
                System.out.println(i + " = " + binary_representation + " (same forward/backward)");
            }
        }
    }
}