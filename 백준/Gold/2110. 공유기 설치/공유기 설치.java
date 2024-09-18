import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int[] diff = new int[n - 1];
		int right = house[n - 1] - house[0];
		int left = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			diff[i] = house[i + 1] - house[i];
			left = Math.min(left, diff[i]);
		}

		while (left < right) {
			int mid = (left + right + 1) / 2;
			int cnt = 1;
			int tmp = 0;
			for (int i = 0; i < n - 1; i++) {
				tmp += diff[i];
				if (tmp >= mid) {
					cnt++;
					tmp = 0;
				}
			}
			if (cnt >= c) left = mid;
			else right = mid - 1;
		}
		System.out.println(left);
	}
}