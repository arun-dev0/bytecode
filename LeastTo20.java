public class LeastTo20 {
    public static void main (String[]args) {

        int pass=0;
        long divisible=20;

        while(pass==0){
           divisible+=20;
           if((divisible%20==0) && (divisible%19==0) && (divisible%18==0) && (divisible%17==0) && (divisible%16==0) && (divisible%15==0) && (divisible%14==0) && (divisible%13==0) && (divisible%11==0)) {
           //if( (divisible%5==0) && (divisible%7==0) && (divisible%8==0) && (divisible%9==0)) {
                 pass=1;
           }
        }
        System.out.println("Final NUmber: "+ divisible);
    }
}