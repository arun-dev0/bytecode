import java.util.ArrayList;

public class solution4 {
    public static void main(String[] args) { 
        String[] names = {"Alice","Bob","Charlie","Diana","Eve"}; // student names
        int[] scores = {88,72,95,60,81}; // matching scores

        //                        ^ stores scores in an array        

        int total = 0; // will hold sum of all scores
        
        for(int i=0;i<scores.length;i++){
            total += scores[i]; // add each score to total
        }
        
        int average = total / scores.length; // find average (rounded down)
        int topIndex = 0; // assume first student is best for now
        ArrayList<String> belowAverage = new ArrayList<>(); // list for names below avg
        // loop again to find top student and below average students
        for(int i=0;i<scores.length;i++){
            if(scores[i] > scores[topIndex]){ // if current score is higher
                topIndex = i; // update best student index
            }
            if(scores[i] < average){ // if score is below average
                belowAverage.add(names[i]); // add their name to list
            }
        }
        System.out.println("Top student: " + names[topIndex]); // print best student
        System.out.println("Below average students: " + belowAverage); // print list
        System.out.println("Average score: " + average); // print average
    }
}