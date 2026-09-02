import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String s = sc.next();
 
            boolean possible = s.equals("abc");
 
            for (int i = 0; i < 3 && !possible; i++) {
                for (int j = i + 1; j < 3; j++) {
                    char[] arr = s.toCharArray();
 
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
 
                    if (new String(arr).equals("abc")) {
                        possible = true;
                        break;
                    }
                }
            }
 
            System.out.println(possible ? "YES" : "NO");
        }
 
        sc.close();
    }
}