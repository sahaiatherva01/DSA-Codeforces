import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        String s = sc.next();
 
        boolean[] seen = new boolean[26];
 
        for (int i = 0; i < n; i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            seen[ch - 'a'] = true;
        }
 
        for (int i = 0; i < 26; i++) {
            if (!seen[i]) {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println("YES");
    }
}