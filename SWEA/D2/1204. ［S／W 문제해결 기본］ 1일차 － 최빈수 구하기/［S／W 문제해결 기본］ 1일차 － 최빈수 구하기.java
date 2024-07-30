import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=10; tc++) {
			tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[101];
			
			for (int i=0; i<1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				arr[score]++;
			}
			
			int max = 0;
			for (int i=100; i>=0; i--) {
				if (arr[max] < arr[i]) max = i;
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
