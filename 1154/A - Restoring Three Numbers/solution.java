import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int[] x = new int[4];
 
        for (int i = 0; i < 4; i++) {
            x[i] = sc.nextInt();
        }
 
        Arrays.sort(x);
 
        System.out.println(
            (x[3] - x[0]) + " " +
            (x[3] - x[1]) + " " +
            (x[3] - x[2])
        );
    }
}