import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, r, c, ans, idx, num;
	static boolean[][] ladder;
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
		if (!checkPossibility(0)) {
			//사다리에 추가할 수 있는 가로선들의 정보는?
			info = new ArrayList<>();
			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < n; j++) {
					if (isValid(i, j)) info.add(new int[] {i, j});
				}
			}
			
			//사다리에 가로선 추가하는 모든 조합
			ans = 4;
			
			for (int i = 1; i <= 3; i++) {
				comb(0, 0, i);
				if (ans == i) break;
			}
			
		}
		
		System.out.println(ans < 4  ? ans : -1);
	}
	
	static void comb(int cnt, int idx, int max) {
	
		if (ans == max) return;	
	
		if (cnt == max) {
			checkPossibility(max);
			return;
		}
	   
		for (int i = idx; i < info.size(); i++) {
			if (!isValid(info.get(i)[0], info.get(i)[1])) continue;
			ladder[info.get(i)[0]][info.get(i)[1]] = true;
			comb(cnt + 1, i + 1, max);
			ladder[info.get(i)[0]][info.get(i)[1]] = false;
		}
		
			
	}
	static boolean checkPossibility(int max) {
		//모든 사다리가 자기자신으로 나오는지 확인
		for (int i = 1; i < n; i++) {
			idx = 1;
			num = i;
			while (idx < h + 1) {
				if (ladder[idx][num]) {
					num++;
				} else if (ladder[idx][num - 1]) {
					num--;
				}
				idx++;
			}
			if (i != num) return false;
		}
		
		ans = Math.min(ans, max);
		return true;
	}
	
	static boolean isValid(int x, int y) {
		return !ladder[x][y] && !ladder[x][y - 1] && !ladder[x][y + 1];
	}
}