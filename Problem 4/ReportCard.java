import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of entries
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String[] names = new String[n];
        int[] scores = new int[n];

        // Input names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name #" + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // Input scores
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for " + names[i] + ": ");
            scores[i] = scanner.nextInt();
        }
        
        int highestScore = scores[0];
        for (int i = 0; i < n; i++){
            if (scores[i] > highestScore) {
                highestScore = scores[i];
            }
        }
        
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Acheived by: ");
        for (int i = 0; i < n; i++){
            if (scores[i] == highestScore){
                System.out.println(names[i]);
            }
        }

        int scoreTotals = 0;
        for (int i = 0; i < n; i++){
            scoreTotals += scores[i];
        }
        double classAverage = (double) scoreTotals/n;
        System.out.println("Class Average: " + classAverage);
        // Print names and scores
        // System.out.println("\nNames and Scores:");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(names[i] + " - " + scores[i]);
        // }
        List<String> belowAverage = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (scores[i] < classAverage){
                belowAverage.add(names[i]);
            }
        }

        System.out.println("Here are the students who came BELOW average: " + String.join(", ", belowAverage));

        scanner.close();
    }
}