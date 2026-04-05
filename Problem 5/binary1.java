import java.util.Scanner;// import the scanner
public class binary1 {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Type in a number between 0 and 255:"); 
        int userNum = number.nextInt();// reads and stores the input number
        String binaryString="";
        int count=0;

        while (userNum>0){// while the user input is greater than 0 this loop will run
            int digit=userNum%2;// mod's the number by 2 and assigns that to the digit valur
         binaryString = digit + binaryString;// adds this to the string
         userNum=userNum/2;// makes sure to remove the decimals 
         if (digit ==1) { // if the number is = to 1
            count+=1;// add it to the count

         }
        }
        System.out.println("The Binary number is: "+binaryString);
        System.out.println("The amount of 1's in the number is: "+ count);
    }

}