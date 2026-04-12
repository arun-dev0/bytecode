import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TournamentBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of students and scores
        System.out.print("Enter the number of contestants: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of scores per contestant: ");
        int s = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] names = new String[n];

        // Input names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name #" + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // Create list of lists for scores
        List<List<Integer>> allScores = new ArrayList<>();

        // Input scores for each student
        for (int i = 0; i < n; i++) {
            List<Integer> studentScores = new ArrayList<>();

            for (int f = 0; f < s; f++) {
                System.out.print("Enter score #" + (f + 1) + " for " + names[i] + ": ");
                studentScores.add(scanner.nextInt());
            }

            allScores.add(studentScores);
        }

        // 🔍 Find highest score overall
        int highestScore = allScores.get(0).get(0);

        for (int i = 0; i < n; i++) {
            for (int score : allScores.get(i)) {
                if (score > highestScore) {
                    highestScore = score;
                }
            }
        }

        System.out.println("\nHighest Score: " + highestScore);
        System.out.println("Achieved by:");

        for (int i = 0; i < n; i++) {
            if (allScores.get(i).contains(highestScore)) {
                System.out.println(names[i]);
            }
        }

        // 📊 Calculate class average (based on student averages)
        double totalAverage = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> studentScores = allScores.get(i);

            int sum = 0;
            for (int score : studentScores) {
                sum += score;
            }

            double avg = (double) sum / s;
            totalAverage += avg;
        }

        double classAverage = totalAverage / n;
        System.out.println("\nClass Average: " + classAverage);

        // 📉 Find students below average
        List<String> belowAverage = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> studentScores = allScores.get(i);

            int sum = 0;
            for (int score : studentScores) {
                sum += score;
            }

            double avg = (double) sum / s;

            if (avg < classAverage) {
                belowAverage.add(names[i]);
            }
        }

        System.out.println("Students below average: " + String.join(", ", belowAverage));

        // 🖨️ Print all students and their scores
        System.out.println("\nAll Students and Scores:");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + ": " + allScores.get(i));
        }

        scanner.close();
    }
}