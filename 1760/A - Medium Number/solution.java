import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
 
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
 
            int medium = a + b + c - min - max;
 
            System.out.println(medium);
        }
    }
}