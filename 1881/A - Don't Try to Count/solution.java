import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
 
            String s = sc.next();
            String target = sc.next();
 
            int operations = 0;
 
            while (s.length() < m) {
                s += s;
                operations++;
            }
 
            if (s.contains(target)) {
                System.out.println(operations);
                continue;
            }
 
            // One extra doubling can allow target
            // to cross the boundary between two copies.
            s += s;
            operations++;
 
            if (s.contains(target)) {
                System.out.println(operations);
            } else {
                System.out.println(-1);
            }
        }
    }
}