import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int sum, nx, ny;

		int n = Integer.parseInt(br.readLine());
		char[][] board1 = new char[n][];
		char[][] board2 = new char[n][];
		boolean isBombOpen = false;

		// 팔방 탐색
		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

		for (int i = 0; i < n; i++) {
			input = br.readLine();
			board1[i] = input.toCharArray();
		}

		for (int i = 0; i < n; i++) {
			input = br.readLine();
			board2[i] = input.toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board2[i][j] == 'x') {
					if (board1[i][j] == '*')
						isBombOpen = true;
					sum = 0;
					for (int d = 0; d < 8; d++) {
						nx = i + dx[d];
						ny = j + dy[d];
						if (0 <= nx && 0 <= ny && nx < n && ny < n && board1[nx][ny] == '*') {
							sum++;
						}
					}
					board2[i][j] = (char)(sum+'0');
				}
			}
		}

		if (isBombOpen)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board1[i][j] == '*')
						board2[i][j] = '*';
				}
			}

		for (int i = 0; i < n; i++) {
			System.out.println(String.valueOf(board2[i]));
		}
	}
}
