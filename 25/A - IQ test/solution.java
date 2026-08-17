import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int evenCount = 0;
        int oddCount = 0;
        int evenIndex = -1;
        int oddIndex = -1;
 
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
 
            if (x % 2 == 0) {
                evenCount++;
                evenIndex = i;
            } else {
                oddCount++;
                oddIndex = i;
            }
        }
 
        if (evenCount == 1) {
            System.out.println(evenIndex);
        } else {
            System.out.println(oddIndex);
        }
    }
}