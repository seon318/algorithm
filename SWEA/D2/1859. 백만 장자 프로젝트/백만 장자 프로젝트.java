import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, max;
        long sum;
		int[] arr;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			max = arr[n - 1];
			sum = 0;

			for (int i = n - 2; i >= 0; i--) {
				if (max < arr[i]) max = arr[i];
				else sum += max - arr[i];
			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}