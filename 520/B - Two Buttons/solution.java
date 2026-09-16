import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int ans = 0;
 
        while (m > n) {
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m++;
            }
            ans++;
        }
 
        ans += n - m;
 
        System.out.println(ans);
    }
}