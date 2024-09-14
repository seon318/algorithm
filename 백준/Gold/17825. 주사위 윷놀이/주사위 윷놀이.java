import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int nowLoc, nowRow, nowCol, nowScore, len, ans;
	static int[] sel, dice;
	static int[][] shortcut, piece, loc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		shortcut = new int[][] { {}, { 10, 13, 16, 19, 25, 30, 35, 40 }, { 20, 22, 24, 25, 30, 35, 40 },
				{ 30, 28, 27, 26, 25, 30, 35, 40 } };
		dice = new int[10];
		piece = new int[4][3];
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		perm(0, 0, piece);
		System.out.println(ans);
	}

	static void perm(int cnt, int score, int[][] piece) {
		if (cnt == 10) {
			ans = Math.max(ans, score);
			return;
		}

		// 현재 주사위로 옮길 애 정하기
		outer: for (int i = 0; i < 4; i++) {
			if (piece[i][0] > 40)
				continue;

			// 위치 배열 복사하기
			loc = new int[4][3];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 3; k++) {
					loc[j][k] = piece[j][k];
				}
			}

			if (loc[i][1] > 0) {
				loc[i][2] += dice[cnt];

				if (loc[i][2] >= shortcut[loc[i][1]].length) {
					loc[i][0] = 41;
				} else {
					loc[i][0] = shortcut[loc[i][1]][loc[i][2]];
				}
			} else {
				loc[i][0] += dice[cnt] * 2;
			}

			if (loc[i][1] == 0 && loc[i][0] <= 30 && loc[i][0] % 10 == 0) {
				loc[i][1] = loc[i][0] / 10;
			}

			if (loc[i][0] <= 40) {
			    for (int j = 0; j < 4; j++) {
			        if (i == j) continue;
			        if (loc[j][0] == loc[i][0]) {
			            if (loc[i][0] == 30 && (loc[i][2] == 0 || loc[j][2] == 0)) continue;
			            if (loc[i][0] >= 25 && loc[i][0] % 5 == 0) continue outer;
			            if (loc[i][1] == loc[j][1] && loc[i][2] == loc[j][2]) continue outer;
			        }
			    }
			}
			perm(cnt + 1, score + (loc[i][0] > 40 ? 0 : loc[i][0]), loc);
		}
	}

}