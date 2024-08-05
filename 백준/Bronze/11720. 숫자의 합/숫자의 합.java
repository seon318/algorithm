import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int LEN = sc.nextInt();
		sc.nextLine();
		String N = sc.nextLine();
		
		int sum = 0;
		
		for (int i = 0; i < LEN; i++) {
			sum += Integer.parseInt(String.valueOf(N.charAt(i)));
		}
		System.out.println(sum);
	}
}
