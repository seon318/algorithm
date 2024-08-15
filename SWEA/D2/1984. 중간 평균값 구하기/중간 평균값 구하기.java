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
		int[] arr = new int[10];
		int max, min, sum, avg;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			max = arr[0];
			min = arr[0];
			sum = arr[0];
			
			for (int i = 1; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (max < arr[i]) max = arr[i];
				if (min > arr[i]) min = arr[i];
				sum += arr[i];
			}
			
			sum -= max + min;
			avg = sum / 8 + (sum % 8 >= 4 ? 1 : 0);

			sb.append("#").append(tc).append(" ").append(avg).append("\n");

		}

		System.out.println(sb);
	}
}
