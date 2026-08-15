import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        for (int i = 0; i < n; i++) {
 
            if (i % 2 == 0) {
                // Full row
                for (int j = 0; j < m; j++) {
                    System.out.print("#");
                }
            } else if (i % 4 == 1) {
                // Snake on the right
                for (int j = 0; j < m - 1; j++) {
                    System.out.print(".");
                }
                System.out.print("#");
            } else {
                // Snake on the left
                System.out.print("#");
                for (int j = 1; j < m; j++) {
                    System.out.print(".");
                }
            }
 
            System.out.println();
        }
    }
}