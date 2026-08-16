import java.io.*;
 
public class Main {
    static final long MOD = 998244353;
 
    static int countWays(String s, int start) {
        int ways = 0;
 
        for (int first = 0; first <= 1; first++) {
            boolean ok = true;
            int expected = first;
 
            for (int i = start; i < s.length(); i += 2) {
                if (s.charAt(i) != '?' && s.charAt(i) - '0' != expected) {
                    ok = false;
                    break;
                }
                expected ^= 1;
            }
 
            if (ok) {
                ways++;
            }
        }
 
        return ways;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
 
            long even = countWays(s, 0);
            long odd = countWays(s, 1);
 
            System.out.println((even * odd) % MOD);
        }
    }
}