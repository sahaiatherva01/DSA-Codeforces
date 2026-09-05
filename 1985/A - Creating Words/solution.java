import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
 
            char firstA = a.charAt(0);
            char firstB = b.charAt(0);
 
            a = firstB + a.substring(1);
            b = firstA + b.substring(1);
 
            System.out.println(a + " " + b);
        }
 
        sc.close();
    }
}