import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int max = 1;
		int incLen = 1;
		int decLen = 1;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				incLen++;
				decLen = 1;
			} else if (arr[i] < arr[i - 1]) {
				decLen++;
				incLen = 1;
			} else {
				incLen++;
				decLen++;
			}

			max = Math.max(max, Math.max(incLen, decLen));
		}
		System.out.println(max);

	}
}
