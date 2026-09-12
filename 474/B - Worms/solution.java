import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] prefix = new int[n];
 
        for (int i = 0; i < n; i++) {
            int worms = sc.nextInt();
 
            if (i == 0) {
                prefix[i] = worms;
            } else {
                prefix[i] = prefix[i - 1] + worms;
            }
        }
 
        int m = sc.nextInt();
 
        StringBuilder out = new StringBuilder();
 
        while (m-- > 0) {
            int q = sc.nextInt();
 
            int left = 0;
            int right = n - 1;
 
            while (left < right) {
                int mid = left + (right - left) / 2;
 
                if (prefix[mid] >= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
 
            out.append(left + 1).append('
');
        }
 
        System.out.print(out);
    }
}