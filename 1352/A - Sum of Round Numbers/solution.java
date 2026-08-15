import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
 
            ArrayList<Integer> result = new ArrayList<>();
 
            int place = 1;
 
            while (n > 0) {
                int digit = n % 10;
 
                if (digit != 0) {
                    result.add(digit * place);
                }
 
                n /= 10;
                place *= 10;
            }
 
            System.out.println(result.size());
 
            for (int x : result) {
                System.out.print(x + " ");
            }
 
            System.out.println();
        }
    }
}