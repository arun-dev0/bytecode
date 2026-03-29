public class problem4num2 {
    public static void main(String[] args) {
        String[] players = {"Alice", "Bob", "Charlie", "Diana"};
        int[][] scores = {
            {72, 88, 65},   // Alice's scores
            {91, 60, 84},   // Bob's scores
            {78, 78, 78},   // Charlie's scores
            {95, 40, 90}    // Diana's scores
        };
        System.out.println("Alice's total score: " + java.util.Arrays.stream(scores[0]).sum());
        System.out.println("Bob's total score: " + java.util.Arrays.stream(scores[1]).sum());
        System.out.println("Charlie's total score: " + java.util.Arrays.stream(scores[2]).sum());
        System.out.println("Diana's total score: " + java.util.Arrays.stream(scores[3]).sum());
        int bestTotal = 0; // start at 0 for the highest total
        int bestIndex = 0; // this keeps track of the winner's index

        for (int i = 0; i < players.length; i++) { // go through each player and check the score and then add it. i is player index
            int playerTotal = 0; // start each player's total at 0

            for (int j = 0; j < scores[i].length; j++) { // go through each score for the players and then adds it to their total 
                playerTotal = playerTotal + scores[i][j]; // add each score to the player's total
            }

            System.out.println(players[i] + " total: " + playerTotal); // print the player's name and total

            if (playerTotal > bestTotal) { // if this total is bigger than the highest total so far
                bestTotal = playerTotal; // make it the highest total
                bestIndex = i; // the best index will become the player's index
            }
        }
        System.out.println("The player with the most points after all 3 rounds: " + players[bestIndex] + " with a total of " + java.util.Arrays.stream(scores[bestIndex]).sum());
    }
}
