import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String s = sc.next();
 
            int countA = 0;
 
            for (char c : s.toCharArray()) {
                if (c == 'A') countA++;
            }
 
            System.out.println(countA >= 3 ? "A" : "B");
        }
    }
}