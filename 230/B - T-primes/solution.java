import java.io.*;
import java.util.*;
 
public class Main {
    static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
 
        if (n % 2 == 0) {
            return n == 2;
        }
 
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        while (n-- > 0) {
            long x = sc.nextLong();
 
            long root = (long) Math.sqrt(x);
 
            if (root * root == x && isPrime(root)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}