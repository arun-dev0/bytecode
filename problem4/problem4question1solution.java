package problem4;

import java.util.ArrayList;
import java.util.List;

public class problem4question1solution {
    public static void main(String[] args) {
        solution1();
        solution2();
    }
    public static void solution1(){ // Original solution
        long start = System.nanoTime();
        List<String> names  = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "Diana", "Eve")); // makes list for names
        List<Integer> scores = new ArrayList<>(List.of(88,72,95,60,81)); // makes list for scores
        List<String> belowAverage = new ArrayList<>(); // list to store names of below average students
        String topStudent=null; // variable to store top student
        int averageScore = 0; // variable to store average score
        for (String name : names) { // goes through each name 
            int i = names.indexOf(name); // stores the index of the name
            int currentScore = scores.get(i); // gets the score for the name
            if (topStudent == null) { // if there is not top student yet, the current student will automatically become the top student
                topStudent = name;
                continue; // exit this iteration of the loop and goes to the next name 
            }
            int topScore = scores.get(names.indexOf(topStudent)); // gets the top score
            if (topScore < currentScore) { // checks if the current student is better than the previous top student
                topStudent = names.get(scores.indexOf(currentScore)); // changes top student to current student
            }
        }
        for (Integer score : scores) { // goes through the loop for each score in the scores list
            averageScore += score; // adds each score to the average
        }
        averageScore = averageScore / scores.size(); // divides the total by the number of scores to get the average
        for (String name : names) { // goes through for each number
            if (scores.get(names.indexOf(name)) < averageScore){  // checks if the student is below average
                belowAverage.add(name); // adds the name to the below average list
            }
        }
        System.out.println("Top Student: " + topStudent); // prints final data points
        System.out.println("Below Average: " + belowAverage.toString());
        long stop = System.nanoTime();
        long executionNano = stop - start;
        double executionMilli = executionNano/1_000_000.0;
        System.out.println("Execution time: " + executionMilli); // execution time
    }
    public static void solution2(){
        long start = System.nanoTime();

        StringAndInteger Alice = new StringAndInteger("Alice", 88); // makes the students (uses a custom class that stores both a string and integer)
        StringAndInteger Bob = new StringAndInteger("Bob", 72);
        StringAndInteger Charlie = new StringAndInteger("Charlie", 95);
        StringAndInteger Diana = new StringAndInteger("Diana", 60);
        StringAndInteger Eve = new StringAndInteger("Eve", 81);

        List<StringAndInteger> students  = new ArrayList<>(List.of(Alice, Bob, Charlie, Diana, Eve)); // makes a list of the students
        List<String> belowAverage = new ArrayList<>(); // list to store below average students
        StringAndInteger topStudent=null; // variable to store the top student
        int averageScore = 0; // variable to store average score
        for (StringAndInteger student : students) { // checks every student
            int currentScore = student.integer(); // gets each student's score
            if (topStudent == null) { // makes sure that the top student already has a value
                topStudent = student; // if not, automatically make the top student the current student
                continue; // jump to the next iteration
            }
            int prevScore = topStudent.integer(); // top score
            if (prevScore < currentScore) { // sees if the current score is better than the top score
                topStudent = student; // if so, replaces the top student with the current student
            }
        }
        for (StringAndInteger student : students) { // goes through every student
            averageScore += student.integer(); // adds all scores to the total
        }
        averageScore = averageScore / students.size(); // divides the total by the amount of students to find the average
        for (StringAndInteger student : students) { // checks every student
            if (student.integer<averageScore){ // sees if a student is below average
                belowAverage.add(student.string()); // if so, adds that student to the list of below average students
            }
        }
        System.out.println("Top Student: " + topStudent.string()); // prints final data
        System.out.println("Below Average: " + belowAverage.toString());
        long stop = System.nanoTime();
        long executionNano = stop - start;
        double executionMilli = executionNano/1_000_000.0;
        System.out.println("Execution time: " + executionMilli); // finds execution time
    }
    public static class StringAndInteger { // custom class to store both an int and a string in the same variable
        private Integer integer; // integer variable
        private String string; // string variable 
        public StringAndInteger(String string, Integer integer){ // initialization function
            this.integer = integer;
            this.string = string;
        }
        public Integer integer(){ // gets the integer value of the variable
            return integer;
        }
        public String string(){ // gets the string value of the variable
            return string;
        }
        public String toString(){ // turns both values into a single string
            return (string + ", " + integer);
        }
    }
}