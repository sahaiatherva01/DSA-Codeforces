import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        Map<String, Integer> goals = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            String team = sc.next();
            goals.put(team, goals.getOrDefault(team, 0) + 1);
        }
 
        String winner = "";
 
        for (String team : goals.keySet()) {
            if (winner.isEmpty() || goals.get(team) > goals.get(winner)) {
                winner = team;
            }
        }
 
        System.out.println(winner);
 
        sc.close();
    }
}