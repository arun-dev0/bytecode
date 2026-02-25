package problem2;
public class problem2solution {
    public static void main(String[] args) {
        solution1();//solution 1, just to get the idea of how to find the solution ( basic solution )
        solution2();//solution 2, only adds every 3rd fibonacci number, but finds all of them, omptimiezed a little bit ( intermediate solution )
        solution3();//solution 3, only stores the values of the even numbers, doesn't even find the odd ones, ompimized all the way ( advanced soltuion )
    }
    private static void solution1(){
        long start = System.nanoTime();
        long sum = 0;// sum variable
        long previous = 1;//first number used for calculations
        long current = 2;//second number used for calculations
        long next = 0;//number added to the sum each time
        sum += current;//adding the first number to the sum
        while ( previous+current < 4000000 ){//making sure that the largest fibonacci number does not exceed 4,000,000
            next = previous + current;//adding 2 previous number to get current number
            if (next % 2 == 0){//check every number to see if it is even
                sum += next;//addse the number if it is even
            }
            previous=current;//sets up for next time through the loop
            current=next;
        }
        System.out.println(sum);//prints total value
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli);//finds execution time
    }
    private static void solution2(){
        long start = System.nanoTime();
        long sum = 0;//sum variable
        long previous = 1;//first number for calculations
        long current = 2;//second number for calculations
        long next = 0;//number added to sum each time
        sum += current;//adds first number
        while (previous+current < 4000000){//making sure that the largest fibonacci number does not exceed 4,000,000
            for (int i = 0; i < 3; i++){// checks every 3rd number
                next = previous + current;// does the math
                previous=current;// sets up for next time
                current=next;
            }
            sum += next;// adds to the total
        }
        System.out.println(sum);//returns the total value
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli);//find execution time
    }
    private static void solution3(){
        long start = System.nanoTime();
        long sum = 0;//sum variable
        long previous = 1;//first number for calculations
        long current = 2;//second number for calculations
        long next = 0;//number added to the sum each time 
        int e1=0;//first even fibonacci number
        int e2=0;//second even fibonacci number        
        next = 1;//making sure that the program enters the loop
        e1 = (int) current; // setting e1 value
        while(next % 2 != 0){// making sure loop does not end until 2nd even number is found
            next = current + previous;// does math
            previous = current;//sets up for next time
            current = next;
            if (next % 2 == 0){//exits the loop when the 2nd even fibonacci number is found
                e2 = (int) next;
                break;
              }
        }
        current = e2;// setting up to do math
        previous = e1;
        sum += e1 + e2;// does math
        while (previous+current < 4000000){//making sure that the largest fibonacci number does not exceed 4,000,000
            next = 4*current + previous;//formula to find the next even fibonacci number using the 2 before it
            sum += next;// does the math
            previous = current;//sets up for next time
            current = next;
        }
        System.out.println(sum);//prints final value
        long stop = System.nanoTime();
        long durationNano = stop - start;
        double durationMilli = (double) durationNano / 1_000_000.0;
        System.out.println("Execution time: " + durationMilli);// finds execution time
    }
}
//Solution: 4613732