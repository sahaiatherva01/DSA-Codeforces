import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] lucky = {
            4, 7, 44, 47, 74, 77,
            444, 447, 474, 477,
            744, 747, 774, 777
        };
 
        for (int x : lucky) {
            if (n % x == 0) {
                System.out.println("YES");
                return;
            }
        }
 
        System.out.println("NO");
    }
}