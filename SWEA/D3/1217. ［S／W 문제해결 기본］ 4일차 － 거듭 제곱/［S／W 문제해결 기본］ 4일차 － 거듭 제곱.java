import java.util.Scanner;

public class Solution {
	static int n, a, b, tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.printf("#%d %d\n", n, pow(a, b));
		}
	}
	
	static int pow(int c, int n) {
		if (n == 1) return c;
		if (n % 2 == 0) {
			tmp = pow(c, n / 2);
			return tmp * tmp;
		}
		return pow(c, n / 2) * pow(c, n / 2 + 1 );
	}
}