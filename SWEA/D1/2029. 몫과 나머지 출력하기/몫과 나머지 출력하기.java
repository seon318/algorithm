import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a, b;
		for (int tc=1; tc<=t; tc++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.printf("#%d %d %d\n", tc, Math.max(a, b)/Math.min(a, b), Math.max(a, b)%Math.min(a, b));
		}
	}
}