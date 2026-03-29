public class Problem_4{
/* Task: Write a program that works with two parallel lists: names and scores
Find the name of the student with the highest score
Calculate the average score (rounded down)
Build a new list of names of students who scored below the average
Explain your algorithm (see section below) */
/* Algorithm:
1. Write all the scores parallel to the names
2. Find the value of all the scores added to eachother
3. Divide that by the total number of scores there are to get a average score
4. Find the person who got less than the average score
5. FInd the person who got the highest score
6. Print the name of the person with the highest score and the average score
7. Print the names of the people who got less than the average score 
*/
    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[] scores = {88, 72, 95, 60, 81};
          
        int highscore = 0;
            
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highscore) {
                highscore = scores[i];
            }
                             System.out.println(names[i] + " had a highest score of " + highscore);

          
           
            int total = 0;
            for (i = 0; i < scores.length; i++) {
                total = scores[i] + total;
            }
            int average = total / scores.length;
            for (i = 0; i < scores.length; i++) {
                if (scores[i] < average) {
                    System.out.println(names[i] + " scored below the average score of " + average);
                }
            }
        }
    }
}
