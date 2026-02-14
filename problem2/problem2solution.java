package problem2;
public class problem2solution {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 0; i < 1000 ; i++){
            if (i % 3 == 0 || i % 5 == 0){
                num += i;
            }
        }
        System.out.println("The output is: " + num);
    }
}
// Answer: 233168