import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}

		out: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j && height[i] + height[j] == sum - 100) {
					height[i] = 0;
					height[j] = 0;
					break out;
				}
			}

		}
		Arrays.sort(height);
		for (int i = 2; i < 9; i++) {
			System.out.println(height[i]);
		}
		sc.close();
	}
}
