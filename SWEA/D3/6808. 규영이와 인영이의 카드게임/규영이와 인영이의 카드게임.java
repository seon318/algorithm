import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int win, lose, score;
	static int[] order = new int[9];;
	static boolean[] visited = new boolean[19];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			visited = new boolean[19];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				order[i] = Integer.parseInt(st.nextToken());
				visited[order[i]] = true;
			}
			
			win = 0;
			lose = 0;
			perm(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt, int playerA, int playerB) {
		if (cnt == 9) {
			if (playerA > playerB) win++;
			else if (playerA < playerB) lose++;
			return;
		}
		
		for (int i = 1; i <= 18; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			score = order[cnt] + i;			
			if (order[cnt] > i) perm(cnt + 1, playerA + score, playerB);
			else if (order[cnt] < i) perm(cnt + 1, playerA, playerB + score);
			else perm(cnt + 1, playerA, playerB);
			visited[i] = false;
		}
	}
}