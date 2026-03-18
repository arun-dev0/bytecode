package problem4;

@SuppressWarnings("unused")
public class problem4question2solution {
    public static void main(String[] args) {
        String[] players = {"Alice", "Bob","Charlie","Diana"};
        int[] totals = new int[4]; // array to hold total scores
        int[][] scores = { // array that holds scores per round
            {72, 88, 65}, // Alice's scores
            {91, 60, 84}, // Bob's scores
            {78, 78, 78}, // Charlie's scores
            {95, 40, 90} // Diana's scores
        };
        int i = 0; // variable to hold indexes for values
        for (int[] individualScores : scores) { // goes through every players scores
            for (int score : individualScores) { // goes through each single score
                totals[i] += score; // adds it to the correct value in the array for totals
            }
            i++; // adds to the current index to get the next index
        }
        int highest = 0; // variable for highest score
        i=0; // gets ready to go through another loop
        String winner = null; // stores the name of the winner
        for (int total : totals) { // goees through once for every total in the array
            int prevHighest = highest; // last highest 
            highest = Math.max(totals[i], highest); // new highest
            if (highest != prevHighest){ // checks if highest changed
                winner = players[i]; // changes top player if necessary
            }
            i++; // adds to the current index to get the next index
        }
        System.out.println(winner + " won with a total score of " + highest + " points"); // prints final value
    }
}
