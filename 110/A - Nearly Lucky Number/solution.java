import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String n = sc.next();
 
        int count = 0;
 
        for (char c : n.toCharArray()) {
            if (c == '4' || c == '7') {
                count++;
            }
        }
 
        if (count == 0) {
            System.out.println("NO");
            return;
        }
 
        while (count > 0) {
            int digit = count % 10;
            if (digit != 4 && digit != 7) {
                System.out.println("NO");
                return;
            }
            count /= 10;
        }
 
        System.out.println("YES");
    }
}