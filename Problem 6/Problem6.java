import java.util.Arrays;

public class Problem6 {
     public static void main (String[]args) {
        question1();
        question2();
        
    }
     public static void question1() {
        String message = "HELLO WORLD";// set message to  HELLO WORLD
        int shift=3;// make the shift 3
        String result="";

        for(int i=0;i<message.length();i++){// stay in the for loop till you have gone through all letters in the message
            char c = message.charAt(i);// get each charecter
            if(Character.isUpperCase(c)){// if the charecter is uppercase 
            char encodedChar = (char)('A' + (c - 'A' + shift) % 26);// do this algorithm
            result+=encodedChar;// add it to result
            }else if (Character.isLowerCase(c)) {// if its lowecase
             char encodedChar = (char) ('a' + (c - 'a' + shift) % 26);// do this algorithm
             result+=encodedChar;// add it to result
            }else{// if it isnt uppercase or lowercase 
                result+=c;// just add the original charecter to the result
            }
        }
        System.out.println("Your encoded message is :"+ result);// print the encoded message
        System.out.println("Your orignial message was: "+message);// print the original message
    }
    public static void question2() {
    String wordA = "listen";// start word a with listen
    String wordB = "silent";// and word b with silent
    System.out.println(isAnagram(wordA, wordB));
    System.out.println(isAnagram("triangle", "integral"));// for later checks 
    System.out.println(isAnagram("hello", "world"));
    System.out.println(isAnagram("astronomer", "moon starer"));
}

public static boolean isAnagram(String wordA, String wordB) {// declare a function
String a = wordA.toLowerCase().replace(" ", "");// make all letters lowercase and have no spaces
String b = wordB.toLowerCase().replace(" ", "");// make all letter lowercase and have no spaces
if(a.length() != b.length()){ // if the lenght is already not equal
    return false;// return false
}
char[] sortedA = a.toCharArray();// store sorted a into this
char[] sortedB = b.toCharArray();// store sorted b into this
Arrays.sort(sortedA);// sort a
Arrays.sort(sortedB);// sort b
return Arrays.equals(sortedA, sortedB);// return true if the sorted arrrays are the same
}

}
    
