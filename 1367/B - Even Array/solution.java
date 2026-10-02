import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            int evenIndexWrong = 0;
            int oddIndexWrong = 0;
 
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
 
                if (i % 2 != x % 2) {
                    if (i % 2 == 0) {
                        evenIndexWrong++;
                    } else {
                        oddIndexWrong++;
                    }
                }
            }
 
            if (evenIndexWrong != oddIndexWrong) {
                System.out.println(-1);
            } else {
                System.out.println(evenIndexWrong);
            }
        }
    }
}