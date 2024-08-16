import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		int cnt = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			if (arr[0] + arr[i] > x) {
				break;
			}
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == x) {
					cnt++;
					break;
				}

			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
