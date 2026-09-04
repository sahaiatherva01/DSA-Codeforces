import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            Map<Integer, Long> map = new HashMap<>();
            long ans = 0;
 
            for (int i = 1; i <= n; i++) {
                int a = sc.nextInt();
 
                int key = a - i;
 
                long count = map.getOrDefault(key, 0L);
 
                ans += count;
 
                map.put(key, count + 1);
            }
 
            System.out.println(ans);
        }
 
        sc.close();
    }
}