
public class Multiples3and5 {
public static void main (String[]args) {
  int sumOfMultiples = 0;
  

for (int i=3;i<1000;i +=3){// check for multiples of 3 all the way to 1000
    sumOfMultiples=sumOfMultiples+i;//add it to the sum
}
for (int i=5;i<1000;i +=5){//check for multiples of 5 all the way to 100
  sumOfMultiples=sumOfMultiples+i;//add it to the sum
}
for (int i=15;i<1000;i +=15){//subtract all the reapeated multiples
  sumOfMultiples=sumOfMultiples-i;//subtract it from the sun
}

System.out.println("The sum of all the multiples of 3 & 5 all the way to 1000 is"+sumOfMultiples);
}
    
  }
