import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class BirthMonthCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> club = new HashMap<>();

        System.out.println("Enter students (type 'done' as the name to finish):");

        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter birth month: ");
            String month = scanner.nextLine();

            if (!club.containsKey(month)) {
                club.put(month, new ArrayList<>());
            }
            club.get(month).add(name);
        }

        scanner.close();

        System.out.println("\nBirthday groups:");
        for (String month : club.keySet()) {
            System.out.println("  " + month + ": " + String.join(", ", club.get(month)));
        }

        int maxCount = 0;
        for (String month : club.keySet()) {
            if (club.get(month).size() > maxCount) {
                maxCount = club.get(month).size();
            }
        }

        ArrayList<String> busiestMonths = new ArrayList<>();
        for (String month : club.keySet()) {
            if (club.get(month).size() == maxCount) {
                busiestMonths.add(month);
            }
        }

        if (busiestMonths.size() == 1) {
            System.out.println("\nThe busiest month is " + busiestMonths.get(0) + " with " + maxCount + " students.");
        } else {
            System.out.println("\nThe busiest months are " + String.join(", ", busiestMonths) + " with " + maxCount + " students.");
        }
    }
}
