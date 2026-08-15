import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String[] arr = sc.next().split("\\+");
        Arrays.sort(arr);
 
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("+" + arr[i]);
        }
    }
}