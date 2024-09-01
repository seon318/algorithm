import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, now, diff, max, min, ans;
	static int[] people;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 1; j < n - 2; j++) {
				for (int d1 = 1; d1 <= j; d1++) {
					for (int d2 = 1; d2 <= n - j - 1; d2++)  {
						if (i + d1 + d2 > n - 1) continue;
						simulation(i, j, d1, d2);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void simulation(int x, int y, int d1, int d2) {
		people = new int[5];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				now = map[i][j];
				if (i < x + d1 && j <= y && i + j < x + y) people[0] += now;
				else if (i <= x + d2 && y < j && i - j < x - y) people[1] += now;
				else if (x + d1 <= i && j < y - d1 + d2 && i - j > x - y + 2 * d1) people[2] += now;
				else if (x + d2 <= i && y - d1 + d2 <= j && i + j > x + y + 2 * d2) people[3] += now;
				else people[4] += now;
			}
		}

		for (int i = 0; i < 5; i++) {
			if (people[i] == 0) return;
		}
		
		max = people[0];
		min = people[0];
		
		for (int i = 1; i < 5; i++) {
			max = Math.max(max, people[i]);
			min = Math.min(min, people[i]);
		}
		
		ans = Math.min(ans, max - min);
	}
	
}