import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int y = sc.nextInt();
        int w = sc.nextInt();
 
        int max = Math.max(y, w);
        int numerator = 7 - max;
        int denominator = 6;
 
        int gcd = gcd(numerator, denominator);
 
        System.out.println((numerator / gcd) + "/" + (denominator / gcd));
 
        sc.close();
    }
 
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}