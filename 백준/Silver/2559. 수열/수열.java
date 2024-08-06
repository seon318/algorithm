import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int sum;
		int max = Integer.MIN_VALUE;

		int[] temp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= n - k; i++) {
			sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += temp[j];
			}
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
}
