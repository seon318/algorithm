import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[5][5];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = 1;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				findIndex(Integer.parseInt(st.nextToken()));
				if (checkBingo() >= 3) {
					System.out.println(num);
					return;
				}
				num++;
			}
		}
	}

	static void findIndex(int x) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == x) {
					board[i][j] = 0;
					return;
				}
			}
		}
	}

	static int checkBingo() {
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][0] + board[i][1] + board[i][2] + board[i][3] + board[i][4] == 0)
				bingo++;
			if (board[0][i] + board[1][i] + board[2][i] + board[3][i] + board[4][i] == 0)
				bingo++;
		}
		if (board[0][0] + board[1][1] + board[2][2] + board[3][3] + board[4][4] == 0)
			bingo++;
		if (board[4][0] + board[3][1] + board[2][2] + board[1][3] + board[0][4] == 0)
			bingo++;
		return bingo;
	}
}
