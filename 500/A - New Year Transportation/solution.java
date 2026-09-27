import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int t = sc.nextInt();
 
        int[] a = new int[n];
 
        for (int i = 1; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int pos = 1;
 
        while (pos < t) {
            pos += a[pos];
        }
 
        System.out.println(pos == t ? "YES" : "NO");
    }
}