public class Scores {
    public static void main (String[]args) {
        question1();
        question2();
        
    }

    // Question 1
    public static void question1() {
        String[] names;
        names = new String[]{"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int names_length = names.length;

          
        int[] scores;
         scores = new int[]{88, 72, 95, 60, 81}; 

         int scores_length = scores.length;
         //System.out.println("The lenght of the scores array is"+length);

         //to find the greatest value's index
         int greatest_value = scores[0];
         int greatest_index = 0;
        

         for(int  i= 1; i < scores_length;i++){
            if (scores[i] > greatest_value) {
                greatest_value = scores[i];
                greatest_index=i;
            }
    
         }
         //System.out.println("Greatest Score equals "+greatest_value);
         System.out.println("Question 1:Name of the person is "+names[greatest_index]);
         //System.out.println("And the index is "+greatest_index);



          int least_value = scores[0];
         int least_index = 0;

         for(int  i= 1; i < scores_length;i++){
            if (scores[i] < least_value) {
                least_value = scores[i];
                least_index=i;
            }
    
         }
         //System.out.println("Least Score equals "+least_value);
         System.out.println("Question 1:Name of the person is "+names[least_index]);
         //System.out.println("And the index is "+least_index);

         //Calculate the Averge and Print the names of the ppl who have below avearge scores
          int sum=0;
         for (int i=0;i<scores.length;i++) {
             sum= sum+scores[i];
         }
         int Average=sum/scores.length;
         System.out.println("Question1:The Average is"+Average);

         for(int i=0; i<scores.length;i++){
            if(scores[i]<Average){
                System.out.println(names[i]+" Question1:This student has scored below average");
            }
         }
    }

    // Question 2
    public static void question2() {
               String[] names;
        names = new String[]{"Alice", "Bob", "Charlie", "Diana"};
        int names_length = names.length;
          
        int[][] scores = {
            {72, 88, 65},
            {91, 60, 84},
            {78, 78, 78},
            {95, 40, 90}
        };

        int scores_length=scores.length;
        int best_total=0;
        int best_index=0;

        for (int i=0;i<scores_length;i++){
            int total=0;
            for (int j=0;j<scores[i].length;j++){
                total+= scores[i][j];
            }
                if (total>best_total) {
                    best_total=total;
                    best_index=i;
                }
        }
        System.out.println("Question2: The person with the greatest total is "+names[best_index]);
    }

}