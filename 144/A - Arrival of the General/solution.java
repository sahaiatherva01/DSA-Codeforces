import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int max = a[0];
        int min = a[0];
 
        // Find maximum and minimum
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
 
        // Leftmost maximum
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == max) {
                maxPos = i;
                break;
            }
        }
 
        // Rightmost minimum
        int minPos = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == min) {
                minPos = i;
                break;
            }
        }
 
        int ans = maxPos + (n - 1 - minPos);
 
        // Moving max to the front shifts min one position left
        if (maxPos > minPos) {
            ans--;
        }
 
        System.out.println(ans);
    }
}