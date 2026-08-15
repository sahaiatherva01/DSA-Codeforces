import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.nextLine();
 
        boolean[] seen = new boolean[26];
        int count = 0;
 
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
 
                if (!seen[index]) {
                    seen[index] = true;
                    count++;
                }
            }
        }
 
        System.out.println(count);
    }
}