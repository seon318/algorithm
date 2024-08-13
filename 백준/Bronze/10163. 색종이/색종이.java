import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];
		for (int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			for (int row = r; row < r + width; row++) {
				for (int col = c; col < c + height; col++) {
					arr[row][col] = i;
				}
			}

		}
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < 1001; j++) {
				for (int k = 0; k < 1001; k++) {
					if (arr[j][k] == i) {
						cnt++;
					}

				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
