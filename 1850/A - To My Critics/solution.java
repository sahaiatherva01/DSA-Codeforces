import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
 
            int max1 = Math.max(a, Math.max(b, c));
 
            int max2;
 
            if (max1 == a) {
                max2 = Math.max(b, c);
            } else if (max1 == b) {
                max2 = Math.max(a, c);
            } else {
                max2 = Math.max(a, b);
            }
 
            if (max1 + max2 >= 10) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
 
        sc.close();
    }
}