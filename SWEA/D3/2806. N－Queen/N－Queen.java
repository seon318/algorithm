import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, nx, ny, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[n];

			putQueen(0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void putQueen(int col) {
		if (col == n) {
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[col] = i;
			if (isPossible(col)) {
				putQueen(col + 1);
			}
		}
	}
	
	static boolean isPossible(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) return false;
			if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) return false;
		}
		
		return true;
	}
	
	

}