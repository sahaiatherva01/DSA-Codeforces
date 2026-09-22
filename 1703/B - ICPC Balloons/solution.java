import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            boolean[] seen = new boolean[26];
            int distinct = 0;
 
            for (char c : s.toCharArray()) {
                int index = c - 'A';
 
                if (!seen[index]) {
                    seen[index] = true;
                    distinct++;
                }
            }
 
            System.out.println(n + distinct);
        }
    }
}