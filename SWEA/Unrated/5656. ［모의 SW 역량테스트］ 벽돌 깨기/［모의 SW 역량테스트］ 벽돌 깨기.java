import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h, total, cnt, ans;
	static int[][] matrix, arr;
	static boolean[][] isBroken;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			matrix = new int[h][w];
			sel = new int[n];
			ans = h * w;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			perm(0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static void perm(int cnt) {
		if (cnt == n) {
			// 구슬 떨어뜨리기
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = matrix[i][j];
				}
			}
			
			throwBead(sel);
			return;
		}

		for (int i = 0; i < w; i++) {
			sel[cnt] = i;
			perm(cnt + 1);
		}
	}

	static void throwBead(int[] nums) {
		// 선택된 곳에 블록을 떨어뜨리기

		for (int i = 0; i < n; i++) {
			int idx = nums[i];
			for (int j = 0; j < h; j++) {
				if (arr[j][idx] != 0) {
					bomb(j, idx, arr[j][idx]);
					break;
				}
			}

			// 폭발 끝나면 벽돌 내리기
			brickDown();

		}

		// 벽돌 세기
		cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] != 0)
					cnt++;
			}
		}
		
		ans = Math.min(cnt, ans);

	}

	static int[][] brickDown() {

		// 역방향 탐색하면서 벽돌을 아래로 내리기
		for (int j = 0; j < w; j++) {
			int idx = h - 1;
			for (int i = h - 1; i >= 0; i--) {
				if (arr[i][j] != 0) {
					if (i != idx) {
						arr[idx--][j] = arr[i][j];
						arr[i][j] = 0;
					} else {
						idx--;
					}
				}
			}
		}

		return arr;
	}

	static void bomb(int x, int y, int k) {
		arr[x][y] = 0;
		for (int i = x - k + 1; i < x + k; i++) {
			if (i == h) break;
			if (i >= 0 && arr[i][y] != 0) {
				bomb(i, y, arr[i][y]);
			}
			
		}
		
		for (int i = y - k + 1; i < y + k; i++) {
			if (i == w) break;
			if (i >= 0 && arr[x][i] != 0) {
				bomb(x, i, arr[x][i]);
			}
			
		}
		
	}

}