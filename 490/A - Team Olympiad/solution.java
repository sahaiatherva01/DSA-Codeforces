import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        ArrayList<Integer> programmers = new ArrayList<>();
        ArrayList<Integer> mathematicians = new ArrayList<>();
        ArrayList<Integer> sportsmen = new ArrayList<>();
 
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
 
            if (t == 1) {
                programmers.add(i);
            } else if (t == 2) {
                mathematicians.add(i);
            } else {
                sportsmen.add(i);
            }
        }
 
        int teams = Math.min(
            programmers.size(),
            Math.min(mathematicians.size(), sportsmen.size())
        );
 
        System.out.println(teams);
 
        for (int i = 0; i < teams; i++) {
            System.out.println(
                programmers.get(i) + " " +
                mathematicians.get(i) + " " +
                sportsmen.get(i)
            );
        }
 
        sc.close();
    }
}