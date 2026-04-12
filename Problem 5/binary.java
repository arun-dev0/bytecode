import java.util.Scanner;// import the scanner
public class binary {
     
    public static void main (String[]args) {
        //question1();
        question2();
        
    }
     public static void question1() {
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
    public static void question2(){
     int count=0;
         


        for(int i=1; i<100;i++){// loop to check all number from 1-100
            String binaryString="";
            int temp=i; // creating a temp variable
            while(temp>0){ // while the temp variable is greater than 0 go into the while loop
            int num = temp%2;// mod the temp by 2 to get the remainder (the binary number)
            temp=temp/2;// divide it by 2 to remove all decimals
             binaryString = num + binaryString;// add num to a binary string so you can reverse it later
            }
             String reversed = new StringBuilder(binaryString).reverse().toString();// reverse the binary string so you can check whether its a palindrome or not
            if(binaryString.equals(reversed)){// check if it equals the same thing
                count+=1;// if it is add it to the count
                System.out.println("the binary number that is a palindrome is"+binaryString);// print all the numbers which are palindromes
            }
        }
        System.out.println("Number of palindromes:"+count);// print the total count at the end


    
    }
}


