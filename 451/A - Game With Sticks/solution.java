import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int moves = Math.min(n, m);
 
        if (moves % 2 == 1) {
            System.out.println("Akshat");
        } else {
            System.out.println("Malvika");
        }
    }
}