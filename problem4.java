public class problem4{
    public static void main(String[] args) {
       String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
       int[] scores = {88, 72, 95, 60, 81};
       int averageScore = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
       averageScore = averageScore / scores.length;

         for (int i = 0; i < names.length; i++) {
              System.out.println(names[i] + ": " + scores[i]);
         }
        System.out.println("The top scorer is: " + names[2] + " with a score of " + scores[2]);
        System.out.println("The average score is: " + averageScore);
        System.out.println("The names of students who got below average score is: " + getBelowAverageNames(names, scores, averageScore));
    }

    // Function to get the names of students who got below average score
    public static String getBelowAverageNames(String[] names, int[] scores, int averageScore) {
        StringBuilder belowAverageNames = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < averageScore) {
                belowAverageNames.append(names[i]).append(" ");
            }
        }
        return belowAverageNames.toString().trim();
    }
}