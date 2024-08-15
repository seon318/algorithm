import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		int[] total;
		int n, k, rank, score, idx;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			total = new int[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				total[i] += 35 * Integer.parseInt(st.nextToken());
				total[i] += 45 * Integer.parseInt(st.nextToken());
				total[i] += 20 * Integer.parseInt(st.nextToken());
			}
			
			rank = 1;
			score = total[k-1];
			for (int i = 0; i < n; i++) {
				if (i == k-1) continue;
				if (total[i] > score) rank++;
			}
			
			idx = -1;
			while (rank > 0) {
				rank -= n / 10;
				idx++;
			}
			
			
			sb.append("#").append(tc).append(" ").append(grade[idx]).append("\n");

		}

		System.out.println(sb);
	}
}
