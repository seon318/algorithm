import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, r, c, ans, idx, num;
	static boolean[][] ladder, matrix;
	static boolean isPossible;
	static int[] sel = new int[3];
	static List<int[]> info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		ladder = new boolean[h + 1][n + 1]; //n에서 0, n번 인덱스는 안 씀!
		
		//최초 사다리
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			ladder[r][c] = true;
		}

		//추가 안 해도 되는지 확인
		checkPossibility(0);
		
		if (!isPossible) {
			//사다리에 추가할 수 있는 가로선들의 정보는?
			info = new ArrayList<>();
			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < n; j++) {
					if (isValid(i, j, ladder)) info.add(new int[] {i, j});
				}
			}
			//사다리에 가로선 추가하는 모든 조합
			isPossible = false;
			ans = 4;
			for (int i = 1; i <= 3; i++) {
				comb(0, 0, i);
				if (ans < 4) break;
			}
		}
		
		System.out.println(ans < 4  ? ans : -1);
	}
	
	static void comb(int cnt, int idx, int max) {
		if (ans < 4) return;
		
		if (cnt == max) {
			checkPossibility(max);
			return;
		}
		
		for (int i = idx; i < info.size(); i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1, max);
		}
	}
	
	static void checkPossibility(int max) {
		 matrix = new boolean[h + 1][n + 1];
		 for (int i = 0; i < h + 1; i++) {
			 for (int j = 0; j < n + 1; j++) {
				 matrix[i][j] = ladder[i][j];
			 }
		 }
		
		for (int i = 0; i < max; i++) {
			r = info.get(sel[i])[0];
			c = info.get(sel[i])[1];
			if (isValid(r, c, matrix)) matrix[r][c] = true;
		}
		
		isPossible = true;
		//모든 사다리가 자기자신으로 나오는지 확인
		for (int i = 1; i < n; i++) {
			idx = 1;
			num = i;
			while (idx < h + 1) {
				if (matrix[idx][num]) {
					num++;
				} else if (matrix[idx][num - 1]) {
					num--;
				}
				idx++;
			}
			if (i != num) {
				isPossible = false;
				return;
			}
		}
		
		ans = Math.min(ans, max);
	}
	
	static boolean isValid(int x, int y, boolean[][] arr) {
		return !arr[x][y] && !arr[x][y - 1] && !arr[x][y + 1];
	}
}