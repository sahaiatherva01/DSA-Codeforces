import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.next();
 
        char[] a = s.toCharArray();
 
        for (int i = 0; i < a.length; i++) {
 
            int digit = a[i] - '0';
            int inverted = 9 - digit;
 
            // Don't make the first digit zero
            if (i == 0 && inverted == 0) {
                continue;
            }
 
            if (inverted < digit) {
                a[i] = (char) (inverted + '0');
            }
        }
 
        System.out.println(new String(a));
 
        sc.close();
    }
}