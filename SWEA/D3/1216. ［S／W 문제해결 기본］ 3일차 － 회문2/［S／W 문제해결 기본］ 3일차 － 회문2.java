import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[100][100];
		int len, max, k;

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			max = 0;

			// 길이가 짝수인 회문
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 99; j++) {
					// 가로 확인
					if (arr[i][j] == arr[i][j + 1]) {
						len = 2;
						k = 1;
						while (0 <= j - k && j + 1 + k < 100) {
							if (arr[i][j - k] == arr[i][j + 1 + k])
								k++;
							else
								break;
						}
						len = 2 * k;
						max = Math.max(max, len);
					}

					// 세로 확인
					if (arr[j][i] == arr[j + 1][i]) {
						len = 2;
						k = 1;
						while (0 <= j - k && j + 1 + k < 100) {
							if (arr[j - k][i] == arr[j + 1 + k][i])
								k++;
							else
								break;

						}
						len = 2 * k;
						max = Math.max(max, len);
					}
				}
			}

			// 길이가 홀수인 회문
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 99; j++) {
					// 가로 확인
					if (arr[i][j - 1] == arr[i][j + 1]) {
						len = 2;
						k = 1;
						while (0 <= j - 1 - k && j + 1 + k < 100) {
							if (arr[i][j - 1 - k] == arr[i][j + 1 + k])
								k++;
							else
								break;
						}
						len = 2 * k + 1;
						max = Math.max(max, len);
					}

					// 세로 확인
					if (arr[j - 1][i] == arr[j + 1][i]) {
						len = 2;
						k = 1;
						while (0 <= j - 1 - k && j + 1 + k < 100) {
							if (arr[j - 1 - k][i] == arr[j + 1 + k][i])
								k++;
							else
								break;
						}
						len = 2 * k + 1;
						max = Math.max(max, len);
					}
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
}
