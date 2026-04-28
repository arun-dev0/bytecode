package problem7;

import java.util.ArrayList;
import java.util.HashMap;

public class problem7question2 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> club = new HashMap<>();
        HashMap<String, String> birthdays = new HashMap<>();
        birthdays.put("Alice", "March");
        birthdays.put("Bob", "July");
        birthdays.put("Charlie", "March");
        birthdays.put("Diana", "December");
        birthdays.put("Eve", "July");
        birthdays.put("Frank", "March");
        birthdays.put("Grace", "April");
        for (String name : birthdays.keySet()) {
            if (!club.containsKey(birthdays.get(name))){
                club.computeIfAbsent(birthdays.get(name), k -> new ArrayList<>()).add(name);
            } else {
                club.get(birthdays.get(name)).add(name);
            }
        }
        String busiestMonth = "";
        int maxB_Days = 0; 
        for (String month : club.keySet()) {
            System.out.println(month + " : " + club.get(month).toString());
            if (club.get(month).size() > maxB_Days){
                maxB_Days = club.get(month).size();
                busiestMonth = month;
            }
        }
        System.out.println(busiestMonth + " is the busiest month, with " + maxB_Days + " birthdays.");
    }
}
