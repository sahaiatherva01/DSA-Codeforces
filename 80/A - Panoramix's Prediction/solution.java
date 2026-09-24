import java.util.*;
 
public class Main {
    static boolean isPrime(int x) {
        if (x < 2) return false;
 
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int next = n + 1;
 
        while (!isPrime(next)) {
            next++;
        }
 
        System.out.println(next == m ? "YES" : "NO");
    }
}