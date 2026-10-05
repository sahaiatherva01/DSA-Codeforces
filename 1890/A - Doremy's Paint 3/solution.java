import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            Map<Integer, Integer> freq = new HashMap<>();
 
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
 
            if (freq.size() > 2) {
                System.out.println("No");
                continue;
            }
 
            if (freq.size() == 1) {
                System.out.println("Yes");
                continue;
            }
 
            int[] count = new int[2];
            int idx = 0;
 
            for (int value : freq.values()) {
                count[idx++] = value;
            }
 
            System.out.println(Math.abs(count[0] - count[1]) <= 1
                    ? "Yes"
                    : "No");
        }
    }
}