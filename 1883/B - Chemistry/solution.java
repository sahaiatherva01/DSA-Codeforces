import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
 
            int[] freq = new int[26];
 
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
 
            int odd = 0;
 
            for (int count : freq) {
                if (count % 2 != 0) {
                    odd++;
                }
            }
 
            System.out.println(odd <= k + 1 ? "YES" : "NO");
        }
    }
}