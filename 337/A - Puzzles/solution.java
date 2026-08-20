import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int[] f = new int[m];
 
        for (int i = 0; i < m; i++) {
            f[i] = sc.nextInt();
        }
 
        Arrays.sort(f);
 
        int answer = Integer.MAX_VALUE;
 
        for (int i = 0; i + n - 1 < m; i++) {
            answer = Math.min(answer, f[i + n - 1] - f[i]);
        }
 
        System.out.println(answer);
    }
}