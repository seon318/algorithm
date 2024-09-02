import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, idx, r, min, max, oper;
	static int[] nums, operators;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			operators = new int[4];
			
			idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			perm(1, nums[0]);
			
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt, int result) {
		if (cnt == n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				oper = i;
				switch (oper) {
				case 0 : 
					perm(cnt + 1, result + nums[cnt]);
					break;
				case 1 : 
					perm(cnt + 1, result - nums[cnt]);
					break;
				case 2 : 
					perm(cnt + 1, result * nums[cnt]);
					break;
				case 3 : 
					perm(cnt + 1, result / nums[cnt]);
					break;
				}
				operators[i]++;
 			}
		}
	}
}