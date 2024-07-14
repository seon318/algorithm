import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a %= 10;
            
            if (a == 0) {
                System.out.println(10);
                continue;
            }
            
            int[] pattern = new int[4];
            pattern[0] = a;
            for (int j = 1; j < 4; j++) {
                pattern[j] = (pattern[j - 1] * a) % 10;
            }
            
            int index = (b - 1) % 4;
            System.out.println(pattern[index]);
        }
    }
}