import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] freq = new int[100001];
 
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            freq[x]++;
        }
 
        long[] dp = new long[100001];
 
        dp[1] = freq[1];
 
        for (int i = 2; i <= 100000; i++) {
 
            long take = dp[i - 2] + (long) i * freq[i];
            long skip = dp[i - 1];
 
            dp[i] = Math.max(take, skip);
        }
 
        System.out.println(dp[100000]);
    }
}