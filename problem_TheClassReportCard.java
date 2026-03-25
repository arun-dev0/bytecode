import java.util.ArrayList;

public class problem_TheClassReportCard {
    public static void main(String[] args) {

        int[] scores = {88, 72, 95, 60, 81}; // those are the scores of the students
        String[] names = {"Ava", "Jay", "Mia", "Noah", "Liam"}; // saying the names
        int total = 0; // start at 0

        for (int i = 0; i < scores.length; i++) { // start at 0. Stop before 5 because that's how many students there are. And then add it to the sum
            total = total + scores[i]; // the total is created by using the previous total and adding the scores
        }

        int average = total / scores.length; // the formula to find average

        int topIndex = 0; // the top index
        for (int i = 1; i < scores.length; i++) { // check every score
            if (scores[i] > scores[topIndex]) { // if the score is the highest, make it the top index
                topIndex = i; // i is the top index
            }
        }

        ArrayList<String> belowAverage = new ArrayList<String>(); // make an empty list for below-average students

        for (int i = 0; i < scores.length; i++) { // check every score
            if (scores[i] < average) { // if the score is less than the average
                belowAverage.add(names[i]); // if it is below average, add the names to the below-average list
            }
        }

        System.out.println("Average: " + average); // prints the average
        System.out.println("Top student: " + names[topIndex]); // prints the name of the top student
        System.out.println("Top score: " + scores[topIndex]); // prints the top score
        System.out.println("Below average students: " + belowAverage); // prints the below-average students
    }
}