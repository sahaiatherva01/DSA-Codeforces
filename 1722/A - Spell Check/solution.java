import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            if (n != 5) {
                System.out.println("NO");
                continue;
            }
 
            char[] a = s.toCharArray();
            char[] b = "Timur".toCharArray();
 
            Arrays.sort(a);
            Arrays.sort(b);
 
            System.out.println(Arrays.equals(a, b) ? "YES" : "NO");
        }
    }
}