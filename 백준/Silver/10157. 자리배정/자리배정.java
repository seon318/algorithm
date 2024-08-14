import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int cnt = 1;
		int[][] arr = new int[C][R];
		int top = 0;
		int left = 0;
		int right = C - 1;
		int bottom = R - 1;
		int K = sc.nextInt();
		if (K <= R * C) {
			out: while (cnt != C * R + 1) {
				for (int r = top; r <= bottom; r++) {

					arr[left][r] = cnt++;
					if (cnt == K + 1) {
						System.out.println((left + 1) + " " + (r + 1));
						break out;
					}
				}
				left++;

				for (int c = left; c <= right; c++) {
					arr[c][bottom] = cnt++;
					if (cnt == K + 1) {
						System.out.println((c + 1) + " " + (bottom + 1));
						break out;
					}
				}
				bottom--;

				for (int r = bottom; r >= top; r--) {
					arr[right][r] = cnt++;
					if (cnt == K + 1) {
						System.out.println((right + 1) + " " + (r + 1));
						break out;
					}
				}
				right--;
				for (int c = right; c >= left; c--) {
					arr[c][top] = cnt++;
					if (cnt == K + 1) {
						System.out.println((c + 1) + " " + (top + 1));
						break out;
					}
				}
				top++;
			}

		} else {

			System.out.println(0);

		}
		sc.close();
	}
}
