import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int length1 = 0;
		int length2 = 0;
		int max = 1;
		if (N >= 2) {
			length1 = 1;
			length2 = 1;
			max = 2;
		}
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				length1++;
				max = Math.max(length1, max);

			} else {
				length1 = 1;
			}
		}
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				length2++;
				max = Math.max(length2, max);

			} else {
				length2 = 1;
			}
		}
		System.out.println(max);
		sc.close();
	}
}
