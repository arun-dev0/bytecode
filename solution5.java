public class solution5 {
    public static void main(String[] args) {
        // List of player names
        String[] players = {"Alice","Bob","Charlie","Diana"};
        // 2D array of scores: each inner array = one player's scores in 3 rounds
        int[][] scores = {
            {72,88,65},   // Alice
            {91,60,84},   // Bob
            {78,78,78},   // Charlie
            {95,40,90}    // Diana
        };
        int bestTotal = 0;   // highest total score seen so far
        int bestIndex = 0;   // index of the player with the highest total
        // Loop through each player
        for(int i=0; i<players.length; i++){
            int playerTotal = 0;   // sum of current player's scores
            // Loop through each round for this player
            for(int j=0; j<scores[i].length; j++){
                playerTotal += scores[i][j]; // add score of this round
            }
            // If this player's total is higher than current best, update
            if(playerTotal > bestTotal){
                bestTotal = playerTotal;   // new highest total
                bestIndex = i;             // save index of this player
            }
        }
        // Print winner
        System.out.println("Winner: " + players[bestIndex]);
        System.out.println("Total score: " + bestTotal);
    }
}