import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            int[] a = new int[n];
            int minIndex = 0;
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
 
                if (a[i] < a[minIndex]) {
                    minIndex = i;
                }
            }
 
            a[minIndex]++;
 
            long product = 1;
 
            for (int x : a) {
                product *= x;
            }
 
            System.out.println(product);
        }
    }
}