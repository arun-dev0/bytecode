public class binary2 {
    public static void main(String[] args) {
        int count=0;
         


        for(int i=1; i<100;i++){
            String binaryString="";
            int temp=i;
            while(temp>0){
            int num = temp%2;
            temp=temp/2;
             binaryString = num + binaryString;
            }
             String reversed = new StringBuilder(binaryString).reverse().toString();
            if(binaryString.equals(reversed)){
                count+=1;
                System.out.println("the binary number that is a palindrome is"+binaryString);
            }
        }
        System.out.println("Number of palindromes:"+count);



    }
}