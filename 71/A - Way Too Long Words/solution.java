import java.util.Scanner;
public class abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline after nextInt()
        
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (word.length() > 10) {
                String abbreviation = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
                System.out.println(abbreviation);
            } else {
                System.out.println(word);
            }
        }
        scanner.close();
    }
}