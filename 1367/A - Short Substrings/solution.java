import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String b = sc.next();
 
            StringBuilder a = new StringBuilder();
 
            // First character
            a.append(b.charAt(0));
 
            // Every second character starting from index 1
            for (int i = 1; i < b.length(); i += 2) {
                a.append(b.charAt(i));
            }
 
            System.out.println(a);
        }
    }
}