import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class birthdaypartymonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Names: ");
        String all_names = scanner.nextLine();

        System.out.print("Birthday months: ");
        String all_months = scanner.nextLine();

        String[] names = all_names.split(" ");
        String[] months = all_months.split(" ");
        HashMap<String, ArrayList<String>> combined = new HashMap<>();    
        for (int i = 0; i<names.length; i++) {
            //combined.put(months[i], names[i]);
            if (!combined.containsKey(months[i])) {
                combined.put(months[i], new ArrayList<>());
            }
                combined.get(months[i]).add(names[i]);
            
        }
        
       
        for (String word : combined.keySet()) {
        System.out.println(word + ": " + combined.get(word));
        }
    }
}