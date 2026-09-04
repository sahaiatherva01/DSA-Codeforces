import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
 
        int[] h = new int[n];
 
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
 
        int sum = 0;
 
        // First window
        for (int i = 0; i < k; i++) {
            sum += h[i];
        }
 
        int minSum = sum;
        int answer = 0;
 
        // Slide the window
        for (int i = k; i < n; i++) {
            sum += h[i] - h[i - k];
 
            if (sum < minSum) {
                minSum = sum;
                answer = i - k + 1;
            }
        }
 
        // Codeforces uses 1-based indexing
        System.out.println(answer + 1);
 
        sc.close();
    }
}