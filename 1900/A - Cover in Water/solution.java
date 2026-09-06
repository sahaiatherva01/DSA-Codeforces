import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            int dots = 0;
            int consecutive = 0;
            boolean hasThree = false;
 
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '.') {
                    dots++;
                    consecutive++;
 
                    if (consecutive >= 3) {
                        hasThree = true;
                    }
                } else {
                    consecutive = 0;
                }
            }
 
            System.out.println(hasThree ? 2 : dots);
        }
 
        sc.close();
    }
}