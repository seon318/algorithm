import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int min = 1000000;
        int max = 0;
        for (int i=0; i<a; i++) {
        	int x = sc.nextInt();
        	min = Math.min(min, x);
        	max = Math.max(max, x);
        }
        System.out.println(min * max);
    }
}
