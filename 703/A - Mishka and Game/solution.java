import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int mishka = 0;
        int chris = 0;
 
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int c = sc.nextInt();
 
            if (m > c) {
                mishka++;
            } else if (c > m) {
                chris++;
            }
        }
 
        if (mishka > chris) {
            System.out.println("Mishka");
        } else if (chris > mishka) {
            System.out.println("Chris");
        } else {
            System.out.println("Friendship is magic!^^");
        }
    }
}